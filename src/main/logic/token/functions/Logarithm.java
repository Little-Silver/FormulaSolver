package logic.token.functions;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * @author Subhomoy Haldar
 * @version 2017.05.12
 */
public class Logarithm extends Operator {
    public static final Logarithm INSTANCE = new Logarithm();

    private Logarithm() {
        super("ln", 1, FUNCTIONAL, Exponential.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].ln();
    }
}
