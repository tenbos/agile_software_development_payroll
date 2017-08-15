package agile_software_development_payroll;

public class AddHourlyEmployee extends AddEmployeeTransaction {

	private double itsHourlyRate;
	
	public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
		super(empId, name, address);
		itsHourlyRate = hourlyRate;
	}

	@Override
	PaymentClassification GetClassification() {
		return new HourlyClassification(itsHourlyRate);
	}

	@Override
	PaymentSchedule GetSchedule() {
		return new WeeklySchedule();
	}

}
