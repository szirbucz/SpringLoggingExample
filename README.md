How to use Logger in Spring
===========================

When you are looking for logging example in Spring, you most probably will find something like this:
	
	@RestController
	public class LoggingController {	 
	
    	Logger logger = LoggerFactory.getLogger(LoggingController.class);
    	
    	@RequestMapping("/")
    	public void index() {
    		logger.info("An INFO Message");
    	}
    }

It is so simple, what is the problem with this?
-
Try to implement it in TDD (that you should always do) and you will realize it shortly. You can't easily write a unit test, that checks if the message has been logged or not.

Never hide a TUF in a TUC
-
It is because logging is a TUF (**T**est **U**nfriendly **F**eature), since you can't reach the value it has been called with, unless you replace it with a fake object (mock).

Than why don't we simply replace it with a mock? Because it is in a static field, that is a TUC (**T**est **U**nfriendly **C**onstruct) that can't be replaced by mock.

The solution
-
The easiest way to make it able to mock is passing it by **dependency injection**. You will need a prototype bean that creates the proper *Logger* instance each time you inject it, since the logger needs information about the caller class. Check the example in the source code and don't forget, **always test first!**

How to try it?
-

* Run the application (either from IDE or with java -jar).
* Open one of the following URLs.
    - <a href="http://localhost:8080/log/hello%20world" target="_blank">http://localhost:8080/log/&lt;your message comes here&gt;</a>
    - <a href="http://localhost:8080/error/hello%20world" target="_blank">http://localhost:8080/error/&lt;your message comes here&gt;</a>
    - <a href="http://localhost:8080/o1g/hello%20world" target="_blank">http://localhost:8080/o1g/&lt;your message comes here&gt;</a>
* Check the console.