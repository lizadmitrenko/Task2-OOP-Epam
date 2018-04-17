package product;

import java.util.List;

public class Laptop implements Product{
    private String name;
    private double battery_capacity;
    private String os;
    private double memoryROM;
    private double systemMemory;
    private double cpu;
    private double displayInches;
    public Laptop(){};
    public Laptop(List<String> value){
        name = "Laptop";
        battery_capacity = Double.parseDouble(value.get(0));
        os = value.get(1);
        memoryROM = Double.parseDouble(value.get(2));
        systemMemory = Double.parseDouble(value.get(3));
        cpu = Double.parseDouble(value.get(4));
        displayInches = Double.parseDouble(value.get(5));
    }

    @Override
    public Product makeSearchByName(String fieldName) {
        if(name.contains(fieldName)||os.contains(fieldName)){
            return this;
        }
        return null;
    }

    @Override
    public Product makeSearchByValue(double minValue, double maxValue) {
        if((minValue<=battery_capacity && maxValue >=battery_capacity)||
                (minValue<=memoryROM && maxValue >=memoryROM) || (minValue <=systemMemory && maxValue >=systemMemory) ||
                (minValue<=cpu && maxValue >=cpu) || (minValue <= displayInches && maxValue >= displayInches)) {
            return this;
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "Battery capacity = " + battery_capacity + ", " +
                "OS = " + os + ", " +
                "Memory ROM= " + memoryROM+ ", " +
                "System Memory = " + systemMemory + ", " +
                "CPU = " + cpu + ", " +
                "Display Inches = " + displayInches + "."
        );
    }
}
