package ASA;

public enum Keyword {
    PACKAGE, IMPORT, RETURN, IF, ELSE, WHILE, FOR, CLASS, INTERFACE, EXTENDS,
    IMPLEMENTS;

    public String toString() {
        switch (this) {
        case PACKAGE:
            return "package";
        case IMPORT:
            return "import";
        case RETURN:
            return "return";
        case IF:
            return "if";
        case ELSE:
            return "else";
        case WHILE:
            return "while";
        case FOR:
            return "for";
        case CLASS:
            return "class";
        case INTERFACE:
            return "interface";
        case EXTENDS:
            return "extends";
        case IMPLEMENTS:
            return "implements";
        default:
            assert false;
            return null;
        }
    }
}
