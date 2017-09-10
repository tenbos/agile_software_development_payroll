package agile_software_development_payroll;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

	private double itsRate;
	
	public ChangeHourlyTransaction(int empId, double rate) {
		super(empId);
		itsRate = rate;
	}
	
	@Override
	PaymentClassification GetClassification() {
		return new HourlyClassification(itsRate);
	}

	@Override
	PaymentSchedule GetSchedule() {
		return new WeeklySchedule();
	}
}
