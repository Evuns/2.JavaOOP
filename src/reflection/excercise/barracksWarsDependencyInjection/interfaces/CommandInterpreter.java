package reflection.excercise.barracksWarsDependencyInjection.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
