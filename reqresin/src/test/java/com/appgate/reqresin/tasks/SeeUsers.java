package com.appgate.reqresin.tasks;

import com.appgate.reqresin.models.UsersResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class SeeUsers implements Task {
    private String endpoint;
    private Integer page;

    public SeeUsers(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint+page));
        UsersResponse.setUsers(SerenityRest.lastResponse().as(UsersResponse.class));

    }
    public static SeeUsers into(String endpoint){
        return Tasks.instrumented(SeeUsers.class,endpoint);
    }
    public SeeUsers on(Integer page){
        this.page=page;
        return this;
    }
}
