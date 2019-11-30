package workshop.systemSplit.components;

public class LightSoftware extends Software {
    public static final int LIGHT_CONSTANT = 2;

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name,Type.LIGHT, capacityConsumption, memoryConsumption);

    }

    @Override
    public int getSomeCapacity() {
        return super.getSomeCapacity() * 3 / 2;
    }

    @Override
    public int getSomeMemory() {
        return super.getSomeMemory() / LIGHT_CONSTANT;
    }
}
