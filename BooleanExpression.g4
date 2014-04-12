grammar BooleanExpression;

start: implication EOF;
negation: 'NOT' unit;
andClause: unit ('AND' unit)*;
orClause: andClause ('OR' andClause)*;
implication: orClause ('IMPLIES' orClause)?;
unit: '(' implication ')' #gruppe
	| '0'   #falsch
	| '1'   #wahr
	| negation  #neg
	;
WS: [ \t\n]+ -> skip;
