package springLoggingExample.logging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	
	@GetMapping("/log/{message}")
	public void info(@PathVariable("message") final String message) {
	}
}
