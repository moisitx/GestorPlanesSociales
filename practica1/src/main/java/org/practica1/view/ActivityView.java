package org.practica1.view;

import org.practica1.model.Activity;

import java.util.ArrayList;

public class ActivityView {

    public void display(Activity activity){
        System.out.println("Activity: ID: "+ activity.getId() +"; Nombre: "+ activity.getName() + "; Descripcion: " + activity.getDesc() + "; Duracion: " + activity.getDuration() + "; Coste: " + activity.getCost() + "; Capacidad: " + activity.getCapacity());
    }
    //d

    public void listActivities(ArrayList<Activity> activities){
        for (Activity activity: activities) {
            display(activity);
        }
    }
    //d
}
