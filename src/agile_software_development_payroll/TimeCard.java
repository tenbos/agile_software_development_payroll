package agile_software_development_payroll;

public class TimeCard {

	private long itsDate;
	private double itsHours;
	
	public TimeCard(long date, double hours) {
		itsDate = date;
		itsHours = hours;
	}
	
	public long GetDate() {
		return itsDate;
	}
	
	public double GetHours() {
		return itsHours;
	}
}
