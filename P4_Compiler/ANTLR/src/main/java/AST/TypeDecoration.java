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
    @Override
    public boolean equals(Object obj)
    {
        //Check for null and compare run-time types.
        if (!(obj instanceof TypeDecoration))
        {
            return false;
        }
        else {
            TypeDecoration T1 = (TypeDecoration) obj;
            TypeDecoration T2 = this;
            if(T1.typeModifier == null) T1.typeModifier = "";
            if(T2.typeModifier == null) T2.typeModifier = "";
            if(T1.fields == null) T1.fields = new SymTab();
            if(T2.fields == null) T2.fields = new SymTab();

            return T1.type.equals(T2.type)
                    && T1.typeModifier.equals(T2.typeModifier)
                    && T1.fields.equals(T2.fields);
        }
    }
}
