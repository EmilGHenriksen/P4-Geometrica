package AST;

//used for expressions-related parts of the AST
public class TypeDecoration {
    String type;
    String typeModifier;

    public TypeDecoration(String _type, String _typeModifier) {
        type = _type;
        typeModifier = _typeModifier;
    }
}
