package org.example.implementations;

import org.example.base.Base;
import org.example.models.GetUserByIdModel;
import org.example.models.GetUserListModel;
import org.example.models.PatchSwitchUserActivityModel;
import org.example.models.PostCreateUserModel;
import org.example.models.PutUpdateUserModel;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.gauge.Step;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepImp extends Base {

    private final String url = "https://7d851fb7-aac2-4995-a48d-0f129b9d6098.mock.pstmn.io/";
    private Response response;
    private RequestSpecification requestSpecification;
    private JSONObject jsonObject;

    private void createBody() {
        requestSpecification.body(jsonObject.toJSONString());
    }

    @Step("Create Body")
    public void createaBody() {
        jsonObject = new JSONObject();
    }

    @Step("Add to body <key> : <value>")
    public void addToBody(String key, String value) {
        jsonObject.put(key, value);
    }

    @Step("Send <method> request to <path>")
    public void sendRequest(String method, String path) {
        RestAssured.baseURI = url + path;
        requestSpecification = given();
        requestSpecification.header(getContentType(), getContentValue());
        requestSpecification.header(getAccept(), getAcceptValue());
        switch (method) {
            case "GET":
                response = requestSpecification.get();
                break;
            case "PUT":
                createBody();
                response = requestSpecification.put();
                break;
            case "POST":
                createBody();
                response = requestSpecification.post();
                break;
            case "PATCH":
                response = requestSpecification.patch();
                break;
            case "DELETE":
                response = requestSpecification.delete();
                break;
            default:
                Assertions.fail("Given method is not acceptable");
        }
    }

    @Step("Check is response status <code>")
    public void checkStatusCode(String code) {
        int statusCode = response.getStatusCode();
        Assertions.assertTrue(statusCode == Integer.valueOf(code),
                "Status code is not " + code + ". Actual status code is " + statusCode);
    }

    @Step("Print out body")
    public void printOutBody() {
        System.out.println(response.getBody().asPrettyString());
    }


    @Step("Clear json")
    public void clearJsonData() {
        jsonObject.clear();
    }

    @Step("Assert response matches user model")
    public void assertResponseMatchesUserModel() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GetUserListModel[] users = objectMapper.readValue(response.getBody().asString(), GetUserListModel[].class);

            Assertions.assertTrue(users.length > 0, "User list should not be empty");

            for (GetUserListModel user : users) {
                Assertions.assertNotNull(user.getid(), "User ID should not be null");
                Assertions.assertNotNull(user.getUsername(), "Username should not be null");
                Assertions.assertNotNull(user.getFirstName(), "First name should not be null");
                Assertions.assertNotNull(user.getLastName(), "Last name should not be null");
                Assertions.assertNotNull(user.getActive(), "isActive should not be null");
            }
        } catch (Exception e) {
            Assertions.fail("Failed to parse response body to GetUserListModel array: " + e.getMessage());
        }
    }

    @Step("Assert response matches post create user model")
    public void assertResponseMatchesPostCreateUserModel() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PostCreateUserModel response = objectMapper.readValue(this.response.getBody().asString(), PostCreateUserModel.class);

            Assertions.assertNotNull(response.getuserId(), "User ID should not be null");
        } catch (Exception e) {
            Assertions.fail("Failed to parse response body to PostCreateUserModel: " + e.getMessage());
        }
    }

    @Step("Assert response matches get user by id model")
    public void assertResponseMatchesGetUserByIdModel() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GetUserByIdModel user = objectMapper.readValue(response.getBody().asString(), GetUserByIdModel.class);

            Assertions.assertNotNull(user.getid(), "User ID should not be null");
            Assertions.assertNotNull(user.getUsername(), "Username should not be null");
            Assertions.assertNotNull(user.getFirstName(), "First name should not be null");
            Assertions.assertNotNull(user.getLastName(), "Last name should not be null");
            Assertions.assertNotNull(user.getActive(), "isActive should not be null");
        } catch (Exception e) {
            Assertions.fail("Failed to parse response body to GetUserByIdModel: " + e.getMessage());
        }
    }

    @Step("Assert response matches patch switch user activity model")
    public void assertResponseMatchesPatchSwitchUserActivityModel() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PatchSwitchUserActivityModel response = objectMapper.readValue(this.response.getBody().asString(), PatchSwitchUserActivityModel.class);

            Assertions.assertNotNull(response.getUserId(), "User ID should not be null");
            Assertions.assertNotNull(response.getActive(), "isActive should not be null");
        } catch (Exception e) {
            Assertions.fail("Failed to parse response body to PatchSwitchUserActivityModel: " + e.getMessage());
        }
    }

    @Step("Assert response matches put update user model")
    public void assertResponseMatchesPutUpdateUserModel() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PutUpdateUserModel response = objectMapper.readValue(this.response.getBody().asString(), PutUpdateUserModel.class);

            Assertions.assertNotNull(response.getUserId(), "User ID should not be null");
        } catch (Exception e) {
            Assertions.fail("Failed to parse response body to PutUpdateUserModel: " + e.getMessage());
        }
    }

}

