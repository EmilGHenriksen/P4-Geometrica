package AST;

import Exceptions.VarNotFoundException;
import Other.WriteToFile;

//generates code in Java
public class CodeGenerator extends ASTvisitor<Node>{
    //output
    private void Emit(String text) {
        WriteToFile.Emit(text);
    }
    String indentation = "    ";
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
        Visit(node.content);
        return null;
    }

    @Override
    public Node Visit(ContentNode node) throws Exception {
        for(int i = 0; i < node.stmtAndFuncNodes.size(); i++){
            Visit(node.stmtAndFuncNodes.get(i));
        }
        return null;
    }

    @Override
    public Node Visit(FunctionNode node) throws Exception {
        //first line
        Emit(node.type + node.typeModifier + " ");
        Emit(node.id + "(");
        for(int i = 0; i < node.parameters.declarations.size(); i++){
            DeclareStmtNode currentParam = node.parameters.declarations.get(i);
            Emit(currentParam.type + currentParam.typeModifier + " ");
            Emit(currentParam.id.id);
            if(i != node.parameters.declarations.size()-1){
                Emit(", ");
            }
        }
        Emit(") {");
        EmitNewline();
        //statements
        Indent();
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
        Emit(node.type + node.typeModifier + " ");
        Emit(node.id.id + " ");
        Emit("= ");
        Visit(node.value);
        Emit(";");
        EmitNewline();
        return null;
    }

    @Override
    public Node Visit(AssignNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(IdentifierNode node) throws VarNotFoundException {
        return null;
    }

    @Override
    public Node Visit(VariableModifierAccessNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(VariablePropertyAccessNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(VariableAccessExprNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(IfNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(SwitchNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(DefinedCaseListNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(DefinedCaseNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(DefaultCaseNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(ForeachNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(LoopNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(WhileNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(ExprStmtNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(IntLiteralNode node) {
        return null;
    }

    @Override
    public Node Visit(FloatLiteralNode node) {
        return null;
    }

    @Override
    public Node Visit(PiLiteralNode node) {
        return null;
    }

    @Override
    public Node Visit(StringLiteralNode node) {
        return null;
    }

    @Override
    public Node Visit(BoolLiteralNode node) {
        return null;
    }

    @Override
    public Node Visit(AngleLiteralNode node) {
        return null;
    }

    @Override
    public Node Visit(ArrayLiteralNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(FunctionCallNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(MethodCallNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(PropertyCallNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(ParenthesisedExprNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(UnaryMinusNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(UnaryPlusNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(UnaryNegationNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(SubtractionNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(AdditionNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(MultiplicationNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(DivisionNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(ModuloNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(PowerNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(EqualsNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(NotEqualsNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(LesserThanNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(GreaterThanNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(LesserOrEqualsNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(GreaterOrEqualsNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(AndNode node) throws Exception {
        return null;
    }

    @Override
    public Node Visit(OrNode node) throws Exception {
        return null;
    }
}
