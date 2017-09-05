package agile_software_development_payroll;

import java.util.HashMap;
import java.util.Map;

public class HourlyClassification implements PaymentClassification {

	private double itsHourlyRate;
	private Map<Long, TimeCard> itsTimeCards;
	
	public HourlyClassification(double hourlyRate) {
		itsHourlyRate = hourlyRate;
		itsTimeCards = new HashMap<>();
	}
	
	public double GetRate() {
		return itsHourlyRate;
	}

	public TimeCard GetTimeCard(long date) {
		return itsTimeCards.get(date);
	}

	public void AddTimeCard(TimeCard tc) {
		itsTimeCards.put(tc.GetDate(), tc);
	}

}
