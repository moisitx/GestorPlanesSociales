package org.practica1.controller.DB;

import org.practica1.model.Plan;
import org.practica1.model.User;

import java.util.ArrayList;

public class PlanController {
    private ArrayList<Plan> plans = DB.plans;

    public void addPlan(Plan plan) {
        plans.add(plan);
    }

    public void removePlan(Plan plan) {
        plans.remove(plan);
    }
    public boolean exists(int id) {
        for (Plan plan : plans) {
            if (plan.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Plan selectPlan(int id) {
        for (Plan plan : plans) {
            if (plan.getId() == id) {
                return plan;
            }
        }
        return null;
    }
    public PlanController sortByUser(User user){
        PlanController result = new PlanController();
        for (Plan plan: this.plans) {
            if(plan.getOwner().equals(user)){
                result.addPlan(plan);
            }
        }
        return result;
    }
    public int getSize(){
        return this.plans.size();
    }
    public ArrayList<Plan> getPlans() {
        return this.plans;
    }
    //d
}
