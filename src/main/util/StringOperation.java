package util;

/**
 * @author Pascal Isliker
 */
public class StringOperation
{
    public static String removeDuplicateSpaces(String string){
        return string.trim().replaceAll("  +", " ");
    }
}
