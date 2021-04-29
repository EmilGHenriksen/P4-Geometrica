package AST;

import Exceptions.VarNotFoundException;
import Other.WriteToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//generates code in Java
public class CodeGenerator extends ASTvisitor<Node>{
    //misc
    SecureRandom randomizer = new SecureRandom();
    private String FixType(String Type){
        switch(Type){
            case "int": return "long";
            case "float": return "double";
            case "angle": return "double";
            case "bool": return "boolean";
            default: return Type;
        }
    }
    private String NonPrimitive(String type){
        switch(type){
            case "long": return "Long";
            case "double": return "Double";
            case "boolean": return "Boolean";
            default: return type;
        }
    }



    //output
    private void Emit(String text) {
        WriteToFile.Emit(text);
    }
    final String indentation = "    ";
    String currentIndentation = "";
    private void EmitNewline(){
        Emit("\n" + currentIndentation);
    }
    private void Indent(){
        currentIndentation += indentation;
    }
    private void Outdent(){
        if(!currentIndentation.equals("")){
            currentIndentation = currentIndentation.substring(0, currentIndentation.length()-indentation.length());
        }
    }
    private void EmitLibrary(){
        String fs = File.separator;
        String BasePath = new File("").getAbsolutePath();
        String OtherPath = BasePath.concat( fs + "ANTLR" + fs + "src" + fs + "main" + fs + "java" + fs + "Other" + fs);
        try {
            File myObj = new File(OtherPath + "DefaultLibrary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Emit(data);
                EmitNewline();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An I/O error occurred while trying to read default library.");
            e.printStackTrace();
        }
    }
    private void EmitType(String type, String typeModifier){
        int dimensions = typeModifier.length()/2;
        for(int i = 0; i < dimensions; i++){
            Emit("List<");
        }
        String fixedType = "";
        if(typeModifier.equals("")){
            fixedType = FixType(type);
        }
        else{
            fixedType = NonPrimitive(FixType(type));
        }
        Emit(fixedType);
        for(int i = 0; i < dimensions; i++){
            Emit(">");
        }
    }


    //visitors
    @Override
    public Node Visit(ProgramNode node) throws Exception {
        //external libraries
        Emit("import java.util.concurrent.TimeUnit;");
        EmitNewline();
        //program
        Emit("public class out{");
        Indent();
            EmitNewline();
            //default library
            EmitLibrary();
            //global variables
            for(int i = 0; i < SymTab.globalVars.size(); i++){
                DeclareStmtNode current = SymTab.globalVars.get(i);
                if(current.typeModifier == null) current.typeModifier = "";
                Emit("private static ");
                Visit(current);
                EmitNewline();
            }
            //global functions
            for(int i = 0; i < SymTab.globalFuncs.size(); i++){
                FunctionNode current = SymTab.globalFuncs.get(i);
                Emit("private static ");
                Visit(current);
                EmitNewline();
            }
            //rest of code
            Emit("public static void main(String[] args) {");
            Indent();
                EmitNewline();
                Visit(node.content);
            Outdent();
            EmitNewline();
            Emit("}");
        Outdent();
        EmitNewline();
        Emit("}");
        EmitNewline();
        return null;
    }

    @Override
    public Node Visit(ContentNode node) throws Exception {
        for(int i = 0; i < node.stmtAndFuncNodes.size(); i++){
            Node current = node.stmtAndFuncNodes.get(i);
            //functions and global declarations already loaded at this point
            if(!(current instanceof FunctionNode) && !(current instanceof DeclareStmtNode)){
                Visit(current);
                if(i != node.stmtAndFuncNodes.size()-1){
                    EmitNewline();
                }
            }
        }
        return null;
    }

    @Override
    public Node Visit(FunctionNode node) throws Exception {
        //first line
        EmitType(node.type, node.typeModifier);
        Emit(" ");
        Emit(node.id.id + "(");
        for(int i = 0; i < node.parameters.declarations.size(); i++){
            DeclareStmtNode currentParam = node.parameters.declarations.get(i);
            EmitType(node.type, node.typeModifier);
            Emit(" ");
            Emit(currentParam.id.id);
            if(i != node.parameters.declarations.size()-1){
                Emit(", ");
            }
        }
        Emit(") {");
        //statements
        Indent();
            EmitNewline();
            Visit(node.stmtFuncNodes);
        Outdent();
        EmitNewline();
        Emit("}");
        return null;
    }

    @Override
    public Node Visit(DeclareStmtListNode node) throws Exception {
        //unused
        return null;
    }

    @Override
    public Node Visit(ValueListNode node) throws Exception {
        //unused
        return null;
    }

    @Override
    public Node Visit(StmtListNode node) throws Exception {
        for(int i = 0; i < node.statements.size(); i++){
            Visit(node.statements.get(i));
            if(i != node.statements.size()-1){
                EmitNewline();
            }
        }
        return null;
    }

    @Override
    public Node Visit(ReturnStmtNode node) throws Exception {
        Emit("return ");
        Visit(node.value);
        Emit(";");
        return null;
    }

    @Override
    public Node Visit(DeclareStmtNode node) throws Exception {
        EmitType(node.type, node.typeModifier);
        Emit(" ");
        Emit(node.id.id);
        if(node.value != null){
            Emit(" = ");
            Visit(node.value);
        }
        Emit(";");
        return null;
    }

    @Override
    public Node Visit(AssignNode node) throws Exception {
        Visit(node.variable);
        Emit(" = ");
        Visit(node.value);
        Emit(";");
        return null;
    }

    @Override
    public Node Visit(IdentifierNode node) throws VarNotFoundException {
        Emit(node.GetID());
        return null;
    }

    @Override
    public Node Visit(VariableModifierAccessNode node) throws Exception {
        Visit(node.variable);
        Emit(".get(");
        Visit(node.expr);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(VariablePropertyAccessNode node) throws Exception {
        Visit(node.parent);
        Emit(".");
        Visit(node.child);
        return null;
    }

    @Override
    public Node Visit(VariableAccessExprNode node) throws Exception {
        Visit(node.variableExpr);
        return null;
    }

    @Override
    public Node Visit(IfNode node) throws Exception {
        Emit("if(");
        Visit(node.value);
        Emit(") {");
        if(node.ifStmtNodes != null){
            Indent();
                EmitNewline();
                Visit(node.ifStmtNodes);
            Outdent();
        }
        EmitNewline();
        Emit("}");
        if(node.elseStmtNode != null){
            EmitNewline();
            Emit("else {");
            Indent();
                EmitNewline();
                Visit(node.elseStmtNode);
            Outdent();
            Emit("}");
        }
        return null;
    }

    @Override
    public Node Visit(SwitchNode node) throws Exception {
        Emit("switch(");
        Visit(node.value);
        Emit(") {");
        Indent();
            EmitNewline();
            Visit(node.cases);
            Visit(node.defaultCase);
        Outdent();
        Emit("}");
        return null;
    }

    @Override
    public Node Visit(DefinedCaseListNode node) throws Exception {
        for(int i = 0; i < node.cases.size(); i++){
            Emit("case ");
            Visit(node.cases.get(i).value);
            Emit(":");
            Indent();
                EmitNewline();
                Visit(node.cases.get(i).stmtNodes);
                Emit("break;");
            Outdent();
            if(i != node.cases.size()-1){
                EmitNewline();
            }
        }
        return null;
    }

    @Override
    public Node Visit(DefinedCaseNode node) throws Exception {
        //unused
        return null;
    }

    @Override
    public Node Visit(DefaultCaseNode node) throws Exception {
        Emit("default:");
        Indent();
            EmitNewline();
            Visit(node.stmtNodes);
        Outdent();
        return null;
    }

    @Override
    public Node Visit(ForeachNode node) throws Exception {
        Emit("for(");
        EmitType(node.elementID.typeDecoration.type, node.elementID.typeDecoration.typeModifier);
        Emit(" ");
        Emit(node.elementID.id + " ");
        Emit(": ");
        Emit(node.collectionID.id);
        Emit(") {");
        Indent();
            EmitNewline();
            Visit(node.stmtNodes);
        Outdent();
        Emit("}");
        return null;
    }

    @Override
    public Node Visit(LoopNode node) throws Exception {
        String newVar = GetUnusedVarName();
        Emit("{");
        Indent();
            EmitNewline();
            //the counting variable
            Emit("long " + newVar + " = ");
            Visit(node.loopcount);
            Emit(";");
            //main matter - converts it to a while loop
            Emit("while(" + newVar + " > 0) {");
            Indent();
                EmitNewline();
                //code from the loop
                Visit(node.stmtNodes);
                //counting update
                Emit(newVar + "--;");
            Outdent();
            Emit("}");
            EmitNewline();
            //end of main matter
        Outdent();
        Emit("}");
        return null;
    }
    private String GetUnusedVarName(){
        //cryptographically secures it is not used (astronomically unlikely)
        byte[] name = new byte[32];
        randomizer.nextBytes(name);
        String newVar = byteArrayToHex(name);
        newVar = "i" + newVar;
        return newVar;
    }
    private String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b)); //formats as: (0 after .?) (2 characters) (hex)
        return sb.toString();
    }

    @Override
    public Node Visit(WhileNode node) throws Exception {
        Emit("while(");
        Visit(node.conditionExpression);
        Emit(") {");
        Indent();
        {
            EmitNewline();
            Visit(node.stmtNodes);
        }
        Outdent();
        Emit("}");
        return null;
    }

    @Override
    public Node Visit(ExprStmtNode node) throws Exception {
        Visit(node.expr);
        Emit(";");
        return null;
    }

    @Override
    public Node Visit(IntLiteralNode node) {
        Emit(node.value.toString());
        return null;
    }

    @Override
    public Node Visit(FloatLiteralNode node) {
        Emit(node.value.toString());
        return null;
    }

    @Override
    public Node Visit(PiLiteralNode node) {
        Emit("Math.PI");
        return null;
    }

    @Override
    public Node Visit(StringLiteralNode node) {
        Emit(node.value);
        return null;
    }

    @Override
    public Node Visit(BoolLiteralNode node) {
        Emit(node.value.toString());
        return null;
    }

    @Override
    public Node Visit(AngleLiteralNode node) {
        double value = node.value % 360;
        Emit(String.valueOf(value));
        return null;
    }

    @Override
    public Node Visit(ArrayLiteralNode node) throws Exception {
        Emit("Arrays.asList(");
        for(int i = 0; i < node.elements.size(); i++){
            Visit(node.elements.get(i));
            if(i != node.elements.size()-1){
                Emit(", ");
            }
        }
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(FunctionCallNode node) throws Exception {
        Emit(node.id + "(");
        for(int i = 0; i < node.parameters.exprNodes.size(); i++){
            Visit(node.parameters.exprNodes.get(i));
            if(i != node.parameters.exprNodes.size()){
                Emit(", ");
            }
        }
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(MethodCallNode node) throws Exception {
        Visit(node.valueID);
        Emit(".");
        Emit(node.methodID.id);
        Emit("(");
        for(int i = 0; i < node.parameters.exprNodes.size(); i++){
            Visit(node.parameters.exprNodes.get(i));
            if(i != node.parameters.exprNodes.size()){
                Emit(", ");
            }
        }
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(PropertyCallNode node) throws Exception {
        Visit(node.valueID);
        Emit(".");
        Emit(node.propertyID.id);
        return null;
    }

    @Override
    public Node Visit(ParenthesisedExprNode node) throws Exception {
        Emit("(");
        Visit(node.innerExpr);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(UnaryMinusNode node) throws Exception {
        Emit("(");
        Emit("-");
        Visit(node.expr);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(UnaryPlusNode node) throws Exception {
        Visit(node.expr);
        return null;
    }

    @Override
    public Node Visit(UnaryNegationNode node) throws Exception {
        Emit("(");
        Emit("!");
        Visit(node.expr);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(SubtractionNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" - ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(AdditionNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" + ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(MultiplicationNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" * ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(DivisionNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" / ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(ModuloNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" % ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(PowerNode node) throws Exception {
        //explicitly type cast because Java's Math.pow returns int
        Emit("((long)Math.pow(");
        Visit(node.left);
        Emit(", ");
        Visit(node.right);
        Emit("))");
        return null;
    }

    @Override
    public Node Visit(EqualsNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" == ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(NotEqualsNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" != ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(LesserThanNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" < ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(GreaterThanNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" > ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(LesserOrEqualsNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" <= ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(GreaterOrEqualsNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" >= ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(AndNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" && ");
        Visit(node.right);
        Emit(")");
        return null;
    }

    @Override
    public Node Visit(OrNode node) throws Exception {
        Emit("(");
        Visit(node.left);
        Emit(" || ");
        Visit(node.right);
        Emit(")");
        return null;
    }
}
