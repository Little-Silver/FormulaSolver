package logic.token.functions;

import logic.exceptions.ArityException;
import logic.exceptions.EvaluationException;
import logic.token.Operand;
import logic.token.Operator;
/**
 * Wrapper for the absolute value function (abs).
 *
 * @author Subhomoy Haldar
 * @version 2017.05.12
 */
public class Absolute extends Operator
{
    public static final Absolute INSTANCE = new Absolute();

    private Absolute() {
        super("abs", 1, FUNCTIONAL, null);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException, EvaluationException
    {
        check(operands.length);
        return operands[0].abs();
    }
}
