package reflection.excercise.barracksWarsDependencyInjection;

import reflection.excercise.barracksWarsDependencyInjection.core.Engine;
import reflection.excercise.barracksWarsDependencyInjection.core.commands.CommandInterpreterImpl;
import reflection.excercise.barracksWarsDependencyInjection.core.factories.UnitFactoryImpl;
import reflection.excercise.barracksWarsDependencyInjection.data.UnitRepository;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.CommandInterpreter;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.Repository;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.Runnable;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
