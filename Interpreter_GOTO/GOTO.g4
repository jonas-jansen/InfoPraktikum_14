grammar GOTO;

start: (exp ';' NEWLINE)+ EOF;
exp: VAR '=' zuw  #Zuweisung
	| 'PRINT' VAR  #Druck
	| 'GOTO' INT  #Goto
	| 'IF' bool 'GOTO' INT  #Bedingung
	;
zuw:    ('-')?aus 	#Ausdruck
	|  ('-')?aus'+'aus  #Addition
	|  ('-')?aus'-'aus  #Subtraction
	|  ('-')?aus'*'aus  #Multiplication
	|  ('-')?aus'/'aus  #Division
	;
bool:  aus '==' ('-')?aus  #istIdentischNumber
	| aus '>' ('-')?aus     #istGroesserNumber
	| aus '<' ('-')?aus  #istKleinerNumber
	;

aus: VAR  #Variable
    | INT  #Number
	;

VAR: [A-Z];

INT: [0-9]+;

NEWLINE: [\r\n]+ ;
WS: [ ]+ -> skip ;
