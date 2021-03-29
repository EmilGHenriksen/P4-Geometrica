package AST;

import gen.CFG_concreteBaseVisitor;
import gen.CFG_concreteParser;

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
            for (int i = 0; i < context.children.size(); i++) {
                if (context.children.get(i) instanceof CFG_concreteParser.FunctionContext) {
                    content.functionNodes.add((FunctionNode) visit(context.function(0)));
                } else if (context.children.get(i) instanceof CFG_concreteParser.StmtContext) {
                    content.stmtNodes.add((StmtNode) visit(context.stmt(0)));
                }
            }
        }
        return content;
    }
    @Override
    public FunctionNode visitFunction(CFG_concreteParser.FunctionContext context) {
        FunctionNode function = new FunctionNode();
        function.type = context.Type().getText();
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
                dcls.declarations.add((DeclareStmtNode) visit(context.getChild(i))); // maybe an alternative: Visit(context.declare())
            }
        }
        return dcls;
    }

    @Override
    public StmtListNode visitStmtList(CFG_concreteParser.StmtListContext context) {
        StmtListNode stmtListNode = new StmtListNode();
        if(context.children != null) {
            for (int i = 0; i < context.children.size(); i++) {
                stmtListNode.statements.add((StmtNode) visit(context.getChild(i)));
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
        assign.id = (IdentifierNode) visit(context.identifier());
        assign.value = (ExprNode) visit(context.expr());
        return assign;
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
                caseList.cases.add((DefinedCaseNode) visit(context.definedCase(i)));
            }
        }
        return caseList;
    }
    @Override
    public DefinedCaseNode visitDefinedCase(CFG_concreteParser.DefinedCaseContext context){
        DefinedCaseNode definedCaseNode = new DefinedCaseNode();
        definedCaseNode.value = (ExprNode) visit(context.expr());
        definedCaseNode.stmtNodes = (StmtListNode) visit(context.stmtList());
        return definedCaseNode;
    }
    @Override
    public DefaultCaseNode visitDefaultCase(CFG_concreteParser.DefaultCaseContext context){
        DefaultCaseNode defaultCaseNode = new DefaultCaseNode();
        defaultCaseNode.stmtNodes = (StmtListNode) visit(context.stmtList());
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
    public LiteralNode visitLiteral(CFG_concreteParser.LiteralContext context){
        LiteralNode literalNode;

        if(context.getChild(0) instanceof IntLiteralNode){
            IntLiteralNode intLiteralNode = new IntLiteralNode();
            intLiteralNode.value = parseLong(context.getChild(0).getText());
            literalNode = intLiteralNode;
        }
        else if(context.getChild(0) instanceof FloatLiteralNode){
            FloatLiteralNode floatLiteralNode = new FloatLiteralNode();
            floatLiteralNode.value = parseDouble(context.getChild(0).getText());
            literalNode = floatLiteralNode;
        }
        else if(context.getChild(0) instanceof PiLiteralNode){
            literalNode = new PiLiteralNode();
        }
        else if(context.getChild(0) instanceof StringLiteralNode){
            StringLiteralNode stringLiteralNode = new StringLiteralNode();
            String temp = context.getChild(0).getText();
            stringLiteralNode.value = temp.substring(1, temp.length() -1);
            literalNode = stringLiteralNode;
        }
        else if(context.getChild(0) instanceof BoolLiteralNode){
            BoolLiteralNode boolLiteralNode = new BoolLiteralNode();
            boolLiteralNode.value = Boolean.parseBoolean(context.getChild(0).getText());
            literalNode = boolLiteralNode;
        }
        else if(context.getChild(0) instanceof AngleLiteralNode){
            AngleLiteralNode angleLiteralNode = new AngleLiteralNode();
            String temp = context.getChild(0).getText();
            angleLiteralNode.value = parseDouble(temp.substring(0, temp.length() - 3));
            literalNode = angleLiteralNode;
        }
        else{
            ArrayLiteralNode arrayLiteralNode = new ArrayLiteralNode();
            for(int i = 1; i < context.children.size(); i += 2 ){
                arrayLiteralNode.elements.add((ExprNode)context.getChild(i));
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
        methodCallNode.valueID = (IdentifierNode) visit(context.identifier(0));
        methodCallNode.methodID = (IdentifierNode) visit(context.identifier(1));
        methodCallNode.parameters = (ValueListNode) visit(context.parameterValueList());
        return methodCallNode;
    }
    @Override
    public PropertyCallNode visitPropertyCall(CFG_concreteParser.PropertyCallContext context){
        PropertyCallNode propertyCallNode = new PropertyCallNode();
        propertyCallNode.valueID = (IdentifierNode) visit(context.identifier(0));
        propertyCallNode.propertyID = (IdentifierNode) visit(context.identifier(1));
        return propertyCallNode;
    }
    @Override
    public ParenthesisedExprNode visitParenthesisedExpr(CFG_concreteParser.ParenthesisedExprContext context){
        ParenthesisedExprNode parenthesisedExprNode = new ParenthesisedExprNode();
        parenthesisedExprNode.innerExpr = (ExprNode) visit(context.orExpr());
        return parenthesisedExprNode;
    }
    @Override
    public UnaryExprNode visitUnaryExpr(CFG_concreteParser.UnaryExprContext context){
        UnaryExprNode unaryExprNode;
        if(context.children.size() > 1){
            if(context.getChild(0).getText().equals("-")){
                unaryExprNode = new UnaryMinusNode();
            }
            else if(context.getChild(0).getText().equals("+")){
                unaryExprNode = new UnaryPlusNode();
            }
            else {
                unaryExprNode = new UnaryNegationNode();
            }
            unaryExprNode.expr = (ExprNode) visit(context.atomExpr());
        }
        else{
            unaryExprNode = (UnaryExprNode) visit(context.getChild(0));
        }
        return unaryExprNode;
    }
    @Override
    public BinaryExprNode visitOrExpr(CFG_concreteParser.OrExprContext context){
        BinaryExprNode binaryExprNode;
        if(context.children.size() > 1){
            binaryExprNode = new OrNode();
            binaryExprNode.left = (ExprNode) visit(context.getChild(0));
            binaryExprNode.right = (ExprNode) visit(context.getChild(2));
        }
        else{
            binaryExprNode = (BinaryExprNode) visit(context.getChild(0));
        }
        return binaryExprNode;
    }
    @Override
    public AndExprNode visitAndExpr(CFG_concreteParser.AndExprContext context){
        AndExprNode binaryExprNode;
        if(context.children.size() > 1){
            binaryExprNode = new AndNode();
            binaryExprNode.left = (ExprNode) visit(context.getChild(0));
            binaryExprNode.right = (ExprNode) visit(context.getChild(2));
        }
        else{
            binaryExprNode = (AndExprNode) visit(context.getChild(0));
        }
        return AndExprNode;
    }
    @Override
    public BinaryExprNode visitEqualityExpr(CFG_concreteParser.EqualityExprContext context){
        BinaryExprNode binaryExprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("==")){
                binaryExprNode = new EqualsNode();
            }
            else{
                binaryExprNode = new NotEqualsNode();
            }
            binaryExprNode.left = (ExprNode) visit(context.getChild(0));
            binaryExprNode.right = (ExprNode) visit(context.getChild(2));
        }
        else{
            binaryExprNode = (BinaryExprNode) visit(context.getChild(0));
        }
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitRelationExpr(CFG_concreteParser.RelationExprContext context){
        BinaryExprNode binaryExprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("<")){
                binaryExprNode = new LesserThanNode();
            }
            else if(context.getChild(1).getText().equals(">")){
                binaryExprNode = new GreaterThanNode();
            }
            else if(context.getChild(1).getText().equals("<=")){
                binaryExprNode = new LesserOrEqualsNode();
            }
            else{
                binaryExprNode = new GreaterOrEqualsNode();
            }
            binaryExprNode.left = (ExprNode) visit(context.getChild(0));
            binaryExprNode.right = (ExprNode) visit(context.getChild(1));
        }
        else{
            binaryExprNode = (BinaryExprNode) visit(context.getChild(0));
        }
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitAdditiveExpr(CFG_concreteParser.AdditiveExprContext context){
        BinaryExprNode binaryExprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("+")){
                binaryExprNode = new AdditionNode();
            }
            else{
                binaryExprNode = new SubtractionNode();
            }
            binaryExprNode.left = (ExprNode) visit(context.getChild(0));
            binaryExprNode.right = (ExprNode) visit(context.getChild(1));
        }
        else{
            binaryExprNode = (BinaryExprNode) visit(context.getChild(0));
        }
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitMultiplicativeExpr(CFG_concreteParser.MultiplicativeExprContext context){
        BinaryExprNode binaryExprNode;
        if(context.children.size() > 1){
            if(context.getChild(1).getText().equals("*")){
                binaryExprNode = new MultiplicationNode();
            }
            else if(context.getChild(1).getText().equals("/")){
                binaryExprNode = new DivisionNode();
            }
            else{
                binaryExprNode = new ModuloNode();
            }
            binaryExprNode.left = (ExprNode) visit(context.getChild(0));
            binaryExprNode.right = (ExprNode) visit(context.getChild(1));
        }
        else{
            binaryExprNode = (BinaryExprNode) visit(context.getChild(0));
        }
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitPowerExpr(CFG_concreteParser.PowerExprContext context){
        BinaryExprNode binaryExprNode;
        if(context.children.size() > 1){
            binaryExprNode = new PowerNode();
            binaryExprNode.left = (ExprNode) visit(context.getChild(0));
            binaryExprNode.right = (ExprNode) visit(context.getChild(1));
        }
        else{
            binaryExprNode = (BinaryExprNode) visit(context.getChild(0));
        }
        return binaryExprNode;
    }
}

