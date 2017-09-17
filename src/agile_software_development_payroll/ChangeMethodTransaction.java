package agile_software_development_payroll;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

	public ChangeMethodTransaction(int empId) {
		super(empId);
	}

	@Override
	public void Change(Employee e) {
		e.SetMethod(GetMethod());
	}

	abstract PaymentMethod GetMethod();
}
