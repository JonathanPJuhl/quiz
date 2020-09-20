package App;

import BusinessLogic.Game;
import BusinessLogic.Question;
import BusinessLogic.QuestionBoard;
import Resources.ConvertFileToList;
import Resources.ReadFromFile;
import Visual.DisplayBoard;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;

    public class Quiztastic {


    public void injectInputToReader(Scanner scanner, PrintWriter print) throws IOException, ParseException {
        int nrOfRounds = 0;
        java.io.InputStream input = this.getClass()
                .getClassLoader()
                .getResourceAsStream("master_season1-35clean.tsv");
        if(input == null){
            System.out.println("Stream is empty");
        }
        else{

            ReadFromFile rF = new ReadFromFile(new InputStreamReader(input));

            if(nrOfRounds == 0) {
                ConvertFileToList cFL = new ConvertFileToList(rF, false);
                ArrayList<QuestionBoard> processedList = cFL.questionController();
                DisplayBoard dB = new DisplayBoard(processedList);
                Game game = new Game(processedList, scanner, print);
                game.processor();
                //dB.createBoard();

                nrOfRounds++;
            } else {
                ConvertFileToList cFL = new ConvertFileToList(rF, true);
                ArrayList<QuestionBoard> processedList = cFL.questionController();
                DisplayBoard dB = new DisplayBoard(processedList);
                Game game = new Game(processedList, scanner, print);
                dB.createBoard();
                game.processor();
                nrOfRounds++;
            }

        }

    }



}
