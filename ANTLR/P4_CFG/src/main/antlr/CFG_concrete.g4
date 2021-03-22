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




program : (stmt | function)* EOF;
stmt  : return_ ';'
	  | declare ';'
	  | assign ';'
	  | select
	  | iterate
	  | functionCall ';'
	  | methodCall ';'    //example:  a.move(...)
	  | '{' stmt* '}'
	  ;




function      : Type Identifier '(' parameterDeclareList ')' '{' stmt* '}' ;
parameterDeclareList : (declare (',' declare)*)? ;

//--------------statements--------------
return_ : 'return' expr? ;
declare : Type Identifier TypeModifier? ('IS' expr)? ;
assign  :      Identifier 'IS' expr ;


//----selection----
select  : ifSelect
		| switchSelect
		;
ifSelect     : 'if' '(' expr ')'  '{' stmt* '}' ('else' stmt)? ;            //the last "statement" can also include if statements, so "else if" is possible. The curly brackets in "{" statement "}" should eliminate the dangling else problem
switchSelect : 'switch' '(' expr ')'  '{' (definedCase)* defaultCase '}' ;
definedCase     : 'case' expr ':' stmt* 'fallthrough;'? ; //break by default
defaultCase     : 'default'    ':' stmt* ;


//----iteration----
iterate  : forIterate
         | foreachIterate
         | loopIterate
         | whileIterate
         ;
forIterate     : 'for' '(' Type? assign ';' expr ';' assign ')' '{' stmt* '}' ;
foreachIterate : 'foreach' '(' Identifier 'in' Identifier ')' '{' stmt* '}' ;
loopIterate    : 'loop' '(' expr ')' '{' stmt* '}' ;
whileIterate   : 'while' '(' expr ')' '{' stmt* '}' ;


//----calls----
functionCall       : Identifier '(' parameterValueList ')' ;
parameterValueList   : (expr (',' expr)*)? ;

methodCall   : Identifier '.' Identifier '(' parameterValueList ')' ;
propertyCall : Identifier '.' Identifier ;





//--------------expressions--------------
expr : orExpr ;

orExpr : andExpr (('OR') andExpr)* ;
andExpr : equalityExpr (('AND') equalityExpr)* ;
equalityExpr : relationExpr (('=='|'!=') relationExpr)* ;
relationExpr : additiveExpr (('<'|'>'|'<='|'>=') additiveExpr)* ;
additiveExpr : multiplicativeExpr (('-'|'+') multiplicativeExpr)* ;
multiplicativeExpr : powerExpr (('*'|'/'|'%') powerExpr)* ;
powerExpr : unaryExpr ('^' unaryExpr)* ;
unaryExpr : ('-'|'+'|'!')? atomExpr ;
atomExpr : '(' orExpr ')'
         | literal
         | Identifier
         | functionCall
         | methodCall
         | propertyCall
         | assign
         ;



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
arrayLiteral : '[' (literal (',' literal)*)? ']' ;





//--------------terminals/token specification-------------


//----literal tokens----
IntLiteral    : '0'|([1-9][0-9]*) ;               //negative numbers are expressions with unary '-'
FloatLiteral  : ('0'|([1-9][0-9]*))'.'([0-9]+) ;  //int literals are implicitly converted to float (to avoid ambiguity)
StringLiteral : '"'(~[\n"])*'"' ;                 //contains anything but literal newline or quote-sign, but notably can contain '\n' (as 2 characters)
BoolLiteral : [tT]'rue'
			| [fF]'alse'
			;
AngleLiteral  : ('0'|([1-9][0-9]*))('.'[0-9]+)?'deg'
			  | ('0'|([1-9][0-9]*))('.'[0-9]+)?'rad' //radians
			  ;


//----types----
Type  : 'void'
	  | 'bool'
	  | 'int'    //actually longs
	  | 'float'  //actually doubles
	  | 'string' //char is single-letter string
	  //figures below here
	  | 'point'
	  | 'line'
	  | 'triangle'
	  | 'square'
	  | 'closedfigure'
	  | 'circle'
	  | 'angle'
	  ;
TypeModifier : '[]'+ ;




//identifiers have lowest priority, adn are therefore placed lowest
Identifier : ([a-zA-Z_])([a-zA-Z_0-9])* ;



//ignore whitespace
WS: (' '|'\t'|'\n')+ -> channel(HIDDEN);