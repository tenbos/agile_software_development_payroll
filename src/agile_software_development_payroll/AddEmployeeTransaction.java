package agile_software_development_payroll;

public abstract class AddEmployeeTransaction implements Transaction {

	private int itsEmpId;
	private String itsName;
	private String itsAddress;
	
	public AddEmployeeTransaction(int empId, String name, String address) {
		itsEmpId = empId;
		itsName = name;
		itsAddress = address;
	}
	
	@Override
	public void Execute() {
		
		PaymentClassification pc = GetClassification();
		PaymentSchedule ps = GetSchedule();
		PaymentMethod pm = new HoldMethod();
		
		Employee e = new Employee(itsEmpId, itsName, itsAddress);
		e.SetClassification(pc);
		e.SetSchedule(ps);
		e.SetMethod(pm);
		
		PayrollDatabase.AddEmployee(itsEmpId, e);
	}
	
	abstract PaymentClassification GetClassification();
	abstract PaymentSchedule GetSchedule();
}
