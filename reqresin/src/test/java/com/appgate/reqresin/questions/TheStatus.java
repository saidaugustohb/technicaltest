package com.appgate.reqresin.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheStatus implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
    public static TheStatus ofResponse(){
        return new TheStatus();
    }
}
