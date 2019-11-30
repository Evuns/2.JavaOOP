package workshop.systemSplit.components;

public class HeavyHardware extends Hardware {


    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.HEAVY, maximumCapacity, maximumMemory);

    }

    @Override
    public int getSomeCapacity() {
        int baseCapacity = super.getSomeCapacity();
        baseCapacity *= 2;
        return baseCapacity - super.getUsedCapacity();
    }

    @Override
    public int getSomeMemory() {
        int baseMemory = super.getSomeMemory();
        baseMemory -= (baseMemory / 4);
        return baseMemory - super.getUsedMemory();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
