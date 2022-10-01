package com.appgate.reqresin.definitions;

import com.appgate.reqresin.models.UserResponse;
import com.appgate.reqresin.tasks.ConsultUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultUserStepDefinitions {
    @Cuando("el consulta el usuario con id {int} en la direccion {string}")
    public void elConsultaElUsuarioConIdEnLaDireccion(Integer id, String endpoint) {
        theActorInTheSpotlight().attemptsTo(ConsultUser.by(id).into(endpoint));
    }
    @Entonces("debera visualizar la informacion del usuario consultado")
    public void deberaVisualizarLaInformacionDelUsuarioConsultado() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(UserResponse.getUserResponse().getId())
                .asAnInteger().isNotNull());
        theActorInTheSpotlight().attemptsTo(Ensure.that(UserResponse.getUserResponse().getEmail())
                .isNotNull());
        theActorInTheSpotlight().attemptsTo(Ensure.that(UserResponse.getUserResponse().getAvatar())
                .isNotNull());
    }
}
