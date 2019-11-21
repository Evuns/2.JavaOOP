package reflection.excercise.barracksWarsNewFactory;

import reflection.excercise.barracksWarsNewFactory.interfaces.Repository;
import reflection.excercise.barracksWarsNewFactory.interfaces.Runnable;
import reflection.excercise.barracksWarsNewFactory.interfaces.UnitFactory;
import reflection.excercise.barracksWarsNewFactory.core.Engine;
import reflection.excercise.barracksWarsNewFactory.core.factories.UnitFactoryImpl;
import reflection.excercise.barracksWarsNewFactory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
