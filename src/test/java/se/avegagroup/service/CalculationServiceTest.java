package se.avegagroup.service;

import org.junit.Test;
import se.avegagroup.nessie.domain.Result;
import se.avegagroup.nessie.service.CalculationService;

/**
 * Runs simulations
 */
public class CalculationServiceTest {
	private CalculationService calculationService = new CalculationService();

	@Test
	public void shouldRunSimulationWithStayStrategy() {
		Result result = calculationService.runStaySimulationsWith(3, 100);

		System.out.println(result);
	}

	@Test
	public void shouldRunSimulationWithSwitchStrategy() {
		Result result = calculationService.runSwitchSimulationsWith(3, 100);

		System.out.println(result);
	}
}
