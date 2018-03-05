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

    public static boolean parseDate_dd_mm_yyyy(String date){
        Pattern regular = Pattern.compile("(([0-2]?[1-9])|([3][0,1])|10|20|30)-" +
                "(Jan|Feb|Mar|Apr|May|June|July|Aug|Sept|Oct|Nov|Dec)-[0-9]{4}");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_dd_mmmm_yy(String date){
        Pattern regular = Pattern.compile("(([0-2]?[1-9])|([3][0,1])|10|20|30)-" +
                "(January|February|March|April|May|June|July|August|September|October|November|December)-[0-9]{2}");
        Matcher match = regular.matcher(date);
        return match.matches();
    }


    public static boolean parseDate_mmmm_dd_yy(String date){
        Pattern regular = Pattern.compile("(Jan|Feb|Mar|Apr|May|June|July|Aug|Sept|Oct|Nov|Dec)" +
                "-(([0-2]?[1-9])|([3][0,1])|10|20|30)-[0-9]{2}");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_weekday_dth_mmmm_yyyy(String date){
        Pattern regular = Pattern.compile("(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)[,]" +
                "\\s(([0-2]?[1-9])|([3][0,1])|10|20|30)\\sof\\s" +
                "(January|February|March|April|May|June|July|August|September|October|November|December)" +
                "\\s[0-9]{4}");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_dd_mmm_yyyy_time(String date){
        Pattern regular = Pattern.compile("(([0-2]?[1-9])|([3][0,1])|10|20|30)-" +
                "(Jan|Feb|Mar|Apr|May|June|July|Aug|Sept|Oct|Nov|Dec)-[0-9]{4}\\s" +
                "([0-1][0-9]|[2][0-4]):[0-6][0-6]:[0-6][0-6][.]([0-9][0-9]|100)");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_yyyy(String date){
        Pattern regular = Pattern.compile("[0-9]{4}");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_yy(String date){
        Pattern regular = Pattern.compile("[0-9]{2}");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_time24(String date){
        Pattern regular = Pattern.compile("([0-1][0-9]|[2][0-4]):[0-6][0-6]:[0-6][0-6]");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_weakday(String date){
        Pattern regular = Pattern.compile("Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday");
        Matcher match = regular.matcher(date);
        return match.matches();
    }

    public static boolean parseDate_mmm_yy(String date){
        Pattern regular = Pattern.compile("(Jan|Feb|Mar|Apr|May|June|July|Aug|Sept|Oct|Nov|Dec)-[0-9]?[1-9][0]?");
        Matcher match = regular.matcher(date);
        return match.matches();
    }
}
