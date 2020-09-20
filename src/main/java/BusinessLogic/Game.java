package BusinessLogic;

import Visual.DisplayBoard;
import Visual.TUI;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player;
    private TUI tUI;
    private ArrayList<QuestionBoard> questions = new ArrayList<>();
    private boolean startGame;
    private boolean endGame;
    private int numberOfAnswers;
    private String correctAnswer;

    public Game(ArrayList<QuestionBoard> questions, Scanner scanner, PrintWriter print) {
        this.player = null;
        this.questions = questions;
        this.startGame = false;
        this.endGame = false;
        this.tUI = new TUI(scanner, print);
        this.numberOfAnswers = numberOfAnswers;
    }
    public void processor(){
        createPlayer();
        int decision = tUI.whatToDoNow();
        if(decision==1){
            setStartGame();
            DisplayBoard dB = new DisplayBoard(questions);
            dB.createBoard();
            tUI.printQuestion(category(tUI.chooseCategory()));
            isAnswerCorrect(tUI.getAnswer(), correctAnswer);


        } else if(decision==2){
            PrintWriter print = new PrintWriter(System.out);
            print.println(getPlayer().name.toString());
            print.flush();
        }else if(decision==3){
            tUI.getHelpMessage();
        }else if(decision==4){
            System.exit(4);
        }


    }
    public String category(int catNumber){
        String catNum = Integer.toString(catNumber);
        String score = null;
        switch(catNum){
            case "1":
                score = Integer.toString(tUI.chooseScoreValue());
                switch(score){
                    case "100":
                        correctAnswer = questions.get(0).getAnswer();
                        return questions.get(0).getQuestion();
                    case "200":
                        correctAnswer = questions.get(1).getAnswer();
                        return questions.get(1).getQuestion();
                    case "300":
                        correctAnswer = questions.get(2).getAnswer();
                        return questions.get(2).getQuestion();
                    case "400":
                        correctAnswer = questions.get(3).getAnswer();
                        return questions.get(3).getQuestion();
                    case "500":
                        correctAnswer = questions.get(4).getAnswer();
                        return questions.get(4).getQuestion();
                }
            case "2":
                score = Integer.toString(tUI.chooseScoreValue());
                switch(score){
                    case "100":
                        correctAnswer = questions.get(5).getAnswer();
                        return questions.get(5).getQuestion();
                    case "200":
                        correctAnswer = questions.get(6).getAnswer();
                        return questions.get(6).getQuestion();
                    case "300":
                        correctAnswer = questions.get(7).getAnswer();
                        return questions.get(7).getQuestion();
                    case "400":
                        correctAnswer = questions.get(8).getAnswer();
                        return questions.get(8).getQuestion();
                    case "500":
                        correctAnswer = questions.get(9).getAnswer();
                        return questions.get(9).getQuestion();
                }
            case "3":
                score = Integer.toString(tUI.chooseScoreValue());
                switch(score){
                    case "100":
                        correctAnswer = questions.get(10).getAnswer();
                        return questions.get(10).getQuestion();
                    case "200":
                        correctAnswer = questions.get(11).getAnswer();
                        return questions.get(11).getQuestion();
                    case "300":
                        correctAnswer = questions.get(12).getAnswer();
                        return questions.get(12).getQuestion();
                    case "400":
                        correctAnswer = questions.get(13).getAnswer();
                        return questions.get(13).getQuestion();
                    case "500":
                        correctAnswer = questions.get(14).getAnswer();
                        return questions.get(14).getQuestion();
                }
            case "4":
                score = Integer.toString(tUI.chooseScoreValue());
                switch(score){
                    case "100":
                        correctAnswer = questions.get(15).getAnswer();
                        return questions.get(15).getQuestion();
                    case "200":
                        correctAnswer = questions.get(16).getAnswer();
                        return questions.get(16).getQuestion();
                    case "300":
                        correctAnswer = questions.get(17).getAnswer();
                        return questions.get(17).getQuestion();
                    case "400":
                        correctAnswer = questions.get(18).getAnswer();
                        return questions.get(18).getQuestion();
                    case "500":
                        correctAnswer = questions.get(19).getAnswer();
                        return questions.get(19).getQuestion();
                }
            case "5":
                score = Integer.toString(tUI.chooseScoreValue());
                switch(score){
                    case "100":
                        correctAnswer = questions.get(20).getAnswer();
                        return questions.get(20).getQuestion();
                    case "200":
                        correctAnswer = questions.get(21).getAnswer();
                        return questions.get(21).getQuestion();
                    case "300":
                        correctAnswer = questions.get(22).getAnswer();
                        return questions.get(22).getQuestion();
                    case "400":
                        correctAnswer = questions.get(23).getAnswer();
                        return questions.get(23).getQuestion();
                    case "500":
                        correctAnswer = questions.get(24).getAnswer();
                        return questions.get(24).getQuestion();
                }
        }
        return null;
    }
    public boolean isAnswerCorrect(String answer, String correctAnswer){
        if(correctAnswer.toLowerCase().equals(answer.toLowerCase())){
            tUI.correctMessage();
            return true;
        }else
            tUI.incorrectMessage(correctAnswer);

        return false;
    }


    public Player createPlayer(){
        player = new Player(tUI.getPlayer());
        return player;
    }
    public void setStartGame(){
        startGame = true;
    }

    public Player getPlayer() {
        return player;
    }
}
