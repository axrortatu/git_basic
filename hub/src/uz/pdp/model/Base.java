package uz.pdp.model;

public abstract class Base {
    private static int idGeneration = 0;
    protected int id = 0;
    protected String name;
    protected boolean isInActive;

    public Base() {
        idGeneration ++;
        this.id = idGeneration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInActive() {
        return isInActive;
    }

    public void setInActive(boolean inActive) {
        isInActive = inActive;
    }
}
