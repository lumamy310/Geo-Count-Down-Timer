package project1_ver5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;



/**********************************************************************
 * Handles the creation and modification of the GeoCountDownTimer
 * objects.
 * @author Lucas Myers
 * @version Winter 2022
 **********************************************************************/

public class GeoCountDownTimer {

	/** current value of the timer's month */
	private int month;

	/** current value of the timer's year */
	private int year;

	/** current value of the timer's day */
	private int day;

	/** the minimum year allowed */
	private static final int MIN_YEAR = 2022;

	/** the last day of each month in order */
	int[] LAST_DAY = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	/** the name of each month in order */
	private static String[] monthSelect = {"", "January", "February",
			"March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December"};

	/**********************************************************************
	 * Getter method that returns the timer's current month.
	 * @return the timer's current month
	 **********************************************************************/
	public int getMonth() {
		return month;
	}

	/**********************************************************************
	 * Getter method that returns the timer's current year.
	 * @return the timer's current year
	 **********************************************************************/
	public int getYear() {
		return year;
	}

	/**********************************************************************
	 * Getter method that returns the timer's current day.
	 * @return the timer's current day
	 **********************************************************************/
	public int getDay() {
		return day;
	}

	/**********************************************************************
	 * Setter method that sets the timer's month.
	 * @param month The timer's current month
	 **********************************************************************/
	public void setMonth(int month) {
		this.month = month;
	}

	/**********************************************************************
	 * Setter method that sets the timer's year.
	 * @param year The timer's current year
	 **********************************************************************/
	public void setYear(int year) {
		this.year = year;
	}

	/**********************************************************************
	 * Setter method that sets the timer's day.
	 * @param day The timer's current day
	 **********************************************************************/
	public void setDay(int day) {
		this.day = day;
	}

	/**********************************************************************
	 * Helper method that checks if the entered year is a leap year or not.
	 * @param year Any year
	 * @return true or false
	 **********************************************************************/
	private boolean isLeapYear(int year){
		if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)) {
			return true;
		}
		else{
			return false;
		}
	}

	/**********************************************************************
	 * Helper method to check if the given date is a leap year or not.
	 * @param year any year
	 * @param month any month
	 * @param day any day
	 * @return true or false
	 **********************************************************************/
	private boolean isValidDate(int year, int month, int day){
		if(isLeapYear(year)) {
			LAST_DAY[2] = 29;
		}
		else{
			LAST_DAY[2] = 28;
		}
		if(year < MIN_YEAR){
			return false;
		}
		else if(month < 1 || month > 12){
			return false;
		}
		else if(day < 1 || day > LAST_DAY[month]){
			return false;
		}
		else{
			return true;
		}
	}

	/**********************************************************************
	 * Default constructor that sets the GeoCountDownTimer to zero.
	 **********************************************************************/
	public GeoCountDownTimer() {
		this.month = 1;
		this.year = MIN_YEAR;
		this.day = 1;
	}

	/**********************************************************************
	 * A constructor that initializes the instance variables with the
	 * provided values.
	 * @param year any year
	 * @param month any month
	 * @param day any day
	 * @throws IllegalArgumentException when the input is not a
	 * valid date
	 **********************************************************************/
	public GeoCountDownTimer(int year, int month, int day) {
		if(!isValidDate(year, month, day)){
			throw new IllegalArgumentException();
		}
		else {
			this.month = month;
			this.year = year;
			this.day = day;
		}
	}

	/**********************************************************************
	 * A constructor that initializes the instance variables with the
	 * other GeoCountDownTimer parameter.
	 * @param other A GEOCDT that becomes the current timer
	 * @throws NullPointerException when other is null
	 **********************************************************************/
	public  GeoCountDownTimer(GeoCountDownTimer other){
		if(other != null){
				this.setMonth(other.getMonth());
				this.setYear(other.getYear());
				this.setDay(other.getDay());
		}
		else {
			throw new NullPointerException();
		}
	}

	/**********************************************************************
	 * A constructor that accepts a string as a parameter with the
	 * following format: “5/10/2119” where 5 indicates the month,
	 * 10 indicates the day,  and 2119 indicates the year.
	 * @param geoDate A string in the form of a date like 1/1/2100
	 * @throws IllegalArgumentException when the input is null, when
	 * the input is not a valid date, and when the input is not
	 * formatted correctly
	 **********************************************************************/
	public GeoCountDownTimer(String geoDate){
		if (geoDate == null)
			throw new IllegalArgumentException();

		String[] s = geoDate.split("/");
		if(s.length == 3){
			month = Integer.parseInt(s[0]);
			day = Integer.parseInt(s[1]);
			year = Integer.parseInt(s[2]);
		}
		else
			throw new IllegalArgumentException();

		if(!isValidDate(year, month, day)){
			throw new IllegalArgumentException();
		}

	}

	/**********************************************************************
	 * A method that returns true if “this” GeoCountDownTimer object
	 * is exactly the same as the other object
	 * @param other An object, typically a GeoCountDownTimer, that is
	 * checked for equality
	 * @return true or false
	 * @throws IllegalArgumentException when input is not a
	 * GeoCountDownTimer, when input is not a valid date
	 * @throws NullPointerException when input is null
	 **********************************************************************/
	public boolean equals (Object other) {
		if (other != null) {
			if (other instanceof GeoCountDownTimer) {
				GeoCountDownTimer temp = (GeoCountDownTimer) other;
					if ((this.month == temp.month) && (this.day == temp.getDay())
							&& (this.year == temp.getYear()))
						return true;
					else
						return false;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new NullPointerException();
		}
	}

	/**********************************************************************
	 * A method that returns 1 if “this” GeoCountDownTimer object is
	 * greater than the other GeoCountDownTimer object;
	 * For example: “1/20/2010” is less than 12/31/2011.
	 * @param other A GeoCountDownTimer that gets compared to the
	 * this object
	 * @return -1 if the “this” GeoCountDownTimer object
	 * is less than the other GeoCountDownTimer;
	 * returns 0 if the “this” GeoCountDownTimer object
	 * is equal to the other GeoCountDownTimer object.
	 **********************************************************************/
	public int CompareTo(GeoCountDownTimer other){
		if (this.year > other.getYear())
			return 1;
		else if(this.year < other.getYear())
			return -1;
		if (this.month > other.getMonth())
			return 1;
		else if(this.month < other.getMonth())
			return -1;
		if (this.day > other.getDay())
			return 1;
		else if(this.day < other.getDay())
			return -1;
		else
			return 0;
	}

	/**********************************************************************
	 * A method that subtracts the number of days from the “this”
	 * GeoCountDownTimer object  This will adjust the timer date
	 * down the number of days.
	 * @param days the number of days to decrease
	 * @throws IllegalArgumentException when the input is negative
	 **********************************************************************/
	public void dec(int days) {
		if (days >= 0) {
			for(int i=0; i < days; i++){
				this.dec();
			}
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	/**********************************************************************
	 * A method that subtracts 1 day from the “this” GeoCountDownTimer object.
	 * @throws IllegalArgumentException when the current year falls below
	 * the minimum year
	 **********************************************************************/
	public void dec(){
		if(isLeapYear(this.getYear())){
			LAST_DAY[2] = 29;
		}
		else{
			LAST_DAY[2] = 28;
		}
		if(this.getDay() - 1 == 0){
			this.setMonth(this.getMonth() - 1);
			if(this.getMonth() == 0){
				this.setMonth(12);
				this.setYear(this.getYear() - 1);
				if(this.getYear() < MIN_YEAR){
					throw new IllegalArgumentException();
				}
				this.setDay(LAST_DAY[this.getMonth()]);
			}
			else{
				this.setDay(LAST_DAY[this.getMonth()]);
			}
		}
		else{
			this.setDay(this.getDay() - 1);
		}
	}

	/**********************************************************************
	 * A method that adds the number of days to the “this” GeoCountDownTimer
	 * object  This will adjust the timer date up the number of days.
	 * @param days the number of days to increase
	 * @throws IllegalArgumentException when the input is negative
	 **********************************************************************/
	public void inc(int days){
		if(days >= 0) {
			for(int i=0; i < days; i++){
				this.inc();
			}
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	/**********************************************************************
	 * A method that adds 1 day from the “this” GeoCountDownTimer object.
	 **********************************************************************/
	public void inc(){
		day ++;
		if(isLeapYear(this.getYear())){
			LAST_DAY[2] = 29;
		}
		else{
			LAST_DAY[2] = 28;
		}
		if(this.getDay() > LAST_DAY[this.getMonth()]){
			this.setMonth(this.getMonth() + 1);
			this.setDay(1);
				if(this.getMonth() == 13){
					this.setYear(this.getYear() + 1);
					this.setMonth(1);
				}
		}
	}

	/**********************************************************************
	 * Method that returns a string that represents a GeoCountDownTimer
	 * with the following format:  “month day, year”. For example:
	 * February 10, 2119
	 * @return a string that represents a GeoCountDownTimer
	 **********************************************************************/
	public String toString(){
		String s = monthSelect[this.month] + " " + Integer.toString(this.day)
				+ ", " + Integer.toString(this.year);
		return s;
	}

	/**********************************************************************
	 * Method that returns a string that represents a GeoCountDownTimer
	 * with the following format:  “month/day/year”. For example: 2/20/2119.
	 * @return a string that represents a GeoCountDownTimer
	 **********************************************************************/
	public String toDateString(){
		String s = Integer.toString(this.month) + "/" + Integer.toString(this.day)
				+ "/" + Integer.toString(this.year);
		return s;
	}

	/**********************************************************************
	 * A  method that loads the “this” GeoCountDownTimer object from a file
	 * @param fileName the name of the file
	 * @throws IllegalArgumentException when the date being loaded from
	 * the file is invalid and when the input is null
	 * @throws RuntimeException when there is a problem reading the file
	 **********************************************************************/
	public void load(String fileName) {
		if(fileName != null) {
			int tempMonth;
			int tempDay;
			int tempYear;
			try {
				Scanner fileReader = new Scanner(new File(fileName));
				tempMonth = fileReader.nextInt();
				tempDay = fileReader.nextInt();
				tempYear = fileReader.nextInt();
				if (isValidDate(tempYear, tempMonth, tempDay)) {
					this.setYear(tempYear);
					this.setDay(tempDay);
					this.setMonth(tempMonth);
				}
				//impossible to write a JUnit for. There is no way to save an invalid
				//date within the program.
				//If you try to load a file that has been tampered with,
				//this error gets thrown
				else {
					throw new IllegalArgumentException();
				}
			}
			// problem reading the file
			catch (Exception error) {
				throw new RuntimeException();
			}
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	/**********************************************************************
	 * A method that saves the “this” GeoCountDownTimer to a file
	 * @param fileName the name of the file
	 **********************************************************************/
	public void save(String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			out.println(this.month + " " + this.day + " " + this.year);
			out.close();
	}

	/**********************************************************************
	 * A method that returns the number of days to go from the parameter
	 * “fromDate” (typically today’s date, but not always) to the “this” object.
	 * @param fromDate any date as a string
	 **********************************************************************/
	public int daysToGo(String fromDate){
		int outputDays = 0;
		GeoCountDownTimer other = new GeoCountDownTimer(fromDate);
			while(!other.equals(this)){
				if(this.CompareTo(other) == 1){
					other.inc();
					outputDays += 1;
				}
				else{
					other.dec();
					outputDays -= 1;
				}
			}
			return outputDays;
	}

	/**********************************************************************
	 * A method that returns a GeoCountDownTimer given a number of
	 * days in the future
	 * @param n number of days in the future
	 **********************************************************************/
	public GeoCountDownTimer daysInFuture(int n){
		GeoCountDownTimer other =
				new GeoCountDownTimer(this.year, this.month, this.day);
		if(n > 0) {
			other.inc(n);
			return other;
		}
		else if(n == 0){
			return other;
		}
		else{
			other.dec(Math.abs(n));
			return other;
		}
	}

	/**********************************************************************
	 * Main method used only for testing purposes
	 **********************************************************************/
	public static void main(String[] args){
		System.out.println("Testing default constructor:");
		GeoCountDownTimer s0 = new GeoCountDownTimer();
		System.out.println("Testing Constructors for last " +
				"day of each month (input as string):");
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/31/2022");
		GeoCountDownTimer s2 = new GeoCountDownTimer("2/28/2022");
		GeoCountDownTimer s3 = new GeoCountDownTimer("3/31/2022");
		GeoCountDownTimer s4 = new GeoCountDownTimer("4/30/2022");
		GeoCountDownTimer s5 = new GeoCountDownTimer("5/31/2022");
		GeoCountDownTimer s6 = new GeoCountDownTimer("6/30/2022");
		GeoCountDownTimer s7 = new GeoCountDownTimer("7/31/2022");
		GeoCountDownTimer s8 = new GeoCountDownTimer("8/31/2022");
		GeoCountDownTimer s9 = new GeoCountDownTimer("9/30/2022");
		GeoCountDownTimer s10 = new GeoCountDownTimer("10/31/2022");
		GeoCountDownTimer s11 = new GeoCountDownTimer("11/30/2022");
		GeoCountDownTimer s12 = new GeoCountDownTimer("12/31/2022");
		GeoCountDownTimer s13 = new GeoCountDownTimer("2/29/2040");
		System.out.println(s1.toDateString());
		System.out.println(s2.toDateString());
		System.out.println(s3.toDateString());
		System.out.println(s4.toDateString());
		System.out.println(s5.toDateString());
		System.out.println(s6.toDateString());
		System.out.println(s7.toDateString());
		System.out.println(s8.toDateString());
		System.out.println(s9.toDateString());
		System.out.println(s10.toDateString());
		System.out.println(s11.toDateString());
		System.out.println(s12.toDateString());


		GeoCountDownTimer s100 =
				new GeoCountDownTimer(2023, 2, 20);
		System.out.println("Date: " + s1.toDateString());
		GeoCountDownTimer s200 = new GeoCountDownTimer(s1);
		GeoCountDownTimer s300 = new GeoCountDownTimer();

		System.out.println("Testing equals:");
		System.out.println(s100.equals(s200));
		System.out.println(s300.equals(s1));
		System.out.println("Testing compare to:");
		System.out.println(s100.CompareTo(s200));
		System.out.println(s300.CompareTo(s100));
		System.out.println(s100.CompareTo(s300));

		System.out.println("Testing getters:");
		System.out.print(s100.getMonth()+"/");
		System.out.print(s100.getDay()+"/");
		System.out.println(s100.getYear());

		System.out.println("Testing setters:");
		s100.setDay(1);
		s100.setMonth(1);
		s100.setYear(2022);
		System.out.print(s100.getMonth()+"/");
		System.out.print(s100.getDay()+"/");
		System.out.println(s100.getYear());

		System.out.println("Testing inc:");
		s100.inc(365);
		System.out.println(s100.toDateString());
		System.out.println("Testing dec:");
		s100.dec(365);
		System.out.println(s100.toDateString());
		//got frustrated at this point, JUnit testing is much better
		s100 = new GeoCountDownTimer("5/10/2023");

		System.out.println("Testing days in future:");
		System.out.println(s100.daysInFuture(10));
		System.out.println(s100.daysInFuture(-10));
		System.out.println("Testing days to go:");
		System.out.println(s1.daysToGo("11/15/2022"));
		System.out.println(s1.daysToGo("8/18/2023"));
	}

	}