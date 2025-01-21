package com.yasin.Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import java.util.Map;
import static com.yasin.Helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders( Map<String, String> headers){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            request.header(entry.getKey(), entry.getValue());
        }
    }

    public static Response getIdUser(String endpoint, Map<String, String> headers, String globalId) {
        setupHeaders(headers);
        return request.when().get(endpoint);
    }

    public static Response createUser(String endpoint, Map<String, String> headers) {
        String title = "ms";
        String firstName = "Petruk";
        String lastName = "Smith";
        String picture = "https://randomuser.me/api/portraits/women/58.jpg";
        String gender = "female";
        String email = generateRandomEmail();
        String dateOfBirth = "1996-04-30T19:26:49.610Z";
        String phone = "92694011";

        JSONObject location = new JSONObject();
        location.put("street", "jalan sesama");
        location.put("city", "gotham");
        location.put("state", "west von");
        location.put("country", "anon");
        location.put("timezone", "-9:00");

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("picture", picture);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("dateOfBirth", dateOfBirth);
        payload.put("phone", phone);
        payload.put("location", location);

        setupHeaders(headers);
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response updateUser(String endpoint, Map<String, String> headers, String globalId) {
        String title = "mr";
        String firstName = "Sule";
        String lastName = "Smith";
        String picture = "https://randomuser.me/api/portraits/women/58.jpg";
        String gender = "male";
        String email = generateRandomEmail();
        String dateOfBirth = "1996-04-30T19:26:49.610Z";
        String phone = "92694011";

        JSONObject location = new JSONObject();
        location.put("street", "jalan sesama");
        location.put("city", "gotham");
        location.put("state", "west von");
        location.put("country", "anon");
        location.put("timezone", "-9:00");

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("picture", picture);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("dateOfBirth", dateOfBirth);
        payload.put("phone", phone);
        payload.put("location", location);

        setupHeaders(headers);
        System.out.println(request.body(payload.toString()));
        System.out.println(headers);
        System.out.println(endpoint);
        return request.body(payload.toString()).when().put(endpoint);
    }

    public static Response deleteUser(String endpoint, Map<String, String> headers, String user_id) {
        setupHeaders(headers);
        return request.when().get(endpoint);
    }

    public static Response getTags(String setUrl, Map<String, String> headers) {
        setupHeaders(headers);
        return request.when().get(setUrl);
    }
}