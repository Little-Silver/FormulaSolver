package model;

import logic.token.Token;
import logic.token.operations.Addition;
import logic.token.operations.Multiplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pascal Isliker
 */
public class FormulaModel
{
    private final String formLeftOriginal;
    private final String formRightOriginal;

    private String formLeftCurrent;
    private String formRightCurrent;

    private List<Token> tokenListLeft;
    private List<Token> tokenListRight;

    private List<String> tokenListHistory = new ArrayList<>();

    private boolean isUnknownLeft = false;

    public FormulaModel(String tokenListLeft, String tokenListRight)
    {
        //remove Brackets "[]" and Kommas ","
        this.formLeftOriginal = tokenListLeft.replaceAll("\\[|\\]|,", "");
        this.formRightOriginal = tokenListRight.replaceAll("\\[|\\]|,", "");
        this.formLeftCurrent = formLeftOriginal;
        this.formRightCurrent = formRightOriginal;

        System.out.println(getOriginalExpression());
        tokenListHistory.add(getOriginalExpression());
    }

    public void updateHistory()
    {
        System.out.println(this.toString().replaceAll("\\[|\\]|,", ""));
        tokenListHistory.add(this.toString().replaceAll("\\[|\\]|,", ""));
    }

    public String getFormLeftOriginal()
    {
        return formLeftOriginal;
    }

    public String getFormRightOriginal()
    {
        return formRightOriginal;
    }

    public List<Token> getTokenListLeft()
    {
        return tokenListLeft;
    }

    public List<Token> getTokenListRight()
    {
        return tokenListRight;
    }

    public Token[] getTokensRight()
    {
        Token[] tokens = new Token[tokenListRight.size()];
        for (int i = 0; i < tokenListRight.size(); i++) {
            tokens[i] = tokenListRight.get(i);
        }
        return tokens;
    }

    public Token[] getTokensLeft(){
        Token[] tokens = new Token[tokenListLeft.size()];
        for (int i = 0; i < tokenListLeft.size(); i++) {
            tokens[i] = tokenListLeft.get(i);
        }
        return tokens;
    }

    public boolean isUnknownLeft()
    {
        return isUnknownLeft;
    }

    @Override
    public String toString()
    {
        return formLeftCurrent + " = " + formRightCurrent;
    }

    public String getOriginalExpression()
    {
        return formLeftOriginal + " = " + formRightOriginal;
    }


    public void setTokensLeft(List<Token> tokenListLeft)
    {
        this.tokenListLeft = tokenListLeft;
        this.formLeftCurrent = tokenListLeft.toString();
    }

    public void setTokensRight(List<Token> tokenListRight)
    {
        this.tokenListRight = tokenListRight;
        this.formRightCurrent = tokenListRight.toString();
    }

    public void setUnknownLeft(boolean unknownLeft)
    {
        isUnknownLeft = unknownLeft;
    }

    public Token[] getSideWithUnknown(){
        return (isUnknownLeft() ? getTokensLeft() : getTokensRight());
    }

    public Token[] getSideWithoutUnknown(){
        return (isUnknownLeft() ? getTokensRight() : getTokensLeft());
    }

    public List<Token> getSideWithoutUnknownAsList(){
        return isUnknownLeft() ? tokenListRight : tokenListLeft;
    }

    public List<Token> getSideWithUnknownAsList(){
        return isUnknownLeft() ? tokenListLeft : tokenListRight;
    }

    public List<String> getTokenListHistory()
    {
        return tokenListHistory;
    }

    public void removeRedundantOperators(){
        //TODO
        getSideWithUnknownAsList().removeIf(token -> token instanceof Addition || token instanceof Multiplication);
    }
}
