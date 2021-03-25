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
        function.type = Visit(context.Type());
        function.id = Visit(context.Identifier());
        function.parameters = Visit(context.parameterDeclareList());
        function.stmtFuncNodes = Visit(context.stmtList());
        return function;
    }
    @Override
    public DeclareStmtListNode visitParameterDeclareList(CFG_concreteParser.ParameterDeclareListContext context) {
        DeclareStmtListNode dcls = new DeclareStmtListNode();
        for(int i = 0 ; i < context.children.size() ; i++) {
            dcls.declarations.add(Visit(context.declare()));
        }
        return dcls;
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
        dcl.accessModifier = Visit(context.AccessModifier());
        dcl.type = Visit(context.Type());
        dcl.typeModifier = Visit(context.TypeModifier());
        dcl.id = Visit(context.Identifier());
        dcl.value = Visit(context.expr());
        return dcl;
    }
    @Override
    public AssignNode visitAssign(CFG_concreteParser.AssignContext context){
        AssignNode assign = new AssignNode();
        assign.id = Visit(context.Identifier());
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
}

