package logic;

public class ConvertLogic implements IConvertLogic {
    public boolean tryParse(String stringToParse) {
        try {
            Integer.parseInt(stringToParse);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
