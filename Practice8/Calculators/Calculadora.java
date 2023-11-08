package Calculators;

public abstract class Calculadora{
    private long mem;

    public long getMem(){return this.mem;}
    public void setMem(long mem){this.mem = mem;}

    public abstract void randomOperation();
}
