package agile_software_development_payroll;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

	public ChangeClassificationTransaction(int empId) {
		super(empId);
	}
	
	abstract PaymentClassification GetClassification();
	abstract PaymentSchedule GetSchedule();
	
	@Override
	public void Change(Employee e) {
		e.SetClassification(GetClassification());
		e.SetSchedule(GetSchedule());
	}
	
}
