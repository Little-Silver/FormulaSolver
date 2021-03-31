package logic.token.operations;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * @author Subhomoy Haldar
 * @version 1.0
 */
public class Subtraction extends Operator {
    public static final Subtraction INSTANCE = new Subtraction();

    private Subtraction() {
        super("-", 2, ADDITIVE, Addition.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].subtract(operands[1]);
    }
}
