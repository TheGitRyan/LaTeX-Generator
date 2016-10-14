//converts the logical symbols in a txt file for Generator, into the latex code equivalents
public class LogicStringConverter {
	
	//class for switching between the two forms of text
	private class Replacer{
		private String logicSymbol;
		private String LaTeXSymbol;
		
		public String replace(String original){
			if(original.contains(this.logicSymbol)){
				return original.replaceAll(this.logicSymbol, this.LaTeXSymbol);
			}
			return original;
		}
		
		
		public Replacer(String logicSymbol, String LaTeXSymbol){
			this.logicSymbol = logicSymbol;
			this.LaTeXSymbol = LaTeXSymbol;
		}
	}
	
	//set of replacement parameters for the string replacer object
	private Replacer[] rArr = {new Replacer("v","\\\\lor"),
							   new Replacer("<>","\\\\leftrightarrow"),
							   new Replacer(">","\\\\rightarrow"),
							   new Replacer("&", "\\\\land"),
							   new Replacer("~","\\\\neg "),
							   new Replacer("x0", "x_{0}"),
							   new Replacer("x1", "x_{1}"),
							   new Replacer(" x ", " \\\\cdot "),
							   new Replacer("a0", "a_{0}"),
							   new Replacer("a1", "a_{1}"),
							   new Replacer("a2", "a_{2}"),
							   new Replacer("b0", "b_{0}"),
							   new Replacer("b1", "b_{1}"),
							   new Replacer("b2", "b_{2}"),
							   new Replacer("c0", "c_{0}"),
							   new Replacer("c1", "c_{1}"),
							   new Replacer("c2", "c_{2}"),
							   new Replacer("d0", "d_{0}"),
							   new Replacer("d1", "d_{1}"),
							   new Replacer("d2", "d_{2}"),
							   new Replacer("y0", "y_{0}"),
							   new Replacer("y1", "y_{1}"),};
	
	//loop through the string[] of logical symbols and replace them with the equivalent (same index) version
	//in latex code
	public String convertLine(String original){
		String retStr = original;
		for(Replacer r : rArr){
			retStr = r.replace(retStr);
		}
		return retStr;
	}
}
