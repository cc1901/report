package service;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import model.UserInfo;
import org.codehaus.jackson.JsonNode;
import util.ModelParser;

public class ChatPersistenceService {
    public void persist(JsonNode chatHistoryJson) {
        UserInfo userInfo = ModelParser.parseUserInfo(chatHistoryJson);
        EbeanServer report = Ebean.getServer("report");
        report.save(userInfo);
    }
}
