package se.avegagroup.nessie.domain;

import se.avegagroup.nessie.service.CalculationService;

public class Result {
	private final CalculationService.Strategy strategy;
	private int successes;
	private int failures;

	public Result(CalculationService.Strategy strategy) {
		this.strategy = strategy;
	}

	public void addResult(Lake lake) {
		if (lake.isNessieInLake()) {
			successes = ++successes;
		} else {
			failures = ++failures;
		}
	}

	private String percentify() {
		return String.valueOf(successes * 100 / (successes + failures));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Result result = (Result) o;

		return successes == result.successes && failures == result.failures && strategy == result.strategy;

	}

	@Override
	public int hashCode() {
		int result = strategy != null ? strategy.hashCode() : 0;
		result = 31 * result + successes;
		result = 31 * result + failures;
		return result;
	}

	@Override
	public String toString() {
		return "Strategy: " + strategy + " succeeded " + successes + " times and failed "
				+ failures + " times! That's a " + percentify() + "% chance of success!";
	}
}
