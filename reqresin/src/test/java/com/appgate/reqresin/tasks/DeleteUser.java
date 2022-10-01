package com.appgate.reqresin.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteUser implements Task {
    private Integer id;
    private String endpoint;
    public DeleteUser(Integer id){
        this.id=id;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(endpoint+id));
    }
    public static DeleteUser with(int id){
        return Tasks.instrumented(DeleteUser.class,id);
    }
    public DeleteUser into(String endpoint){
        this.endpoint=endpoint;
        return this;
    }
}
