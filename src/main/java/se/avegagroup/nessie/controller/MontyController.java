package se.avegagroup.nessie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MontyController {
	@RequestMapping("/test")
	public String getString() {
		return "Working";
	}
}
