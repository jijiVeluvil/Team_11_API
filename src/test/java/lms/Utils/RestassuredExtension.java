package lms.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

//import lms.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lms.Endpoints.ConstantFilePaths;

public class RestassuredExtension {
	private static RequestSpecification reqSpecific;

	public RestassuredExtension() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(ConstantFilePaths.BASE_URL);
		builder.setContentType(ContentType.JSON);
		reqSpecific = RestAssured.given().spec(builder.build());

	}

	public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String, String> body) {
		reqSpecific.body(body);
		return reqSpecific.post(url);
	}

	public static void requestWithAuth(String token) {
		reqSpecific.header(new Header("Authorization", "Bearer " + token));
	}

	public static Header getTokenHeader(String token) {
		return new Header("Authorization", "Bearer " + token);
	}

	public static void requestWithNoAuth() {
		reqSpecific.header(new Header("NoAuth", " "));

	}

	public static Response getAllRequestWithEndpoint(String endPoint) {
		try {
			return reqSpecific.get(new URI(endPoint));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;

	}

	// Post method by passing JSON String as request body
	public static Response postRequestStringBody(String url, String body) {
		try {

			reqSpecific.body(body);
			return reqSpecific.post(new URI(url));

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// public static RequestSpecification req;

	public static RequestSpecification getRequestSpecification() throws IOException {

		if (reqSpecific == null) {
			reqSpecific = new RequestSpecBuilder().setBaseUri(ConstantFilePaths.BASE_URL)
					.setContentType(ContentType.JSON).build();
			return reqSpecific;
		}
		return reqSpecific;

	}

	// Post method by passing Map object as request body
	public static ResponseOptions<Response> postRequestWithBody(String url, Map<String, String> body) {

		try {
			reqSpecific.body(body);
			return reqSpecific.post(new URI(url));

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Response getWithPathParram(String url, Map<String, String> pathParam) {
		try {
			String urlwithId = url + pathParam.get("Id");
			// reqSpecific.pathParam("Id", pathParam);
			return reqSpecific.get(new URI(urlwithId));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Response getWithPaQueryParram(String url, Map<String, String> queryParam) {
		try {
			String urlwithId = url + queryParam.get("Id");
			// reqSpecific.pathParam("Id", pathParam);
			return reqSpecific.get(new URI(urlwithId));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Response deleteWithPathParram(String url, Map<String, String> pathParam) {
		try {
			String urlwithId = url + pathParam.get("Id");
			return reqSpecific.delete(new URI(urlwithId));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Response putRequestStringBody(String url, String body, Map<String, String> pathParam) {

		try {
			// reqSpecific.pathParams(pathParam);
			String urlwithId = url + pathParam.get("Id");
			System.out.println("URL with Id: " + urlwithId);
			reqSpecific.body(body);
			return reqSpecific.put(new URI(urlwithId));

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
