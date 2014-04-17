import java.util.*;

//Was noch getan werden muss: durchreichen der Exceptions (try, catch). Ich weiß nicht, ob ich alle Exceptions habe. Logik-Fehler suchen.

public class MyInterpreter extends GOTOBaseVisitor<Boolean> {

	private HashMap<String,Integer> variablen = new HashMap<String,Integer>();
	private HashMap<Integer,Tree> commands = new HashMap<Integer,Tree>();
	private Integer line = new Integer(0);						//Das ist in vielerlei Hinsicht einfacher.

	@Override 
	public Integer visitIstKleinerNumber(@NotNull GOTOParser.IstKleinerNumberContext ctx) {
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
	public Integer visitMultiplication(@NotNull GOTOParser.MultiplicationContext ctx) { 
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
	public Integer visitVariable(@NotNull GOTOParser.VariableContext ctx) {
		String var = ctx.VAR().getText();
               	if(!variablen.containsKey(var)) {
			throw new VariableDoesNotExistException();
			return new Integer(0);
		} else {
			return variablen.get(var);
		}
	}

        @Override 
	public Integer visitNumber(@NotNull GOTOParser.NumberContext ctx) {
		 return Integer.valueOf(ctx.INT().getText());
	}

        @Override 
	public Integer visitGoto(@NotNull GOTOParser.GotoContext ctx) { 
		line = visit(ctx.getChild(1));
		return new Integer(0); 
	}

        @Override 
	public Integer visitDruck(@NotNull GOTOParser.DruckContext ctx) throws VariableDoesNotExistException  { //Exception: Variable does not exist
		if (!variablen.containsKey(ctx.getChild(1))) {
			throw new VariableDoesNotExistException();                     //TODO
		} else {
			System.out.println(variablen.get(ctx.getChild(1)));
		}
		line = new Integer(line.intValue()++);
		return new Integer(1);
	}

        @Override 
	public Integer visitIstIdentischNumber(@NotNull GOTOParser.IstIdentischNumberContext ctx) {
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
	public Integer visitBedingung(@NotNull GOTOParser.BedingungContext ctx) { 
		if(visit(ctx.getChild(new Integer(1)) {
			line = visit(ctx.getChild(3));
		} else if {
			line = new Integer(line.intValue()++);
		}
		return new Integer(1);
	}

        @Override 
	public Integer visitSubtraction(@NotNull GOTOParser.SubtractionContext ctx) { 
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
	public Integer visitStart(@NotNull GOTOParser.StartContext ctx) { 
		int size = ctx.getChildCount();
		for(int i=0;i<size/3;i++) {
			commands.put(i,ctx.getChild(3*i);
		}
		while(commands.containsKey(line)) {
			visit(commands.get(line));
		}
		return new Integer(0);
	}

        @Override 
	public Integer visitZuweisung(@NotNull GOTOParser.ZuweisungContext ctx) { 
		variablen.put(ctx.getChild(0),visit(ctx.getChild(2));
		line = new Integer(line.intValue()++);
	}

        @Override 
	public Integer visitDivision(@NotNull GOTOParser.DivisionContext ctx) { //Integer Division
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
	public Integer visitAusdruck(@NotNull GOTOParser.AusdruckContext ctx) { 
		int value = visit(ctx.getChild(2)).intValue();
		return new Integer(-value);
	}

        @Override 
	public Integer visitIstGroesserNumber(@NotNull GOTOParser.IstGroesserNumberContext ctx) {  //Exception 
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
	public Integer visitAddition(@NotNull GOTOParser.AdditionContext ctx) { 
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
