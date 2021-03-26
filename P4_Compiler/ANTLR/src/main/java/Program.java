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
            inputStream = CharStreams.fromFileName("C:\\Users\\Anders\\Documents\\GitHub\\p4_compiler\\P4_Compiler\\ANTLR\\src\\main\\java\\test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        CFG_concreteLexer lexer = new CFG_concreteLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFG_concreteParser parser = new CFG_concreteParser(tokenStream);

        try
        {
            var cst = parser.program();
            var ast = new BuildAstVisitor().visitProgram(cst);
            System.out.println(ast);
        }
        catch (Exception ex)
        {
            System.out.print(ex.toString());
        }

    }
}
