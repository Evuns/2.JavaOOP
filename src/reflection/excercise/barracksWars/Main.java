package reflection.excercise.barracksWars;

import reflection.excercise.barracksWars.interfaces.Repository;
import reflection.excercise.barracksWars.interfaces.Runnable;
import reflection.excercise.barracksWars.interfaces.UnitFactory;
import reflection.excercise.barracksWars.core.Engine;
import reflection.excercise.barracksWars.core.factories.UnitFactoryImpl;
import reflection.excercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
