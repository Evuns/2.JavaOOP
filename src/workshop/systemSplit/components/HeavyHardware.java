package workshop.systemSplit.components;

public class HeavyHardware extends Hardware {

    protected HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name,Type.HEAVY, maximumCapacity, maximumMemory);
    }

    @Override
    public int getSomeCapacity() {
        return super.getSomeCapacity() * 2;
    }

    @Override
    public int getSomeMemory() {
        return (int)(super.getSomeMemory() * 0.75);
    }
}
