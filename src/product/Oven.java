package product;

import java.util.List;

public class Oven implements Product {
    //fields
    private String name;
    private double power_consumption;
    private double weight;
    private double capacity;
    private double depth;
    private double height;
    private double width;
    //constructors
    public Oven(){};

    public Oven(List<String> values){
        name = "Oven";
        power_consumption = Double.parseDouble(values.get(0));
        weight = Double.parseDouble(values.get(1));
        capacity = Double.parseDouble(values.get(2));
        depth = Double.parseDouble(values.get(3));
        height = Double.parseDouble(values.get(4));
        width = Double.parseDouble(values.get(5));
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
                (minValue<=weight && maxValue >=weight) || (minValue <=capacity && maxValue >= capacity) ||
                (minValue<=depth && maxValue >=depth) || (minValue <= height && maxValue >= height) ||
                (minValue<=width && maxValue >= width)) {
            return this;
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "Power Consumption = " + power_consumption + ", " +
                "Weight = " + weight + ", " +
                "Capacity = " + capacity + ", " +
                "Depth = " + depth + ", " +
                "Height = " + height + ", " +
                "Width = " + width + "."
        );
    }
}
