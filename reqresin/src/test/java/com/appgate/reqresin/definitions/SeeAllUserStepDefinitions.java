package com.appgate.reqresin.definitions;

import com.appgate.reqresin.models.UserResponse;
import com.appgate.reqresin.models.UsersResponse;
import com.appgate.reqresin.questions.TheStatus;
import com.appgate.reqresin.tasks.SeeUsers;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class SeeAllUserStepDefinitions {
    @Cuando("el consulta los usuarios en la pagina {int} en la direccion {string}")
    public void elConsultaLosUsuariosEnLaPaginaEnLaDireccion(Integer page, String endpoint) {
    theActorInTheSpotlight().attemptsTo(SeeUsers.into(endpoint).on(page));
    }

    @Entonces("el deberia obtener un estado {int} de peticion exitosa")
    public void elDeberiaObtenerUnEstadoDePeticionExitosa(Integer status) {
        theActorInTheSpotlight().should(seeThat(TheStatus.ofResponse(), is(status)));
    }

    @Entonces("debera visualizar la informacion de los usuarios")
    public void deberaVisualizarLaInformacionDeLosUsuarios() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(UsersResponse.getUsers().getData().size())
                .asAnInteger().isGreaterThan(0));
    }

    @Entonces("no se debe visualizar ningun usuario")
    public void noSeDebeVisualizarNingunUsuario() {
        theActorInTheSpotlight().attemptsTo(Ensure.that(UsersResponse.getUsers().getData().size())
                .asAnInteger().isEqualTo(0));
    }
}
