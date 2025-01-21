package page.Api;

import com.yasin.Helper.EndpointApi;
import com.yasin.Helper.Models;
import com.yasin.Helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setUrl, global_id;
    Map<String, String> headers = new HashMap<>();
    Response result;

    public void urlFor(String url) {
        switch (url) {
            case "GET_USER_BY_ID":
                setUrl = EndpointApi.GET_USER_BY_ID;
                break;
            case "CREATE_USER":
                setUrl = EndpointApi.CREATE_USER;
                break;
            case "UPDATE_USER":
                setUrl = EndpointApi.UPDATE_USER;
                break;
            case "DELETE_USER":
                setUrl = EndpointApi.DELETE_USER;
                break;
            case "GET_LIST_TAGS":
                setUrl = EndpointApi.GET_LIST_TAGS;
                break;
            default:
                System.out.println("input right url");
                break;
        }
    }

    public void addHeader(String appId, String apiKey) {
        headers.put(appId, apiKey);
    }

    public void hitGetUserId() {
        setUrl.equals("GET_USER_BY_ID");
        setUrl = EndpointApi.GET_USER_BY_ID.replace("{id}", global_id);
        result = Models.getIdUser(setUrl, headers, global_id);
    }

    public void hitGetTag() {
        result = Models.getTags(setUrl, headers);
    }

    public void hitUpdateUser() {
        setUrl.equals("UPDATE_USER");
        setUrl = EndpointApi.UPDATE_USER.replace("{id}", global_id);
        result = Models.updateUser(setUrl, headers, global_id);
    }

    public void hitPostCreateUser() {
        result = Models.createUser(setUrl, headers);
    }

    public void hitDeleteUser() {
        setUrl.equals("DELETE_USER");
        setUrl = EndpointApi.DELETE_USER.replace("{id}", global_id);
        result = Models.deleteUser(setUrl, headers, global_id);
    }

    public void validateStatusCode(int statuscode) {
        assertThat(result.statusCode()).isEqualTo(statuscode);
    }

    public void validateJson(String schemaFile) {
        File JSONFile = Utility.getJSONSchemaFile(schemaFile);
        result.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validateResponseBody() {
        JsonPath jsonPathEmulator = result.jsonPath();
        String id = jsonPathEmulator.getString("id");
        String title = jsonPathEmulator.getString("title");
        String firstName = jsonPathEmulator.getString("firstName");
        String lastName = jsonPathEmulator.getString("lastName");
        String picture = jsonPathEmulator.getString("picture");
        String email = jsonPathEmulator.getString("email");
        String dateOfBirth = jsonPathEmulator.getString("dateOfBirth");
        String phone = jsonPathEmulator.getString("phone");
        Map<String, String> location = jsonPathEmulator.getMap("location");

        assertThat(firstName).isNotNull().isNotEmpty();
        assertThat(lastName).isNotNull().isNotEmpty();
        assertThat(email).isNotNull().isNotEmpty();
        assertThat(title).isIn("ms", "mr");
        assertThat(picture).isNotNull().startsWith("https://");
        assertThat(dateOfBirth).isNotNull();
        assertThat(phone).isNotNull();
        assertThat(location).isNotNull();
        assertThat(location.get("street")).isNotNull();
        assertThat(location.get("city")).isNotNull();
        assertThat(location.get("state")).isNotNull();
        assertThat(location.get("country")).isNotNull();
        assertThat(location.get("timezone")).isNotNull();

        global_id = id;
    }
}