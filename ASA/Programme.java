package ASA;

import java.util.List;

public class Programme {
    private String pack;

    private List<String> imports;

    private List<Commentaire> comments;

    private DeclarationClasseOuInterface decl;

    public Programme(String pack, List<String> imports,
                     List<Commentaire> comments,
                     DeclarationClasseOuInterface decl) {
        this.pack = pack;
        this.imports = imports;
        this.comments = comments;
        this.decl = decl;
    }

    public String getPack() {
        return pack;
    }

    public List<String> getImports() {
        return imports;
    }

    public List<Commentaire> getComments() {
        return comments;
    }

    public DeclarationClasseOuInterface getDecl() {
        return decl;
    }
}
