package agile_software_development_payroll;

public class Employee {

	private int itsEmpId;
	private String itsName;
	private String itsAddress;
	private PaymentClassification itsClassification;
	private PaymentSchedule itsSchedule;
	private PaymentMethod itsMethod;
	
	public Employee(int empId, String name, String address) {
		itsEmpId = empId;
		itsName = name;
		itsAddress = address;
	}

	public PaymentClassification GetClassification() {
		return itsClassification;
	}

	public String GetName() {
		return itsName;
	}

	public PaymentSchedule GetSchedule() {
		return itsSchedule;
	}

	public PaymentMethod GetMethod() {
		return itsMethod;
	}

	public void SetClassification(PaymentClassification pc) {
		itsClassification = pc;
	}

	public void SetSchedule(PaymentSchedule ps) {
		itsSchedule = ps;
	}

	public void SetMethod(PaymentMethod pm) {
		itsMethod = pm;
	}
}
