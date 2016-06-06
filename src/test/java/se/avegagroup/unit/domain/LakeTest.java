package se.avegagroup.unit.domain;

import org.junit.Test;
import se.avegagroup.nessie.domain.Lake;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LakeTest {
	@Test
	public void shouldCreateLakeWithMonster() {
		assertThat(Lake.withMonster().isNessieInLake(), is(true));
	}
	@Test
	public void shouldCreateLakeWithoutMonster() {
		assertThat(Lake.withoutMonster().isNessieInLake(), is(false));
	}
}
