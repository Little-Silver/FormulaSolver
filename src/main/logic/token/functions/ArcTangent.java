package logic.token.functions;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * Wrapper for the Tangent function (atan).
 *
 * @author Pascal Isliker
 */
public class ArcTangent extends Operator {
    public static final ArcTangent INSTANCE = new ArcTangent();

    private ArcTangent() {
        super("arctan", 1, FUNCTIONAL, Tangent.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].arcTangent();
    }
}
