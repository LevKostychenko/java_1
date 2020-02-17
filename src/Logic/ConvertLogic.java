package Logic;

public class ConvertLogic implements IConvertLogic
{
    public boolean TryParse(String stringToParse)
    {
        try
        {
            Integer.parseInt(stringToParse);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
