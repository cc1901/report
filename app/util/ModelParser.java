package util;

import model.ChatHistory;
import model.UserInfo;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
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
            throw new RuntimeException("no ip info in request...");
        }
    }

    public static ChatHistory parseChatHistory(JsonNode jsonNodes) {
        String question = jsonNodes.findPath("question").getTextValue();
        String sessionId = jsonNodes.findPath(SESSION_ID).getTextValue();
        String answer = jsonNodes.findPath("answer").getTextValue();
        String time = jsonNodes.findPath("time").getTextValue();
        if (question != null) {
            try {
                return new ChatHistory(sessionId, question, answer, time);
            } catch (ParseException e) {
                e.printStackTrace();
                throw new RuntimeException("time info is not correct...");
            }
        } else {
            throw new RuntimeException("no chat history info in request...");
        }
    }
}
