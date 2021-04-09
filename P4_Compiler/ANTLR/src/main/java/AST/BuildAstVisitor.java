package AST;

import gen.CFG_concreteBaseVisitor;
import gen.CFG_concreteParser;
import gen.CFG_concreteVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class BuildAstVisitor extends CFG_concreteBaseVisitor<Node> {
    @Override
    public ProgramNode visitProgram(CFG_concreteParser.ProgramContext context) {
        ProgramNode program = new ProgramNode();
        program.content = (ContentNode) visit(context.content());
        return program;
    }
    @Override
    public ContentNode visitContent(CFG_concreteParser.ContentContext context) {
        ContentNode content = new ContentNode();
        if(context.children != null) {
            int nFunctions = 0;
            int nStatements = 0;
            for (int i = 0; i < context.children.size(); i++) {
                if (context.children.get(i) instanceof CFG_concreteParser.FunctionContext) {
                    content.functionNodes.add((FunctionNode) visit(context.function(nFunctions)));
                    nFunctions++;
                } else if (context.children.get(i) instanceof CFG_concreteParser.StmtContext) {
                    content.stmtNodes.add((StmtNode) visit(context.stmt(nStatements)));
                    nStatements++;
                }
            }
        }
        return content;
    }
    @Override
    public FunctionNode visitFunction(CFG_concreteParser.FunctionContext context) {
        FunctionNode function = new FunctionNode();
        if(context.Type() != null){
            function.type = context.Type().getText();
        }
        else{
            function.type = "void";
        }
        if(context.TypeModifier() != null) {
            function.typeModifier = context.TypeModifier().getText();
        }
        function.id = (IdentifierNode) visit(context.identifier());
        function.parameters = (DeclareStmtListNode) visit(context.parameterDeclareList());
        function.stmtFuncNodes = (StmtListNode) visit(context.stmtList());
        return function;
    }
    @Override
    public DeclareStmtListNode visitParameterDeclareList(CFG_concreteParser.ParameterDeclareListContext context) {
        DeclareStmtListNode dcls = new DeclareStmtListNode();
        if(context.children != null) {
            for (int i = 0; i < context.children.size(); i++) {
                DeclareStmtNode dcl = (DeclareStmtNode) visit(context.getChild(i)); // maybe an alternative: Visit(context.declare())
                if(dcl != null){
                    dcls.declarations.add(dcl);
                }
            }
        }
        return dcls;
    }
    @Override
    public DeclareStmtNode visitParameterDeclare(CFG_concreteParser.ParameterDeclareContext context){
        DeclareStmtNode declareStmtNode = new DeclareStmtNode();
        declareStmtNode.type = context.Type().getText();
        if(context.TypeModifier() != null) {
            declareStmtNode.typeModifier = context.TypeModifier().getText();
        }
        declareStmtNode.id = (IdentifierNode) visit(context.identifier());
        return declareStmtNode;
    }
    @Override
    public ValueListNode visitParameterValueList(CFG_concreteParser.ParameterValueListContext context){
        ValueListNode valueListNode = new ValueListNode();
        if(context.children != null){
            for(int i = 0; i < context.children.size(); i++){
                ExprNode expr = (ExprNode) visit(context.getChild(i));
                if(expr != null){
                    valueListNode.exprNodes.add(expr);
                }
            }
        }
        return valueListNode;
    }

    @Override
    public StmtListNode visitStmtList(CFG_concreteParser.StmtListContext context) {
        StmtListNode stmtListNode = new StmtListNode();
        if(context.children != null) {
            for (int i = 0; i < context.children.size(); i++) {
                StmtNode nextStmt = (StmtNode) visit(context.getChild(i));
                if(nextStmt != null){
                    stmtListNode.statements.add(nextStmt);
                }
            }
        }
        return stmtListNode;
    }
    @Override
    public StmtListNode visitStmtListNoBraces(CFG_concreteParser.StmtListNoBracesContext context){
        StmtListNode stmtListNode = new StmtListNode();
        stmtListNode.hasBraces = false;
        if(context.children != null) {
            for (int i = 0; i < context.children.size(); i++) {
                StmtNode nextStmt = (StmtNode) visit(context.getChild(i));
                if(nextStmt != null){
                    stmtListNode.statements.add(nextStmt);
                }
            }
        }
        return stmtListNode;
    }

    @Override
    public ReturnStmtNode visitReturn_(CFG_concreteParser.Return_Context context) {
        ReturnStmtNode returnStmt = new ReturnStmtNode();
        if(context.children != null) {
            if (context.children.size() > 0) {
                returnStmt.value = (ExprNode) visit(context.expr());
            }
        }
        return returnStmt;
    }
    @Override
    public DeclareStmtNode visitDeclare(CFG_concreteParser.DeclareContext context) {
        DeclareStmtNode dcl = new DeclareStmtNode();
        if(context.AccessModifier() != null) {
            dcl.accessModifier = context.AccessModifier().getText();
        }
        dcl.type = context.Type().getText();
        if(context.TypeModifier() != null) {
            dcl.typeModifier = context.TypeModifier().getText();
        }
        dcl.id = (IdentifierNode) visit(context.identifier());
        if(context.expr() != null) {
            dcl.value = (ExprNode) visit(context.expr());
        }
        return dcl;
    }
    @Override
    public AssignNode visitAssign(CFG_concreteParser.AssignContext context){
        AssignNode assign = new AssignNode();
        assign.variable = (VariableAccessNode) visit(context.variableAccess());
        assign.value = (ExprNode) visit(context.expr());
        return assign;
    }
    @Override
    public VariableAccessNode visitVariableAccess(CFG_concreteParser.VariableAccessContext context){
        VariableAccessNode variableAccessNode = (VariableAccessNode) visit(context.variablePropertyAccess());
        return variableAccessNode;
    }
    @Override
    public VariableAccessNode visitVariablePropertyAccess(CFG_concreteParser.VariablePropertyAccessContext context){
        VariableAccessNode variableAccessNode;
        if(context.children.size() == 1){
            variableAccessNode = (VariableAccessNode) visit(context.variableModifierAccess());
        }
        else{
            VariablePropertyAccessNode variablePropertyAccessNode = new VariablePropertyAccessNode();
            variablePropertyAccessNode.parent = (VariableAccessNode) visit(context.variablePropertyAccess());
            variablePropertyAccessNode.child = (VariableAccessNode) visit(context.variableModifierAccess());
            variableAccessNode = variablePropertyAccessNode;
        }
        return variableAccessNode;
    }
    @Override
    public VariableAccessNode visitVariableModifierAccess(CFG_concreteParser.VariableModifierAccessContext context){
        VariableAccessNode variableAccessNode;
        if(context.children.size() == 1){
            IdentifierNode id = (IdentifierNode) visit(context.identifier());
            variableAccessNode = id;
        }
        else{
            VariableModifierAccessNode variableModifierAccessNode = new VariableModifierAccessNode();
            variableModifierAccessNode.variable = (VariableAccessNode) visit(context.variableModifierAccess());
            variableModifierAccessNode.expr = (ExprNode) visit(context.expr());
            variableAccessNode = variableModifierAccessNode;
        }
        return variableAccessNode;
    }

    @Override
    public IfNode visitIfSelect(CFG_concreteParser.IfSelectContext context){
        IfNode ifnode = new IfNode();
        ifnode.value = (ExprNode) visit(context.expr());
        ifnode.ifStmtNodes = (StmtListNode) visit(context.stmtList());
        ifnode.elseStmtNode = (StmtNode) visit(context.stmt());
        return ifnode;
    }
    @Override
    public SwitchNode visitSwitchSelect(CFG_concreteParser.SwitchSelectContext context) {
        SwitchNode switchnode = new SwitchNode();
        switchnode.value = (ExprNode) visit(context.expr());
        switchnode.cases = (DefinedCaseListNode) visit(context.definedCaseList());
        switchnode.defaultCase = (DefaultCaseNode) visit(context.defaultCase());
        return switchnode;
    }
    @Override
    public DefinedCaseListNode visitDefinedCaseList(CFG_concreteParser.DefinedCaseListContext context){
        DefinedCaseListNode caseList = new DefinedCaseListNode();
        if(context.children != null) {
            for (int i = 0; i < context.children.size(); i++) {
                DefinedCaseNode defined = (DefinedCaseNode) visit(context.definedCase(i));
                if(defined != null){
                    caseList.cases.add(defined);
                }
            }
        }
        return caseList;
    }
    @Override
    public DefinedCaseNode visitDefinedCase(CFG_concreteParser.DefinedCaseContext context){
        DefinedCaseNode definedCaseNode = new DefinedCaseNode();
        definedCaseNode.value = (ExprNode) visit(context.expr());
        definedCaseNode.stmtNodes = (StmtListNode) visit(context.stmtListNoBraces());
        return definedCaseNode;
    }
    @Override
    public DefaultCaseNode visitDefaultCase(CFG_concreteParser.DefaultCaseContext context){
        DefaultCaseNode defaultCaseNode = new DefaultCaseNode();
        defaultCaseNode.stmtNodes = (StmtListNode) visit(context.stmtListNoBraces());
        return defaultCaseNode;
    }
    @Override
    public ForeachNode visitForeachIterate(CFG_concreteParser.ForeachIterateContext context){
        ForeachNode foreachNode = new ForeachNode();
        foreachNode.elementID = (IdentifierNode) visit(context.identifier(0));
        foreachNode.collectionID = (IdentifierNode) visit(context.identifier(1));
        foreachNode.stmtNodes = (StmtListNode) visit(context.stmtList());
        return foreachNode;
    }
    @Override
    public LoopNode visitLoopIterate(CFG_concreteParser.LoopIterateContext context){
        LoopNode loopNode = new LoopNode();
        loopNode.loopcount = (ExprNode) visit(context.expr());
        loopNode.stmtNodes = (StmtListNode) visit(context.stmtList());
        return loopNode;
    }
    @Override
    public WhileNode visitWhileIterate(CFG_concreteParser.WhileIterateContext context){
        WhileNode whileNode = new WhileNode();
        whileNode.conditionExpression = (ExprNode) visit(context.expr());
        whileNode.stmtNodes = (StmtListNode) visit(context.stmtList());
        return whileNode;
    }
    @Override
    public ExprStmtNode visitExprStmt(CFG_concreteParser.ExprStmtContext context){
        ExprStmtNode exprStmtNode = new ExprStmtNode();
        exprStmtNode.expr = (ExprNode) visit(context.expr());
        return exprStmtNode;
    }

    @Override
    public LiteralNode visitLiteral(CFG_concreteParser.LiteralContext context){
        LiteralNode literalNode;

        if(context.getChild(0) instanceof CFG_concreteParser.IntLiteralContext){
            IntLiteralNode intLiteralNode = new IntLiteralNode();
            intLiteralNode.value = parseLong(context.getChild(0).getText());
            literalNode = intLiteralNode;
        }
        else if(context.getChild(0) instanceof CFG_concreteParser.FloatLiteralContext){
            FloatLiteralNode floatLiteralNode = new FloatLiteralNode();
            floatLiteralNode.value = parseDouble(context.getChild(0).getText());
            literalNode = floatLiteralNode;
        }
        else if(context.getChild(0) instanceof CFG_concreteParser.PiLiteralContext){
            literalNode = new PiLiteralNode();
        }
        else if(context.getChild(0) instanceof CFG_concreteParser.StringLiteralContext){
            StringLiteralNode stringLiteralNode = new StringLiteralNode();
            String temp = context.getChild(0).getText();
            stringLiteralNode.value = temp.substring(1, temp.length() -1);
            literalNode = stringLiteralNode;
        }
        else if(context.getChild(0) instanceof CFG_concreteParser.BoolLiteralContext){
            BoolLiteralNode boolLiteralNode = new BoolLiteralNode();
            boolLiteralNode.value = Boolean.parseBoolean(context.getChild(0).getText());
            literalNode = boolLiteralNode;
        }
        else if(context.getChild(0) instanceof CFG_concreteParser.AngleLiteralContext){
            AngleLiteralNode angleLiteralNode = new AngleLiteralNode();
            String temp = context.getChild(0).getText();
            angleLiteralNode.value = parseDouble(temp.substring(0, temp.length() - 3));
            literalNode = angleLiteralNode;
        }
        else{
            ArrayLiteralNode arrayLiteralNode = new ArrayLiteralNode();
            for(int i = 1; i < context.getChild(0).getChildCount(); i += 2 ){
                ExprNode expr = (ExprNode) visit(context.getChild(0).getChild(i));
                if(expr != null){
                    arrayLiteralNode.elements.add(expr);
                }
            }
            literalNode = arrayLiteralNode;
        }
        return literalNode;
    }
    @Override
    public IdentifierNode visitIdentifier(CFG_concreteParser.IdentifierContext context){
        IdentifierNode identifierNode = new IdentifierNode();
        identifierNode.id = context.getText();
        return identifierNode;
    }
    @Override
    public FunctionCallNode visitFunctionCall(CFG_concreteParser.FunctionCallContext context){
        FunctionCallNode functionCallNode = new FunctionCallNode();
        functionCallNode.id = (IdentifierNode) visit(context.identifier());
        functionCallNode.parameters = (ValueListNode) visit(context.parameterValueList());
        return functionCallNode;
    }
    @Override
    public MethodCallNode visitMethodCall(CFG_concreteParser.MethodCallContext context){
        MethodCallNode methodCallNode = new MethodCallNode();
        methodCallNode.valueID = (VariableAccessNode) visit(context.variableAccess());
        methodCallNode.methodID = (IdentifierNode) visit(context.identifier());
        methodCallNode.parameters = (ValueListNode) visit(context.parameterValueList());
        return methodCallNode;
    }
    @Override
    public ParenthesisedExprNode visitParenthesisedExpr(CFG_concreteParser.ParenthesisedExprContext context){
        ParenthesisedExprNode parenthesisedExprNode = new ParenthesisedExprNode();
        parenthesisedExprNode.innerExpr = (ExprNode) visit(context.orExpr());
        return parenthesisedExprNode;
    }
    @Override
    public ExprNode visitUnaryExpr(CFG_concreteParser.UnaryExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            if(context.getChild(0).getText().equals("-")){
                UnaryMinusNode unaryMinusNode = new UnaryMinusNode();
                unaryMinusNode.expr = (ExprNode) visit(context.atomExpr());
                exprNode = unaryMinusNode;
            }
            else if(context.getChild(0).getText().equals("+")){
                UnaryPlusNode unaryPlusNode = new UnaryPlusNode();
                unaryPlusNode.expr = (ExprNode) visit(context.atomExpr());
                exprNode = unaryPlusNode;
            }
            else {
                UnaryNegationNode unaryNegationNode = new UnaryNegationNode();
                unaryNegationNode.expr = (ExprNode) visit(context.atomExpr());
                exprNode = unaryNegationNode;
            }
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
    @Override
    public ExprNode visitOrExpr(CFG_concreteParser.OrExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            OrNode orNode = new OrNode();
            orNode.left = (ExprNode) visit(context.getChild(0));
            orNode.right = (ExprNode) visit(context.getChild(2));
            exprNode = orNode;
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
    @Override
    public ExprNode visitAndExpr(CFG_concreteParser.AndExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            AndNode andNode = new AndNode();
            andNode.left = (ExprNode) visit(context.getChild(0));
            andNode.right = (ExprNode) visit(context.getChild(2));
            exprNode = andNode;
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
    @Override
    public ExprNode visitEqualityExpr(CFG_concreteParser.EqualityExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("==")){
                EqualsNode equalsNode = new EqualsNode();
                equalsNode.left = (ExprNode) visit(context.getChild(0));
                equalsNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = equalsNode;
            }
            else{
                NotEqualsNode notEqualsNode = new NotEqualsNode();
                notEqualsNode.left = (ExprNode) visit(context.getChild(0));
                notEqualsNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = notEqualsNode;
            }
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
    @Override
    public ExprNode visitRelationExpr(CFG_concreteParser.RelationExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("<")){
                LesserThanNode lesserThanNode = new LesserThanNode();
                lesserThanNode.left = (ExprNode) visit(context.getChild(0));
                lesserThanNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = lesserThanNode;
            }
            else if(context.getChild(1).getText().equals(">")){
                GreaterThanNode greaterThanNode = new GreaterThanNode();
                greaterThanNode.left = (ExprNode) visit(context.getChild(0));
                greaterThanNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = greaterThanNode;
            }
            else if(context.getChild(1).getText().equals("<=")){
                LesserOrEqualsNode lesserOrEqualsNode = new LesserOrEqualsNode();
                lesserOrEqualsNode.left = (ExprNode) visit(context.getChild(0));
                lesserOrEqualsNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = lesserOrEqualsNode;
            }
            else{
                GreaterOrEqualsNode greaterOrEqualsNode = new GreaterOrEqualsNode();
                greaterOrEqualsNode.left = (ExprNode) visit(context.getChild(0));
                greaterOrEqualsNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = greaterOrEqualsNode;
            }
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
    @Override
    public ExprNode visitAdditiveExpr(CFG_concreteParser.AdditiveExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("+")){
                AdditionNode additionNode = new AdditionNode();
                additionNode.left = (ExprNode) visit(context.getChild(0));
                additionNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = additionNode;
            }
            else{
                SubtractionNode subtractionNode = new SubtractionNode();
                subtractionNode.left = (ExprNode) visit(context.getChild(0));
                subtractionNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = subtractionNode;
            }
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
    @Override
    public ExprNode visitMultiplicativeExpr(CFG_concreteParser.MultiplicativeExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("*")){
                MultiplicationNode multiplicationNode = new MultiplicationNode();
                multiplicationNode.left = (ExprNode) visit(context.getChild(0));
                multiplicationNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = multiplicationNode;
            }
            else if(context.getChild(1).getText().equals("/")){
                DivisionNode divisionNode = new DivisionNode();
                divisionNode.left = (ExprNode) visit(context.getChild(0));
                divisionNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = divisionNode;
            }
            else{
                ModuloNode moduloNode = new ModuloNode();
                moduloNode.left = (ExprNode) visit(context.getChild(0));
                moduloNode.right = (ExprNode) visit(context.getChild(2));
                exprNode = moduloNode;
            }
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
    @Override
    public ExprNode visitPowerExpr(CFG_concreteParser.PowerExprContext context){
        ExprNode exprNode;
        if(context.children.size() > 1){
            PowerNode powerNode = new PowerNode();
            powerNode.left = (ExprNode) visit(context.getChild(0));
            powerNode.right = (ExprNode) visit(context.getChild(2));
            exprNode = powerNode;
        }
        else{
            exprNode = (ExprNode) visit(context.getChild(0));
        }
        return exprNode;
    }
}

