package reflection.excercise.barracksWars.core.factories;

import reflection.excercise.barracksWars.interfaces.Unit;
import reflection.excercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "reflection.excercise.barracksWars.models.otherUnits.";

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
