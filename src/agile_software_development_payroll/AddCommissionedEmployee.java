package agile_software_development_payroll;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
	
	private double itsSalary;
	private double itsCommissionRate;

	public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionRate) {
		super(empId, name, address);
		itsSalary = salary;
		itsCommissionRate = commissionRate;
	}

	@Override
	PaymentClassification GetClassification() {
		return new CommissionedClassification(itsSalary, itsCommissionRate);
	}

	@Override
	PaymentSchedule GetSchedule() {
		return new BiweeklySchedule();
	}

}
