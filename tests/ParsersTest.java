import org.junit.Test;

import static org.junit.Assert.*;

public class ParsersTest {

    @Test
    public void main() {
        parseMail();
        parsePass();
        parseDateYYYYMMDD();
        parseDateDDMMYYYY();
        parseURL();
        parseDate_dd_mm_yyyy();
        parseDate_dd_mmmm_yy();
        parseDate_mmmm_dd_yy();
        parseDate_weekday_dth_mmmm_yyyy();
        parseDate_dd_mmm_yyyy_time();
        parseDate_yyyy();
        parseDate_yy();
        parseDate_time24();
        parseDate_weakday();
        parseDate_mmm_yy();
    }

    @Test
    public void parseMail() {
        assertTrue(Parsers.parseMail("tajbe123@gmail.com"));
        assertFalse(Parsers.parseMail("tajbe123gmail.com"));
        assertFalse(Parsers.parseMail("tajbe@.com"));
        assertFalse(Parsers.parseMail("tajbe123.com"));
        assertFalse(Parsers.parseMail(""));
    }

    @Test
    public void parsePass() {
        assertTrue( Parsers.parsePass("7c7rNGKP59"));
        assertFalse(Parsers.parsePass("qwer"));
        assertFalse(Parsers.parsePass("QWERTY"));
        assertFalse(Parsers.parsePass("qwerty"));
        assertFalse(Parsers.parsePass("123244grg23"));
    }

    @Test
    public void parseDateYYYYMMDD() {
        assertFalse( Parsers.parseDateYYYYMMDD("1999..01"));
        assertFalse(Parsers.parseDateYYYYMMDD("1999.01."));
        assertFalse(Parsers.parseDateYYYYMMDD(".01.01"));
        assertFalse(Parsers.parseDateYYYYMMDD("1999.00.01"));
        assertFalse(Parsers.parseDateYYYYMMDD("1999.01.00"));
        assertFalse(Parsers.parseDateYYYYMMDD("-1024.01.01"));
        assertFalse(Parsers.parseDateYYYYMMDD("1999.01.00"));
        assertTrue(Parsers.parseDateYYYYMMDD("1999.01.01"));
    }

    @Test
    public void parseDateDDMMYYYY() {
        assertFalse( Parsers.parseDateDDMMYYYY("01..1999"));
        assertFalse(Parsers.parseDateDDMMYYYY(".02.2099"));
        assertFalse(Parsers.parseDateDDMMYYYY("01.02."));
        assertFalse(Parsers.parseDateDDMMYYYY("01.00.1999"));
        assertFalse(Parsers.parseDateDDMMYYYY("00.01.1999"));
        assertFalse(Parsers.parseDateDDMMYYYY("01.01.-1999"));
        assertFalse(Parsers.parseDateDDMMYYYY(""));
        assertTrue(Parsers.parseDateDDMMYYYY("01.01.1999"));
    }

    @Test
    public void parseURL() {
        assertTrue( Parsers.parseURL("https://soundcloud.com/charts/top"));
        assertTrue(Parsers.parseURL("http://androiddocs.ru/vidzhet-recyclerview-prostoj-primer/"));
        assertTrue(Parsers.parseURL("http://www.quizful.net/post/Java-Parsersp"));
        assertFalse(Parsers.parseURL("т строку на содержание в ней слова"));
        assertFalse(Parsers.parseURL("hhtocjo:/kp.com"));
        assertTrue(Parsers.parseURL("https://catalog.onliner.by/hdd/westerndigital/wd5000avds" +
                                "/prices?town=minsk"));
        assertTrue(Parsers.parseURL("https://javascript.ru/forum/"));
    }

    @Test
    public void parseDate_dd_mm_yyyy() {
        assertFalse( Parsers.parseDate_dd_mm_yyyy("01.June.1999"));
        assertFalse(Parsers.parseDate_dd_mm_yyyy("05.Lo.2099"));
        assertTrue(Parsers.parseDate_dd_mm_yyyy("01-Aug-1999"));
        assertFalse(Parsers.parseDate_dd_mm_yyyy("01.01.1999"));
    }

    @Test
    public void parseDate_dd_mmmm_yy() {
        assertFalse(Parsers.parseDate_dd_mmmm_yy("01--1999"));
        assertFalse(Parsers.parseDate_dd_mmmm_yy("01-Aug-2099"));
        assertFalse(Parsers.parseDate_dd_mmmm_yy("01.July.2018"));
        assertTrue(Parsers.parseDate_dd_mmmm_yy("01-May-99"));
        assertFalse(Parsers.parseDate_dd_mmmm_yy("01.June.1999"));
        assertFalse(Parsers.parseDate_dd_mmmm_yy("05.Lo.2099"));
        assertFalse(Parsers.parseDate_dd_mmmm_yy("01-Aug-1999"));
        assertFalse(Parsers.parseDate_dd_mmmm_yy("01.01.1999"));
    }

    @Test
    public void parseDate_mmmm_dd_yy() {
        assertTrue( Parsers.parseDate_mmmm_dd_yy("May-01-99"));
        assertFalse(Parsers.parseDate_mmmm_dd_yy("Aug-100-2099"));
        assertFalse(Parsers.parseDate_mmmm_dd_yy("July.01.2018"));
        assertFalse(Parsers.parseDate_mmmm_dd_yy("01-May-99"));
        assertFalse( Parsers.parseDate_mmmm_dd_yy("Error-10-1999"));
        assertFalse(Parsers.parseDate_mmmm_dd_yy("May-14-1099"));
    }

    @Test
    public void parseDate_weekday_dth_mmmm_yyyy() {
        assertTrue(Parsers.parseDate_weekday_dth_mmmm_yyyy("Monday, 3 of August 2006"));
        assertFalse(Parsers.parseDate_weekday_dth_mmmm_yyyy("Error, 8 of August 2006"));
        assertFalse(Parsers.parseDate_weekday_dth_mmmm_yyyy("Monday, 40 of August 2006"));
        assertFalse(Parsers.parseDate_weekday_dth_mmmm_yyyy("Monday, 3 August 2006"));
        assertFalse(Parsers.parseDate_weekday_dth_mmmm_yyyy("Monday, 3 of Error 2006"));
        assertFalse(Parsers.parseDate_weekday_dth_mmmm_yyyy("Monday, 3 of August 99"));
    }

    @Test
    public void parseDate_dd_mmm_yyyy_time() {
        assertTrue(Parsers.parseDate_dd_mmm_yyyy_time("03-Aug-2006 18:55:30.35"));
        assertFalse(Parsers.parseDate_dd_mmm_yyyy_time("44-Aug-2006 18:55:30.35"));
        assertFalse(Parsers.parseDate_dd_mmm_yyyy_time("03-lulwy-2006 18:55:30.35"));
        assertFalse(Parsers.parseDate_dd_mmm_yyyy_time("03-Aug-99 18:55:30.35"));
        assertFalse(Parsers.parseDate_dd_mmm_yyyy_time("03-Aug-2006 77:55:30.35"));
        assertFalse(Parsers.parseDate_dd_mmm_yyyy_time("03-Aug-2006 18:70:30.35"));
        assertFalse(Parsers.parseDate_dd_mmm_yyyy_time("03-Aug-2006 77:55:70.35"));
        assertFalse(Parsers.parseDate_dd_mmm_yyyy_time("03-Aug-2006 77:55:70.222"));
    }

    @Test
    public void parseDate_yyyy() {
        assertTrue(Parsers.parseDate_yyyy("2006"));
        assertFalse(Parsers.parseDate_yyyy("-2006"));
        assertFalse(Parsers.parseDate_yyyy("06"));
        assertFalse(Parsers.parseDate_yyyy("-06"));
    }

    @Test
    public void parseDate_yy() {
        assertFalse(Parsers.parseDate_yy("2006"));
        assertFalse(Parsers.parseDate_yy("-2006"));
        assertTrue(Parsers.parseDate_yy("06"));
        assertFalse(Parsers.parseDate_yy("-06"));
    }

    @Test
    public void parseDate_time24() {
        assertTrue(Parsers.parseDate_time24("18:55:30"));
        assertFalse(Parsers.parseDate_time24("77:55:30"));
        assertFalse(Parsers.parseDate_time24("18:77:30"));
        assertFalse(Parsers.parseDate_time24("18:55:77"));
        assertFalse(Parsers.parseDate_time24("18.55.30"));
    }

    @Test
    public void parseDate_weakday() {
        assertTrue(Parsers.parseDate_weakday("Monday"));
        assertFalse(Parsers.parseDate_weakday("Munday"));
        assertFalse(Parsers.parseDate_weakday("Error"));
        assertFalse(Parsers.parseDate_weakday("01"));
    }

    @Test
    public void parseDate_mmm_yy() {
        assertTrue(Parsers.parseDate_mmm_yy("Aug-99"));
        assertFalse(Parsers.parseDate_mmm_yy("Aog-99"));
        assertFalse(Parsers.parseDate_mmm_yy("Aug-100"));
        assertFalse(Parsers.parseDate_mmm_yy("Aug.14"));
    }
}