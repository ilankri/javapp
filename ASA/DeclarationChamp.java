package ASA;

import java.util.List;

public class DeclarationChamp implements CorpsClasse {
    private List<String> qualifiers;

    private Type type;

    private String name;

    private Expression value;

    public DeclarationChamp(List<String> qualifiers, Type type, String name,
                            Expression value) {
        this.qualifiers = qualifiers;
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public List<String> getQualifiers() {
        return qualifiers;
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
