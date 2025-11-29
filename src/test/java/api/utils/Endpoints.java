package api.utils;

import java.util.Map;

public class Endpoints {
    public static final String BASE_URL = "https://reqres.in/api";
    public static final Map<String, ?> API_DEFAULT_HEADERS = Map.ofEntries(
            Map.entry("Content-Type", "application/json"),
            Map.entry("x-api-key", "reqres-free-v1")
    );

    //    users
    public static final String GET_USERS = "/users";
    public static final String GET_USER = "/users/{id}";
    public static final String CREATE_USER = "/users";
    public static final String UPDATE_USERS = "/users/{id}";
    public static final String PARTIAL_USERS_UPDATE = "/users/{id}";
    public static final String DELETE_USERS = "/users/{id}";

    //    register
    public static final String REGISTER = "/register";

    //    login
    public static final String LOGIN = "/login";


}
