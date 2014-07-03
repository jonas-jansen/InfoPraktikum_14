import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class RegexMatcherBNFA {
	
	public static void main (String[] args){
		if (args.length == 2) {
			match(args[0], args[1]).print();
		} else {
			match("(ab)*", "cababc").print();
		}	
	}
	
    public static MatchingResult match(String regex, String text) {
    	// System.out.println("Regex: " + regex + "\nText:  " + text);
    	ANTLRInputStream input = new ANTLRInputStream(regex);
        regularExpressionLexer lexer = new regularExpressionLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        regularExpressionParser parser = new regularExpressionParser(tokens);
        ParseTree tree = parser.start(); // parse
        
        return new BNFAEngine(tree, text, regex).run();
        
    }
}