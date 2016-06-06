package se.avegagroup.nessie.domain;

import se.avegagroup.nessie.service.CalculationService.Strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.compare;
import static se.avegagroup.nessie.service.CalculationService.Strategy.NA;

public class Results {
	private int simulations;
	private int lakes;
	private List<Result> results;

	private Results(int simulations, int lakes, Result... results) {
		this.simulations = simulations;
		this.lakes = lakes;
		this.results = Arrays.asList(results);
	}

	public int getSimulations() {
		return simulations;
	}

	public int getLakes() {
		return lakes;
	}

	public Strategy getSuperiorStrategy() {
		Optional<Result> bestResult = results.stream().max((p1, p2) -> compare(p1.getSuccessRate(), p2.getSuccessRate()));

		if(bestResult.isPresent()) {
			return bestResult.get().getStrategy();
		} else {
			return NA;
		}
	}

	public List<Result> getResults() {
		return results;
	}

	public static Results resultsOf(int simulations, int lakes, Result... results) {
		return new Results(simulations, lakes, results);
	}
}
