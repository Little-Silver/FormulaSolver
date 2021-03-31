package logic.token.operations;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * @author Subhomoy Haldar
 * @version 1.0
 */
public class Division extends Operator {
    public static final Division INSTANCE = new Division();

    private Division() {
        super("/", 2, MULTIPLICATIVE, Multiplication.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].divide(operands[1]);
    }
}
