package logic;



import logic.exceptions.ArityException;
import logic.exceptions.ImproperParenthesesException;
import logic.token.Operand;
import logic.token.Token;
import logic.token.operations.Assignment;
import model.FormulaModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Pascal Isliker
 */
public class Expression
{
    private       FormulaModel dissolvedExpression;

    private final FormulaModel expression;

    public Expression(final FormulaModel expression) throws ExpressionConverter.ConversionException, ImproperParenthesesException, ExpressionTokenizer.UnrecognizedCharacterException, ExpressionTokenizer.UnrecognizedOperatorException
    {
        this.expression = expression;

        ExpressionDissolver expressionDissolver = new ExpressionDissolver();
        //Split between assignment
        //tokenize left and right separately

        expression.setTokensLeft(ExpressionConverter.convert(ExpressionTokenizer.tokenize(expression.getFormLeftOriginal())));
        expression.setTokensRight(ExpressionConverter.convert(ExpressionTokenizer.tokenize(expression.getFormRightOriginal())));

        dissolvedExpression = expressionDissolver.dissolveExpression(expression, true);
    }

    public Operand evaluate() throws ArityException, ExpressionConverter.ConversionException
    {
        return ExpressionEvaluator.evaluate(Arrays.asList(expression.getSideWithoutUnknown().clone()));
    }

    private boolean containsAssignment(String expression)
    {
        String pattern = ".*[" + Assignment.INSTANCE.getSymbol() + "].*";
        return Pattern.compile(pattern).matcher(expression).matches();
    }

    public FormulaModel getDissolvedExpression()
    {
        return dissolvedExpression;
    }

    public void setDissolvedExpression(FormulaModel dissolvedExpression)
    {
        this.dissolvedExpression = dissolvedExpression;
    }

    public FormulaModel getExpression()
    {
        return expression;
    }
}
