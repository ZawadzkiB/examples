package com.bzawadzki;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class JsonTests {

  @BeforeEach
  void setup() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
  }

  @Test
  void findMaxUserIdTests() {
    Comparator<Post> userIdComparator = Comparator.comparing(Post::getUserId);
    Post post = Arrays.stream(
            given().log().all()
                    .when()
                    .get("/posts")
                    .then().log().all()
                    .statusCode(200)
                    .extract()
                    .as(Post[].class)).max(userIdComparator).orElse(new Post());
    assertEquals(post.getUserId(),10);
  }

  @Test
  void findMaxPostIdTests() {
    Comparator<Post> userIdComparator = Comparator.comparing(Post::getId);
    Post post = Arrays.stream(
            given().log().all()
                    .queryParam("userId", 10)
                    .when()
                    .get("/posts")
                    .then().log().all()
                    .statusCode(200)
                    .extract()
                    .as(Post[].class)).max(userIdComparator).orElse(new Post());
    assertEquals(post.getId(),100);
  }

  @Test
  void addCommentForPost(){
    Comment commentToPost = new Comment().setPostId(100).setName("test name").setEmail("test@test.org").setBody("test body");
    Comment comment = given().log().all()
            .contentType(ContentType.JSON)
            .when()
            .body(commentToPost)
            .post("/comments")
            .then().log().all()
            .statusCode(201)
            .extract()
            .as(Comment.class);
    assertNotNull(comment.getId());
    assertEquals(comment.getBody(), commentToPost.getBody());
    assertEquals(comment.getEmail(), commentToPost.getEmail());
    assertEquals(comment.getPostId(), commentToPost.getPostId());
    assertEquals(comment.getName(), commentToPost.getName());
  }

}
