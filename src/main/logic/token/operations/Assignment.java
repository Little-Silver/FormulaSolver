package logic.token.operations;

import logic.exceptions.ArityException;
import logic.exceptions.EvaluationException;
import logic.token.Operand;
import logic.token.Operator;
import logic.token.VariableMap;
import logic.token.operands.Variable;

/**
 * @author Subhomoy Haldar
 * @version 2017.04.22
 */
public class Assignment extends Operator {
    public static final Assignment INSTANCE = new Assignment();

    private Assignment() {
        super("=", 2, ASSIGNMENT, null);
    }

    @Override
    public Operand evaluate(Operand... operands) throws
            ArityException,
            EvaluationException {
        check(operands.length);
        // Make sure that the operand being assigned to
        // is a variable.
        if (!(operands[0] instanceof Variable)) {
            throw new EvaluationException("Assignment only works for variables.");
        }
        VariableMap.INSTANCE.bind((Variable) operands[0], operands[1]);
        return operands[1];
    }
}
