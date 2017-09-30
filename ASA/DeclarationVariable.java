package ASA;

public class DeclarationVariable implements Instruction {
    private Type type;

    private String name;

    private Expression value;

    public DeclarationVariable(Type type, String name, Expression value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Expression getValue() {
        return value;
    }
}
