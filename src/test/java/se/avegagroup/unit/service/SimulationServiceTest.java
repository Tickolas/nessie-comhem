package se.avegagroup.unit.service;

import org.junit.Test;
import se.avegagroup.nessie.domain.Result;
import se.avegagroup.nessie.service.SimulationService;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static se.avegagroup.nessie.service.SimulationService.Strategy.STAY;
import static se.avegagroup.nessie.service.SimulationService.Strategy.SWITCH;

public class SimulationServiceTest {
	private SimulationService simulationService = new SimulationService();

	@Test
	public void shouldRunSimulationWithStayStrategy() {
		Result result = simulationService.runStaySimulationsWith(3, 100);

		assertThat(result.getStrategy(), is(STAY));
		assertThat(result.getSuccesses() + result.getFailures(), is(100));
		assertThat(result.getSuccesses(), lessThan(result.getFailures()));
	}

	@Test
	public void shouldRunSimulationWithSwitchStrategy() {
		Result result = simulationService.runSwitchSimulationsWith(3, 100);

		assertThat(result.getStrategy(), is(SWITCH));
		assertThat(result.getSuccesses() + result.getFailures(), is(100));
		assertThat(result.getFailures(), lessThan(result.getSuccesses()));
	}
}
