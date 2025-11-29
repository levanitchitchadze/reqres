package api.tests;

import api.clients.UserClient;
import api.models.request.UserCreate;
import api.models.request.UserUpdate;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class UsersTest {

    private UserClient userClient;
    private Faker faker;


    @BeforeClass
    public void setUp() {
        userClient = new UserClient();
        faker = new Faker();
    }

    @Test
    public void getSingleUser() {
        int userId = 1;
        Response response = userClient.getSingeUser(userId);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("data.id", equalTo(userId))
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
        ;
    }


    @Test
    public void getNonExistingUser() {
        int userId = 99;
        Response response = userClient.getSingeUser(userId);

        response.prettyPrint();

        response.then()
                .statusCode(404)
                .body(equalTo("{}"))
        ;


    }


    @Test
    public void getUsers() {
        int page = 1;
        Response response = userClient.getUsers(page);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("page", equalTo(page))
                .body("data[0].id", notNullValue())
                .body("data[0].email", notNullValue())
                .body("data[0].first_name", notNullValue())
                .body("data[0].last_name", notNullValue())
        ;
    }

    @Test
    public void createUser() {
        UserCreate userCreate = new UserCreate();
        userCreate.setName(faker.name().firstName());
        userCreate.setJob(faker.job().position());

        Response response = userClient.createUser(userCreate);

        response.prettyPrint();

        response.then()
                .statusCode(201)
                .body("name", equalTo(userCreate.getName()))
                .body("job", equalTo(userCreate.getJob()))
                .body("id", notNullValue())
                .body("createdAt", notNullValue())
        ;

    }

    @Test
    public void updateUser() {
        int userId = 0;
        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setName(faker.name().firstName());
        userUpdate.setJob(faker.job().position());

        Response response = userClient.updateUser(userId, userUpdate);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("name", equalTo(userUpdate.getName()))
                .body("job", equalTo(userUpdate.getJob()))
                .body("updatedAt", notNullValue())
        ;

    }

    @Test
    public void partiallyUpdateUser() {
        int userId = 0;
        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setName(faker.name().firstName());
        userUpdate.setJob(faker.job().position());

        Response response = userClient.partialUserUpdate(userId, userUpdate);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("name", equalTo(userUpdate.getName()))
                .body("job", equalTo(userUpdate.getJob()))
                .body("updatedAt", notNullValue())
        ;
    }

    @Test
    public void deleteUser() {
        int userId = 1;

        Response response = userClient.deleteUser(userId);

        response.prettyPrint();

        response.then()
                .statusCode(204)
                .body(blankString())
        ;


    }

}
