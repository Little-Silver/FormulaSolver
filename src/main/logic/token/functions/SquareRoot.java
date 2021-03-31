package logic.token.functions;

import logic.exceptions.ArityException;
import logic.exceptions.EvaluationException;
import logic.token.Operand;
import logic.token.Operator;
import logic.token.operations.RaisingToPower;
/**
 * Wrapper for the square root function (sqrt).
 *
 * @author Subhomoy Haldar
 * @version 2017.04.22
 */
public class SquareRoot extends Operator
{
    public static final SquareRoot INSTANCE = new SquareRoot();

    private SquareRoot() {
        super("sqrt", 1, FUNCTIONAL, RaisingToPower.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException, EvaluationException
    {
        check(operands.length);
        return operands[0].sqrt();
    }
}
