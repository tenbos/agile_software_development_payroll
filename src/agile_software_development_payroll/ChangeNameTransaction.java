package agile_software_development_payroll;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

	private String itsName;
	
	public ChangeNameTransaction(int empId, String name) {
		super(empId);
		itsName = name;
	}
	
	@Override
	void Change(Employee e) {
		e.SetName(itsName);
	}
}
