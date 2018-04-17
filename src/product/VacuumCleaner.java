package product;

import java.util.List;

public class VacuumCleaner implements Product{
    private String name;
    private Integer power_consumption;
    private String filter_type;
    private String bag_type;
    private String wand_type;
    private Integer motor_speed_regulation;
    private Double cleaning_width;

    public VacuumCleaner(){};
    public VacuumCleaner(List<String> value){
        name = "VacuumCleaner";
        power_consumption = Integer.parseInt(value.get(0));
        filter_type = value.get(1);
        bag_type = value.get(2);
        wand_type = value.get(3);
        motor_speed_regulation = Integer.parseInt(value.get(4));
        cleaning_width = Double.parseDouble(value.get(5));
    }

    @Override
    public Product makeSearchByName(String fieldName) {
        if(name.contains(fieldName)||filter_type.contains(fieldName)||bag_type.contains(fieldName)||wand_type.contains(fieldName)){
            return this;
        }
        return null;
    }

    @Override
    public Product makeSearchByValue(double minValue, double maxValue) {
        if((minValue<=power_consumption && maxValue >=power_consumption)||
                (minValue<=motor_speed_regulation && maxValue >=motor_speed_regulation) || (minValue <=cleaning_width && maxValue >=cleaning_width)) {
            return this;
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "Power_Comsumption = " + power_consumption + ", " +
                "Filter_Type = " + filter_type + ", " +
                "Bag_Type= " + bag_type+ ", " +
                "Motor_Speed_Regulation = " + motor_speed_regulation + ", " +
                "Cleaning_Width = " + cleaning_width + "."
        );
    }
}

