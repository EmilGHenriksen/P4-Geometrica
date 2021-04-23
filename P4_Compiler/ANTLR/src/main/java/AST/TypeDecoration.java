package AST;

import java.lang.reflect.Type;

//used for expressions-related parts of the AST
public class TypeDecoration {
    //maybe insert access modifier here
    String type;
    String typeModifier;
    SymTab fields;

    public TypeDecoration(){}
    public TypeDecoration(String _type, String _typeModifier) {
        type = _type;
        typeModifier = _typeModifier;
    }
}
