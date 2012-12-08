package controllers;

import com.avaje.ebean.Ebean;
import model.UserInfo;
import org.codehaus.jackson.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import service.ChatPersistenceService;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result testEbean() {
        UserInfo userInfo = new UserInfo("10.10.10.10", "sessionId");
        Ebean.save(userInfo);
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