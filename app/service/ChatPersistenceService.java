package service;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import model.ChatHistory;
import model.UserInfo;
import org.codehaus.jackson.JsonNode;
import util.ModelParser;

import javax.annotation.Nullable;
import java.util.List;

public class ChatPersistenceService {
    public void persist(JsonNode chatHistoryJson) {
        UserInfo userInfo = ModelParser.parseUserInfo(chatHistoryJson);
        EbeanServer report = Ebean.getServer("report");
        List<UserInfo> userInfos = report.find(UserInfo.class).where().eq("session_id", userInfo.sessionId).findList();
        if (userInfos.isEmpty()) {
            report.save(userInfo);
        }
        ChatHistory chatHistory = ModelParser.parseChatHistory(chatHistoryJson);
        report.save(chatHistory);
    }
}
