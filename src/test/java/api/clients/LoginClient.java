package api.clients;

import api.models.request.Login;
import api.utils.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class LoginClient {


    ObjectMapper mapper = new ObjectMapper();

    public Response login(Login loginData) {

        String jsonBody = "";
        try {
            jsonBody = mapper.writeValueAsString(loginData);

        } catch (JsonProcessingException jpe) {
            log.error("can't convert object to json: " + jpe);
        }

        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .body(jsonBody)
                .when()
                .post(Endpoints.LOGIN);
    }
}
