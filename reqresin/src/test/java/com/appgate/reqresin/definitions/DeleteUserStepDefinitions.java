package com.appgate.reqresin.definitions;

import com.appgate.reqresin.questions.TheStatus;
import com.appgate.reqresin.tasks.ConsultUser;
import com.appgate.reqresin.tasks.DeleteUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class DeleteUserStepDefinitions {

    @Cuando("el elimina un usuario con el id {int} en la direccion {string}")
    public void elEliminaUnUsuarioConElIdEnLaDireccion(Integer id, String endpoint) {
        theActorInTheSpotlight().attemptsTo(DeleteUser.with(id).into(endpoint));

    }

    @Entonces("el deberia obtener un estado {int} sin contenido")
    public void elDeberiaObtenerUnEstadoSinContenido(Integer status) {
        theActorInTheSpotlight().should(seeThat(TheStatus.ofResponse(), is(status)));
    }

    @Entonces("al consultar el usuario este no debe existir retornando un estado {int}")
    public void alConsultarElUsuarioEsteNoDebeExistir(Integer status) {
        theActorInTheSpotlight().should(seeThat(TheStatus.ofResponse(), is(status)));
    }

}
