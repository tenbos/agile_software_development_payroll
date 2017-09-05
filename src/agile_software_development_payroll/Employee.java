package agile_software_development_payroll;

public class Employee {

	private int itsEmpId;
	private String itsName;
	private String itsAddress;
	private PaymentClassification itsClassification;
	private PaymentSchedule itsSchedule;
	private PaymentMethod itsMethod;
	private Affiliation itsAffiliation;
	
	public Employee(int empId, String name, String address) {
		itsEmpId = empId;
		itsName = name;
		itsAddress = address;
	}

	public String GetName() {
		return itsName;
	}

	public PaymentClassification GetClassification() {
		return itsClassification;
	}

	public void SetClassification(PaymentClassification pc) {
		itsClassification = pc;
	}

	public PaymentSchedule GetSchedule() {
		return itsSchedule;
	}

	public void SetSchedule(PaymentSchedule ps) {
		itsSchedule = ps;
	}

	public PaymentMethod GetMethod() {
		return itsMethod;
	}

	public void SetMethod(PaymentMethod pm) {
		itsMethod = pm;
	}
	
	public Affiliation GetAffiliation() {
		return itsAffiliation;
	}
	
	public void SetAffiliation(Affiliation af) {
		itsAffiliation = af;		
	}
}
