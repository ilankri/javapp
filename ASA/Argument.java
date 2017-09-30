package ASA;

public class Argument {
    private Type type;

    private String name;

    public Argument(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
