package se.avegagroup.nessie.domain;

import se.avegagroup.nessie.service.CalculationService.Strategy;

public class Result {
	private final Strategy strategy;
	private int successes;
	private int failures;

	public Result(Strategy strategy) {
		this.strategy = strategy;
	}

	public void addResult(Lake lake) {
		if (lake.isNessieInLake()) {
			successes = ++successes;
		} else {
			failures = ++failures;
		}
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public int getSuccesses() {
		return successes;
	}

	public int getFailures() {
		return failures;
	}

	public int getSuccessRate() {
		return successes * 100 / (successes + failures);
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
				+ failures + " out of " + (successes + failures) + " times! That's a " + getSuccessRate()
				+ "% chance of success!";
	}
}
