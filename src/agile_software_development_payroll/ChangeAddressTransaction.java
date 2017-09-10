package agile_software_development_payroll;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {

	private String itsAddress;
	
	public ChangeAddressTransaction(int empId, String address) {
		super(empId);
		itsAddress = address;
	}
	
	@Override
	void Change(Employee e) {
		e.SetAddress(itsAddress);
	}

}
