package agile_software_development_payroll;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
	
	public ChangeUnaffiliatedTransaction(int empId) {
		super(empId);
	}

	@Override
	void RecordMembership(Employee e) {
		Affiliation af = e.GetAffiliation();
		if (af instanceof UnionAffiliation) {
			UnionAffiliation ua = (UnionAffiliation) af;
			int memberId = ua.GetMemberId();
			PayrollDatabase.RemoveUnionMember(memberId);
		}
	}

	@Override
	Affiliation GetAffiliation() {
		return new NoAffiliation();
	}

}
