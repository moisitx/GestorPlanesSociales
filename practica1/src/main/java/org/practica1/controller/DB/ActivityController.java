package org.practica1.controller.DB;

import org.practica1.model.Activity;
import org.practica1.model.User;

import java.util.ArrayList;

public class ActivityController {
    private ArrayList<Activity> activities = DB.activities;

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public boolean exists(int id) {
        for (Activity activity : activities) {
            if (activity.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public Activity selectActivity(int id){
        Activity result = null;
        for (Activity activity : activities) {
            if (activity.getId() == id) {
                result = activity;
                return result;
            }
        }
        return null;
    }
    public ActivityController sortByUser(User user){
        ActivityController result = new ActivityController();
        for (Activity activity: this.activities) {
            if(activity.getOwner().equals(user)){
                result.addActivity(activity);
            }
        }
        return result;
    }
    public int getSize(){
        return this.activities.size();
    }
    public ArrayList<Activity> getActivities() {
        return this.activities;
    }
    public int getTotalDuration(){
        int total = 0;
        for(Activity activity:activities){
            total = total + activity.getDuration();
        }
        return total;
    }
    //d
    //d
}
