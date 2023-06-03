package apiTests.pet;

import api.Category;
import api.Dog;
import api.Tag;
import base.DataGenerator;
import base.Specification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static io.restassured.RestAssured.given;

public class AddPetTests {

    private final static String URL = "https://petstore.swagger.io/v2/pet";

    @Test
    public void addPet_WithCorrectParams_ReturnsCorrectResponse() {

        // Arrange
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(HttpStatus.SC_OK));

        var expectedResult = new Dog(
                1,
                DataGenerator.generateString(5),
                new ArrayList<>(Collections.singletonList(DataGenerator.generateString(5))),
                new ArrayList<>(Collections.singletonList(new Tag(1, DataGenerator.generateString(5)))),
                new Category(1, DataGenerator.generateString(5)),
                "Available");

        // Act
        var actualResult = given()
                .body(expectedResult)
                .when()
                .post(URL)
                .then()
                .extract().as(Dog.class);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
}
