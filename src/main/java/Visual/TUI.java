package Visual;

import BusinessLogic.Player;

import java.io.PrintWriter;
import java.util.Scanner;

public class TUI {
    private final Scanner scanner;
    private final PrintWriter print;

    public TUI(Scanner scanner, PrintWriter print) {
        this.scanner = scanner;
        this.print = print;

    }

    public String getPlayer(){
        print.println("Welcome to Jeopardy! Please enter player name: ");
        print.flush();
        String playerName = scanner.nextLine();
        return playerName;
        }

        public int whatToDoNow(){
            print.println("What would you like to do?:");
            print.println("1: play game");
            print.println("2: check player name");
            print.println("3: help");
            print.println("4: Quit game");
            print.flush();
            int answer = scanner.nextInt();
            scanner.nextLine();
            return answer;
        }

        public int chooseCategory(){
            print.println("Which category would you like a question from? answer with 1-5, from left to right:");
            print.flush();
            int answer = scanner.nextInt();
            scanner.nextLine();
        return answer;
        }


    public void getHelpMessage() {
        print.println("If you need help for jeopardy, ask google.");
        print.print("This is helpful... right?");
    }

    public int chooseScoreValue() {
        print.println("Choose a score from the chosen category e.g.: \"100\"");
        print.flush();
        int answer = scanner.nextInt();
        scanner.nextLine();
        return answer;
    }
    public void printQuestion(String question){
        print.println(question);
        print.flush();
    }
    public String getAnswer(){
        String answer = scanner.nextLine();
        return answer;
    }
    public void correctMessage(){
        print.println("Correct!");
        print.flush();

    }
    public void incorrectMessage(String correct){
        print.println("incorrect! The right answer was " + correct);
        print.flush();

    }
}

