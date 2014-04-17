import java.util.*;
//import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class MyInterpreter extends GOTOBaseVisitor<Integer> {

	private HashMap<String,Integer> variablen = new HashMap<String,Integer>();
	//private HashMap<Integer,AbstractParseTreeVisitor> kids = new HashMap<Integer,AbstractParseTreeVisitor>();
	private int curLine = 0;

	@Override
	public Integer visitStart(GOTOParser.StartContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		/*for (int i=0; (3*i)<size; i++) {
			kids.put(new Integer(i),ctx.getChild(3*i));
		}*/
		//System.out.println("Size:"+size);
		
		while ( (3*curLine)<(size-1) ){
			value = visit(ctx.getChild(curLine*3)).intValue();
			//System.out.println("Line:"+curLine+"\tValue:"+value);
			
			if ( value == -1 ) {
				curLine++;
			} else {
				curLine = value;
			}
		}
		
		return new Integer(1);
	}

	@Override
	public Integer visitZuweisung(GOTOParser.ZuweisungContext ctx) {
		variablen.put(ctx.VAR().getText(),visit(ctx.getChild(2)));

		return new Integer(-1);
	}

	@Override
	public Integer visitDruck(GOTOParser.DruckContext ctx) {
		if (!variablen.containsKey(ctx.VAR().getText())) {
			System.out.println("Variable does not exist");
		} else {
			System.out.println(variablen.get(ctx.VAR().getText()));
		}

		return new Integer(-1);
	}

	@Override
	public Integer visitGoto(GOTOParser.GotoContext ctx) {
		return Integer.valueOf(ctx.INT().getText());
	}

	@Override
	public Integer visitBedingung(GOTOParser.BedingungContext ctx) {
		boolean bool = (visit(ctx.getChild(1)).intValue() == 1);
		if ( bool ) {
			return Integer.valueOf(ctx.INT().getText());
		}
		
		return new Integer(-1);
	}

	@Override
	public Integer visitAusdruck(GOTOParser.AusdruckContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if ( size == 1 ) {
			value = visit(ctx.getChild(0)).intValue();
		} else if ( size == 2 ) {
			value = -visit(ctx.getChild(1)).intValue();
		}

		return new Integer(value);
	}

	@Override
	public Integer visitAddition(GOTOParser.AdditionContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			value = visit(ctx.getChild(0)).intValue() + visit(ctx.getChild(2)).intValue();
		} else if( size == 4 ) {
			value = -visit(ctx.getChild(1)).intValue() + visit(ctx.getChild(3)).intValue();
		}

		return new Integer(value);
	}

	@Override
	public Integer visitSubtraction(GOTOParser.SubtractionContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			value = visit(ctx.getChild(0)).intValue() - visit(ctx.getChild(2)).intValue();	
		} else if( size == 4 ) {
			value = -visit(ctx.getChild(1)).intValue() - visit(ctx.getChild(3)).intValue();
		}

		return new Integer(value);
	}

	@Override
	public Integer visitMultiplication(GOTOParser.MultiplicationContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
				value = visit(ctx.getChild(0)).intValue() * visit(ctx.getChild(2)).intValue();
		} else if( size == 4 ) {
				value = -visit(ctx.getChild(1)).intValue() * visit(ctx.getChild(3)).intValue();
		}
		
		return new Integer(value);
	}

	@Override
	public Integer visitDivision(GOTOParser.DivisionContext ctx) { //Integer Division
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			value = visit(ctx.getChild(0)).intValue() / visit(ctx.getChild(2)).intValue();
		} else if( size == 4 ) {
			value = -visit(ctx.getChild(1)).intValue() / visit(ctx.getChild(3)).intValue();
		}

		return new Integer(value);
	}

	@Override
	public Integer visitIstIdentischNumber(GOTOParser.IstIdentischNumberContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			if(visit(ctx.getChild(0)).intValue() == visit(ctx.getChild(2)).intValue()) {
				value = 1;
			}
		} else if (size == 4) {
			if(visit(ctx.getChild(0)).intValue() == visit(ctx.getChild(3)).intValue()) {
				value = 1;
			}
		}
		
		return new Integer(value);  //falls Fehler oben, return false
	}

	@Override
	public Integer visitIstGroesserNumber(GOTOParser.IstGroesserNumberContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			if(visit(ctx.getChild(0)) > visit(ctx.getChild(2))) {
				value = 1;
			}
		} else if (size == 4) {
			if(visit(ctx.getChild(0)) > visit(ctx.getChild(3))) {
				value = 1;
			}
		}

		return new Integer(value);  //falls Fehler oben, return false
	}

	@Override
	public Integer visitIstKleinerNumber(GOTOParser.IstKleinerNumberContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			if(visit(ctx.getChild(0)) < visit(ctx.getChild(2))) {
				value = 1;
			}
		} else if (size == 4) {
			if(visit(ctx.getChild(0)) < visit(ctx.getChild(3))) {
				value = 1;
			}
		}

		return new Integer(value);	//falls Fehler oben, return false
	}

	@Override
	public Integer visitVariable(GOTOParser.VariableContext ctx) {
		String var = ctx.VAR().getText();
		if(!variablen.containsKey(var)) {
			System.out.println("Variable does not exist");
			return new Integer(0);
		}
		
		return variablen.get(var);
	}

	@Override
	public Integer visitNumber(GOTOParser.NumberContext ctx) {
		return Integer.valueOf(ctx.INT().getText());
	}

}
