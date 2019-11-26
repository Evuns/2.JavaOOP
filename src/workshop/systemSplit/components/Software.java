package workshop.systemSplit.components;

public abstract class Software extends ComponentType {

    public Software(String name, Enum type, int someCapacity, int someMemory) {
        super(name, type, someCapacity, someMemory);
    }

    protected enum Type{
        EXPRESS,
        LIGHT
    }
}
