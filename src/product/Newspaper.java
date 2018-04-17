package product;

import java.util.List;

public class Newspaper implements Product{
    private String name;
    private String title;
    private Integer [] periodycity;
    private String paid_or_free;

    public Newspaper(){};
    public Newspaper(List<String> value){
        name = "Newspaper";
        title = value.get(0);
        String [] temp = value.get(1).split("x");
        periodycity = new Integer[2];
        periodycity[0] = Integer.parseInt(temp[0]);
        periodycity[1] = Integer.parseInt(temp[1]);
        paid_or_free = value.get(2);
    }

    @Override
    public Product makeSearchByName(String fieldName) {
        if(name.contains(fieldName) || title.contains(fieldName)||paid_or_free.contains(fieldName)){
            return this;
        }
        return null;
    }

    @Override
    public Product makeSearchByValue(double minValue, double maxValue) {
        if((minValue==periodycity[0] && maxValue == maxValue)) {
            return this;
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "title = " + title + ", " +
                "periodycity = " + periodycity[0] + "x"+periodycity[1]+", " +
                "Paid_or_free = " + paid_or_free+ "."
        );
    }
}
