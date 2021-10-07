package com.crystal.blogpagebe;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

@SpringBootTest
class BlogPageBeApplicationTests {

    @Test
    public void testGetAllArticlesAPI() {
        given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .when()
                .get("/articles")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testGetAllArticlesAPIWhenTheURIisWrong() {
        given().baseUri("https://blogpagedeployyyyyyyyyyyyyy.herokuapp.com")
                .contentType(ContentType.JSON)
                .when()
                .get("/articles")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testGetOneArticleAPI() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .when()
                .get("/articles/15")
                .thenReturn();

        Assert.assertEquals(articleResponse.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(articleResponse.getBody().jsonPath().getInt("id"), 15);
    }

    @Test
    public void testGetOneArticleAPIWhenArticleDoesNotExist() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .when()
                .get("/articles/1")
                .thenReturn();

        Assert.assertEquals(articleResponse.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testDeleteOneArticleAPI() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .when()
                .delete("/articles/4963")
                .thenReturn();

        Assert.assertEquals(200, articleResponse.getStatusCode());
    }

    @Test
    public void testDeleteOneArticleAPIWhenArticleDoesNotExist() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .when()
                .delete("/articles/1")
                .thenReturn();

        Assert.assertEquals(400, articleResponse.getStatusCode());
    }

    @Test
    public void testCreateOneArticleAPI() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"Sarmale - stuffed cabbage rolls. Good or bad?\",\n" +
                        "\"tag\": \"Food\",\n" +
                        "\"author\": \"Jonnathan Mercadina\",\n" +
                        "\"date\": \"December 29, 2017\",\n" +
                        "\"imageURL\": \"img/sarmale.jpg\",\n" +
                        "\"content\": \"Lorem ipsum dolor sit amet consectetur...!\",\n" +
                        "\"saying\": \"Love at first bite.\",\n" +
                        "\"dateTimestamp\": \"2021-09-17T08:26:35.000+00:00\"\n" +
                        "}")
                .when()
                .post("/articles")
                .thenReturn();

        Assert.assertEquals(201, articleResponse.getStatusCode());
    }


    @Test
    public void testCreateOneArticleAPIWhenIDisAssignedToThatArticle() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"id\": \"1\",\n" +
                        "\"title\": \"The complete guide to explore Trasilvania, with your bike\",\n" +
                        "\"tag\": \"Destination Europe\",\n" +
                        "\"author\": \"Jolika Sulejmani\",\n" +
                        "\"date\": \"July 01, 2021\",\n" +
                        "\"imageUrl\": \"img/bike.jpg\",\n" +
                        "\"saying\": \"Life is like riding a bicycle, to keep your balance you must keep moving\",\n" +
                        "\"content\": \"Lorem ipsum dolor sit amet consectetur, adipisicing elit. \",\n" +
                        "\"dateTimestamp\":\"2021-09-17T08:26:35.307+00:00\"\n" +
                        "}")
                .when()
                .post("/articles")
                .thenReturn();

        Assert.assertEquals(400, articleResponse.getStatusCode());
    }

    @Test
    public void testUpdateOneArticleAPI() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"UPDATED - The complete guide to explore Trasilvania, with your bike\",\n" +
                        "\"tag\": \"UPDATED - Destination Europe\",\n" +
                        "\"author\": \"UPDATED - Jolika Sulejmani\",\n" +
                        "\"date\": \"UPDATED - July 01, 2021\",\n" +
                        "\"imageUrl\": \"img/bike.jpg\",\n" +
                        "\"saying\": \"UPDATED - Life is like riding a bicycle, to keep your balance you must keep moving\",\n" +
                        "\"content\": \"UPDATED - Lorem ipsum dolor sit amet consectetur, adipisicing elit. Est totam laboriosam debitis magnam voluptatum, incidunt neque. Totam ullam non quis, repellendus molestiae in itaque natus labore quos ipsum alias, veritatis nihil! Quisquam labore, sequi minima expedita necessitatibus omnis error amet recusandae atque commodi quia! Vel laborum recusandae voluptatum rerum id harum, fuga beatae ut, consequuntur repellendus ipsum temporibus libero itaque. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde quod tempore quaerat deserunt. Voluptatibus possimus, magni quas rem adipisci, esse ipsa fuga, fugit eos repellendus quis? Dicta perferendis, doloremque provident repellendus natus fugit obcaecati, voluptate odio, nulla similique officia. Iure at aliquam dicta provident nulla modi optio maiores. Similique eos molestiae earum voluptatum nostrum porro, consequuntur nihil ex earum. Voluptatum placeat labore necessitatibus repellat. Repudiandae velit suscipit amet tenetur, mollitia aut dolor ipsa delectus a autem ut quibusdam incidunt? Nisi facilis voluptatem omnis debitis laborum cupiditate pariatur inventore molestiae eveniet!\",\n" +
                        "\"dateTimestamp\":\"2021-10-07T08:26:35.307+00:00\"\n" +
                        "}")
                .when()
                .put("/articles/15")
                .thenReturn();

        Assert.assertEquals(200, articleResponse.getStatusCode());
    }

    @Test
    public void testUpdateOneArticleAPIWhenArticleDoesNotExist() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"UPDATED - The complete guide to explore Trasilvania, with your bike\",\n" +
                        "\"tag\": \"UPDATED - Destination Europe\",\n" +
                        "\"author\": \"UPDATED - Jolika Sulejmani\",\n" +
                        "\"date\": \"UPDATED - July 01, 2021\",\n" +
                        "\"imageUrl\": \"UPDATED - img/bike.jpg\",\n" +
                        "\"saying\": \"UPDATED - Life is like riding a bicycle, to keep your balance you must keep moving\",\n" +
                        "\"content\": \"UPDATED - Lorem ipsum dolor sit amet consectetur, adipisicing elit. Est totam laboriosam debitis magnam voluptatum, incidunt neque. Totam ullam non quis, repellendus molestiae in itaque natus labore quos ipsum alias, veritatis nihil! Quisquam labore, sequi minima expedita necessitatibus omnis error amet recusandae atque commodi quia! Vel laborum recusandae voluptatum rerum id harum, fuga beatae ut, consequuntur repellendus ipsum temporibus libero itaque. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde quod tempore quaerat deserunt. Voluptatibus possimus, magni quas rem adipisci, esse ipsa fuga, fugit eos repellendus quis? Dicta perferendis, doloremque provident repellendus natus fugit obcaecati, voluptate odio, nulla similique officia. Iure at aliquam dicta provident nulla modi optio maiores. Similique eos molestiae earum voluptatum nostrum porro, consequuntur nihil ex earum. Voluptatum placeat labore necessitatibus repellat. Repudiandae velit suscipit amet tenetur, mollitia aut dolor ipsa delectus a autem ut quibusdam incidunt? Nisi facilis voluptatem omnis debitis laborum cupiditate pariatur inventore molestiae eveniet!\",\n" +
                        "\"dateTimestamp\":\"2021-10-07T08:26:35.307+00:00\"\n" +
                        "}")
                .when()
                .put("/articles/1")
                .thenReturn();

        Assert.assertEquals(400, articleResponse.getStatusCode());
    }

    @Test
    public void testNumberOfArticlesAPI() {
        Response articleResponse = given().baseUri("https://blogpagedeploy.herokuapp.com")
                .contentType(ContentType.JSON)
                .when()
                .put("/articles/numbers")
                .thenReturn();

        Assert.assertEquals(200, articleResponse.getStatusCode());
        Assert.assertEquals(6, articleResponse.getBody());
    }

}
