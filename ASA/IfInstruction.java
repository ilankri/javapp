package ASA;

public class IfInstruction implements Instruction {
    private Expression condition;

    private Instruction thenStatement;

    private Instruction elseStatement;

    public IfInstruction(Expression condition, Instruction thenStatement,
                         Instruction elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public Expression getCondition() {
        return condition;
    }

    public BlocInstructions getThenBlock() {
        return toBlock(thenStatement);
    }

    public BlocInstructions getElseBlock() {
        return toBlock(elseStatement);
    }
}
