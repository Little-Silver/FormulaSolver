package logic.token.functions;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * Wrapper for the Sine function (sin).
 *
 * @author Subhomoy Haldar
 * @version 2017.04.20
 */
public class ArcSine extends Operator {
    public static final ArcSine INSTANCE = new ArcSine();

    private ArcSine() {
        super("arcsin", 1, FUNCTIONAL, Sine.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].arcSine();
    }
}
