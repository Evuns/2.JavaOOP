package workshop.systemSplit.components;

public class ExpressSoftware  extends Software{

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name,Type.EXPRESS, capacityConsumption, memoryConsumption);
    }

    @Override
    public int getSomeMemory() {
        return super.getSomeMemory() * 2;
    }
}
