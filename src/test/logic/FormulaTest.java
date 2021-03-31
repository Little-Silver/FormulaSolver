package logic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class FormulaTest
{
    @Test 
    void numberOfVariables(){
        assertEquals(3, FormulaEnum.URI.numberOfVariables());
    }
}