package logic.token.operations;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * @author Subhomoy Haldar
 * @version 1.0
 */
public class Multiplication extends Operator {
    public static final Multiplication INSTANCE = new Multiplication();

    private Multiplication() {
        super("*", 2, MULTIPLICATIVE, Division.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].multiply(operands[1]);
    }
}
