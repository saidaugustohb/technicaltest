package com.appgate.reqresin.tasks;

import com.appgate.reqresin.models.UserResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultUser implements Task {
    private Integer id;
    private String endpoint;
    public ConsultUser(Integer id){
        this.id=id;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint+id));
        SerenityRest.lastResponse().prettyPrint();
        UserResponse.setUserResponse(SerenityRest.lastResponse().jsonPath().getObject("data",UserResponse.class));

    }

    public static ConsultUser by(Integer id){
        return Tasks.instrumented(ConsultUser.class,id);
    }
    public ConsultUser into(String endpoint){
        this.endpoint=endpoint;
        return this;
    }

}
