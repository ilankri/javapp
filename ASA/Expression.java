package ASA;

/*
 * Une expression est un morceau de code Java dont ce qu'il contient ne
 * nous interesse pas pour ce projet.  Il suffit de recuperer la chaine
 * de caracteres associee et de l'afficher.
 */
public class Expression implements Instruction {
    private String contents;

    public Expression(String contents) {
        this.contents = contents;
    }

    public String toString() {
        return contents;
    }
}
