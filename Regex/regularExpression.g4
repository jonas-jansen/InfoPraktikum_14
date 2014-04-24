grammar regularExpression;

start: altn EOF;
altn: concat ('|' concat)* ;
concat: starred (starred)*;
starred: exp		#expr
	| (exp '*')	#starred
	;
exp: '(' altn ')'	#group
	| SYMB		#symbol
;
SYMB: [a-z];
WS: [ \t\n]+ -> skip;


