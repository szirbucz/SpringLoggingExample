package springLoggingExample.logging;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	
	@Autowired
	private Logger logger;
	
	@GetMapping("/log/{message}")
	public void info(@PathVariable("message") final String message) {
		logger.info(message);
	}

	@GetMapping("/error/{message}")
	public void error(@PathVariable("message") final String message) {
	}
}
