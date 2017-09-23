package agile_software_development_payroll;

public class ChangeMailTransaction extends ChangeMethodTransaction {

	private String itsAddress;
	
	public ChangeMailTransaction(int empId, String address) {
		super(empId);
		itsAddress = address;
	}
	
	@Override
	PaymentMethod GetMethod() {
		return new MailMethod(itsAddress);
	}

}
