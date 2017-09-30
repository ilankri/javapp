package ASA;

public class ForInstruction implements Instruction {
    private Expression init;

    private Expression condition;

    private Expression step;

    private Instruction body;

    public ForInstruction(Expression init, Expression condition,
                          Expression step, Instruction body) {
        this.init = init;
        this.condition = condition;
        this.step = step;
        this.body = body;
    }

    public Expression getInit() {
        return init;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getStep() {
        return step;
    }

    public BlocInstructions getBody() {
        return toBlock(body);
    }
}
