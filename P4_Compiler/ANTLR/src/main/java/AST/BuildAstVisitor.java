package AST;
import gen.CFG_concreteBaseVisitor;
import gen.CFG_concreteParser;

public class BuildAstVisitor extends CFG_concreteBaseVisitor<StmtNode> {
    @Override
    public StmtNode visitProgram(CFG_concreteParser.ProgramContext context){
        if (context == context.function()) {
            return Visit(context.function());
        }
        else if(context == context.stmt()){
            return Visit(context.stmt());
        }
    }
}
