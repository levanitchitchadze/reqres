package api.clients;

import api.models.request.UserCreate;
import api.models.request.UserUpdate;
import api.utils.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class UserClient {
    ObjectMapper mapper = new ObjectMapper();

    public Response getSingeUser(int id) {

        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .pathParam("id", id)
                .when()
                .get(Endpoints.GET_USER);

    }


    public Response getUsers(int pageNumber) {

        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .queryParam("page", pageNumber)
                .when()
                .get(Endpoints.GET_USERS);

    }

    public Response createUser(UserCreate userCreate) {
        String jsonBody = "";
        try {
            jsonBody = mapper.writeValueAsString(userCreate);

        } catch (JsonProcessingException jpe) {
            log.error("can't convert object to json: " + jpe);
        }

        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .body(jsonBody)
                .when()
                .post(Endpoints.CREATE_USER);

    }

    public Response updateUser(int userId, UserUpdate userUpdate) {
        String jsonBody = "";
        try {
            jsonBody = mapper.writeValueAsString(userUpdate);

        } catch (JsonProcessingException jpe) {
            log.error("can't convert object to json: " + jpe);
        }

        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .pathParam("id", userId)
                .body(jsonBody)
                .when()
                .put(Endpoints.UPDATE_USERS);

    }

    public Response partialUserUpdate(int userId, UserUpdate userUpdate) {
        String jsonBody = "";
        try {
            jsonBody = mapper.writeValueAsString(userUpdate);

        } catch (JsonProcessingException jpe) {
            log.error("can't convert object to json: " + jpe);
        }

        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .pathParam("id", userId)
                .body(jsonBody)
                .when()
                .patch(Endpoints.PARTIAL_USERS_UPDATE);

    }


    public Response deleteUser(int userId) {
        return given()
                .headers(Endpoints.API_DEFAULT_HEADERS)
                .baseUri(Endpoints.BASE_URL)
                .pathParam("id", userId)
                .when()
                .delete(Endpoints.DELETE_USERS);
    }
}
