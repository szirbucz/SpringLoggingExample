package springLoggingExample.logging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkedLoggingController {
	
	@GetMapping("/o1g/{message}")
	public void o1g(@PathVariable("message") final String message) {
	}
}
