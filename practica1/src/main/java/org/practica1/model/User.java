package org.practica1.model;

import java.util.ArrayList;

public class User {
    //private ActivityList ownedActivities;
    //private PlanList ownedPlans;
    private final String username;
    private final String password;
    private final int age;
    private final int tlf;
    private int id;
    private static int contador = 0;
    private boolean loggedIn;

    public User(String username, String password, int age, int tlf) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.tlf = tlf;
        this.id = ++contador;
        this.loggedIn = false;
        //this.ownedActivities = new ActivityList();
        //this.ownedPlans = new PlanList();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getTlf() {
        return tlf;
    }

    public int getId() {
        return id;
    }

    /*public ActivityList getOwnedActivities() {
        return ownedActivities;
    }*/

    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void logIn(){
        this.loggedIn = true;
    }
    public void logOut(){
        this.loggedIn = false;
    }
   /* public void addActivity(Activity activity){
        this.ownedActivities.addActivity(activity);
        activity.setOwner(this); //Asignamos dueño.
    }*/
    /*public void addPlan(Plan plan){
        this.ownedPlans.addPlan(plan);
        plan.setOwner(this); //Asignamos dueño.
    }*/
    //d
    //d
}
