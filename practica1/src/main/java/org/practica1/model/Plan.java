package org.practica1.model;

import org.practica1.controller.CostVisitor;
import org.practica1.controller.DB.ActivityController;
import org.practica1.controller.DB.UserController;

import java.util.ArrayList;
import java.util.Date;

public class Plan {
    private User owner;
    private ArrayList<Activity> activities;
    private ArrayList<User> users;
    private final String name;
    private final Date dateAndTime;
    private int capacity;
    private final int id;
    private static int contador = 0;
    private String place;
    private double cost;
    public Plan(Date dateAndTime, String name, int capacity, String place){
        this.activities = new ArrayList<>();
        this.users = new ArrayList<>();
        this.owner = null;
        this.dateAndTime = dateAndTime;
        this.name = name;
        this.capacity = capacity;
        this.id = ++contador;
        this.place = place;
        this.cost = 0;
    }

    public ArrayList<Activity> getActivities() {
        return this.activities;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public String getName() {
        return name;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public int getContador() {
        return contador;
    }
    public void enrollActivity(Activity activity){
        this.activities.add(activity);
    }
    public void enrollUser(User user){
        this.users.add(user);
    }
    public User getOwner(){
        return this.owner;
    }
    public void setOwner(User user){
        this.owner = user;
    }
    public double getCost(){
        return this.cost;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public String getPlace(){
        return this.place;
    }
    public void setPlace(String place){
        this.place = place;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (Activity activity : this.getActivities()) {
            totalDuration += activity.getDuration();
        }
        return totalDuration;
    }
    public double getTotalCost(User user) {
        ActivityVisitor visitor = new CostVisitor();
        double totalCost = 0;
        for (Activity activity : this.getActivities()) {
            totalCost = totalCost + activity.accept(visitor, user.getAge());
        }
        return totalCost;
    }

    //d
    //d
}
