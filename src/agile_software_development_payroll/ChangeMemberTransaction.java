package agile_software_development_payroll;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
	
	private int itsMemberId;
	private double itsDues;

	public ChangeMemberTransaction(int empId, int memberId, double dues) {
		super(empId);
		itsMemberId = memberId;
		itsDues = dues;
	}

	@Override
	void RecordMembership(Employee e) {
		PayrollDatabase.AddUnionMember(itsMemberId, e);
	}

	@Override
	Affiliation GetAffiliation() {
		return new UnionAffiliation(itsMemberId, itsDues);
	}

}
