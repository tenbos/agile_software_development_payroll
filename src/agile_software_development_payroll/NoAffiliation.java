package agile_software_development_payroll;

public class NoAffiliation implements Affiliation {

	@Override
	public double GetServiceCharge(long date) {
		return 0;
	}

}
