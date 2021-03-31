package logic;

import util.StringOperation;
/**
 * Greek Symobls
 * <ul>
 *     <li>Sigma: {@value SIGMA_L}</li>
 *     <li>Omega: {@value OMEGA_L}</li>
 *     <li>Rho: {@value RHO_S}</li>
 * </ul>
 * <a href="https://unicode-table.com/de/">Unicode-Symbol-Search</a>
 */
public enum FormulaEnum
{
    URI("U = R * I"),
    URI_2("R = U / I"),
    URI_3("I = U / R"),
    PUI("P = U * I"),
    KNOT("I_in = I_out1 + I_out2"),
    MESH("0 = " + "\u03A3" + "[I_n]"),
    R_SERIAL("R_s = R_1 + R_2"), //
    R_PARALLEL("R_p = (R_1 * R_2) / (R_1 + R_2)"),
    R_TO_U_PROPORTION("U_2 = U_0 / (R_1 + R_2)")
    ;

    public static final String SIGMA_L = "\u03A3";
    public static final String OMEGA_L = "\u03A9";
    public static final String RHO_S = "\u03C1";

    private String content;
    private int type; // 1 = Basic, 2 = Array...
    private int numberOfVariables; // 0 = infinity



    FormulaEnum(String content)
    {
        this.content = content;
    }
    
    public void replaceVariable(String variable, double value){
        content = content.replace(variable, String.valueOf(value));
    }

    public int numberOfVariables()
    {
        String variableString;
        variableString = content.replaceAll("[^(a-z|A-Z|0-9|_)]"," ");
        String[] variables = StringOperation.removeDuplicateSpaces(variableString).split(" ");
        return variables.length;
    }

    public String getContent()
    {
        return content;
    }
}
