package slabs.tech.avti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import slabs.tech.avti.persistance.model.AppUser;

public class UserTest {

    private static final String API_ROOT = "http://localhost:8080/api/app_users";

    @Test
    public void whenGetAllAppUsers_thenOK() {
        final Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    
    @Test
    public void whenGetExistAppUserById_thenFound() {
        final Response response = RestAssured.get(API_ROOT + "/1");
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
    /*
    @Test
    public void whenGetAppUsersByName_thenOK() {
        final AppUser appUser = createRandomAppUser();
        createAppUserAsUri(appUser);

        final Response response = RestAssured.get(API_ROOT + "/name/" + appUser.getUser_name());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
            .size() > 0);
    }
    */
    @Test
    public void whenGetCreatedAppUserById_thenOK() {
        final AppUser appUser = createRandomAppUser();
        final String location = createAppUserAsUri(appUser);

        final Response response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(appUser.getUser_name(), response.jsonPath()
            .get("user_name"));
    }

    @Test
    public void whenGetNotExistAppUserById_thenNotFound() {
        final Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

      // POST
    @Test
    public void whenCreateNewAppUser_thenCreated() {
        final AppUser appUser = createRandomAppUser();

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(appUser)
            .post(API_ROOT);
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenInvalidAppUser_thenError() {
        final AppUser appUser = createRandomAppUser();
        appUser.setUser_name(null);

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(appUser)
            .post(API_ROOT);
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    public void whenUpdateCreatedAppUser_thenUpdated() {
        final AppUser appUser = createRandomAppUser();
        final String location = createAppUserAsUri(appUser);

        appUser.setId(Long.parseLong(location.split("api/appUsers/")[1]));
        appUser.setUser_name("newName");
        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(appUser)
            .put(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("newName", response.jsonPath()
            .get("name"));

    }

    @Test
    public void whenDeleteCreatedAppUser_thenOk() {
        final AppUser appUser = createRandomAppUser();
        final String location = createAppUserAsUri(appUser);

        Response response = RestAssured.delete(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    // ===============================

    private AppUser createRandomAppUser() {
        final AppUser appUser = new AppUser();
        appUser.setFirst_name(randomAlphabetic(10));
        return appUser;
    }

    private String randomAlphabetic(int i) {
        return "thisISCool";
    }

    private String randomNumeric(int i) {
        return "007";
    }



    private String createAppUserAsUri(AppUser appUser) {
        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(appUser)
            .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath()
            .get("id");
    }
    
    

}