package logic;
import logic.token.Operator;
import logic.token.Token;
import logic.token.operands.Real;
import logic.token.operands.Variable;
import logic.token.operations.Addition;
import logic.token.operations.Multiplication;
import jdk.jshell.spi.ExecutionControl;
import model.FormulaModel;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExpressionDissolver
{
    public ExpressionDissolver()
    {

    }

    public FormulaModel dissolveExpression(FormulaModel expression, boolean stepMode)
    {
        expression.setUnknownLeft(!containsVariable(expression.getTokensRight()));

        while (variableIsNotIsolated(expression))
        {
            performIsolationStep(expression);
        }

        Token[] sideWithUnknown = expression.getSideWithUnknown();
        if (variableHasOperator(sideWithUnknown)) {
            if (onlyPositivOperation(sideWithUnknown)) {
                expression.removeRedundantOperators();
            } else {
                try {
                    throw new ExecutionControl.NotImplementedException("Negativ Operator with isolated Variable");
                } catch (ExecutionControl.NotImplementedException e) {
                    e.printStackTrace();
                }
            }

        }

        return expression;
    }

    private void performIsolationStep(FormulaModel expression)
    {
        Token[] sideWithVar = expression.getSideWithUnknown();
        Operator mainOperation = (Operator) sideWithVar[sideWithVar.length - 1];

        List<Token[]> tokensGroup = getTokenGroupList(sideWithVar, mainOperation);
        ArrayUtils.removeAll(sideWithVar);

        List<Token> sideNoVarNew = expression.getSideWithoutUnknownAsList();
        List<Token> sideWithVarNew = new ArrayList<>();

        for (Token[] tokens : tokensGroup)
        {
            if (containsVariable(tokens))
            {
                sideWithVarNew.addAll(Arrays.asList(tokens));
            }
            else
            {
                Operator operator = (Operator) tokens[(tokens.length - 1)];

                if (operator.getPriority() != (mainOperation).getPriority()) {
                    ArrayUtils.add(tokens, logic.OperatorMap.INSTANCE.getFor(mainOperation.getSymbol()));
                }

                invertLast(tokens);

                sideNoVarNew.addAll(Arrays.asList(tokens));
            }
        }

        expression.setTokensLeft(sideWithVarNew);
        expression.setTokensRight(sideNoVarNew);
        expression.setUnknownLeft(true);
        expression.updateHistory();
    }

    private void removeOperators(Token[] tokensWithVar)
    {
        Iterator<Token> it = Arrays.stream(tokensWithVar).iterator();
        while (it.hasNext()){
            if(it.next() instanceof  Operator){
                it.remove();
            }
        }
    }

    private boolean onlyPositivOperation(Token[] tokensWithVar)
    {
        for (Token token : tokensWithVar) {
            if (token instanceof Operator && (!(token instanceof Addition) && !(token instanceof Multiplication))) {
                return false;
            }
        }
        return true;
    }

    private boolean variableHasOperator(Token[] tokensWithVar)
    {
        for (Token token : tokensWithVar) {
            if (token instanceof Operator) {
                return true;
            }
        }
        return false;
    }

    private boolean variableIsNotIsolated(FormulaModel expression)
    {
        Token[] tokensWithVar = expression.getSideWithUnknown();

        for (Token token : tokensWithVar) {
            if (token instanceof Real) {
                return true;
            }
        }
        return false;
    }

    private void invertLast(Token[] tokensArr)
    {
        tokensArr[tokensArr.length - 1] = ((Operator)tokensArr[tokensArr.length - 1]).getInvertedOperation();
    }

    private boolean containsVariable(Token[] tokens)
    {
        for (Token token : tokens) {
            if (token instanceof Variable) {
                return true;
            }
        }
        return false;
    }

    private List<Token[]> getTokenGroupList(Token[] tokensWithVar, Operator mainOperator)
    {
        List<Token[]> tokensGroup = new ArrayList<>();

        int distanceUntilBlockEnd = 0;
        int blockEnd              = tokensWithVar.length - 1;

        for (int i = blockEnd; i >= 0; i--) {
            if (tokensWithVar[i] instanceof Operator) {
                distanceUntilBlockEnd++;
            } else {
                distanceUntilBlockEnd--;
            }

            if (distanceUntilBlockEnd == 0) {
                tokensGroup.add(Arrays.copyOfRange(tokensWithVar, i, blockEnd + 1));
                blockEnd = i - 1;
            }

        }
        if(distanceUntilBlockEnd < 0){
            Token[] tokensToAdd = Arrays.copyOfRange(tokensWithVar, 0, 0 - distanceUntilBlockEnd);
            tokensGroup.add(ArrayUtils.add(tokensToAdd, logic.OperatorMap.INSTANCE.getFor(mainOperator.getSymbol())));
        }

        return tokensGroup;
    }

}
