package agile_software_development_payroll;

public class AddSalariedEmployee extends AddEmployeeTransaction {
	
	private double itsSalary;
	
	public AddSalariedEmployee(int empId, String name, String address, double salary) {
		super(empId, name, address);
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
