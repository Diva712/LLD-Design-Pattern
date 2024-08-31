abstract class LoggerProcessor {
  public static int INFO = 1;
  public static int ERROR = 2;
  public static int DEBUG = 3;

  LoggerProcessor nextLoggerProcessor;

  LoggerProcessor(LoggerProcessor nextLoggerProcessor) {
    this.nextLoggerProcessor = nextLoggerProcessor;
  }

  void log(int loglevel, String msg) {
    if (nextLoggerProcessor != null) {
      nextLoggerProcessor.log(loglevel, msg);
    }
  }
}

class InfoLogger extends LoggerProcessor {

  InfoLogger(LoggerProcessor nextLoggerProcessor) {
    super(nextLoggerProcessor);
  }

  @Override
  void log(int loglevel, String msg) {
    if (loglevel == INFO) {
      System.out.println("INFO: " + msg);
    } else {
      super.log(loglevel, msg);
    }
  }
}

class DebugLogger extends LoggerProcessor {
  DebugLogger(LoggerProcessor nextLoggerProcessor) {
    super(nextLoggerProcessor);
  }

  @Override
  void log(int loglevel, String msg) {
    if (loglevel == DEBUG) {
      System.out.println("DEBUG: " + msg);
    } else {
      super.log(loglevel, msg);
    }
  }
}

class ErrorLogger extends LoggerProcessor {
  ErrorLogger(LoggerProcessor nextLoggerProcessor) {
    super(nextLoggerProcessor);
  }

  @Override
  void log(int loglevel, String msg) {
    if (loglevel == ERROR) {
      System.err.println("ERROR: " + msg);
    } else {
      super.log(loglevel, msg);
    }
  }
}

public class Main {
  public static void main(String[] args) {
    LoggerProcessor logger = new InfoLogger(new ErrorLogger(new DebugLogger(null)));
    logger.log(LoggerProcessor.DEBUG, "I am from Debugger Logger, And Ready to debug a code!!");
    logger.log(LoggerProcessor.INFO, "This is an informational message.");
    logger.log(LoggerProcessor.ERROR, "An error has occurred.");
  }
}
