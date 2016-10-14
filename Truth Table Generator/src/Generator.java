import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Generator {
	public static void generateTruthTable(PropVar[] vars, String[] equationsStr) throws FileNotFoundException{
		PrintStream ps = new PrintStream("outputTable.txt");
		int n = vars.length + equationsStr.length;
		/*
		 * section to set up environment and number of columns in table
		 */
		ps.print("\\begin{center}\n\\begin{tabular}{|");
		for(int x = 0; x < n; x++){
			ps.print("c|");
		}
		ps.println("}");
		
		/* print header row with string equations */
		
		//print out the header labels for the propositional variables
		ps.println("\\hline");
		for(int x = 0; x < vars.length; x++){
			ps.print(" $" + vars[x] + "$ &");
		}
		//print out the header text labels for the expressions
		for(int x = 0; x < equationsStr.length; x++){
			ps.print(" $" + equationsStr[x] + "$");
			if(x != equationsStr.length - 1){
				ps.print(" &");
			}
		}
		ps.println("\\\\");
		ps.println("\\hline");
		
		/*
		 * Section to fill in the truth table with all of the values
		 */
		for(int i = 0; i < Math.pow(2, vars.length); i++){
			for(int j = 0; j < vars.length; j++){
				String varStr = vars[j].evaluate(vars.length);
				ps.print("$" + varStr + "$ & ");
			}
			
			boolean p = vars[0].getVal();
			boolean q = vars[1].getVal();
			//boolean r = vars[2].getVal();
			
			//put equations here {
			ps.print("$" + ((p & q)?"T":"F") + "$ ");
			//ps.print("& $" + ((q & r)?"T":"F") + "$");
			//}
			ps.println("\\\\\n\\hline");
		}
		
		
		ps.println("\\end{tabular}\n\\end{center}");
		ps.close();
	}
	
	/*
	 * takes a txt file with the liens of a proof and their reasoning seperated by a semicolon
	 * and outputs the same proof formatted in a LaTeX table.
	 */
	
	public static void generateProofTable(File proofLines) throws FileNotFoundException{
		 PrintStream ps = new PrintStream("outputProof.txt");
		 Scanner scan = new Scanner(proofLines);
		 LogicStringConverter lsc = new LogicStringConverter();
		 SyntaxChecker.checkParentheses(proofLines); //checks to make sure that proofLines is well - formed
		 
		/*
		 * section to set up environment and number of columns in table
		 */
		ps.println("\\begin{center}\n\\begin{tabular}{c c c}");
		
		/* print header row with string original equation */
		ps.println("$" + lsc.convertLine(scan.nextLine()) + "$ &&\\\\");
		
		/* print body of the table */
		outsideLoops:
		while(scan.hasNextLine()){
			String proofLine = scan.nextLine();
			
			//skip over blank lines in proof
			
			while(proofLine.equals("")) {
				if(scan.hasNextLine()){
					proofLine = scan.nextLine();
				} else {
					break outsideLoops;
				}
			} 
			
			//seperate into two parts for table
			String expression = proofLine.substring(0, proofLine.indexOf(';'));
			String reason = proofLine.substring((proofLine.indexOf(';') + 2), proofLine.length());
			
			ps.println("$\\equiv$ & $" + lsc.convertLine(expression) + "$ & " + reason + "\\\\");
		}
		
		ps.print("\\end{tabular}\n\\end{center}");
		scan.close();
		ps.close();
	}
	
	
	
	private static boolean impl(boolean p, boolean q){
		return !p || q;
	}
}
