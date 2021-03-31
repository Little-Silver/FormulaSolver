package logic.token.functions;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * Wrapper for the Tangent function (tan).
 *
 * @author Subhomoy Haldar
 * @version 2017.04.20
 */
public class Tangent extends Operator {
    public static final Tangent INSTANCE = new Tangent();

    private Tangent() {
        super("tan", 1, FUNCTIONAL, ArcTangent.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].tangent();
    }
}
