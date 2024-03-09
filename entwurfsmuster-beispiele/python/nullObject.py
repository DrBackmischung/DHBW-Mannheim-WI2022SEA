from abc import ABC, abstractmethod

# Abstract Logger
class Logger(ABC):
    @abstractmethod
    def log(self, message):
        pass

# Concrete Logger: ConsoleLogger
class ConsoleLogger(Logger):
    def log(self, message):
        print(f"Console Log: {message}")

# Null Object: NullLogger
class NullLogger(Logger):
    def log(self, message):
        # Null Object does nothing when log is called
        pass

# Client Code
class Application:
    def __init__(self, logger):
        self.logger = logger

    def do_something(self):
        # Some operation
        self.logger.log("Did something")

# Example usage

# Using ConsoleLogger
console_logger = ConsoleLogger()
app_with_console_logger = Application(console_logger)
app_with_console_logger.do_something()

# Using NullLogger
null_logger = NullLogger()
app_with_null_logger = Application(null_logger)
app_with_null_logger.do_something()

# Setting console_logger to NullLogger
console_logger = NullLogger()
app_with_null_logger.logger = console_logger
app_with_null_logger.do_something()
