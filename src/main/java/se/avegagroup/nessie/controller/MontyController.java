package se.avegagroup.nessie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.avegagroup.nessie.domain.Result;
import se.avegagroup.nessie.domain.Results;
import se.avegagroup.nessie.service.CalculationService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static se.avegagroup.nessie.domain.Results.resultsOf;

@RestController
@RequestMapping("/nessie")
public class MontyController {
	private static final int DEFAULT_NUMBER_OF_LAKES = 3;
	private static final int DEFAULT_NUMBER_OF_SIMULATIONS = 100;
	@Autowired
	private CalculationService calculationService;

	@RequestMapping(method = GET)
	public
	@ResponseBody
	Results bothStrategies() {
		return bothStrategies(DEFAULT_NUMBER_OF_LAKES, DEFAULT_NUMBER_OF_SIMULATIONS);
	}

	@RequestMapping(method = GET, path = "/both")
	public @ResponseBody Results bothStrategies(
			@RequestParam(name = "numberOfLakes", required = false, defaultValue = "" + DEFAULT_NUMBER_OF_LAKES) int numberOfLakes,
			@RequestParam(name = "simulations", required = false, defaultValue = "" + DEFAULT_NUMBER_OF_SIMULATIONS) int simulations) {
		Result staySimulation = calculationService.runStaySimulationsWith(numberOfLakes, simulations);
		Result switchSimulation = calculationService.runSwitchSimulationsWith(numberOfLakes, simulations);
		return resultsOf(numberOfLakes, simulations, staySimulation, switchSimulation);
	}

	@RequestMapping(method = GET, path = "/switch")
	public Results switchStrategy(
			@RequestParam(name = "numberOfLakes", required = false, defaultValue = "" + DEFAULT_NUMBER_OF_LAKES) int numberOfLakes,
			@RequestParam(name = "simulations", required = false, defaultValue = "" + DEFAULT_NUMBER_OF_SIMULATIONS) int simulations) {
		return resultsOf(numberOfLakes, simulations, calculationService.runSwitchSimulationsWith(numberOfLakes, simulations));
	}

	@RequestMapping(method = GET, path = "/stay")
	public Results stayStrategy(
			@RequestParam(name = "numberOfLakes", required = false, defaultValue = "" + DEFAULT_NUMBER_OF_LAKES) int numberOfLakes,
			@RequestParam(name = "simulations", required = false, defaultValue = "" + DEFAULT_NUMBER_OF_SIMULATIONS) int simulations) {
		return resultsOf(numberOfLakes, simulations, calculationService.runStaySimulationsWith(numberOfLakes, simulations));
	}
}
