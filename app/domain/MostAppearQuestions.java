package domain;

import java.util.List;

public class MostAppearQuestions {
    private String answer;
    private List<String> questions;

    public MostAppearQuestions(String answer, List<String> questions) {
        this.answer = answer;
        this.questions = questions;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getQuestions() {
        return questions;
    }
}
