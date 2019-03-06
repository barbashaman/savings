package api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class SavingsInvestmentsAPITests {

    @Tag("API")
    @Test
    public void savingsInvestmentsGetMockTest() {
        when()
                .get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador")
                .then()
                .statusCode(200)
                .body(
                        "id", equalTo(1),
                        "meses", hasItems("112", "124", "136", "148"),
                        "valor", hasItems("2.802", "3.174", "3.564", "3.971"));
    }
}