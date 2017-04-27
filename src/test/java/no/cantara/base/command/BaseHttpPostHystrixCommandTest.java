package no.cantara.base.command;

import com.xebialabs.restito.server.StubServer;
import io.restassured.RestAssured;
import org.glassfish.grizzly.http.Method;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import static com.xebialabs.restito.builder.stub.StubHttp.whenHttp;
import static com.xebialabs.restito.builder.verify.VerifyHttp.verifyHttp;
import static com.xebialabs.restito.semantics.Action.status;
import static com.xebialabs.restito.semantics.Action.stringContent;
import static com.xebialabs.restito.semantics.Condition.*;
import static io.restassured.RestAssured.expect;
import static org.junit.Assert.assertEquals;

/**
 * Created by baardl on 2017-04-27.
 */
public class BaseHttpPostHystrixCommandTest {
    private StubServer server;
    private BaseHttpPostHystrixCommand baseHttpPostHystrixCommand;
    private int port;
    private URI uri;

    @Before
    public void start() {
        server = new StubServer().run();
        RestAssured.port = server.getPort();
        this.port = server.getPort();
        uri = URI.create("http://localhost:" + port );

    }

    @Test
    public void testDoPostCommand() throws Exception {
        // Restito
        whenHttp(server).
//                match(contentType("applicatin/json"))
                match(post("/postJson"), withHeader("CONTENT-TYPE","application/json")).
                then(status(HttpStatus.OK_200), stringContent("Updated Ok") );


        baseHttpPostHystrixCommand = new BaseHttpPostHystrixCommand(uri, "test") {
            @Override
            protected String getTargetPath() {
                return "/postJson";
            }

            @Override
            protected String getJsonBody() {
                return "{\"test\": \"value\"}";
            }
        };

        String response = (String) baseHttpPostHystrixCommand.doPostCommand();
        assertEquals("Updated Ok", response);

    }

    @After
    public void stop() {
        server.stop();
    }

    @Test
    public void shouldPassVerification() throws UnsupportedEncodingException {
        // Restito
        whenHttp(server).
                match(get("/demo")).
                then(status(HttpStatus.OK_200));

        // Rest-assured
        expect().statusCode(200).when().get("/demo");

        // Restito
        verifyHttp(server).once(
                method(Method.GET),
                uri("/demo")
        );
    }

}