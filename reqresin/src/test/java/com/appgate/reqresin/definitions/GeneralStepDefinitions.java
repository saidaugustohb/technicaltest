package com.appgate.reqresin.definitions;

import com.appgate.reqresin.models.User;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Dado;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static com.appgate.reqresin.models.enums.ConnectionInformation.API_URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class GeneralStepDefinitions {
    @Before
    public void before(){
        SerenityRest.setDefaultParser(Parser.JSON);
        OnStage.setTheStage(OnlineCast.ofStandardActors());
    }
    @Dado("que el {string} realiza la conexion con el API de reqresin")
    public void queElRealizaLaConexionConElAPIDeReqresin(String actorName) {
        theActorCalled(actorName).whoCan(CallAnApi.at(API_URL.toString()));

    }
    @DataTableType
    public User userRequestProcessor(Map<String, String> data) {
        User user=new User();
        user.setName(data.get("name"));
        user.setJob(data.get("job"));
        return user;
    }
}
