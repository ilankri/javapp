package ASA;

import java.util.List;

public class DeclarationMethode implements CorpsClasse {
    private List<String> qualifiers;

    private Type returnType;

    private String name;

    private List<Argument> args;

    private List<Instruction> body;

    public DeclarationMethode(List<String> qualifiers, Type returnType,
                              String name, List<Argument> args,
                              List<Instruction> body) {
        this.qualifiers = qualifiers;
        this.returnType = returnType;
        this.name = name;
        this.args = args;
        this.body = body;
    }

    public List<String> getQualifiers() {
        return qualifiers;
    }

    public Type getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }

    public List<Argument> getArgs() {
        return args;
    }

    public BlocInstructions getBody() {
        return new BlocInstructions(body);
    }
}
