package App;

import BusinessLogic.Category;
import BusinessLogic.Question;

import java.util.List;

public interface QuestionRepository {

    List<Category> getCategories();

    List<Question> getQuestionsWithCategory(Category category);

    Iterable<Question> getQuestions();
}
