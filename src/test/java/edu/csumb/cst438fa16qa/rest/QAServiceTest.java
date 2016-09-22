package edu.csumb.cst438fa16qa.rest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * See:
 * https://jersey.java.net/documentation/latest/test-framework.html
 * https://jersey.java.net/apidocs/latest/jersey/index.html
 */
public class QAServiceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(QAService.class);
    }
    
    @Test
    public void testQAWithEmptyAnswer() {
        WebTarget webTarget = target("testanswer").queryParam("name", "");                             //
        String theday = webTarget.request().get(String.class);             // act
        assertThat(theday, equalTo("You need to type an answer"));                               // assert
    }
    
    @Test
    public void testQAWithNoAnswer() {
        WebTarget webTarget = target("testanswer").queryParam("name", null);                             //
        String theday = webTarget.request().get(String.class);             // act
        assertThat(theday, equalTo("You need to type an answer"));                               // assert
    }

}
