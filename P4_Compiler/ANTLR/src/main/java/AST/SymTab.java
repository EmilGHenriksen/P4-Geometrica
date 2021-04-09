package AST;

import java.util.List;

public class SymTab {
    List<SymList> scopes;
    //make constructors and methods next

}

class SymList {
    List<Symbol> symbols;
}

class Symbol {
    String id;
    ExprNode value;
}