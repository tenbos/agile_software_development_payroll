package agile_software_development_payroll;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

	public ChangeAffiliationTransaction(int empId) {
		super(empId);
	}

	@Override
	void Change(Employee e) {
		RecordMembership(e);
		e.SetAffiliation(GetAffiliation());
	}

	abstract void RecordMembership(Employee e);
	abstract Affiliation GetAffiliation();
}
