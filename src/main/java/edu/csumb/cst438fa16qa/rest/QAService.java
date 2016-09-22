package edu.csumb.cst438fa16qa.rest;

import edu.csumb.cst438fa16qa.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST service that greets requests.
 *
 * This is a "root resource class" as explained in
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("/")
public class QAService {
    
    public static QuestionsAnswers qa = new QuestionsAnswers();
    
    @GET
    @Path("/randomquestion")
    public String question() {
        qa.put("Roses are", "red");
        qa.put("What is my favorite color?", "teal");
        qa.put("What color is the sky?", "blue");
        return qa.getRandomQuestion();
    }

    @GET
    @Path("/testanswer")
    public String result(@QueryParam("question") String question,@QueryParam("answer") String answer) {
        if (answer == null || answer.isEmpty()) {
            return "You need to type an answer";
        }else if(qa.testAnswer(question, answer)){
            return "Yes, '" + answer + "' is the answer to '" + question + "'";
        }else{
            return "'" + answer + "' is not the correct answer to '" + question + "'";
        }
    }
}
