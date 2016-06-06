package se.avegagroup.nessie.service;

import org.springframework.stereotype.Service;
import se.avegagroup.nessie.domain.Lake;
import se.avegagroup.nessie.domain.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static se.avegagroup.nessie.service.CalculationService.Strategy.STAY;
import static se.avegagroup.nessie.service.CalculationService.Strategy.SWITCH;

@Service
public class CalculationService {
	private static final Random RANDOM_NUMBER_GENERATOR = new Random();
	private static final boolean DEBUG = false;

	/**
	 * Run a number of simulations with the STAY strategy.
	 *
	 * When we select a lake, stay on it no matter what!
	 *
	 * @param numberOfLakes Number of lakes to generate.
	 * @param simulations Number of simulations to run.
	 * @return The result of the simulations.
	 */
	public Result runStaySimulationsWith(int numberOfLakes, int simulations) {
		return runSimulation(STAY, numberOfLakes, simulations);
	}

	/**
	 * Run a number of simulations with the SWITCH strategy.
	 *
	 * When told that one of the other lakes doesn't hold Nessie, always switch!
	 *
	 * @param numberOfLakes Number of lakes to generate.
	 * @param simulations Number of simulations to run.
	 * @return The result of the simulations.
	 */
	public Result runSwitchSimulationsWith(int numberOfLakes, int simulations) {
		return runSimulation(SWITCH, numberOfLakes, simulations);
	}

	/**
	 * Run a simulation of a selected strategy.
	 *
	 * @param strategy The strategy to use, stay or switch lakes.
	 * @param numberOfLakes Number of lakes to generate for each iteration.
	 * @param simulations Number of simulations to run.
	 * @return The result of the simulations.
	 */
	private Result runSimulation(Strategy strategy, int numberOfLakes, int simulations) {
		Result result = new Result(strategy);

		for (int i = 0; i < simulations; i++) {
			log("------ NEW " + strategy + " SIM ------");

			List<Lake> lakes = createLakes(numberOfLakes);

			Lake lake = pickLakeFrom(lakes);

			log("Picked lake " + (lakes.indexOf(lake) + 1));

			lakes = debunkALakeFrom(lakes, lake);

			if(strategy == SWITCH) {
				lake = otherLake(lake, lakes);
				log("Switched to lake " + (lakes.indexOf(lake) + 1));
			}

			result.addResult(lake);
			log(strategy + " was " + (lake.isNessieInLake() ? "successful!" : "a failure!"));
			log("------ END " + strategy + " SIM ------");
			log("");
		}

		return result;
	}

	/**
	 * A farmer tells us Nessie isn't in one of the other lakes. How nice, but I wonder
	 * how he knows...?
	 *
	 * @param lakes The list of lakes.
	 * @param initialLake The lake that was initially chosen.
	 * @return An updated list of lakes.
	 */
	private List<Lake> debunkALakeFrom(List<Lake> lakes, Lake initialLake) {
		Lake otherLake = null;

		while (otherLake == null) {
			Lake lake = lakes.get(RANDOM_NUMBER_GENERATOR.nextInt(lakes.size()));

			if(!lake.equals(initialLake) && !lake.isNessieInLake()) {
				lake.debunk();
				otherLake = lake;
			}
		}

		lakes.set(lakes.indexOf(otherLake), otherLake);

		log("Lake " + (lakes.indexOf(otherLake) + 1) + " is debunked");

		return lakes;
	}

	/**
	 * Pick a random lake, other than the initially selected one.
	 *
	 * @param initialLake The lake that was initially selected.
	 * @param lakes The list of lakes.
	 * @return Another lake.
	 */
	private Lake otherLake(Lake initialLake, List<Lake> lakes) {
		Lake chosenLake = null;

		while (chosenLake == null) {
			Lake lake = lakes.get(RANDOM_NUMBER_GENERATOR.nextInt(lakes.size()));

			if(!lake.equals(initialLake) && !lake.isDebunked()) {
				chosenLake = lake;
			}
		}
		return chosenLake;
	}

	/**
	 * Pick a random lake from the list.
	 *
	 * @param lakes The list of lakes.
	 * @return A random lake.
	 */
	private Lake pickLakeFrom(List<Lake> lakes) {
		return lakes.get(RANDOM_NUMBER_GENERATOR.nextInt(lakes.size() - 1));
	}

	/**
	 * Create a list of lakes, one of which contains Nessie.
	 *
	 * @param numberOfLakes Number of lakes to create.
	 * @return A list of lakes.
	 */
	private List<Lake> createLakes(int numberOfLakes) {
		List<Lake> lakes = new ArrayList<>();

		for (int i = 0; i < numberOfLakes; i++) {
			lakes.add(Lake.withoutMonster());
		}

		int index = RANDOM_NUMBER_GENERATOR.nextInt(numberOfLakes);
		lakes.set(index, Lake.withMonster());

		log("Nessie is in lake " + (index + 1));

		return lakes;
	}

	/**
	 * If debug is enabled, log the message to the console.
	 *
	 * @param message The message to log.
	 */
	private void log(String message) {
		if(DEBUG) {
			System.out.println(message);
		}
	}

	public enum Strategy {
		STAY,
		SWITCH,
		NA;

		@Override
		public String toString() {
			return this.name();
		}
	}
}
