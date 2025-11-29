package api.tests;

import api.clients.LoginClient;
import api.models.request.Login;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;

public class LoginTest {
    private LoginClient loginClient;

    @BeforeClass
    public void setUp() {
        loginClient = new LoginClient();
    }

    @Test
    public void loginSuccessfully() {
        Login loginData = new Login();
        loginData.setEmail("eve.holt@reqres.in");
        loginData.setPassword("cityslicka");


        Response response = loginClient.login(loginData);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("token", notNullValue())
        ;
    }
}
