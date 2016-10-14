import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//reads through the syntax of a proof lines file and prints to console if there
//are any problems with the code
public class SyntaxChecker {
	/*
	 * checks whether or not there are the correct number of open and close parentheses
	 * in a proof file, uses stack to pair open and closed parentheses. Prints out line of error 
	 * as well. 
	 */
	public static void checkParentheses(File f) throws FileNotFoundException{
		Scanner scanf = new Scanner(f);
		int lineNum = 0;
		
		while(scanf.hasNext()){
			String line = scanf.nextLine();
			Stack<Character> paren = new Stack<Character>();
			lineNum++;
			for(char c : line.toCharArray()){
				if(c == '('){
					paren.push('(');
				} else if(c == ')'){
					if(paren.isEmpty() == true){
						System.out.println("Missing open parenthesis - Line " + lineNum);
					} else {
						paren.pop();
					}
				}
			}

			if(paren.isEmpty() == false){
				System.out.println("Missing close parenthesis - Line " + lineNum);
			}
		}
		scanf.close();
	}
}
