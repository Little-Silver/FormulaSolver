package logic.token.functions;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;
import logic.token.operations.RaisingToPower;

/**
 * Wrapper for the Exponential function (exp).
 *
 * @author Subhomoy Haldar
 * @version 2017.04.20
 */
public class Exponential extends Operator {
    public static final Exponential INSTANCE = new Exponential();

    private Exponential() {
        super("exp", 1, FUNCTIONAL, RaisingToPower.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].exp();
    }
}
