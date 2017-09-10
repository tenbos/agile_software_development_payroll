package agile_software_development_payroll;

public abstract class ChangeEmployeeTransaction implements Transaction {

	private int itsEmpId;
	
	public ChangeEmployeeTransaction(int empId) {
		itsEmpId = empId;
	}
	
	@Override
	public void Execute() {
		Employee e = PayrollDatabase.GetEmployee(itsEmpId);
		if (e != null) {
			Change(e);
		}
	}
	
	abstract void Change(Employee e);
}
