package ASA;

import java.util.List;

public class BlocInstructions implements Instruction, CorpsClasse {
    private List<Instruction> statements;

    public BlocInstructions(List<Instruction> statements) {
        this.statements = statements;
    }

    public List<Instruction> getStatements() {
        return statements;
    }
}
