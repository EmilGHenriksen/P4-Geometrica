import AST.ASTdecorator;
import AST.BuildAstVisitor;
import AST.CodeGenerator;
import AST.Node;
import Other.WriteToFile;
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
        String fs = File.separator;
        String fileName = "test.txt";
        try {
            String BasePath = new File("").getAbsolutePath();
            String ANTLRpath = BasePath.concat( fs + "ANTLR" + fs + "src" + fs + "main" + fs + "java" + fs);
            String InputPath = ANTLRpath.concat(fileName);
            inputStream = CharStreams.fromFileName(InputPath);


            CFG_concreteLexer lexer = new CFG_concreteLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CFG_concreteParser parser = new CFG_concreteParser(tokenStream);
            ASTdecorator decorator = new ASTdecorator();
            CodeGenerator generator = new CodeGenerator();

            try
            {
                var cst = parser.program();
                var ast = new BuildAstVisitor().visitProgram(cst);
                var ASTdecorated = decorator.Visit(ast);
                WriteToFile.Initiate(ANTLRpath + "out.java");
                generator.Visit(ASTdecorated);
                //WriteToFile.Close();

                System.out.println(ASTdecorated);
            }
            catch (Exception ex)
            {
                System.out.print(ex.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
