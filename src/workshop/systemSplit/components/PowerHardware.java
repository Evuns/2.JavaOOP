package workshop.systemSplit.components;


public class PowerHardware extends Hardware {

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.POWER, maximumCapacity, maximumMemory);

    }

    @Override
    public int getSomeCapacity() {
        int baseCapacity = super.getSomeCapacity();
        baseCapacity -= ((baseCapacity * 3) / 4);
        return baseCapacity - super.getUsedCapacity();
    }

    @Override
    public int getSomeMemory() {
        int baseMemory = super.getSomeMemory();
        baseMemory += ((baseMemory * 3) / 4);
        return baseMemory - super.getUsedMemory();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
