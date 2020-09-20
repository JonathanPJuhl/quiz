package BusinessLogic;

public class Category {
    String name;

    public Category(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category: '" +
                name + '\'';
    }
}
