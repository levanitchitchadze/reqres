package api.tests;

import api.clients.RegisterClient;
import api.models.request.Register;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;

public class RegisterTest {


    private RegisterClient registerClient;


    @BeforeClass
    public void setUp() {
        registerClient = new RegisterClient();

    }

    @Test
    public void registerNewUser() {
        Register registrationData = new Register();
        registrationData.setEmail("eve.holt@reqres.in");
        registrationData.setPassword("pistol");


        Response response = registerClient.registration(registrationData);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("token", notNullValue())
        ;
    }
}
