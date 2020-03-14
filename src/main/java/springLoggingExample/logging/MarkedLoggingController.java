package springLoggingExample.logging;

import org.slf4j.Logger;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkedLoggingController {

	@Autowired
	private Logger logger;
	
	@GetMapping("/o1g/{message}")
	public void o1g(@PathVariable("message") final String message) {
		logger.info(MarkerFactory.getMarker("o1g"), message);
	}
}
