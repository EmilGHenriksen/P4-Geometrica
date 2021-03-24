package AST;
import gen.CFG_concreteBaseVisitor;
import gen.CFG_concreteParser;

public class BuildAstVisitor extends CFG_concreteBaseVisitor<Node> {
    @Override
    public ProgramNode visitProgram(CFG_concreteParser.ProgramContext context) throws InvalidNodeException {
        if (context != context.EOF()) {
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
            if (context == context.function()) {
                content.functionNodes.add(Visit(context.function()));
            } else if (context == context.stmt()) {
                content.stmtNodes.add(Visit(context.stmt()));
            } else {
                throw new InvalidNodeException();
            }
        }
        return content;
    }
    @Override
    public FunctionNode visitFunction(CFG_concreteParser.FunctionContext context) {
        
    }
}

