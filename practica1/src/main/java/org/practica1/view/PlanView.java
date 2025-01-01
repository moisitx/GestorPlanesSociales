package org.practica1.view;

import org.practica1.model.Plan;

import java.util.ArrayList;

public class PlanView {
    public void display(Plan plan){

        System.out.println("ID: "+plan.getId()+"; Propietario: "+plan.getOwner().getUsername()+"; Nombre: "+plan.getName()+"; Fecha: "
                +plan.getDateAndTime() +"; Lugar: "+plan.getPlace()+"; Aforo: "+plan.getCapacity()+"; Participantes: "
                +plan.getUsers().size()+"; Duración: "+plan.getTotalDuration()+" min; Coste: "+plan.getCost()+"€");

    }
    public void listPlans(ArrayList<Plan> plans){
        for (Plan plan: plans) {
            display(plan);
        }
    }
    //d
    //d
}
