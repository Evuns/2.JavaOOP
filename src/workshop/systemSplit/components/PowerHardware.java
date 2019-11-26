package workshop.systemSplit.components;


public class PowerHardware extends Hardware {
    public static final double REDUCE_CONSTANT = 0.75;

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name,Type.POWER, maximumCapacity, maximumMemory);
    }

    @Override
    public int getSomeCapacity() {
        return (int) (super.getSomeCapacity() - REDUCE_CONSTANT * super.getSomeCapacity());
    }

    @Override
    public int getSomeMemory() {
        return (int) (super.getSomeMemory() + REDUCE_CONSTANT * super.getSomeMemory());

    }
}
