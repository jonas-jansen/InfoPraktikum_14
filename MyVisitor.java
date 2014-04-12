public class MyVisitor extends BooleanExpressionBaseVisitor<Boolean> {

  @Override
  public Boolean visitFalsch (BooleanExpressionParser.FalschContext ctx) {
     return false;
  }

  public Boolean visitWahr(BooleanExpressionParser.WahrContext ctx) {
     return true;
  }
  
  public Boolean visitNeg(BooleanExpressionParser.NegContext ctx) {
    return visit(ctx.negation());
  }

  @Override
  public Boolean visitNegation(BooleanExpressionParser.NegationContext ctx) {
     BooleanExpressionParser.UnitContext negList = ctx.unit();
     return !visit(negList.getChild(0));
  }

  @Override
  public Boolean visitOrClause(BooleanExpressionParser.OrClauseContext ctx) {
    boolean value = false;
    for(BooleanExpressionParser.AndClauseContext a : ctx.andClause()) {
      value = (value || visit(a));
    }
    return value;
  }

  @Override
  public Boolean visitImplication(BooleanExpressionParser.ImplicationContext ctx) {
    BooleanExpressionParser.ImplicationContext orList = ctx;
    Boolean value;
    System.out.println("Es gibt Kinder: " +  orList.getChildCount());
    if(orList.getChildCount() == 1) {
      return visit(orList.getChild(0));
    } else {
       value = !visit(orList.getChild(0)) || visit(orList.getChild(2)) ;
    }
    return value;
  }

  @Override 
  public Boolean visitStart(BooleanExpressionParser.StartContext ctx) { 
    return visit(ctx.implication());  //fertig 
  }

  @Override
  public Boolean visitAndClause(BooleanExpressionParser.AndClauseContext ctx) {
    boolean value = true;
    for(BooleanExpressionParser.UnitContext u : ctx.unit()) {
      value = (value && visit(u));
    }
    return value;
  }

  @Override
  public Boolean visitGruppe(BooleanExpressionParser.GruppeContext ctx) {
     return visit(ctx.implication());
  }
}
