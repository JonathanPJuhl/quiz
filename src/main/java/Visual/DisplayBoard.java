package Visual;

import App.Quiztastic;
import BusinessLogic.QuestionBoard;
import Resources.ConvertFileToList;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;

public class DisplayBoard {
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers = new String[5];
    private List<String[]> rows = new ArrayList<>();
    private String[] scores = new String[25];
    ArrayList<QuestionBoard> questions = new ArrayList<>();


    public DisplayBoard(ArrayList<QuestionBoard> questions) {
        this.questions = questions;
    }

    public void createBoard(){
        setShowVerticalLines(true);
        int count = 0;
        for (int i = 0; i < questions.size()-1; i++) {
            headers[count]=(questions.get(i).getCategory().getCategoryName());
            count++;
            i+=4;
        }
            setHeaders(headers[0],headers[1],headers[2],headers[3],headers[4]);


            addRow(Integer.toString(questions.get(0).getScore()), Integer.toString(questions.get(5).getScore()), Integer.toString(questions.get(10).getScore()),
                    Integer.toString(questions.get(15).getScore()),Integer.toString(questions.get(20).getScore()));

        addRow(Integer.toString(questions.get(1).getScore()), Integer.toString(questions.get(6).getScore()), Integer.toString(questions.get(11).getScore()),
                Integer.toString(questions.get(16).getScore()),Integer.toString(questions.get(21).getScore()));

        addRow(Integer.toString(questions.get(2).getScore()), Integer.toString(questions.get(7).getScore()), Integer.toString(questions.get(12).getScore()),
                Integer.toString(questions.get(17).getScore()),Integer.toString(questions.get(22).getScore()));

        addRow(Integer.toString(questions.get(3).getScore()), Integer.toString(questions.get(8).getScore()), Integer.toString(questions.get(13).getScore()),
                Integer.toString(questions.get(18).getScore()),Integer.toString(questions.get(23).getScore()));

        addRow(Integer.toString(questions.get(4).getScore()), Integer.toString(questions.get(9).getScore()), Integer.toString(questions.get(14).getScore()),
                Integer.toString(questions.get(19).getScore()),Integer.toString(questions.get(24).getScore()));

            print();
            setShowVerticalLines(false);


    }



    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            /*if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }*/
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";

                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        System.out.println();
    }


    public static void main(String[] args) throws IOException, ParseException {
        new Quiztastic().injectInputToReader(new Scanner(System.in), new PrintWriter(System.out));
    }
}

