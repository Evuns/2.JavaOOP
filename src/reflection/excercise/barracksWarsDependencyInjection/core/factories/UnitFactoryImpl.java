package reflection.excercise.barracksWarsDependencyInjection.core.factories;

import reflection.excercise.barracksWarsDependencyInjection.interfaces.Unit;
import reflection.excercise.barracksWarsDependencyInjection.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "reflection.excercise.barracksWarsDependencyInjection.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;

        try {
            Class <?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor cotor = clazz.getConstructor();
            unit = (Unit) cotor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        return unit;
    }
}
