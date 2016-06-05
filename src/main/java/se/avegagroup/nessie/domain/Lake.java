package se.avegagroup.nessie.domain;

import java.util.UUID;

public class Lake {
	private String id = UUID.randomUUID().toString();
	private boolean nessieInLake;
	private boolean debunked;

	private Lake(boolean nessieInLake) {
		this.nessieInLake = nessieInLake;
	}

	public boolean isNessieInLake() {
		return nessieInLake;
	}

	public boolean isDebunked() {
		return debunked;
	}

	public void debunk() {
		this.debunked = true;
	}

	public static Lake withMonster() {
		return new Lake(true);
	}

	public static Lake withoutMonster() {
		return new Lake(false);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Lake lake = (Lake) o;

		return id != null ? id.equals(lake.id) : lake.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Lake " + id;
	}
}
