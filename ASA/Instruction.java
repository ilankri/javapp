package ASA;

/*
 * Cette interface correspond aux instructions.  Une instruction pourra
 * etre:
 *
 * +Une expression quelconque
 *
 * +Un branchement If Then Else
 *
 * +Une boucle While
 *
 * +Une boucle For
 *
 * +Une declaration de variable
 *
 * +Un bloc d'instructions
 */
import java.util.ArrayList;

public interface Instruction{
    default BlocInstructions toBlock(Instruction statement) {
        if (statement == null)
            return null;
        if (statement instanceof BlocInstructions) {
            return (BlocInstructions) statement;
        } else {
            ArrayList<Instruction> l = new ArrayList<>();
            l.add(statement);
            return new BlocInstructions(l);
        }
    }
}
