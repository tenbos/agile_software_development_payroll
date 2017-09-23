package agile_software_development_payroll;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
	
	private double itsSalary;
	
	public ChangeSalariedTransaction(int empId, double salary) {
		super(empId);
		itsSalary = salary;
	}

	@Override
	PaymentClassification GetClassification() {
		return new SalariedClassification(itsSalary);
	}

	@Override
	PaymentSchedule GetSchedule() {
		return new MonthlySchedule();
	}

}
