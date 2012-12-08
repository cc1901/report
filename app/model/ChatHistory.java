package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatHistory {
    private final String sessionId;
    private final String question;
    private final String answer;
    private final Date date;

    public ChatHistory(String sessionId, String question, String answer, String time) throws ParseException {
        this.sessionId = sessionId;
        this.question = question;
        this.answer = answer;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("");
        date = simpleDateFormat.parse(time);
    }
}
