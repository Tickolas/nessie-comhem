package se.avegagroup.nessie.domain;

public class Lake {
	private boolean nessieInLake;

	private Lake(boolean nessieInLake) {
		this.nessieInLake = nessieInLake;
	}

	public boolean isNessieInLake() {
		return nessieInLake;
	}

	public static Lake withMonster() {
		return new Lake(true);
	}

	public static Lake withoutMonster() {
		return new Lake(false);
	}
}
