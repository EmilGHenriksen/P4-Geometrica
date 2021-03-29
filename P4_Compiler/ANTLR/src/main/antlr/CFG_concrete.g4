grammar CFG_concrete;

/*
the CFG is made with EBNF using this notation:
? = "0 or 1 times" (aka optional)
* = "0 or more times"
+ = "1 or more times"
| = selection (either left or right side)
() = group
'' = literal
"" = regex

// = EOL comment
/*  * / = block comment
*/




program : content EOF;
content : (stmt | function)+ ;
stmt  : return_ ';'
	  | declare ';'
	  | assign ';'
	  | select
	  | iterate
	  | '{' stmtList '}'
	  | expr ';'
	  ;




function      : (Type TypeModifier? | 'void') identifier '(' parameterDeclareList ')' '{' stmtList '}' ;
parameterDeclareList : (declare (',' declare)*)? ;
stmtList : stmt* ;

//--------------statements--------------
return_ : 'return' expr? ;
declare : AccessModifier? Type TypeModifier? identifier ('IS' expr)? ;
assign  :                      identifier typeModAccess?  'IS' expr ;
typeModAccess : ('[' expr ']')+ ;

//----selection----
select  : ifSelect
		| switchSelect
		;
ifSelect     : 'if' '(' expr ')'  '{' stmtList '}' ('else' stmt)? ;            //the last "statement" can also include if statements, so "else if" is possible. The curly brackets in "{" statement "}" should eliminate the dangling else problem
switchSelect : 'switch' '(' expr ')'  '{' definedCaseList defaultCase '}' ;
definedCaseList : definedCase* ;
definedCase     : 'case' expr ':' stmtList ; //always implicitly break after the statements
defaultCase     : 'default'    ':' stmtList ;


//----iteration----
iterate  : foreachIterate
         | loopIterate
         | whileIterate
         ;
foreachIterate : 'foreach' '(' identifier 'in' identifier ')' '{' stmtList '}' ;
loopIterate    : 'loop' '(' expr ')' '{' stmtList '}' ;
whileIterate   : 'while' '(' expr ')' '{' stmtList '}' ;


//----calls----
functionCall       : identifier '(' parameterValueList ')' ;
parameterValueList   : (expr (',' expr)*)? ;

methodCall   : identifier '.' identifier '(' parameterValueList ')' ;
propertyCall : identifier '.' identifier ;





//--------------expressions--------------
expr : orExpr ;

orExpr : andExpr (('OR') orExpr)? ;
andExpr : equalityExpr (('AND') andExpr)? ;
equalityExpr : relationExpr (('=='|'!=') equalityExpr)? ;
relationExpr : additiveExpr (('<'|'>'|'<='|'>=') relationExpr)? ;
additiveExpr : multiplicativeExpr (('-'|'+') additiveExpr)? ;
multiplicativeExpr : powerExpr (('*'|'/'|'%') multiplicativeExpr)? ;
powerExpr : unaryExpr ('^' powerExpr)? ;
unaryExpr : ('-'|'+'|'!')? atomExpr ;
atomExpr : parenthesisedExpr
         | literal
         | variableExpr
         | functionCall
         | methodCall
         | propertyCall
         ;
parenthesisedExpr : '(' orExpr ')' ;
variableExpr : identifier typeModAccess? ;


//----literals----
literal  : IntLiteral
		 | FloatLiteral
		 | 'PI' //converts to float number for pi
		 | StringLiteral
		 | BoolLiteral
		 | AngleLiteral
		 | arrayLiteral
		 //the other types have no literals
		 ;
arrayLiteral : '[' (expr (',' expr)*)? ']' ;





//--------------terminals/token specification-------------


//----literal tokens----
IntLiteral    : '0'|([1-9][0-9]*) ;               //negative numbers are expressions with unary '-'
FloatLiteral  : ('0'|([1-9][0-9]*))'.'([0-9]+) ;  //int literals are implicitly converted to float (to avoid ambiguity)
StringLiteral : '"'(~[\n"])*'"' ;                 //contains anything but literal newline or quote-sign, but notably can contain '\n' (as 2 characters)
BoolLiteral : 'TRUE'
			| 'FALSE'
			;
AngleLiteral  : ('0'|([1-9][0-9]*))('.'[0-9]+)?'deg'
			  | ('0'|([1-9][0-9]*))('.'[0-9]+)?'rad' //radians
			  ;


//----types----
AccessModifier : 'const' ;
Type :  'bool'
	  | 'int'    //actually longs
	  | 'float'  //actually doubles
	  | 'string' //char is single-letter string
	  //figures below here
	  | 'point'
	  | 'line'
	  | 'triangle'
	  | 'square'
	  | 'circle'
	  | 'angle'
	  ;
TypeModifier : '[]'+ ;




//identifiers have lowest priority, adn are therefore placed lowest
identifier : IdToken ;
IdToken : ([a-zA-Z_])([a-zA-Z_0-9])* ;



//ignore whitespace
WS: (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN);