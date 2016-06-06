package se.avegagroup.nessie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.avegagroup.nessie.domain.Result;
import se.avegagroup.nessie.domain.Results;
import se.avegagroup.nessie.service.CalculationService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/nessie")
public class MontyController {
	private static final int DEFAULT_NUMBER_OF_LAKES = 3;
	private static final int DEFAULT_NUMBER_OF_SIMULATIONS = 100;
	@Autowired
	private CalculationService calculationService;

	@RequestMapping(method = GET)
	public @ResponseBody
	Results getString() {
		Result staySimulation = calculationService.runStaySimulationsWith(DEFAULT_NUMBER_OF_LAKES, DEFAULT_NUMBER_OF_SIMULATIONS);
		Result switchSimulation = calculationService.runSwitchSimulationsWith(DEFAULT_NUMBER_OF_LAKES, DEFAULT_NUMBER_OF_SIMULATIONS);
		return Results.resultsOf(DEFAULT_NUMBER_OF_LAKES, DEFAULT_NUMBER_OF_SIMULATIONS, staySimulation, switchSimulation);
	}
}
