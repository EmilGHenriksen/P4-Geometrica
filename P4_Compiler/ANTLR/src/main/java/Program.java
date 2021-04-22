import AST.ASTdecorator;
import AST.BuildAstVisitor;
import AST.Node;
import gen.CFG_concreteLexer;
import gen.CFG_concreteParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ErrorNodeImpl;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.ParseTreeMatch;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        ASTdecorator decorator = new ASTdecorator();

        try
        {
            var cst = parser.program();
            var ast = new BuildAstVisitor().visitProgram(cst);
            var ASTdecorated = decorator.Visit(ast);
            System.out.println(ASTdecorated);
        }
        catch (Exception ex)
        {
            System.out.print(ex.toString());
        }
    }
}
