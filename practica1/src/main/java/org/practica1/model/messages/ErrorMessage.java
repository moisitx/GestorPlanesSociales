package org.practica1.model.messages;

import org.practica1.model.Message;

public enum ErrorMessage implements Message {
    PASSWORD_NOT_SAFE("Error: Password must be at least 3 characters long."),
    CANT_ADD_USER_TO_PLAN("Error: Can't subscribe to the selected plan."),
    CANT_ADD_ACTIVITY_TO_PLAN("Error: Can't add activity to the selected plan."),
    CANT_REMOVE_ACTIVITY_FROM_PLAN("Error: Can't remove activity from the selected plan."),
    PHONE_ALREADY_USED("Error: Phone already on use."),
    THERE_ARE_NO_ACTIVITIES("Error: There are no activities."),
    USER_HAS_NO_OWNED_PLANS("Error: User has no owned plans."),
    THERE_ARE_NO_REGISTERED_USERS("Error: There are no registered users."),
    USER_NOT_SUBSCRIBED_IN_PLAN("Error: User not subscribed to plan."),
    USER_NOT_FOUND("Error: User not found."),
    USER_NOT_CREATED("Error: User not created."),
    USER_NOT_OWNER("Error: User not owner of the plan."),
    USER_ALREADY_EXISTS("Error: User already exists."),
    USER_ALREADY_SUBSCRIBED_IN_PLAN("Error: User already in the plan."),
    PLAN_FULL("Error: Plan is full."),
    FIELD_NULL("Error: Field is empty."),
    ACTIVITY_TYPE_NOT_VALID("Error: Activity type not valid."),
    ACTIVITY_NOT_CREATED("Error: Activity not created."),
    CANT_DELETE_PLAN("Error: Can't delete the selected plan."),
    ACTIVITY_NOT_FOUND("Error: Activity not found."),
    USER_NOT_LOGGED_IN("Error: User not logged in."),
    LOGOUT_FAILED("Error: Logout failed."),
    WRONG_PASSWORD("Error: Wrong password."),
    WRONG_NUMBER_OF_ARGUMENTS("Error: Wrong number of arguments."),
    THERE_ARE_NO_PLANS("Error: There are no plans."),
    ACTIVITY_ALREADY_IN_PLAN("Error: Activity already in plan."),

    USER_ALREADY_LOGGED_IN("Error: User already logged in."),
    CANT_LEAVE_PLAN("Error: Can't leave the selected plan."),
    THERE_ARE_NO_SUBSCRIBED_USERS("Error: There are no subscribed users."),
    PLAN_NOT_FOUND("Error: Plan not found."),
    ACTIVITY_NOT_IN_PLAN("Error: Activity not found on the selected plan."),
    USER_ALREADY_SUBSCRIBED_IN_PLAN_AT_SAME_TIME("Error: User already subscribed to a plan at the same time.");

    private final String content;
    ErrorMessage(String content) {
        this.content = content;
    }
    @Override
    public String getContent() {
        return this.content;
    }
    //dd
    //d
}
