package org.practica1.model.messages;

import org.practica1.model.Message;

public enum SuccessMessage implements Message {
    USER_CREATED("Message: User registered."),
    LOGGED_IN("Message: logged in."),
    LOGGED_OUT("Message: logged out."),
    ACTIVITY_ADDED_TO_PLAN("Message: Activity added."),
    ACTIVITY_REMOVED_FROM_PLAN("Message: Activity deleted."),
    ACTIVITY_CREATED("Message: Activity created."),
    USER_SUBSCRIBED_IN_PLAN("Message: User subscribed in plan."),
    USER_LEFT_PLAN("Message: User left plan."),
    PLAN_DELETED("Message: Plan deleted."),
    PLAN_ADDED("Message: plan added"),
    EXIT("Message: System shutdown.");


    private final String content;

    SuccessMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }
    //d
}
