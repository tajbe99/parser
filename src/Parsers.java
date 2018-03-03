import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsers {
    public static void main(String[] args) {
        System.out.println(parseMail("fsd"));
    }

    public static boolean parseMail (String eMail){
        Pattern regular = Pattern.compile("^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\\.)+[a-z]{2,6}$");
        Matcher match = regular.matcher(eMail);
        return match.matches();
    }

    public static boolean parsePass(String passwordString){
        Pattern regular = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=[A-za-z0-9]{6,}).*$");
        Matcher match = regular.matcher(passwordString);
        return match.matches();
    }

    public static boolean parseDateYYYYMMDD(String dateString){
        Pattern regular = Pattern.compile("[0-9]{4}\\W(([1][1-2])|([0][1-9]))\\W(([0-2][1-9])|([3][0,1])|10|20|30)");
        Matcher match = regular.matcher(dateString);
        return match.matches();
    }

    public static boolean parseDateDDMMYYYY(String dateString){
        Pattern regular = Pattern.compile("(([0-2][1-9])|([3][0,1])|10|20|30)\\W(([1][1-2])|([0][1-9]))\\W[0-9]{4}");
        Matcher match = regular.matcher(dateString);
        return match.matches();
    }

    public static boolean parseURL(String uRL){
        Pattern regular = Pattern.compile("^(https://|http://)(?:[a-z0-9][-a-z0-9]+\\.)+[a-z]{2,6}(/?.+)+$");
        Matcher match = regular.matcher(uRL);
        return match.matches();
    }
}
