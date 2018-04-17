package product;

import java.util.List;

public class TextBook implements Product{
    private String name;
    private String title;
    private String subject;
    private String author;
    private double number_of_pages;

    public TextBook(){};
    public TextBook(List<String> value){
        name = "TextBook";
        title = value.get(0);
        subject = value.get(1);
        author = value.get(2);
        number_of_pages = Integer.parseInt(value.get(3));
    }

    @Override
    public Product makeSearchByName(String fieldName) {
        if(name.contains(fieldName) || title.contains(fieldName)||subject.contains(fieldName)){
            return this;
        }
        return null;
    }

    @Override
    public Product makeSearchByValue(double minValue, double maxValue) {
        if(maxValue == 0.0d || minValue==0.0d) {
            if(minValue==number_of_pages || maxValue==number_of_pages) {
                return this;
            }
        }
        else{
            if(minValue<=number_of_pages && maxValue>=number_of_pages){
                return this;
            }
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "title = " + title + ", " +
                "subject = " + subject+", " +
                "author = " + author + ", " +
                "number_of_pages = " + number_of_pages +"."
        );
    }
}
