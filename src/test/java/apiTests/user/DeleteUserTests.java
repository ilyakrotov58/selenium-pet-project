package apiTests.user;

import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests {

    private final static String URL = "https://petstore.swagger.io/v2/user/";

    @Test
    public void deleteUser_WithInvalidId_Returns404Code() {

        // Arrange
        var invalidUserId = 0;

        // Act
        var actualResult = given()
                .when()
                .delete(URL + invalidUserId)
                .then()
                .extract()
                .response();
        
        // Assert
        Assert.assertEquals(actualResult.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }
}
