package BusinessLogic;

public class QuestionBoard extends Question{
    private String answered;

    @Override
    public String toString() {
        return "QuestionBoard{" +
                "answered='" + answered + '\'' +
                ", score=" + score +
                ", category=" + category +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public void setAnswered(String answered) {

        this.answered = answered;
    }

    public String getAnswered() {

        return answered;
    }

    public QuestionBoard(int score, Category category, String question, String answer) {
        super(score, category, question, answer);
        this.answered = null;
    }
}
