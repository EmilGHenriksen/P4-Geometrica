package AST;

import gen.CFG_concreteBaseVisitor;
import gen.CFG_concreteParser;
import java.util.ArrayList;
import java.util.List;

public class BuildAstVisitor extends CFG_concreteBaseVisitor<Node> {
    @Override
    public ProgramNode visitProgram(CFG_concreteParser.ProgramContext context) throws InvalidNodeException {
        if (context.children.size() > 0  &&  context.children.get(0) != context.EOF()) {
            ProgramNode program = new ProgramNode();
            program.content = Visit(context.content());
            return program;
        }
        else {
            throw new InvalidNodeException();
        }
    }
    @Override
    public ContentNode visitContent(CFG_concreteParser.ContentContext context) throws InvalidNodeException {
        ContentNode content = new ContentNode();
        for (int i = 0; i < context.children.size() ;i++) {
            if (context.children.get(i) == context.function()) {
                content.functionNodes.add(Visit(context.function()));
            } else if (context.children.get(i) == context.stmt()) {
                content.stmtNodes.add(Visit(context.stmt()));
            } else {
                throw new InvalidNodeException();
            }
        }
        return content;
    }
    @Override
    public FunctionNode visitFunction(CFG_concreteParser.FunctionContext context) {
        FunctionNode function = new FunctionNode();
        function.type = context.Type().getText();
        function.typeModifier = context.TypeModifier().getText();
        function.id = Visit(context.identifier());
        function.parameters = Visit(context.parameterDeclareList());
        function.stmtFuncNodes = Visit(context.stmtList());
        return function;
    }
    @Override
    public DeclareStmtListNode visitParameterDeclareList(CFG_concreteParser.ParameterDeclareListContext context) {
        DeclareStmtListNode dcls = new DeclareStmtListNode();
        for(int i = 0 ; i < context.children.size() ; i++) {
            dcls.declarations.add(Visit(context.getChild(i))); // maybe an alternative: Visit(context.declare())
        }
        return dcls;
    }

    @Override
    public StmtListNode visitStmtList(CFG_concreteParser.StmtListContext context) {
        StmtListNode stmtListNode = new StmtListNode();
        for (int i = 0 ; i < context.children.size() ; i++) {
            stmtListNode.statements.add(Visit(context.getChild(i)));
        }
        return stmtListNode;
    }

    @Override
    public ReturnStmtNode visitReturn_(CFG_concreteParser.Return_Context context) {
        ReturnStmtNode returnStmt = new ReturnStmtNode();
        if(context.children.size() > 0) {
            returnStmt.value = Visit(context.expr());
        }
        return returnStmt;
    }
    @Override
    public DeclareStmtNode visitDeclare(CFG_concreteParser.DeclareContext context) {
        DeclareStmtNode dcl = new DeclareStmtNode();
        dcl.accessModifier = context.AccessModifier().getText();
        dcl.type = context.Type().getText();
        dcl.typeModifier = context.TypeModifier().getText();
        dcl.id = Visit(context.identifier());
        dcl.value = Visit(context.expr());
        return dcl;
    }
    @Override
    public AssignNode visitAssign(CFG_concreteParser.AssignContext context){
        AssignNode assign = new AssignNode();
        assign.id = Visit(context.identifier());
        assign.value = Visit(context.expr());
        return assign;
    }
    @Override
    public IfNode visitIfSelect(CFG_concreteParser.IfSelectContext context){
        IfNode ifnode = new IfNode();
        ifnode.value = Visit(context.expr());
        ifnode.ifStmtNodes = Visit(context.stmtList());
        ifnode.elseStmtNode = Visit(context.stmt());
        return ifnode;
    }
    @Override
    public SwitchNode visitSwitchSelect(CFG_concreteParser.SwitchSelectContext context) {
        SwitchNode switchnode = new SwitchNode();
        switchnode.value = Visit(context.expr());
        switchnode.cases = Visit(context.definedCaseList());
        switchnode.defaultCase = Visit(context.defaultCase());
        return switchnode;
    }
    @Override
    public DefinedCaseListNode visitDefinedCaseList(CFG_concreteParser.DefinedCaseListContext context){
        DefinedCaseListNode caseList = new DefinedCaseListNode();
        for(int i = 0 ; i < context.children.size() ; i++){
            caseList.cases.add(Visit(context.definedCase()));
        }
        return caseList;
    }
    @Override
    public DefinedCaseNode visitDefinedCase(CFG_concreteParser.DefinedCaseContext context){
        DefinedCaseNode definedCaseNode = new DefinedCaseNode();
        definedCaseNode.value = Visit(context.expr());
        definedCaseNode.stmtNodes = Visit(context.stmtList());
        return definedCaseNode;
    }
    @Override
    public DefaultCaseNode visitDefaultCase(CFG_concreteParser.DefaultCaseContext context){
        DefaultCaseNode defaultCaseNode = new DefaultCaseNode();
        defaultCaseNode.stmtNodes = Visit(context.stmtList());
        return defaultCaseNode;
    }
    @Override
    public ForeachNode visitForeachIterate(CFG_concreteParser.ForeachIterateContext context){
        ForeachNode foreachNode = new ForeachNode();
        foreachNode.elementID = Visit(context.identifier(0));
        foreachNode.collectionID = Visit(context.identifier(1));
        foreachNode.stmtNodes = Visit(context.stmtList());
        return foreachNode;
    }
    @Override
    public LoopNode visitLoopIterate(CFG_concreteParser.LoopIterateContext context){
        LoopNode loopNode = new LoopNode();
        loopNode.loopcount = Visit(context.expr());
        loopNode.stmtNodes = Visit(context.stmtList());
        return loopNode;
    }
    @Override
    public WhileNode visitWhileIterate(CFG_concreteParser.WhileIterateContext context){
        WhileNode whileNode = new WhileNode();
        whileNode.conditionExpression = Visit(context.expr());
        whileNode.stmtNodes = Visit(context.stmtList());
        return whileNode;
    }
    @Override
    public LiteralNode visitLiteral(CFG_concreteParser.LiteralContext context){
        LiteralNode literalNode = Visit(context.children);

        if(literalNode instanceof IntLiteralNode){
            IntLiteralNode intLiteralNode = new IntLiteralNode();
            intLiteralNode.value = ((IntLiteralNode) literalNode).value;
            literalNode = intLiteralNode;
        }
        else if(literalNode instanceof FloatLiteralNode){
            FloatLiteralNode floatLiteralNode = new FloatLiteralNode();
            floatLiteralNode.value = ((FloatLiteralNode) literalNode).value;
            literalNode = floatLiteralNode;
        }
        else if(literalNode instanceof PiLiteralNode){
            literalNode = new PiLiteralNode();
        }
        else if(literalNode instanceof StringLiteralNode){
            StringLiteralNode stringLiteralNode = new StringLiteralNode();
            stringLiteralNode.value = ((StringLiteralNode) literalNode).value;
            literalNode = stringLiteralNode;
        }
        else if(literalNode instanceof BoolLiteralNode){
            BoolLiteralNode boolLiteralNode = new BoolLiteralNode();
            boolLiteralNode.value = ((BoolLiteralNode) literalNode).value;
            literalNode = boolLiteralNode;
        }
        else if(literalNode instanceof AngleLiteralNode){
            AngleLiteralNode angleLiteralNode = new AngleLiteralNode();
            angleLiteralNode.value = ((AngleLiteralNode) literalNode).value;
            literalNode = angleLiteralNode;
        }
        else if(literalNode instanceof ArrayLiteralNode){
            ArrayLiteralNode arrayLiteralNode = new ArrayLiteralNode();
            arrayLiteralNode.elements = ((ArrayLiteralNode) literalNode).elements;
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
        functionCallNode.id = Visit(context.identifier());
        functionCallNode.parameters = Visit(context.parameterValueList());
        return functionCallNode;
    }
    @Override
    public MethodCallNode visitMethodCall(CFG_concreteParser.MethodCallContext context){
        MethodCallNode methodCallNode = new MethodCallNode();
        methodCallNode.valueID = Visit(context.identifier(0));
        methodCallNode.methodID = Visit(context.identifier(1));
        methodCallNode.parameters = Visit(context.parameterValueList());
        return methodCallNode;
    }
    @Override
    public PropertyCallNode visitPropertyCall(CFG_concreteParser.PropertyCallContext context){
        PropertyCallNode propertyCallNode = new PropertyCallNode();
        propertyCallNode.valueID = Visit(context.identifier(0));
        propertyCallNode.propertyID = Visit(context.identifier(1));
        return propertyCallNode;
    }
    @Override
    public ParenthesisedExprNode visitParenthesisedExpr(CFG_concreteParser.ParenthesisedExprContext context){
        ParenthesisedExprNode parenthesisedExprNode = new ParenthesisedExprNode();
        parenthesisedExprNode.innerExpr = Visit(context.orExpr());
        return parenthesisedExprNode;
    }
    @Override
    public UnaryExprNode visitUnaryExpr(CFG_concreteParser.UnaryExprContext context){
        UnaryExprNode unaryExprNode = Visit(context.children);
        unaryExprNode.expr = Visit(context.atomExpr());
        return unaryExprNode;
    }
    @Override
    public BinaryExprNode visitOrExpr(CFG_concreteParser.OrExprContext context){
        BinaryExprNode binaryExprNode = Visit(context.children);
        binaryExprNode.left = Visit(context.getChild(0));
        binaryExprNode.right = Visit(context.getChild(1));
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitAndExpr(CFG_concreteParser.AndExprContext context){
        BinaryExprNode binaryExprNode = Visit(context.children);
        binaryExprNode.left = Visit(context.getChild(0));
        binaryExprNode.right = Visit(context.getChild(1));
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitEqualityExpr(CFG_concreteParser.EqualityExprContext context){
        BinaryExprNode binaryExprNode = Visit(context.children);
        binaryExprNode.left = Visit(context.getChild(0));
        binaryExprNode.right = Visit(context.getChild(1));
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitRelationExpr(CFG_concreteParser.RelationExprContext context){
        BinaryExprNode binaryExprNode = Visit(context.children);
        binaryExprNode.left = Visit(context.getChild(0));
        binaryExprNode.right = Visit(context.getChild(1));
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitAdditiveExpr(CFG_concreteParser.AdditiveExprContext context){
        BinaryExprNode binaryExprNode = Visit(context.children);
        binaryExprNode.left = Visit(context.getChild(0));
        binaryExprNode.right = Visit(context.getChild(1));
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitMultiplicativeExpr(CFG_concreteParser.MultiplicativeExprContext context){
        BinaryExprNode binaryExprNode = Visit(context.children);
        binaryExprNode.left = Visit(context.getChild(0));
        binaryExprNode.right = Visit(context.getChild(1));
        return binaryExprNode;
    }
    @Override
    public BinaryExprNode visitPowerExpr(CFG_concreteParser.PowerExprContext context){
        BinaryExprNode binaryExprNode = Visit(context.children);
        binaryExprNode.left = Visit(context.getChild(0));
        binaryExprNode.right = Visit(context.getChild(1));
        return binaryExprNode;
    }
}

