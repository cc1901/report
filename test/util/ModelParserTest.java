package util;

import org.junit.Test;

import static play.mvc.Controller.request;

public class ModelParserTest {
    @Test
    public void should_parse_user_info(){
        ModelParser modelParser = new ModelParser();
//        modelParser.parseUserInfo(request().body().asJson());
    }

    @Test
    public void should_parse_chat_history(){
    }
}
