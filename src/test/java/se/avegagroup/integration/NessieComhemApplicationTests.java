package se.avegagroup.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import se.avegagroup.nessie.NessieComhemApplication;
import se.avegagroup.nessie.domain.Results;
import se.avegagroup.nessie.service.CalculationService;

import static org.hamcrest.Matchers.is;
import static se.avegagroup.nessie.service.CalculationService.Strategy.STAY;
import static se.avegagroup.nessie.service.CalculationService.Strategy.SWITCH;

@WebIntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NessieComhemApplication.class)
public class NessieComhemApplicationTests {
	private RestTemplate template = new TestRestTemplate();

	@Test
	public void shouldRunDefaultSimulation() throws Exception {
		ResponseEntity<Results> results = template.getForEntity("http://localhost:8080/nessie", Results.class);

		Assert.assertThat(results.getBody().getSimulations(), is(100));
		Assert.assertThat(results.getBody().getLakes(), is(3));
		Assert.assertThat(results.getBody().getSuperiorStrategy(), is(SWITCH));
	}

	@Test
	public void shouldRunBothSimulationWithParams() throws Exception {
		ResponseEntity<Results> results = template.getForEntity("http://localhost:8080/nessie/both?numberOfLakes=4&simulations=150", Results.class);

		Assert.assertThat(results.getBody().getSimulations(), is(150));
		Assert.assertThat(results.getBody().getLakes(), is(4));
		Assert.assertThat(results.getBody().getSuperiorStrategy(), is(SWITCH));
	}

	@Test
	public void shouldRunSwitchSimulationWithParams() throws Exception {
		ResponseEntity<Results> results = template.getForEntity("http://localhost:8080/nessie/switch?numberOfLakes=3&simulations=120", Results.class);

		Assert.assertThat(results.getBody().getSimulations(), is(120));
		Assert.assertThat(results.getBody().getLakes(), is(3));
		Assert.assertThat(results.getBody().getSuperiorStrategy(), is(SWITCH));
	}

	@Test
	public void shouldRunStaySimulationWithParams() throws Exception {
		ResponseEntity<Results> results = template.getForEntity("http://localhost:8080/nessie/stay?numberOfLakes=3&simulations=120", Results.class);

		Assert.assertThat(results.getBody().getSimulations(), is(120));
		Assert.assertThat(results.getBody().getLakes(), is(3));
		Assert.assertThat(results.getBody().getSuperiorStrategy(), is(STAY));
	}
}
