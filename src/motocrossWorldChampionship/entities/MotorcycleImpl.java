package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;

public abstract class MotorcycleImpl implements Motorcycle {

    private String model;
    private int horsePower;

    public MotorcycleImpl (String model, int horsePower) {
        setModel(model);
        setHorsePower(horsePower);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if(model.isEmpty() || model.length() < 4){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL,model, 4));
        }
        this.model = model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }



}
