package project1_ver5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestGeoCountDownTimer {

    //This test checks that the default constructor creates a
    //timer with the correct date
    @Test
    public void testDefaultConstructor() {
        GeoCountDownTimer s = new GeoCountDownTimer();
        assertTrue(s.toDateString().equals("1/1/2022"));
        assertTrue(s.toString().equals("January 1, 2022"));
    }
    //This test checks that the constructor outputs the
    //correct date when input is numbers (year, month, day)
    @Test
    public void testConstructor1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 10);
        assertEquals(s.toDateString(), "5/10/2121");
        assertEquals(s.toString(), "May 10, 2121");
        s = new GeoCountDownTimer(2121, 1, 11);
        assertEquals(s.toDateString(), "1/11/2121");
        assertEquals(s.toString(), "January 11, 2121");
        s = new GeoCountDownTimer(2121, 1, 31);
        assertEquals(s.toDateString(), "1/31/2121");
        s = new GeoCountDownTimer(2121, 2, 28);
        assertEquals(s.toDateString(), "2/28/2121");
        s = new GeoCountDownTimer(2121, 3, 31);
        assertEquals(s.toDateString(), "3/31/2121");
        s = new GeoCountDownTimer(2121, 4, 30);
        assertEquals(s.toDateString(), "4/30/2121");
        s = new GeoCountDownTimer(2121, 5, 31);
        assertEquals(s.toDateString(), "5/31/2121");
        s = new GeoCountDownTimer(2121, 6, 30);
        assertEquals(s.toDateString(), "6/30/2121");
        s = new GeoCountDownTimer(2121, 7, 31);
        assertEquals(s.toDateString(), "7/31/2121");
        s = new GeoCountDownTimer(2121, 8, 31);
        assertEquals(s.toDateString(), "8/31/2121");
        s = new GeoCountDownTimer(2121, 9, 30);
        assertEquals(s.toDateString(), "9/30/2121");
        s = new GeoCountDownTimer(2121, 10, 31);
        assertEquals(s.toDateString(), "10/31/2121");
        s = new GeoCountDownTimer(2121, 11, 30);
        assertEquals(s.toDateString(), "11/30/2121");
        s = new GeoCountDownTimer(2121, 12, 31);
        assertEquals(s.toDateString(), "12/31/2121");
    }
    //This test ensures that creating a timer with a year < min_year throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1InvalidYear(){
        GeoCountDownTimer s = new GeoCountDownTimer(2001, 5, 10);
    }
    //This test ensures that creating a timer with a month < 1 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1InvalidMonth1(){
        GeoCountDownTimer s = new GeoCountDownTimer(2111, 0, 10);
    }
    //This test ensures that creating a timer with a month > 12 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1InvalidMonth2(){
        GeoCountDownTimer s = new GeoCountDownTimer(2111, 13, 10);
    }
    //This test ensures that creating a timer
    //with a day < 1 throws an error for month 1
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1InvalidDay1(){
        GeoCountDownTimer s = new GeoCountDownTimer(2111, 1, 0);
    }
    //This test ensures that creating a timer with
    //a day > last day of month 1 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1InvalidDay2(){
        GeoCountDownTimer s = new GeoCountDownTimer(2111, 1, 32);
    }

    //test ensures day < 1 for month 2 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2123, 2, 0);
    }

    //test ensures day > last day of month 2 (NOT LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2123, 2, 29);
    }

    //test ensures day < 1 for month 2 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays3() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 2, 0);
    }

    //test ensures day < 1 for month 2 (LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays4() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 2, 30);
    }

    //test ensures day < 1 for month 2 (NOT LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays5() {
        GeoCountDownTimer s = new GeoCountDownTimer(3000, 2, 0);
    }

    //test ensures day > last day of month 2 (NOT LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays6() {
        GeoCountDownTimer s = new GeoCountDownTimer(3000, 2, 29);
    }

    //test ensures day < 0 for month 2 (LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays7() {
        GeoCountDownTimer s = new GeoCountDownTimer(4000, 2, 0);
    }

    //test ensures day > last day of month 2 (LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1FebDays8() {
        GeoCountDownTimer s = new GeoCountDownTimer(4000, 2, 30);
    }

    //test ensures day < 1 for month 3 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1MarDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 3, 0);
    }

    //test ensures day > last day of month 3 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1MarDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 3, 32);
    }

    //test ensures day < 1 for month 4 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1AprDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 4, 0);
    }

    //test ensures day > last day of month 4 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1AprDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 4, 31);
    }

    //test ensures day < 1 for month 5 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1MayDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 5, 0);
    }

    //test ensures day > last day of month 5 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1MayDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 5, 32);
    }

    //test ensures day < 1 for month 6 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1JunDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 6, 0);
    }

    //test ensures day > last day of month 6 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1JunDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 6, 31);
    }

    //test ensures day < 1 for month 7 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1JulDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 7, 0);
    }

    //test ensures day > last day of month 7 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1JulDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 7, 32);
    }

    //test ensures day < 1 for month 8 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1AugDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 8, 0);
    }

    //test ensures day > last day of month 8 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1AugDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 8, 32);
    }

    //test ensures day < 1 for month 9 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1SepDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 9, 0);
    }

    //test ensures day > last day of month 9 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1SepDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 9, 31);
    }

    //test ensures day < 1 for month 10 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1OctDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 10, 0);
    }

    //test ensures day > last day of month 10 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1OctDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 10, 32);
    }

    //test ensures day < 1 for month 11 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1NovDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 11, 0);
    }

    //test ensures day > last day of month 11 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1NovDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 11, 31);
    }

    //test ensures day < 1 for month 12 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1DecDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 12, 0);
    }

    //test ensures day > last day of month 12 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1DecDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer(2124, 12, 32);
    }

    //This test checks that the constructor creates a timer with
    //the correct date when input is a valid string
    @Test
    public void testConstructor2() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/10/2121");
        assertTrue(s.toDateString().equals("5/10/2121"));
    }
    //This test checks that the constructor outputs
    //the correct date when input is a date
    @Test
    public void testConstructor22() {
        GeoCountDownTimer s = new GeoCountDownTimer("1/31/2055");
        assertEquals(s.toDateString(), "1/31/2055");
        s = new GeoCountDownTimer("2/28/2055");
        assertEquals(s.toDateString(), "2/28/2055");
        s = new GeoCountDownTimer("3/31/2055");
        assertEquals(s.toDateString(), "3/31/2055");
        s = new GeoCountDownTimer("4/30/2055");
        assertEquals(s.toDateString(), "4/30/2055");
        s = new GeoCountDownTimer("5/31/2055");
        assertEquals(s.toDateString(), "5/31/2055");
        s = new GeoCountDownTimer("6/30/2055");
        assertEquals(s.toDateString(), "6/30/2055");
        s = new GeoCountDownTimer("7/31/2055");
        assertEquals(s.toDateString(), "7/31/2055");
        s = new GeoCountDownTimer("8/31/2055");
        assertEquals(s.toDateString(), "8/31/2055");
        s = new GeoCountDownTimer("9/30/2055");
        assertEquals(s.toDateString(), "9/30/2055");
        s = new GeoCountDownTimer("10/31/2055");
        assertEquals(s.toDateString(), "10/31/2055");
        s = new GeoCountDownTimer("11/30/2055");
        assertEquals(s.toDateString(), "11/30/2055");
        s = new GeoCountDownTimer("12/31/2055");
        assertEquals(s.toDateString(), "12/31/2055");
    }

    //This test ensures that creating a timer with a
    //day < 1 throws an error for month 1
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1InvalidDay1(){
        GeoCountDownTimer s = new GeoCountDownTimer("1/0/2111");
    }
    //This test ensures that creating a timer with
    //a day > last day of month 1 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1InvalidDay2(){
        GeoCountDownTimer s = new GeoCountDownTimer("1/32/2111");
    }
    //test ensures day < 1 for month 2 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/0/2111");
    }

    //test ensures day > last day of month 2 (NOT LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2111");
    }

    //test ensures day < 1 for month 2 throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/0/2124");
    }

    //test ensures day < 1 for month 2 (LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays4() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/30/2111");
    }

    //test ensures day < 1 for month 2 (NOT LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays5() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/0/3000");
    }

    //test ensures day > last day of month 2 (NOT LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays6() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/30/3000");
    }

    //test ensures day < 0 for month 2 (LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays7() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/0/4000");
    }

    //test ensures day > last day of month 2 (LEAP YEAR) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1FebDays8() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/30/4000");
    }

    //test ensures day < 1 for month 3 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1MarDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("3/0/2111");
    }

    //test ensures day > last day of month 3 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1MarDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("3/32/2111");
    }

    //test ensures day < 1 for month 4 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1AprDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("4/0/2111");
    }

    //test ensures day > last day of month 4 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1AprDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("4/31/2111");
    }

    //test ensures day < 1 for month 5 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1MayDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/0/2111");
    }

    //test ensures day > last day of month 5 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1MayDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/32/2111");
    }

    //test ensures day < 1 for month 6 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1JunDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("6/0/2111");
    }

    //test ensures day > last day of month 6 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1JunDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("6/31/2111");
    }

    //test ensures day < 1 for month 7 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1JulDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("7/0/2111");
    }

    //test ensures day > last day of month 7 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1JulDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("7/32/2111");
    }

    //test ensures day < 1 for month 8 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1AugDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("8/0/2111");
    }

    //test ensures day > last day of month 8 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1AugDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("8/32/2111");
    }

    //test ensures day < 1 for month 9 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1SepDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("9/0/2111");
    }

    //test ensures day > last day of month 9 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1SepDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("9/31/2111");
    }

    //test ensures day < 1 for month 10 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1OctDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("10/0/2111");
    }

    //test ensures day > last day of month 10 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1OctDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("10/32/2111");
    }

    //test ensures day < 1 for month 11 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1NovDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("11/0/2111");
    }

    //test ensures day > last day of month 11 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1NovDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("11/31/2111");
    }

    //test ensures day < 1 for month 12 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1DecDays1() {
        GeoCountDownTimer s = new GeoCountDownTimer("12/0/2111");
    }

    //test ensures day > last day of month 12 throws error
    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructor1DecDays2() {
        GeoCountDownTimer s = new GeoCountDownTimer("12/32/2111");
    }

    //test ensures the get and set methods for day work properly
    @Test
    public void testDaySetGet(){
        GeoCountDownTimer s = new GeoCountDownTimer(2111, 5, 24);
        s.setDay(20);
        s.getDay();
        assertEquals(s.getDay(), 20);
    }
    //test ensures the get and set methods for month work properly
    @Test
    public void testMonthSetGet(){
        GeoCountDownTimer s = new GeoCountDownTimer(2111, 5, 24);
        s.setMonth(8);
        s.getMonth();
        assertEquals(s.getMonth(), 8);
    }
    //test ensures the get and set methods for year work properly
    @Test
    public void testYearSetGet(){
        GeoCountDownTimer s = new GeoCountDownTimer(2111, 5, 24);
        s.setYear(2033);
        s.getYear();
        assertEquals(s.getYear(), 2033);
    }

    //This test checks that the constructor outputs
    //the correct date when input is a GEOCDT
    @Test
    public void testOtherConstructor() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2111, 1, 10);
        GeoCountDownTimer s2 = new GeoCountDownTimer(s1);
        assertTrue(s2.equals(s1));
    }
    //This test ensures that null input for the
    //constructor(other) returns a null error
    @Test(expected = NullPointerException.class)
    public void testNullConstructor() {
        GeoCountDownTimer s = new GeoCountDownTimer((GeoCountDownTimer) null);
    }
    //This test ensures that invalid input for the
    //constructor(year, month, day) returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor1() {
        new GeoCountDownTimer(2, -3, -3);
    }
    //This test ensures that invalid input for
    //the constructor( month, day) returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor3() {
        new GeoCountDownTimer(2222, -3, 3);
    }
    //This test ensures that February 29th does
    //not exist for a year that is not a leap year
    @Test(expected = IllegalArgumentException.class)
    public void testContructor4() {
        GeoCountDownTimer s = new GeoCountDownTimer(2123, 2, 29);
    }
    //This test ensures that invalid input
    //for the constructor(string) returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2() {
        new GeoCountDownTimer("2,-3/-3");
    }
    //This test ensures that invalid month < 1 returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2InvalidMonth1() {
        new GeoCountDownTimer("0/1/2022");
    }//This test ensures that invalid month > 12 returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2InvalidMonth2() {
        new GeoCountDownTimer("13/1/2022");
    }//This test ensures that invalid day < 1 returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2InvalidDay1() {
        new GeoCountDownTimer("1/0/2022");
    }
    //This test ensures that invalid day > last day of the month returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2InvalidDay2() {
        new GeoCountDownTimer("1/32/2022");
    }
    //This test ensures that invalid year < 2022
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2InvalidYear1() {
        new GeoCountDownTimer("1/1/2021");
    }
    //This test ensures that invalid input leap year
    //with feb 29 for the constructor(string) returns an error
    @Test(expected = IllegalArgumentException.class)
    public void testContructorInvalidLeap() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2121");
    }
    //This test ensures that an error is thrown
    //if the string used for the constructor is null
    @Test(expected = IllegalArgumentException.class)
    public void testContructor5() {
        String invalid = null;
        GeoCountDownTimer s = new GeoCountDownTimer(invalid);
    }
    //This test checks that all possible string inputs for the constructor are valid
    @Test
    public void testGeoHelp() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2100");
        GeoCountDownTimer s2 = new GeoCountDownTimer("1/10/2100");
        GeoCountDownTimer s3 = new GeoCountDownTimer("10/1/2100");
        GeoCountDownTimer s4 = new GeoCountDownTimer("10/10/2100");
        assertTrue(s1.equals(s1));
        assertTrue(s2.equals(s2));
        assertTrue(s3.equals(s3));
        assertTrue(s4.equals(s4));
    }
    //This test ensures that garbage input
    //into the constructor(string) throws an error
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGeoHelp6() {
        GeoCountDownTimer s = new GeoCountDownTimer("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGeoHelp1() {
        GeoCountDownTimer s = new GeoCountDownTimer("a/b/cdef");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGeoHelp2() {
        GeoCountDownTimer s = new GeoCountDownTimer("a/bb/cdef");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGeoHelp3() {
        GeoCountDownTimer s = new GeoCountDownTimer("aa/b/cdef");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGeoHelp4() {
        GeoCountDownTimer s = new GeoCountDownTimer("aa/bb/cdef");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGeoHelp5() {
        GeoCountDownTimer s = new GeoCountDownTimer("asdl.gad/gsaers/asdg/bb.");
    }
    //This test checks that the add() and add(days)
    //methods are working properly with valid input
    @Test
    public void testAddMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 10);
        s1.inc(365);
        assertTrue(s1.toDateString().equals("5/10/2122"));

        s1 = new GeoCountDownTimer(2120, 1, 10);

        for (int i = 0; i < 366; i++)
            s1.inc();
        assertTrue(s1.toDateString().equals("1/10/2121"));

        s1 = new GeoCountDownTimer(2022, 5, 10);

        for (int i = 0; i < 31665; i++)
            s1.inc();

        for (int i = 0; i < 31665; i++)
            s1.dec();

        assertTrue(s1.toDateString().equals("5/10/2022"));

    }

    //This test checks that the add() and add(days)
    //methods are working properly with valid input
    @Test
    public void testAddMethod1() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 10);
        s1.inc(365);
        assertTrue(s1.toDateString().equals("5/10/2122"));

        s1 = new GeoCountDownTimer(2120, 1, 10);

        for (int i = 0; i < 366; i++)
            s1.inc();
        assertTrue(s1.toDateString().equals("1/10/2121"));

        s1 = new GeoCountDownTimer(2022, 5, 10);

        for (int i = 0; i < 531665; i++)
            s1.inc();

        for (int i = 0; i < 531665; i++)
            s1.dec();

        assertTrue(s1.toDateString().equals("5/10/2022"));

    }





    //This test checks that the add() and add(days) methods
    //are working properly for leap years with valid input
    @Test
    public void testAddMethodLeap1() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2040, 1, 10);
        s1.inc(365);
        assertTrue(s1.toDateString().equals("1/9/2041"));

        GeoCountDownTimer s2 = new GeoCountDownTimer(2040, 1, 10);
        for (int i = 0; i < 365; i++)
            s2.inc();
        assertTrue(s2.toDateString().equals("1/9/2041"));
    }
    @Test
    public void testAddMethodLeap2() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2039, 1, 10);
        s1.inc(500);
        assertTrue(s1.toDateString().equals("5/24/2040"));
    }
    //This test checks that the dec() and dec(days) methods
    //are working properly with valid input
    @Test
    public void testDecMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 10);
        s1.dec(365);
        assertTrue(s1.toDateString().equals("5/10/2120"));

        s1 = new GeoCountDownTimer(2120, 1, 10);

        for (int i = 0; i < 365; i++)
            s1.dec();
        assertTrue(s1.toDateString().equals("1/10/2119"));
    }
    //This test checks that the dec(days) and dec() methods
    //are working for leap years with valid input
    @Test
    public void testDecMethodLeap() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2120, 5, 10);
        s1.dec(365);
        assertTrue(s1.toDateString().equals("5/11/2119"));
    }
    //This test ensures that an error
    //is thrown when decreasing below the minimum year
    @Test(expected = IllegalArgumentException.class)
    public void testDecMethodInvalidYear1() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022, 5, 10);
        s1.dec(365);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDecMethodInvalidYear2() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022, 5, 10);
        for (int i = 0; i < 365; i++)
            s1.dec();
    }
    //This test ensures that an error is thrown
    //when dec(days) is called with a negative number
    @Test(expected = IllegalArgumentException.class)
    public void testDecMethodNeg() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022, 5, 10);
        s1.dec(-365);
    }
    //This test ensures that an error is thrown
    //when inc(days) is called with a negative number
    @Test(expected = IllegalArgumentException.class)
    public void testIncMethodNeg() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022, 5, 10);
        s1.inc(-365);
    }
    //This test checks that the equals() method is working properly with valid input
    @Test
    public void testEqual() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 5);
        GeoCountDownTimer s4 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s5 = new GeoCountDownTimer(3000, 5, 9);

        assertEquals(s4, s5);
        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s4));
    }
    //This test ensures that an error is thrown when an object
    //that is not a GEOCDT is used as input for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testEqualInvalid() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(3000, 5, 9);
        String invalid = "invalid";
        s1.equals(invalid);

    }
    //This test ensures that an error is thrown when
    //a null GEOCDT is used as input for the constructor
    @Test(expected = NullPointerException.class)
    public void testEqualNull() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer((GeoCountDownTimer) null);
    }
    //This test ensures that an error is thrown when
    //a null object is used as input for the constructor
    @Test(expected = NullPointerException.class)
    public void testEqualNull2() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(3000, 5, 9);
        String nll = null;
        s1.equals(nll);
    }

    //This test checks that the CompareTo method is working properly with valid input
    @Test
    public void testCompareTo() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 8);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s5 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s6 = new GeoCountDownTimer(2121, 2, 9);
        GeoCountDownTimer s7 = new GeoCountDownTimer(2121, 3, 8);

        //s2 is bigger than s1
        assertTrue(s2.CompareTo(s1) > 0);
        assertTrue(s3.CompareTo(s1) < 0);
        assertTrue(s1.CompareTo(s4) == 0);
        assertTrue(s5.CompareTo(s1) > 0);
        assertTrue(s1.CompareTo(s5) < 0);
        assertTrue(s6.CompareTo(s7) < 0);
        assertTrue(s7.CompareTo(s6) > 0);
    }
    //This test checks that the load() and save() methods
    //are working properly with valid input
    @Test
    public void testLoadSave() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 9, 1);

        s1.save("file1");
        s1 = new GeoCountDownTimer(2111, 1, 1);  // resets to zero
        s1.load("file1");
        assertTrue(s2.equals(s1));

    }
    //test save throws error for invalid file name
    @Test(expected = NullPointerException.class)
    public void testSaveFail() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2122, 5, 11);
        s1.save("/");
    }
    //test save throws error for null file name
    @Test(expected = NullPointerException.class)
    public void testSaveFail2() {
        String fileName = null;
        GeoCountDownTimer s1 = new GeoCountDownTimer(2122, 5, 11);
        s1.save(fileName);
    }
    //test load throws error for null file name
    @Test(expected = IllegalArgumentException.class)
    public void testLoadNull() {
        String fileName = null;
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        s1.load(fileName);
    }

    //test load throws error for missing file
    @Test(expected = RuntimeException.class)
    public void testLoadMissingFile() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        s1.save("file1");
        s1.load("file12");
    }

    //test load throws error for file with invalid date
    @Test(expected = RuntimeException.class)
    public void testLoadInvalidDate1() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        s1.load("file2");
    }

    //test load throws error for file with non-numerical content
    @Test(expected = RuntimeException.class)
    public void testLoadInvalidDate2() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        s1.load("file3");
    }
    //This test checks that the daysToGo() method
    //is working properly with valid input
    @Test
    public void testDaysToGo() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 2, 9);
        assertTrue(s1.daysToGo("2/1/2121") == 8);
        assertTrue(s1.daysToGo("2/8/2121") == 1);
        assertTrue(s1.daysToGo("2/9/2121") == 0);
        assertTrue(s1.daysToGo("2/10/2121") == -1);

        assertTrue(s1.daysToGo("1/30/2121") == 10);
        assertTrue(s1.daysToGo("3/11/2121") == -30);
        assertTrue(s1.daysToGo("2/10/2120") == 365);

    }
    //This test checks that the daysInFuture()
    //method is working properly with valid input
    @Test
    public void testDaysInFuture () {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 12,9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 12,19);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 12,4);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2120, 12,9);
        GeoCountDownTimer s5 = new GeoCountDownTimer(2122, 12,9);


        assertTrue (s1.daysInFuture(10).equals(s2));
        assertTrue (s1.daysInFuture(-5).equals(s3));
        assertTrue (s1.daysInFuture(0).equals(s1));
        assertTrue (s1.daysInFuture(-365).equals(s4));
        assertTrue (s1.daysInFuture(365).equals(s5));
    }
    //This test ensure that an error is thrown when an
    //invalid year is used as input for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYear(){
        GeoCountDownTimer s = new GeoCountDownTimer(2001, 1, 1);
    }

}

