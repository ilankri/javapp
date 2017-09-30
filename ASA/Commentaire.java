package ASA;

public class Commentaire implements Instruction, CorpsClasse {
    private String contents;

    public Commentaire(String contents) {
        this.contents = contents;
    }

    public String toString() {
        return contents;
    }
}
