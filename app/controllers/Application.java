package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import model.ChatHistory;
import model.UserInfo;
import org.codehaus.jackson.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import service.ChatPersistenceService;
import views.html.index;

import java.text.ParseException;
import java.util.Date;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result testEbean() throws ParseException {
        UserInfo userInfo = new UserInfo("10.10.10.10", "sessionId");
        EbeanServer report = Ebean.getServer("report");
        ChatHistory chatHistory = new ChatHistory("sessionId", "question", "answer", "2012-11-12:15:23:30");
        report.save(userInfo);
        report.save(chatHistory);
        return ok();
    }

    public static Result logChatHistory() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting Json data");
        } else {
            new ChatPersistenceService().persist(json);
            return ok();
        }
    }

}