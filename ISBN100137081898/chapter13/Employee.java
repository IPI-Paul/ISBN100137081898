package chapter13; // inheritance

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Employee class Listing 5.2
 * @author Cay Horstmann
 */
public class Employee {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String n) {
		name = n;
	}
	
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public Date getHireDay() {
		return (Date) hireDay.clone();
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public String toString() {
		return name;
	}
}
