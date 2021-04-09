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
stmt  : return_
	  | declare
	  | assign
	  | select
	  | iterate
	  | stmtList
	  | exprStmt
	  ;




function      : (Type TypeModifier? | 'void') identifier '(' parameterDeclareList ')' stmtList ;
parameterDeclareList : (parameterDeclare (',' parameterDeclare)*)? ;
parameterDeclare : Type TypeModifier? identifier ;
stmtList : '{' stmt*  '}';
stmtListNoBraces : stmt* ;

//--------------statements--------------
return_ : 'return' expr? ';' ;
declare : AccessModifier? Type TypeModifier? identifier ('IS' expr)? ';' ;
assign  :                                 variableAccess 'IS' expr ';' ;

//--variable access--
variableAccess : variablePropertyAccess ;
variablePropertyAccess : variablePropertyAccess '.' variableModifierAccess | variableModifierAccess ;
//variablePropertyAccess : variableModifierAccess propAccessList ;
//propAccessList : ('.' variableModifierAccess propAccessList)? ;

variableModifierAccess : variableModifierAccess '[' expr ']' | identifier ;
//variableModifierAccess : identifier modAccessList ;
//modAccessList : ('[' expr ']' modAccessList)? ;



//----selection----
select  : ifSelect
		| switchSelect
		;
ifSelect     : 'if' '(' expr ')' stmtList ('else' stmt)? ;            //the last "statement" can also include if statements, so "else if" is possible. The curly brackets in "{" statement "}" should eliminate the dangling else problem
switchSelect : 'switch' '(' expr ')'  '{' definedCaseList defaultCase '}' ;
definedCaseList : definedCase* ;
definedCase     : 'case' expr ':' stmtListNoBraces ; //always implicitly break after the statements
defaultCase     : 'default'   ':' stmtListNoBraces ;


//----iteration----
iterate  : foreachIterate
         | loopIterate
         | whileIterate
         ;
foreachIterate : 'foreach' '(' identifier 'in' identifier ')' stmtList ;
loopIterate    : 'loop' '(' expr ')' stmtList ;
whileIterate   : 'while' '(' expr ')' stmtList ;


//----calls----
functionCall       : identifier '(' parameterValueList ')' ;
parameterValueList   : (expr (',' expr)*)? ;

methodCall   : variableAccess '.' identifier '(' parameterValueList ')' ;

//----expr stmt----
exprStmt : expr ';' ;



//--------------expressions--------------
expr : orExpr ;

orExpr : orExpr ('OR') andExpr                                  | andExpr ;
andExpr : andExpr ('AND') equalityExpr                          | equalityExpr ;
equalityExpr : equalityExpr ('=='|'!=') relationExpr            | relationExpr ;
relationExpr : relationExpr ('<'|'>'|'<='|'>=') additiveExpr    | additiveExpr ;
additiveExpr : additiveExpr ('-'|'+') multiplicativeExpr        | multiplicativeExpr ;
multiplicativeExpr : multiplicativeExpr ('*'|'/'|'%') powerExpr | powerExpr ;
powerExpr : unaryExpr ('^' powerExpr)? ;
unaryExpr : ('-'|'+'|'!')? atomExpr ;
atomExpr : parenthesisedExpr
         | literal
         | variableAccess
         | functionCall
         | methodCall
         ;
parenthesisedExpr : '(' orExpr ')' ;


//----literals----
literal  : intLiteral
		 | floatLiteral
		 | piLiteral //converts to float number for pi
		 | stringLiteral
		 | boolLiteral
		 | angleLiteral
		 | arrayLiteral
		 //the other types have no literals
		 ;
arrayLiteral : '[' (expr (',' expr)*)? ']' ;
piLiteral : 'PI' ;




//--------------terminals/token specification-------------


//----literal tokens----
//double definition so they have names instead of only being terminals
intLiteral : IntLiteral ;
IntLiteral    : '0'|([1-9][0-9]*) ;               //negative numbers are expressions with unary '-'
floatLiteral : FloatLiteral ;
FloatLiteral  : ('0'|([1-9][0-9]*))'.'([0-9]+) ;  //int literals are implicitly converted to float (to avoid ambiguity)
stringLiteral : StringLiteral ;
StringLiteral : '"'(~[\n"])*'"' ;                 //contains anything but literal newline or quote-sign, but notably can contain '\n' (as 2 characters)
boolLiteral : BoolLiteral ;
BoolLiteral : 'TRUE'
			| 'FALSE'
			;
angleLiteral : AngleLiteral ;
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



//ignore comments
EOLcomment : ('//'(~[\n\r]+))+ -> channel(HIDDEN);
BlockComment : ('/*'(.*?)'*/')+ -> channel(HIDDEN);

//ignore whitespace
WS: (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN);
