package se.avegagroup.service;

import org.junit.Test;
import se.avegagroup.nessie.service.CalculationService;

public class CalculationServiceTest {
	private CalculationService calculationService = new CalculationService();

	@Test
	public void shouldRunSimulationWithStayStrategy() {
		calculationService.runStaySimulationsWith(3, 500);
	}

	@Test
	public void shouldRunSimulationWithSwitchStrategy() {
		calculationService.runSwitchSimulationsWith(3, 500);
	}
}
