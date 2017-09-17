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
	
	@Test
	public void testDeleteEmployee() {
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.Execute();
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
		dt.Execute();
		e = PayrollDatabase.GetEmployee(empId);
		assertNull(e);
	}
	
	@Test
	public void testTimeCardTransaction() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		TimeCardTransaction tct = new TimeCardTransaction(20011031, 8.0, empId);
		tct.Execute();
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		PaymentClassification pc = e.GetClassification();
		HourlyClassification hc = (HourlyClassification) pc;
		assertNotNull(hc);
		TimeCard tc = hc.GetTimeCard(20011031);
		assertNotNull(tc);
		assertEquals(8.0, tc.GetHours());
	}
	
	@Test
	public void testSalesReceiptTransaction() {
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.Execute();
		SalesReceiptTransaction srt = new SalesReceiptTransaction(20011112, 25000, empId);
		srt.Execute();
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		PaymentClassification pc = e.GetClassification();
		CommissionedClassification cc = (CommissionedClassification) pc;
		assertNotNull(cc);
		SalesReceipt sr = cc.GetSalesReceipt(20011112);
		assertNotNull(sr);
		assertEquals(25000.0, sr.GetAmount());
	}
	
	@Test
	public void testAddServiceCharge() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		TimeCardTransaction tct = new TimeCardTransaction(20011031, 8.0, empId);
		tct.Execute();
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		Affiliation af = new UnionAffiliation(12.5);
		e.SetAffiliation(af);
		int memberId = 86;
		PayrollDatabase.AddUnionMember(memberId, e);
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, 20011031, 12.95);
		sct.Execute();
		double sc = af.GetServiceCharge(20011031);
		assertEquals(12.95, sc, .001);
	}
	
	@Test
	public void testChangeNameTransaction() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Bob");
		cnt.Execute();
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		assertEquals("Bob", e.GetName());
	}
	
	@Test
	public void testChangeAddressTransaction() {
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		ChangeAddressTransaction cat = new ChangeAddressTransaction(empId, "Second Home");
		cat.Execute();
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		assertEquals("Second Home", e.GetAddress());
	}
	
	@Test
	public void testChangeHourlyTransaction() {
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.Execute();
		ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
		cht.Execute();
		
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		
		PaymentClassification pc = e.GetClassification();
		assertNotNull(pc);
		HourlyClassification hc = (HourlyClassification) pc;
		assertNotNull(hc);
		assertEquals(27.52, hc.GetRate());
		
		PaymentSchedule ps = e.GetSchedule();
		assertNotNull(ps);
		WeeklySchedule ws = (WeeklySchedule) ps;
		assertNotNull(ws);
	}
	
	@Test
	public void testChangeSalariedTransaction() {
		int empId = 3;
		
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.Execute();
		
		ChangeSalariedTransaction cst = new ChangeSalariedTransaction(empId, 25000);
		cst.Execute();
		
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		
		PaymentClassification pc = e.GetClassification();
		assertNotNull(pc);
		SalariedClassification sc = (SalariedClassification) pc;
		assertNotNull(sc);
		assertEquals(25000.0, sc.GetSalary());
		
		PaymentSchedule ps = e.GetSchedule();
		MonthlySchedule ms = (MonthlySchedule) ps;
		assertNotNull(ms);
	}
	
	@Test
	public void testChangeCommissionedTransaction() {
		int empId = 2;
		
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		
		ChangeCommissionedTransaction cct = new ChangeCommissionedTransaction(empId, 25000, 4.5);
		cct.Execute();
		
		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);
		
		PaymentClassification pc = e.GetClassification();
		assertNotNull(pc);
		CommissionedClassification cc = (CommissionedClassification) pc;
		assertNotNull(cc);
		assertEquals(25000.0, cc.GetSalary());
		assertEquals(4.5, cc.GetRate());
		
		PaymentSchedule ps = e.GetSchedule();
		BiweeklySchedule bs = (BiweeklySchedule) ps;
		assertNotNull(bs);
	}

	@Test
	public void testChangeMailTransaction() {

		int empId = 2;

		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();

		ChangeMailTransaction cmt = new ChangeMailTransaction(empId, "4080 El Cerrito Road");
		cmt.Execute();

		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);

		PaymentMethod pm = e.GetMethod();
		assertNotNull(pm);
		MailMethod mm = (MailMethod) pm;
		assertNotNull(mm);
		assertEquals("4080 El Cerrito Road", mm.GetAddress());
	}

	@Test
	public void testChangeDirectTransaction() {

		int empId = 2;

		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();

		ChangeDirectTransaction cdt = new ChangeDirectTransaction(empId, "FirstNational", "1058209");
		cdt.Execute();

		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);

		PaymentMethod pm = e.GetMethod();
		assertNotNull(pm);
		DirectMethod dm = (DirectMethod) pm;
		assertNotNull(dm);
		assertEquals("FirstNational", dm.GetBank());
		assertEquals("1058209", dm.GetAccount());
	}
	
	@Test
	public void testChangeHoldTransaction() {

		int empId = 2;

		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();

		ChangeHoldTransaction cht = new ChangeHoldTransaction(empId);
		cht.Execute();

		Employee e = PayrollDatabase.GetEmployee(empId);
		assertNotNull(e);

		PaymentMethod pm = e.GetMethod();
		assertNotNull(pm);
		HoldMethod hm = (HoldMethod) pm;
		assertNotNull(hm);
	}
}
