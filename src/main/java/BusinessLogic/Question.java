package BusinessLogic;


public class Question{
    int score;
    Category category;
    String question;
    String answer;

    public Question(int score, Category category, String question, String answer) {
        this.score = score;
        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public Category getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    @Override
    public String toString(){
        return "Score = "+score+category+question+answer;
    }
}
