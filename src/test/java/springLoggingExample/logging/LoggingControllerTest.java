package springLoggingExample.logging;


import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

@ExtendWith(MockitoExtension.class)
class LoggingControllerTest {
	
	private static final String MESSAGE = "Meshuggah";

	@InjectMocks
	private LoggingController loggingController;
	
	@Mock
	private Logger logger;

	@Test
	void testInfoMessageIsLogged() {
		loggingController.info(MESSAGE);
		verify(logger).info(MESSAGE);
	}
	
	@Test
	void testErrorMessageIsLogged() {
		loggingController.error(MESSAGE);
		verify(logger).error(MESSAGE);
	}

}
