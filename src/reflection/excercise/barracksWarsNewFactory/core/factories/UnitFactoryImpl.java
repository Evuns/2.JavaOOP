package reflection.excercise.barracksWarsNewFactory.core.factories;

import reflection.excercise.barracksWarsNewFactory.interfaces.Unit;
import reflection.excercise.barracksWarsNewFactory.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "reflection.excercise.barracksWarsNewFactory.models.Allunits.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
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
