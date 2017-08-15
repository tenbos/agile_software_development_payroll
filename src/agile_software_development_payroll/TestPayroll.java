package agile_software_development_payroll;

import org.junit.Test;

import junit.framework.TestCase;

public class TestPayroll extends TestCase {
	
	@Test
	public void testAddSalariedEmployee() {
				
		int empId = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
		t.Execute();
		
		Employee e = PayrollDatabase.GetEmployee(empId);
		
		assertNotNull(e);
		assertEquals("Bob", e.GetName());
		
		PaymentClassification pc = e.GetClassification();
		SalariedClassification sc = (SalariedClassification) pc;
		
		assertNotNull(sc);
		assertEquals(1000.00, sc.GetSalary());
		
		PaymentSchedule ps = e.GetSchedule();
		MonthlySchedule ms = (MonthlySchedule) ps;
		
		assertNotNull(ms);
		
		PaymentMethod pm = e.GetMethod();
		HoldMethod hm = (HoldMethod) pm;
		
		assertNotNull(hm);
	}
	
	@Test
	public void testAddHourlyEmployee() {
		
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		
		Employee e = PayrollDatabase.GetEmployee(empId);
		
		assertNotNull(e);
		assertEquals("Bill", e.GetName());
		
		PaymentClassification pc = e.GetClassification();
		HourlyClassification hc = (HourlyClassification) pc;
		
		assertNotNull(hc);
		assertEquals(15.25, hc.GetRate());
		
		PaymentSchedule ps = e.GetSchedule();
		WeeklySchedule ws = (WeeklySchedule) ps;
		
		assertNotNull(ws);
		
		PaymentMethod pm = e.GetMethod();
		HoldMethod hm = (HoldMethod) pm;
		
		assertNotNull(hm);
	}
	
	@Test
	public void testAddCommissionedEmployee() {
				
		int empId = 1;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500.0, 3.2);
		t.Execute();
		
		Employee e = PayrollDatabase.GetEmployee(empId);
		
		assertNotNull(e);
		assertEquals("Lance", e.GetName());
		
		PaymentClassification pc = e.GetClassification();
		CommissionedClassification cc = (CommissionedClassification) pc;
		
		assertNotNull(cc);
		assertEquals(2500.0, cc.GetSalary());
		
		PaymentSchedule ps = e.GetSchedule();
		BiweeklySchedule bs = (BiweeklySchedule) ps;
		
		assertNotNull(bs);
		
		PaymentMethod pm = e.GetMethod();
		HoldMethod hm = (HoldMethod) pm;
		
		assertNotNull(hm);
	}
}
