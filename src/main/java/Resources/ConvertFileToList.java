package Resources;

import BusinessLogic.Question;
import BusinessLogic.QuestionBoard;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class ConvertFileToList {
    private ReadFromFile reader;
    private ArrayList<Question> questionList = new ArrayList<>();
    private Question question;
    private ArrayList<Integer> randList = new ArrayList<Integer>();
    private int[] random5Numbers = new int[5];
    private final ArrayList<QuestionBoard> questionBordList;
    private ArrayList<Question> finalList = new ArrayList<>();
    private boolean isGameHardYet;

    public ConvertFileToList(ReadFromFile reader, boolean isGameHardYet) {
        this.reader = reader;
        this.questionBordList = new ArrayList<>();
        this.isGameHardYet = isGameHardYet;
    }

    public ArrayList<QuestionBoard> questionController() throws IOException, ParseException {
        createFinalFilteredList();

        ArrayList<Question> boardQuestions;
        int[] boardNumberList;

        if(isGameHardYet == false){
            boardQuestions=easyGame();
        }else{
            boardQuestions=hardGame();
        }

        boardNumberList = createRandomNumbers(boardQuestions);
        return boardQuestions(boardQuestions, boardNumberList);
    }

    public ArrayList<Question> createFinalFilteredList() throws IOException, ParseException {
        makeQuestionList();
        filterScores();
         removeCategoriesIfNotEnoughQuestions();
         return finalList;
    }

    public void makeQuestionList() throws IOException, ParseException {
        while ((this.question = reader.readQuestion()) != null){
            questionList.add(question);
        }
    }
    public void filterScores(){
        for(int i=0; i<questionList.size(); i++){
            if     (questionList.get(i).getScore() == 0 ||
                    questionList.get(i).getScore() == 1200 ||
                    questionList.get(i).getScore() == 1600 ||
                    questionList.get(i).getScore() == 2000 ||
                    questionList.get(i).getScore() == 3400 ||
                    questionList.get(i).getScore() == 3800 ||
                    questionList.get(i).getScore() == 4000 ||
                    questionList.get(i).getScore() == 5000 ||
                    questionList.get(i).getScore() == 5200 ||
                    questionList.get(i).getScore() == 6000) {

                questionList.remove(i);
                i--;
            }
        }
    }
    public ArrayList<Question> removeCategoriesIfNotEnoughQuestions(){


        for(int i = 0; i<questionList.size()-4;i++){

                if(questionList.get(i).getCategory().getCategoryName().equals(questionList.get(i+4).getCategory().getCategoryName())){
                    for(int j=i; j<=i+3;j++) {
                        finalList.add(questionList.get(j));
                    }
                    i +=4;
                }
        }
        return finalList;
    }
    public ArrayList<Question> easyGame(){
        ArrayList<Question> easyQuestionsList = new ArrayList<>();
        for(int i=0; i<questionList.size(); i++){
            if     (questionList.get(i).getScore() == 100 &&
                    questionList.get(i+1).getScore() == 200 &&
                    questionList.get(i+2).getScore() == 300 &&
                    questionList.get(i+3).getScore() == 400 &&
                    questionList.get(i+4).getScore() == 500) {

                for(int j = 0; j<=4; j++) {
                    easyQuestionsList.add(questionList.get(i + j));
                }
                i+=4;
            }

        }
        return easyQuestionsList;
    }
    public ArrayList<Question> hardGame(){
        ArrayList<Question> hardQuestionsList = new ArrayList<>();
        for(int i=0; i<questionList.size(); i++){
            if     (questionList.get(i).getScore() == 200 &&
                    questionList.get(i+1).getScore() == 400 &&
                    questionList.get(i+2).getScore() == 600 &&
                    questionList.get(i+3).getScore() == 800 &&
                    questionList.get(i+4).getScore() == 1000) {

                for(int j = 0; j==4; j++) {
                    hardQuestionsList.add(questionList.get(i + j));
                }
                i+=4;
            }

        }
        return hardQuestionsList;
    }

    public int[] createRandomNumbers(ArrayList<Question> list) throws IOException, ParseException {

        for(int i = 0; i<list.size()-1; i+=5){
            randList.add(i);
        }
        Collections.shuffle(randList);
        for(int i = 0; i<5; i++){
            random5Numbers[i]=(randList.get(i));
        }

        return random5Numbers;
    }
    public ArrayList<QuestionBoard> boardQuestions(ArrayList<Question> list, int[] random5Numbers) throws IOException, ParseException {

        for(int i = 0; i < random5Numbers.length; i++){
            for(int j = 0; j < 5; j++){
                questionBordList.add(new QuestionBoard(
                        list.get(random5Numbers[i]+j).getScore(),
                        list.get(random5Numbers[i]+j).getCategory(),
                        list.get(random5Numbers[i]+j).getQuestion(),
                        list.get(random5Numbers[i]+j).getAnswer()
                ));
            }
        }
        return questionBordList;
    }

}
