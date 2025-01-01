package org.practica1.model;

public interface ActivityVisitor {
    double visit(CinemaActivity cinemaActivity, int edad);
    double visit(GenericActivity genericActivity, int edad);
    double visit(TheatreActivity theatreActivity, int edad);
    //d
}


