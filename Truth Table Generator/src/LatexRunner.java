import java.io.File;
import java.io.FileNotFoundException;

public class LatexRunner {
	//propositional variables are written here
	static PropVar[] vars = {new PropVar(true, 0, "x_{1}"),
							 new PropVar(true, 1, "y_{0}")};
	
	//equations in textual form 
	static String[] equationsStr = {"a_{1}"};
	
	public static void main(String[] args) throws FileNotFoundException{
		//Generator.generateTruthTable(vars, equationsStr);
		Generator.generateProofTable(new File("proofLines.txt"));
	}
	
	
}
