package logic.token.functions;

import logic.exceptions.ArityException;
import logic.token.Operand;
import logic.token.Operator;

/**
 * Wrapper for the Cosine function (cos).
 *
 * @author Subhomoy Haldar
 * @version 2017.04.20
 */
public class Cosine extends Operator {
    public static final Cosine INSTANCE = new Cosine();

    private Cosine() {
        super("cos", 1, FUNCTIONAL, ArcCosine.INSTANCE);
    }

    @Override
    public Operand evaluate(Operand... operands) throws ArityException {
        check(operands.length);
        return operands[0].cosine();
    }
}
