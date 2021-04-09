import AST.BuildAstVisitor;
import AST.Node;
import gen.CFG_concreteLexer;
import gen.CFG_concreteParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.ParseTreeMatch;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;

import java.io.*;

public class Program
{
    public static void main(String[] args) {
        CharStream inputStream = null;
        try {
            String path = new File("").getAbsolutePath();
            path = path.concat("\\ANTLR\\src\\main\\java\\test.txt");
            inputStream = CharStreams.fromFileName(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CFG_concreteLexer lexer = new CFG_concreteLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFG_concreteParser parser = new CFG_concreteParser(tokenStream);

        try
        {
            var cst = parser.program();
            checkCstExceptions(cst);
            var ast = new BuildAstVisitor().visitProgram(cst);
            System.out.println(ast);
        }
        catch (Exception ex)
        {
            System.out.print(ex.toString());
        }

    }

    static void checkCstExceptions(CFG_concreteParser.ProgramContext cst) throws Exception {
        int iStmt = 0;
        int iFunc = 0;
        for(int i = 0; i < cst.content().children.size(); i++){
            if(cst.content().getChild(i) instanceof CFG_concreteParser.StmtContext){
                if(cst.content().stmt(iStmt).exception != null){
                    throw new Exception("Null statement in CST");
                }
                iStmt++;
            }
            else{
                if(cst.content().function(iFunc).exception != null){
                    throw new Exception("Null function in CST");
                }
                iFunc++;
            }
        }
    }
}
