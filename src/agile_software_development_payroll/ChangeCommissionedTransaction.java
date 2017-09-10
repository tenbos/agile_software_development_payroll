package agile_software_development_payroll;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {

	private double itsSalary;
	private double itsCommissionRate;
	
	public ChangeCommissionedTransaction(int empId, double salary, double commissionRate) {
		super(empId);
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
