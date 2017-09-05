package agile_software_development_payroll;

import java.util.HashMap;
import java.util.Map;

public class UnionAffiliation implements Affiliation {
	
	private Map<Long, ServiceCharge> itsServiceCharges = new HashMap<>();
	
	public UnionAffiliation(double d) {
	}

	@Override
	public double GetServiceCharge(long date) {
		ServiceCharge sc = itsServiceCharges.get(date);
		if (sc == null) {
			return 0;
		}
		return sc.GetAmount();
	}

	public void AddServiceCharge(long date, double amount) {
		itsServiceCharges.put(date, new ServiceCharge(date, amount));
	}

}
