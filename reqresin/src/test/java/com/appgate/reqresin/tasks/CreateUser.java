package com.appgate.reqresin.tasks;

import com.appgate.reqresin.models.User;
import com.appgate.reqresin.models.UserResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateUser implements Task {
    private User information;
    private String endpoint;
    public CreateUser(User information){
        this.information=information;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
    actor.remember("User",information);
    actor.attemptsTo(Post.to(endpoint)
            .withRequest(request->request
                    .header("Content-Type","application/json")
                    .body(information)
            ));
        UserResponse.setUserResponse(SerenityRest.lastResponse().as(UserResponse.class));
        SerenityRest.lastResponse().prettyPrint();
    }

    public static CreateUser with(User information){
        return Tasks.instrumented(CreateUser.class,information);
    }
    public CreateUser into(String endpoint){
        this.endpoint=endpoint;
        return this;
    }
}
