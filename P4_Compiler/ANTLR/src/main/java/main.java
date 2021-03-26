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

public class main
{
    private static void Main() throws IOException {
        while (true)
        {
            System.out.print("> ");

            CharStream inputStream = CharStreams.fromFileName("test.txt");
            CFG_concreteLexer lexer = new CFG_concreteLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CFG_concreteParser parser = new CFG_concreteParser(tokenStream);

            try
            {
                ParseTree t = parser.expr();
                ParseTreePattern p = parser.compileParseTreePattern("<ID>+0", CFG_concreteParser.RULE_expr);
                ParseTreeMatch m = p.match(t);

                Node ast = new BuildAstVisitor().visit(t);

                //var value = new EvaluateExpressionVisitor().Visit(ast);
                //Console.WriteLine("= {0}", value);
            }
            catch (Exception ex)
            {
                System.out.print(ex);
            }

            //Console.WriteLine();
        }
    }
}
