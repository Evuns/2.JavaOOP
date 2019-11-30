package workshop.systemSplit.components;

public abstract class ComponentType {
    private String name;
    private Enum type;
    private int someCapacity;
    private int someMemory;

    public ComponentType(String name, Enum type, int someCapacity, int someMemory) {
        this.name = name;
        this.type = type;
        this.someCapacity = someCapacity;
        this.someMemory = someMemory;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type.name();
    }

    public int getSomeCapacity(){
        return this.someCapacity;
    }

    public int getSomeMemory(){
        return this.someMemory;
    }

    protected void setSomeCapacity(int someCapacity) {
        this.someCapacity = someCapacity;
    }

    protected void setSomeMemory(int someMemory) {
        this.someMemory = someMemory;
    }
}

