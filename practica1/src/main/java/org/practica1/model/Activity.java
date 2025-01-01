package org.practica1.model;

public abstract class Activity {
    private User owner;
    private final String name;
    private final String desc;
    private final int duration;
    private double cost;
    private final int capacity;
    private int id;
    private static int contador = 0;
    public Activity(String name, String desc, int duration, double cost, int capacity) {
        this.name = name;
        this.desc = desc;
        this.duration = duration;
        this.cost = cost;
        this.capacity = capacity;
        this.id = ++contador;
        this.owner = null; //Primero creamos la actividad con los parámetros, posteriormente le asignamos un dueño.
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getDuration() {
        return this.duration;
    }

    public double getCost() {
        return this.cost;
    }
    public void setCost(double cost){
        this.cost = cost;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getId() {
        return this.id;
    }

    public int getContador() {
        return this.contador;
    }
    public User getOwner(){
        return this.owner;
    }
    public void setOwner(User user){
        this.owner = user;
    }

    public void display(){
        System.out.println("ID: "+this.id+"; Nombre: "+this.name+"; Descripción: "+this.desc+"; Duración: "
                                +this.duration +" min; Coste: "+this.cost+"€; Aforo: "+this.capacity);
    }

    public abstract double accept(ActivityVisitor visitor, int edad);
    //d
}
