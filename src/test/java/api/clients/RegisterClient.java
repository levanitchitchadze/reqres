package api.clients;

import api.models.request.Register;
import api.utils.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class RegisterClient {
    ObjectMapper mapper = new ObjectMapper();

    public Response registration(Register registrationData) {

        String jsonBody = "";
        try {
            jsonBody = mapper.writeValueAsString(registrationData);

        } catch (JsonProcessingException jpe) {
            log.error("can't convert object to json: " + jpe);
        }

        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .body(jsonBody)
                .when()
                .post(Endpoints.REGISTER);
    }
}
