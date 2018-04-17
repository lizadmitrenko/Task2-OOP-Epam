package product;

import java.util.List;

public class Refrigerator implements Product {
    private String name;
    private double powerConsumption;
    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator(){};
    public Refrigerator(List<String> values){
        name = "Refrigerator";
        powerConsumption = Double.parseDouble(values.get(0));
        weight = Double.parseDouble(values.get(1));
        freezerCapacity = Double.parseDouble(values.get(2));
        overallCapacity = Double.parseDouble(values.get(3));
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
        if((minValue<=powerConsumption && maxValue >=powerConsumption)||
                (minValue<=weight && maxValue >=weight) || (minValue <=freezerCapacity && maxValue >= freezerCapacity) ||
                (minValue<=overallCapacity && maxValue >=overallCapacity) || (minValue <= height && maxValue >= height) ||
                (minValue<=width && maxValue >= width)) {
            return this;
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "Power Consumption = " + powerConsumption + ", " +
                "Weight = " + weight + ", " +
                "Freezer Capacity= " + freezerCapacity + ", " +
                "Overall Capacity = " + overallCapacity + ", " +
                "Height = " + height + ", " +
                "Width = " + width + "."
        );
    }
}
