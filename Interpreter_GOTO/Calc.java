import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class Calc {
	
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        GOTOLexer lexer = new GOTOLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GOTOParser parser = new GOTOParser(tokens);
        ParseTree tree = parser.start(); // parse
        
        MyInterpreter eval = new MyInterpreter();
        Integer result = eval.visit(tree);
        //System.out.println("The term given in the file " + args[0] + " takes the value " + result.intValue());
    }
    
}
