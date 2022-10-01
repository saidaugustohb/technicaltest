package com.appgate.reqresin.tasks;

import com.appgate.reqresin.models.User;
import com.appgate.reqresin.models.UserResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdateUser implements Task {
    private User body;
    private Integer id;
    private String endpoint;


    public UpdateUser(Integer id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(endpoint+id).with(request -> request
                .header("Content-Type","application/json")
                .body(body)));
        UserResponse.setUserResponse(SerenityRest.lastResponse().as(UserResponse.class));
        SerenityRest.lastResponse().prettyPrint();
    }
    public static UpdateUser by(Integer id){
        return Tasks.instrumented(UpdateUser.class,id);
    }

    public UpdateUser with(User body){
        this.body=body;
        return this;
    }
    public UpdateUser into(String endpoint){
        this.endpoint=endpoint;
        return this;
    }
}
