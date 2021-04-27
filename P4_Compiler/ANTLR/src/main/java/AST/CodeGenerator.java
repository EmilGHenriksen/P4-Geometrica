package AST;

import Exceptions.VarNotFoundException;
import Other.WriteToFile;
import java.security.SecureRandom;

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


    //visitors
    @Override
    public Node Visit(ProgramNode node) throws Exception {
        Emit("public class out{");
        Indent();
            EmitNewline();
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
            Emit("}");
            EmitNewline();
        Outdent();
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
            }
        }
        return null;
    }

    @Override
    public Node Visit(FunctionNode node) throws Exception {
        //first line
        Emit(FixType(node.type) + node.typeModifier + " ");
        Emit(node.id.id + "(");
        for(int i = 0; i < node.parameters.declarations.size(); i++){
            DeclareStmtNode currentParam = node.parameters.declarations.get(i);
            Emit(FixType(currentParam.type) + currentParam.typeModifier + " ");
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
        //end of function
        Emit("}");
        EmitNewline();
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
        }
        return null;
    }

    @Override
    public Node Visit(ReturnStmtNode node) throws Exception {
        Emit("return ");
        Visit(node.value);
        Emit(";");
        EmitNewline();
        return null;
    }

    @Override
    public Node Visit(DeclareStmtNode node) throws Exception {
        Emit(FixType(node.type) + node.typeModifier + " ");
        Emit(node.id.id);
        if(node.value != null){
            Emit(" = ");
            Visit(node.value);
        }
        Emit(";");
        EmitNewline();
        return null;
    }

    @Override
    public Node Visit(AssignNode node) throws Exception {
        Visit(node.variable);
        Emit(" = ");
        Visit(node.value);
        Emit(";");
        EmitNewline();
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
        Emit("[");
        Visit(node.expr);
        Emit("]");
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
        Emit("}");
        EmitNewline();
        if(node.elseStmtNode != null){
            Emit("else {");
            Indent();
                EmitNewline();
                Visit(node.elseStmtNode);
            Outdent();
            Emit("}");
            EmitNewline();
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
        EmitNewline();
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
            EmitNewline();
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
        Emit(FixType(node.elementID.typeDecoration.type) + node.elementID.typeDecoration.typeModifier + " ");
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
        EmitNewline();
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
        EmitNewline();
        return null;
    }

    @Override
    public Node Visit(ExprStmtNode node) throws Exception {
        Visit(node.expr);
        Emit(";");
        EmitNewline();
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
        Emit("{");
        for(int i = 0; i < node.elements.size(); i++){
            Visit(node.elements.get(i));
            if(i != node.elements.size()-1){
                Emit(", ");
            }
        }
        Emit("}");
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
        Emit("Math.Pow(");
        Visit(node.left);
        Emit(", ");
        Visit(node.right);
        Emit(")");
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