package logic.token.operations;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * @author Subhomoy Haldar
 * @version 1.0
 */
public class Addition extends Operator {
    public static final Addition INSTANCE = new Addition();

    private Addition() {
        super("+", 2, ADDITIVE, Subtraction.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].add(operands[1]);
    }
}
