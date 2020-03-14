package springLoggingExample.logging;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MarkedLoggingControllerTest {

	private static final Marker MARKER = MarkerFactory.getMarker("o1g");

	private static final String MESSAGE = "The orange is rotten.";

	@InjectMocks
	private MarkedLoggingController markedLoggingController;
	
	@Mock
	private Logger logger;
	
	@Test
	void testMessageIsLoggedWithMark() {
		markedLoggingController.o1g(MESSAGE);
		verify(logger).info(MARKER, MESSAGE);
	}

}
