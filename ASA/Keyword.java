package ASA;

public enum Keyword {
    PACKAGE, IMPORT, RETURN, IF, ELSE, WHILE, FOR, CLASS, INTERFACE, EXTENDS,
    IMPLEMENTS;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
