package org.practica1.model;

public class TheatreActivity extends Activity{
    public TheatreActivity(String name, String desc, int duration, double cost, int capacity){
        super(name, desc, duration, cost, capacity);
    }

    public double getCost(int edad){
        return super.getCost();
    }

    @Override
    public double accept(ActivityVisitor visitor, int edad) {
        return visitor.visit(this, edad);
    }
    //d
}
