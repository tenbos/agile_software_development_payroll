package agile_software_development_payroll;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

	public ChangeHoldTransaction(int empId) {
		super(empId);
	}

	@Override
	PaymentMethod GetMethod() {
		return new HoldMethod();
	}

}
