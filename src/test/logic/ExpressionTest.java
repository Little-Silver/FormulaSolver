package logic;
import logic.token.Token;
import logic.token.operands.Real;
import logic.token.operands.Variable;
import model.FormulaModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
class ExpressionTest
{
    Expression expression;

    @BeforeEach
    void setUp(){
        
    }
    
    //region Dissolve-Expression
    
    @Test
    @Disabled
    void dissolveAdd(){

        ExpressionDissolver expressionDissolver = new ExpressionDissolver();
        String expressionString = "4 + = 2 2 +";

        FormulaModel expression = new FormulaModel("4", "2 + 2");

        expression.setTokensLeft(ExpressionConverter.convert(ExpressionTokenizer.tokenize(expression.getFormLeftOriginal())));
        expression.setTokensRight(ExpressionConverter.convert(ExpressionTokenizer.tokenize(expression.getFormRightOriginal())));


        FormulaModel dissolvedExpression = expressionDissolver.dissolveExpression(expression, true);
        //TODO
    }

    @Test
    void dissolveAdd2(){
        ExpressionDissolver expressionDissolver = new ExpressionDissolver();
        
        String expressionString = "1 = A + 2";
        List<Token> tokensLeft  = ExpressionConverter.convert(ExpressionTokenizer.tokenize(expressionString.split("=")[0]));
        List<Token> tokensRight  = ExpressionConverter.convert(ExpressionTokenizer.tokenize(expressionString.split("=")[1]));
//TODO
        //assertEquals("A = 1 2 +",expressionDissolver.dissolveExpression(tokensLeft, tokensRight, false));
    }
    
    @Test
    void Test(){

        ExpressionDissolver expressionDissolver = new ExpressionDissolver();

        List<Token>    tokensRight = new ArrayList<>();
        tokensRight.add(new Variable("x"));
        tokensRight.add(new Real("4"));

        tokensRight.add(OperatorMap.INSTANCE.getFor("+"));
        
        List<Token>    tokensLeft = new ArrayList<>();
        tokensLeft.add(new Real("4"));
        tokensLeft.add(new Real("5"));
        tokensLeft.add(OperatorMap.INSTANCE.getFor("+"));

//TODO
        //assertEquals("A = 1 2 +",expressionDissolver.dissolveExpression(tokensLeft, tokensRight, false));
    }
    
    //endregion
    
    
    //region Basic-Calculation
    
    //region Operations
    @Test
    void add(){
        expression = new Expression(new FormulaModel("x", "4 + 2"));
        assertEquals(6.0,expression.evaluate().getValue());
    }

    @Test
    void subtract(){
        expression = new Expression(new FormulaModel("x", "4 - 2"));
        assertEquals(2.0,expression.evaluate().getValue());
    }
    
    @Test
    void divide(){
        expression = new Expression(new FormulaModel("x", "6 / 2"));
        assertEquals(3.0,expression.evaluate().getValue());
    }

    @Test
    void multiply(){
        expression = new Expression(new FormulaModel("x", "2 * 2"));
        assertEquals(4.0,expression.evaluate().getValue());
    }

    @Test
    void pow(){
        expression = new Expression(new FormulaModel("x", "2^3"));
        assertEquals(8.0,expression.evaluate().getValue());
    }
    //endregion

    //region Functions
    @Test
    void abs(){
        expression = new Expression(new FormulaModel("x", "sqrt(64)"));
        assertEquals(8.0,expression.evaluate().getValue());
    }

    @Test
    void arcSine(){
        expression = new Expression(new FormulaModel("x", "arcsin(1)"));
        assertEquals(Math.asin(1),expression.evaluate().getValue());
    }

    @Test
    void arcCosine(){
        expression = new Expression(new FormulaModel("x", "arccos(1)"));
        assertEquals(Math.acos(1),expression.evaluate().getValue());
    }
    
    @Test
    @Disabled
    void arcTangent(){
        expression = new Expression(new FormulaModel("x", "arctan(0.5)"));
        assertEquals(Math.atan(0.5),expression.evaluate().getValue());
    }

    @Test
    void cosine(){
        expression = new Expression(new FormulaModel("x", "cos(0)"));
        assertEquals(1.0,expression.evaluate().getValue());
    }

    @Test
    void exp(){
        expression = new Expression(new FormulaModel("x", "exp(2)"));
        assertEquals(Math.exp(2),expression.evaluate().getValue());
    }

    @Test
    void log(){
        expression = new Expression(new FormulaModel("x", "ln(16)"));
        assertEquals(Math.log(16),expression.evaluate().getValue());
    }

    @Test
    void sine(){
        expression = new Expression(new FormulaModel("x", "sin(0)"));
        assertEquals(0.0,expression.evaluate().getValue());
    }

    @Test
    void srqt(){
        expression = new Expression(new FormulaModel("x", "sqrt(64)"));
        assertEquals(8.0,expression.evaluate().getValue());
    }

    @Test
    void tangent(){
        expression = new Expression(new FormulaModel("x", "tan(0)"));
        assertEquals(0.0,expression.evaluate().getValue());
    }
    //endregion
    
    //endregion
    
}