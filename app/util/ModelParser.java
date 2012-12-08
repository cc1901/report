package util;

import model.ChatHistory;
import model.UserInfo;
import org.codehaus.jackson.JsonNode;

import java.text.ParseException;

public class ModelParser {

    public static final String IP = "ip";
    public static final String SESSION_ID = "sessionId";

    static public UserInfo parseUserInfo(JsonNode jsonNodes) {
        String ip = jsonNodes.findPath(IP).getTextValue();
        String sessionId = jsonNodes.findPath(SESSION_ID).getTextValue();
        if (ip != null) {
            return new UserInfo(ip, sessionId);
        } else {
            throw new IllegalArgumentException("no ip info in request...");
        }
    }

    public static ChatHistory parseChatHistory(JsonNode jsonNodes) throws ParseException {
        String question = jsonNodes.findPath("question").getTextValue();
        String sessionId = jsonNodes.findPath(SESSION_ID).getTextValue();
        String answer = jsonNodes.findPath("answer").getTextValue();
        String time = jsonNodes.findPath("time").getTextValue();
        if (question != null) {
            return new ChatHistory(sessionId, question, answer, time);
        } else {
            throw new IllegalArgumentException("no ip info in request...");
        }
    }
}
