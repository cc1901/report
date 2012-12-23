package model;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "chat_history")
public class ChatHistory {
    @Id
    @Constraints.Min(1)
    public Long id;

    @Constraints.Required
    private final String sessionId;

    @Constraints.Required
    private final String question;

    @Constraints.Required
    private final String answer;

    @Constraints.Required
    private final Date date;

    public ChatHistory(String sessionId, String question, String answer, String time) throws ParseException {
        this.sessionId = sessionId;
        this.question = question;
        this.answer = answer;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        date = simpleDateFormat.parse(time);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
