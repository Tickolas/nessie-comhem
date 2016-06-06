package se.avegagroup.unit;

import se.avegagroup.nessie.domain.Lake;
import se.avegagroup.nessie.domain.Result;
import se.avegagroup.nessie.service.CalculationService;

public class Helpers {
	public static Result generateResult(CalculationService.Strategy strategy, int failures, int successes) {
		Result result = new Result(strategy);

		for (int i = 0; i < failures; i++) {
			result.addResult(Lake.withoutMonster());
		}
		for (int i = 0; i < successes; i++) {
			result.addResult(Lake.withMonster());
		}
		return result;
	}
}
