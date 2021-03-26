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
        System.out.print("> ");

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
            ParseTree t = parser.expr();
            ParseTreePattern p = parser.compileParseTreePattern("<ID>+0", CFG_concreteParser.RULE_program);
            ParseTreeMatch m = p.match(t);

            Node ast = new BuildAstVisitor().visit(t);

            //var value = new EvaluateExpressionVisitor().Visit(ast);
            //Console.WriteLine("= {0}", value);
        }
        catch (Exception ex)
        {
            System.out.print(ex.toString());
        }

        //Console.WriteLine();
    }
}
