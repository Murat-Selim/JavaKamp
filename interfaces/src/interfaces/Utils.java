package interfaces;

public class Utils {
	public static void runLogger(Logger[] loggers, String message) {
		for(Logger logger: loggers) {
			logger.log(message);
		}
	}

}
