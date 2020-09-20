package Resources;

import BusinessLogic.Category;
import BusinessLogic.Question;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class ReadFromFile {
    private final BufferedReader reader;
    int counter = 0;

    public ReadFromFile(BufferedReader reader) {

        this.reader = reader;
    }

    public ReadFromFile(Reader reader) {

        this(new BufferedReader(reader));
    }

    public Question readQuestion() throws IOException, ParseException {
        String line = reader.readLine();
        counter++;
        if (line != null) {
            String[] fields = line.split("\t");

            if (fields.length != 4) {
                throw new ParseException("Question must consist of 4 elements, this only has: " + fields.length, counter);
            } else {
                int score;
                try {
                    score = Integer.parseInt(fields[0]);
                    Category category = new Category(fields[1]);
                    addCategoriesToList(category);
                    String questionName = fields[2];
                    String answer = fields[3];

                    Question question = new Question(score, category, questionName, answer);
                    return question;
                } catch (NumberFormatException e) {
                    throw new ParseException("Score must be a number" + fields[0], counter);
                }



            }

            }else
                return null;
        }


    public void addCategoriesToList(Category category) {
        ArrayList<Category> cats = new ArrayList<Category>();
        if (!cats.contains(category)) {
            cats.add(category);
        }
    }
}
