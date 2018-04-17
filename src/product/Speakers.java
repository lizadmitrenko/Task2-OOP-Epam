package product;

import java.util.List;

public class Speakers implements Product{
    private String name;
    private Integer power_consumption;
    private Integer number_of_speakers;
    private Double [] frequency_range;
    private Integer cord_length;

    public Speakers(){};
    public Speakers(List<String> value){
        name = "Speakers";
        power_consumption = Integer.parseInt(value.get(0));
        number_of_speakers = Integer.parseInt(value.get(1));
        String[] temp = value.get(2).split("-");
        frequency_range = new Double[2];
        frequency_range[0] = Double.parseDouble(temp[0]);
        frequency_range[1] = Double.parseDouble(temp[1]);
        cord_length = Integer.parseInt(value.get(3));
    }

    @Override
    public Product makeSearchByName(String fieldName) {
        if(name.contains(fieldName)){
            return this;
        }
        return null;
    }

    @Override
    public Product makeSearchByValue(double minValue, double maxValue) {
        if((minValue<=power_consumption && maxValue >=power_consumption)||
                (minValue<=number_of_speakers && maxValue >=number_of_speakers) || (minValue <=cord_length && maxValue >=cord_length) ||
                (minValue<=frequency_range[0] && maxValue >=frequency_range[1])) {
            return this;
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "Power_Consumption = " + power_consumption + ", " +
                "Number_of_Speackers = " + number_of_speakers + ", " +
                "Frequency_Range" +frequency_range[0]+"-"+frequency_range[1]+ ", " +
                "Cord Length = " + cord_length +  "."
        );
    }
}
