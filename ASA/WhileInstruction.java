package ASA;

public class WhileInstruction implements Instruction {
    private Expression condition;

    private Instruction body;

    public WhileInstruction(Expression condition, Instruction body) {
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public BlocInstructions getBody() {
        return toBlock(body);
    }
}
