package org.practica1.controller;

import org.practica1.model.ActivityVisitor;
import org.practica1.model.CinemaActivity;
import org.practica1.model.GenericActivity;
import org.practica1.model.TheatreActivity;

public class CostVisitor implements ActivityVisitor {
    @Override
    public double visit(CinemaActivity cinemaActivity, int edad) {
        return (edad <= 21) ? (cinemaActivity.getCost() * 0.5) : cinemaActivity.getCost();
    }

    @Override
    public double visit(GenericActivity genericActivity, int edad) {
        return genericActivity.getCost();
    }

    @Override
    public double visit(TheatreActivity theatreActivity, int edad) {
        if (edad <= 25) {
            return (theatreActivity.getCost() * 0.5);
        } else if (edad >= 65) {
            return (theatreActivity.getCost() * 0.3);
        } else {
            return theatreActivity.getCost();
        }
    }
    //d
}
