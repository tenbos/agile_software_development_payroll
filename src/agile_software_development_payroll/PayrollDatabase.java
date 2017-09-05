package agile_software_development_payroll;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

	private static Map<Integer, Employee> itsEmployees = new HashMap<>();
	private static Map<Integer, Employee> itsUnionMembers = new HashMap<>();
	
	public static void AddEmployee(int empId, Employee e) {
		itsEmployees.put(empId, e);
	}
	
	public static Employee GetEmployee(int empId) {
		return itsEmployees.get(empId);
	}
	
	public static void Clear() {
		itsEmployees.clear();
	}
	
	public static void DeleteEmployee(int empId) {
		itsEmployees.remove(empId);
	}

	public static void AddUnionMember(int memberId, Employee e) {
		itsUnionMembers.put(memberId, e);
	}
	
	public static Employee GetUnionMember(int memberId) {
		return itsUnionMembers.get(memberId);
	}
	
}
