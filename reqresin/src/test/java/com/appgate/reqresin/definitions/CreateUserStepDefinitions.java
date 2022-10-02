package com.appgate.reqresin.definitions;

import com.appgate.reqresin.models.User;
import com.appgate.reqresin.models.UserResponse;
import com.appgate.reqresin.models.enums.ConnectionInformation;
import com.appgate.reqresin.questions.TheStatus;
import com.appgate.reqresin.tasks.ConsultUser;
import com.appgate.reqresin.tasks.CreateUser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.core.Is;

import java.util.List;

import static com.appgate.reqresin.models.enums.ConnectionInformation.API_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class CreateUserStepDefinitions {


    @Cuando("el realiza la creacion del usuario en la direccion {string}")
    public void elRealizaUnaPeticionALaDireccion(String endpoint, List<User> listUser) {
    theActorInTheSpotlight().attemptsTo(CreateUser.with(listUser.get(0)).into(endpoint));
    }

    @Entonces("el deberia obtener un estado {int} de creacion")
    public void elDeberiaObtenerUnEstadoDeCreacion(Integer status) {
        theActorInTheSpotlight().should(seeThat(TheStatus.ofResponse(), is(status)));
    }

    @Cuando("se consulta el id del usuario creado en la direccion {string}")
    public void seConsultaElIdDelUsuarioCreado(String endpoint) {
        theActorInTheSpotlight().attemptsTo(ConsultUser.by(UserResponse.getUserResponse().getId()).into(endpoint));
    }

    @Entonces("debera visualizar la informacion del usuario creado")
    public void deberaVisualizarLaInformacionDelUsuarioCreado() {
        User userRequest=theActorInTheSpotlight().recall("User");
        theActorInTheSpotlight().attemptsTo(Ensure.that(UserResponse.getUserResponse().getName())
                .isEqualTo(userRequest.getName()));
        theActorInTheSpotlight().attemptsTo(Ensure.that(UserResponse.getUserResponse().getJob())
                .isEqualTo(userRequest.getJob()));
        theActorInTheSpotlight().attemptsTo(Ensure.that(UserResponse.getUserResponse().getId())
                .asAnInteger().isNotNull());

    }
}
