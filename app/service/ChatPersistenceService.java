package service;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import model.ChatHistory;
import model.UserInfo;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.codehaus.jackson.JsonNode;
import play.Logger;
import util.ModelParser;

import javax.annotation.Nullable;
import java.util.List;

public class ChatPersistenceService {
    public void persist(JsonNode chatHistoryJson) {
        UserInfo userInfo = ModelParser.parseUserInfo(chatHistoryJson);
        EbeanServer report = Ebean.getServer("report");
        List<UserInfo> userInfos = report.find(UserInfo.class).where().eq("session_id", userInfo.sessionId).findList();
        if (userInfos.isEmpty()) {
            Logger.info("user info: ===" + new ReflectionToStringBuilder(userInfo).toString());
            report.save(userInfo);
        }
        ChatHistory chatHistory = ModelParser.parseChatHistory(chatHistoryJson);
        Logger.info("chat history: ===" + new ReflectionToStringBuilder(chatHistory).toString());
        report.save(chatHistory);
    }
}
