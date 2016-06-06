package se.avegagroup.unit.domain;

import org.junit.Test;
import se.avegagroup.nessie.domain.Results;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static se.avegagroup.nessie.service.CalculationService.Strategy.NA;
import static se.avegagroup.unit.Helpers.generateResult;
import static se.avegagroup.nessie.domain.Results.resultsOf;
import static se.avegagroup.nessie.service.CalculationService.Strategy.STAY;
import static se.avegagroup.nessie.service.CalculationService.Strategy.SWITCH;

public class ResultsTest {
	@Test
	public void shouldCalculateSuperiorStrategy() throws Exception {
		Results results = resultsOf(100, 3, generateResult(SWITCH, 3, 7), generateResult(STAY, 7, 3));

		assertThat(results.getSuperiorStrategy(), is(SWITCH));
	}

	@Test
	public void shouldReturnStrategyIfOnlyOneResultWasAdded() throws Exception {
		Results results = resultsOf(100, 3, generateResult(SWITCH, 3, 7));

		assertThat(results.getSuperiorStrategy(), is(SWITCH));
	}

	@Test
	public void shouldReturnDefaultValueIfNoResultsAreAdded() throws Exception {
		Results results = resultsOf(100, 3);

		assertThat(results.getSuperiorStrategy(), is(NA));
	}
}
