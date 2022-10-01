package com.appgate.reqresin.definitions;

import com.appgate.reqresin.models.User;
import com.appgate.reqresin.questions.TheStatus;
import com.appgate.reqresin.tasks.UpdateUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class UpdateUserStepDefinitions {
    @Cuando("el actualiza el usuario con el id {int} direccion {string}")
    public void elActualizaElUsuarioConElIdIdDireccion(Integer id, String endpoint, List<User> userList) {
        theActorInTheSpotlight().attemptsTo(UpdateUser.by(id).into(endpoint).with(userList.get(0)));
    }

    @Entonces("el deberia obtener un estado {int} de solicitud exitosa")
    public void elDeberiaObtenerUnEstadoDeSolicitudExitosa(Integer status) {
        theActorInTheSpotlight().should(seeThat(TheStatus.ofResponse(), is(status)));
    }

    @Entonces("el debera encontrar el usuario consultado obteniendo un estado {int}")
    public void deberaVisualizarLaInformacionDelUsuarioActualizado(Integer status) {
        theActorInTheSpotlight().should(seeThat(TheStatus.ofResponse(), is(status)));
    }
}
