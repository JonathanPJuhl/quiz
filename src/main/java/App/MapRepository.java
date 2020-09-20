/*package App;

import BusinessLogic.Category;
import BusinessLogic.Question;
import Resources.ReadFromFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapRepository implements QuestionRepository{

    private final HashMap<Category, List<Question>> questionsWithCategory;

    public MapRepository(HashMap<Category, List<Question>> questionsWithCategory) {
        this.questionsWithCategory = questionsWithCategory;
    }


    @Override
    public List<Category> getCategories() {
        ArrayList<Category> categoryList = new ArrayList<Category>();
        return categoryList;
    }
    @Override
    public List<Question> getQuestionsWithCategory(Category category) {

        return null;
    }
    @Override
    public Iterable<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        for (List<Question> l : questionsWithCategory.values()){
            questions.addAll(l);
        }
        return questions;
    }
    public static MapRepository fromQuestionReader(ReadFromFile reader) throws IOException, ParseException {

        Question q = reader.readQuestion();
        System.out.println(q);
        return new MapRepository(new HashMap<>());
    }
}*/
