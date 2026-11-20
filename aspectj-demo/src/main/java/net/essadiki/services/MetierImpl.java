package net.essadiki.services;
public class MetierImpl implements IMetier {

    @Override
    public void process() {
        System.out.println("Execution de la methode process()");
    }

    @Override
    public double compute(double a, double b) {
        System.out.println("Execution de la methode compute()");
        return a + b;
    }
}
