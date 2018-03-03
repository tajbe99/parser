import org.junit.Test;

import static org.junit.Assert.*;

public class ParsersTest {

    public Parsers regex = new Parsers();

    @Test
    public void main() {
        parseMail();
        parsePass();
        parseDateYYYYMMDD();
        parseDateDDMMYYYY();
        parseURL();
    }

    @Test
    public void parseMail() {
        System.out.println(
                        String.valueOf( regex.parseMail("tajbe123@gmail.com"))+"\n"+
                        String.valueOf(regex.parseMail("tajbe123gmail.com"))+"\n"+
                        String.valueOf(regex.parseMail("tajbe@.com"))+"\n"+
                        String.valueOf(regex.parseMail("tajbe123.com"))+"\n"+
                        String.valueOf(regex.parseMail(""))+"\n");
    }

    @Test
    public void parsePass() {
        System.out.println(
                        String.valueOf( regex.parsePass("7c7rNGKP59"))+"\n"+
                        String.valueOf(regex.parsePass("qwer"))+"\n"+
                        String.valueOf(regex.parsePass("QWERTY"))+"\n"+
                        String.valueOf(regex.parsePass("qwerty"))+"\n"+
                        String.valueOf(regex.parsePass("123244grg23"))+"\n");
    }

    @Test
    public void parseDateYYYYMMDD() {
        System.out.println(
                        String.valueOf( regex.parseDateYYYYMMDD("1999..01"))+"\n"+
                        String.valueOf(regex.parseDateYYYYMMDD("1999.01."))+"\n"+
                        String.valueOf(regex.parseDateYYYYMMDD(".01.01"))+"\n"+
                        String.valueOf(regex.parseDateYYYYMMDD("1999.00.01"))+"\n"+
                        String.valueOf(regex.parseDateYYYYMMDD("1999.01.00"))+"\n"+
                        String.valueOf(regex.parseDateYYYYMMDD("-1024.01.01"))+"\n"+
                        String.valueOf(regex.parseDateYYYYMMDD("1999.01.00"))+"\n"+
                        String.valueOf(regex.parseDateYYYYMMDD("1999.01.01"))+"\n");
    }

    @Test
    public void parseDateDDMMYYYY() {
        System.out.println(
                        String.valueOf( regex.parseDateDDMMYYYY("01..1999"))+"\n"+
                        String.valueOf(regex.parseDateDDMMYYYY(".02.2099"))+"\n"+
                        String.valueOf(regex.parseDateDDMMYYYY("01.02."))+"\n"+
                        String.valueOf(regex.parseDateDDMMYYYY("01.00.1999"))+"\n"+
                        String.valueOf(regex.parseDateDDMMYYYY("00.01.1999"))+"\n"+
                        String.valueOf(regex.parseDateDDMMYYYY("01.01.-1999"))+"\n"+
                        String.valueOf(regex.parseDateDDMMYYYY(""))+"\n"+
                        String.valueOf(regex.parseDateDDMMYYYY("01.01.1999"))+"\n");
    }

    @Test
    public void parseURL() {
        System.out.println(
                        String.valueOf( regex.parseURL("https://soundcloud.com/charts/top"))+"\n"+
                        String.valueOf(regex.parseURL("http://androiddocs.ru/vidzhet-recyclerview-prostoj-primer/"))+"\n"+
                        String.valueOf(regex.parseURL("http://www.quizful.net/post/Java-RegExp"))+"\n"+
                        String.valueOf(regex.parseURL("т строку на содержание в ней слова"))+"\n"+
                        String.valueOf(regex.parseURL("hhtocjo:/kp.com"))+"\n"+
                        String.valueOf(regex.parseURL("https://catalog.onliner.by/hdd/westerndigital/wd5000avds/prices?town=minsk"))+"\n"+
                        String.valueOf(regex.parseURL("https://javascript.ru/forum/"))+"\n");
    }
}