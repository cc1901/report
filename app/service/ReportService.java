package service;

import com.avaje.ebean.*;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import domain.MostAppearQuestions;
import model.ChatHistory;
import model.UserInfo;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    public List<String> reportIp() {
        EbeanServer report = Ebean.getServer("report");
        List<String> ips = Lists.transform(report.find(UserInfo.class).findList(), new Function<UserInfo, String>() {
            @Override
            public String apply(@Nullable UserInfo userInfo) {
                return userInfo.ip;
            }
        });
        return ips;
    }

    public MostAppearQuestions reportAppearMost() {
        EbeanServer report = Ebean.getServer("report");
        String sql = "select answer, count(1) as count from chat_history group by order_id order by count desc";
        RawSql rawSql = RawSqlBuilder.parse(sql).create();
        Query<String> answerQuery = report.find(String.class);
        answerQuery.setRawSql(rawSql);
        List<String> answers = answerQuery.findList();
        String appearMostAnswer = answers.get(0);
        List<ChatHistory> chatHistories = report.find(ChatHistory.class).where().eq("answer", appearMostAnswer).findList();
        List<String> questions = Lists.transform(chatHistories, new Function<ChatHistory, String>() {
            @Override
            public String apply(@Nullable ChatHistory chatHistory) {
                return chatHistory.getQuestion();
            }
        });
        return new MostAppearQuestions(appearMostAnswer, questions);
    }

}
