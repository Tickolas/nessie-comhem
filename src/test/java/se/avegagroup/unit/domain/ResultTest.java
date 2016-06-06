package se.avegagroup.unit.domain;

import org.junit.Test;
import se.avegagroup.nessie.domain.Result;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static se.avegagroup.unit.Helpers.generateResult;
import static se.avegagroup.nessie.service.CalculationService.Strategy.SWITCH;

public class ResultTest {
	@Test
	public void shouldCalculateProbabilityCorrectly() throws Exception {
		int successes = 7;
		int failures = 3;

		Result result = generateResult(SWITCH, failures, successes);

		assertThat(result.getSuccessRate(), is(70));
	}
}
