import java.util.*;

public class MyInterpreter extends GOTOBaseVisitor<Boolean> {
												//TODO Ersetze boolean!!!
	private HashMap<String,Integer> variablen = new HashMap<String,Integer>();
	
	@Override 
	public boolean visitIstKleinerNumber(@NotNull GOTOParser.IstKleinerNumberContext ctx) {
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			if(visit(ctx.getChild(0) < visit(ctx.getChild(2)) {
				value = 1;
			}
		} else if (size == 4) {
			if(visit(ctx.getChild(0) < visit(ctx.getChild(3)) {
				value = 1;
			}
		}
		return new Integer(value);							//falls Fehler oben, return false
	}

        @Override 
	public boolean visitMultiplication(@NotNull GOTOParser.MultiplicationContext ctx) { 
		int size = ctx.getChildCount();
                int value = 0;
                if( size == 3 ) {
                        value = visit(ctx.getChild(0)).intValue() * visit(ctx.getChild(2).intValue();
                } else if( size == 4 ) {
                        value = -visit(ctx.getChild(1)).intValue() * visit(ctx.getChild(2)).intValue();
                }
                return new Integer(value);

	}

        @Override 
	public boolean visitVariable(@NotNull GOTOParser.VariableContext ctx) {
		String var = ctx.VAR().getText();
               	if(!variablen.containsKey(var)) {
			throw new VariableDoesNotExistException();
			return new Integer(0);
		} else {
			return variablen.get(var);
		}
	}

        @Override 
	public boolean visitNumber(@NotNull GOTOParser.NumberContext ctx) {
		 return Integer.valueOf(ctx.INT().getText());
	}

        @Override 
	public boolean visitGoto(@NotNull GOTOParser.GotoContext ctx) { 
		return visitChildren(ctx); 
	}

        @Override 
	public boolean visitDruck(@NotNull GOTOParser.DruckContext ctx) throws Exception  { //Exception: Variable does not exist
		if (!variablen.containsKey(ctx.getChild(1))) {
			throw new VariableDoesNotExistException();                     //TODO
		} else {
			System.out.println(variablen.get(ctx.getChild(1)));
		}
		return new Integer(1);
	}

        @Override 
	public boolean visitIstIdentischNumber(@NotNull GOTOParser.IstIdentischNumberContext ctx) {  //Exception
		int size = ctx.getChildCount();
                int value = 0;
                if( size == 3 ) {
                        if(visit(ctx.getChild(0) == visit(ctx.getChild(2)) {
                                value = 1;
                        } 
                } else if (size == 4) {
                        if(visit(ctx.getChild(0) == visit(ctx.getChild(3)) {
                                value = 1;
                        } 
                }
                return new Integer(value);                                                      //falls Fehler oben, return false
 
	}

        @Override 
	public boolean visitBedingung(@NotNull GOTOParser.BedingungContext ctx) { 
		return visitChildren(ctx); 
	}

        @Override 
	public boolean visitSubtraction(@NotNull GOTOParser.SubtractionContext ctx) { 
		int size = ctx.getChildCount();
		int value = 0;
		if( size == 3 ) {
			value = visit(ctx.getChild(0)).intValue() - visit(ctx.getChild(2)).intValue();	
		} else if( size == 4 ) {
			value = -visit(ctx.getChild(1)).intValue() - visit(ctx.getChild(2)).intValue();
		}
		return new Integer(value);
	}

	@Override 
	public boolean visitStart(@NotNull GOTOParser.StartContext ctx) { 
		return visitChildren(ctx); 
	}

        @Override 
	public boolean visitZuweisung(@NotNull GOTOParser.ZuweisungContext ctx) { 
		variablen.put(ctx.getChild(0),visit(ctx.getChild(2));
	}

        @Override 
	public boolean visitDivision(@NotNull GOTOParser.DivisionContext ctx) { //Integer Division
		int size = ctx.getChildCount();
                int value = 0;
                if( size == 3 ) {
                        value = visit(ctx.getChild(0)).intValue() / visit(ctx.getChild(2).intValue();
                } else if( size == 4 ) {
                        value = -visit(ctx.getChild(1)).intValue() / visit(ctx.getChild(2)).intValue();
                }
                return new Integer(value);

	}

        @Override 
	public boolean visitAusdruck(@NotNull GOTOParser.AusdruckContext ctx) { 
		return visitChildren(ctx); 
	}

        @Override 
	public boolean visitIstGroesserNumber(@NotNull GOTOParser.IstGroesserNumberContext ctx) {  //Exception 
		int size = ctx.getChildCount();
                int value = 0;
                if( size == 3 ) {
                        if(visit(ctx.getChild(0) > visit(ctx.getChild(2)) {
                                value = 1;
                        } 
                } else if (size == 4) {
                        if(visit(ctx.getChild(0) > visit(ctx.getChild(3)) {
                                value = 1;
                        } 
                }
                return new Integer(value);                                                      //falls Fehler oben, return false

	}

        @Override 
	public boolean visitAddition(@NotNull GOTOParser.AdditionContext ctx) { 
		int size = ctx.getChildCount();
                int value = 0;
                if( size == 3 ) {
                        value = visit(ctx.getChild(0)).intValue() + visit(ctx.getChild(2).intValue();
                } else if( size == 4 ) {
                        value = -visit(ctx.getChild(1)).intValue() + visit(ctx.getChild(2)).intValue();
                } 
                return new Integer(value);
 
	}


}
