package ASA;

import java.util.List;

public class DeclarationClasseOuInterface {
    private List<String> qualifiers;

    private boolean isClass;

    private String name;

    private List<String> interfaces;

    private String parent;

    private List<CorpsClasse> body;

    public DeclarationClasseOuInterface(List<String> qualifiers,
                                        boolean isClass, String name,
                                        List<String> interfaces, String parent,
                                        List<CorpsClasse> body) {
        this.qualifiers = qualifiers;
        this.isClass = isClass;
        this.name = name;
        this.interfaces = interfaces;
        this.parent = parent;
        this.body = body;
    }

    public List<String> getQualifiers() {
        return qualifiers;
    }

    public boolean isClass() {
        return isClass;
    }

    public String getName() {
        return name;
    }

    public List<String> getInterfaces() {
        return interfaces;
    }

    public String getParent() {
        return parent;
    }

    public List<CorpsClasse> getBody() {
        return body;
    }
}
