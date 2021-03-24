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
        List<StmtNode> Statements = new ArrayList<StmtNode>();
        for(int i = 3; i < context.children.size(); i++) {
            Statements.add(Visit(context.stmt()));
        }
        function.stmtNodes = Statements;

        return function;
    }
    
}

