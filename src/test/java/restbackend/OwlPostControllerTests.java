package restbackend;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import restbackend.domain.StudentInfo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.with;

public class OwlPostControllerTests {

    static {
        RestAssured.baseURI = "http://localhost:8080";
    }

    private RequestSpecification spec =
            with()
                    .baseUri("http://localhost:8080")
                    .basePath("/");

    @Test
    void bankControllerTest() {
        StudentInfo[] userInfos = spec.get("user/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(StudentInfo[].class);

        Stream.of(userInfos)
                .filter(userInfo -> userInfo.getStudentName().equals("Olga"))
                .peek(userInfo -> System.out.println(userInfo.getStudentName()))
                .map(userInfo -> userInfo.toString())
                .collect(Collectors.toList());
    }
}
