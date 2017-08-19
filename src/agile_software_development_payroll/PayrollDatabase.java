package agile_software_development_payroll;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

	private static Map<Integer, Employee> itsEmployees = new HashMap<>();
	
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
}
