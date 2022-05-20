package slabs.tech.avti;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import slabs.tech.avti.persistance.model.Driver;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DriverTest {

    private static final String API_ROOT = "http://localhost:8080/api/drivers";

    @Test
    public void whenGetAllDrivers_thenOK() {
        final Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    
    @Test
    public void whenGetExistDriverById_thenFound() {
        final Response response = RestAssured.get(API_ROOT + "/1");
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
    /*
    @Test
    public void whenGetDriversByName_thenOK() {
        final Driver driver = createRandomDriver();
        createDriverAsUri(driver);

        final Response response = RestAssured.get(API_ROOT + "/name/" + driver.getName());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
            .size() > 0);
    }
    
    @Test
    public void whenGetCreatedDriverById_thenOK() {
        final Driver driver = createRandomDriver();
        final String location = createDriverAsUri(driver);

        final Response response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(driver.getName(), response.jsonPath()
            .get("name"));
    }

    @Test
    public void whenGetNotExistDriverById_thenNotFound() {
        final Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    // POST
    @Test
    public void whenCreateNewDriver_thenCreated() {
        final Driver driver = createRandomDriver();

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(driver)
            .post(API_ROOT);
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenInvalidDriver_thenError() {
        final Driver driver = createRandomDriver();
        driver.setName(null);

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(driver)
            .post(API_ROOT);
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    public void whenUpdateCreatedDriver_thenUpdated() {
        final Driver driver = createRandomDriver();
        final String location = createDriverAsUri(driver);

        driver.setId(Long.parseLong(location.split("api/drivers/")[1]));
        driver.setName("newName");
        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(driver)
            .put(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("newName", response.jsonPath()
            .get("name"));

    }

    @Test
    public void whenDeleteCreatedDriver_thenOk() {
        final Driver driver = createRandomDriver();
        final String location = createDriverAsUri(driver);

        Response response = RestAssured.delete(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
*/
    // ===============================

    private Driver createRandomDriver() {
        final Driver driver = new Driver();
        driver.setName(randomAlphabetic(10));
        return driver;
    }

    private String createDriverAsUri(Driver driver) {
        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(driver)
            .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath()
            .get("id");
    }

}