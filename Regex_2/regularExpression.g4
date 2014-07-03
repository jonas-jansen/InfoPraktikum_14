grammar regularExpression;

start: altn EOF;
altn: concat ('|' concat)* ;
concat: starred (starred)*;
starred: exp		#expr
	| (exp '*')	#star
	| (exp '?')	#ques
	| (exp '+')	#plus
	;
exp: '(' altn ')'	#group
	| SYMB		#symbol
	| '[' SYMB+ ']'	#orexp
	| '\{' INT '}'	#reku
	;
SYMB: [A-Za-z. ];
INT: [1-9][0-9]*;
WS: [\t\n]+ -> skip;

