//propositional variable
public class PropVar {
	private boolean value;
	private int rowNum;
	private String stringRep;
	private int toggleCount = 0; // this is the internal propositional variable count that 
							 	 // will determine when to switch from true to false in the 
							 	 // truth tables
	
	
	
	/* constructor */
	public PropVar(boolean value, int rowNum, String stringRep){
		this.value = value;
		this.rowNum = rowNum;
		this.stringRep = stringRep;
	}
	
	public String toString(){
		return stringRep;
	}
	
	public boolean getVal(){
		return this.value;
	}
	
	/*
	 * evaluates the current row and the total number of vars to tell whether
	 * the current position in the truth table should evaluate to true or false.
	 * This switches if the toggle count has reached the toggle point, and then returns
	 * the current value of the variable.
	 */
	public String evaluate(int numVars){
		if(this.toggleCount >= Math.pow(2, numVars - (rowNum+1))){
			this.toggleCount = 1;
			this.value = !value;
		} else {
			toggleCount++;
		}
		return value ? "T" : "F";
	}
	
	
}
