package product;

import java.util.List;

public class TabletPC implements Product {
    private String name;
    private Integer battery_capacity;
    private Integer display_inches;
    private Integer memory_rom;
    private Integer flash_memory_capacity;
    private String color;

    public TabletPC() {};

    public TabletPC(List<String> value) {
        name = "Laptop";
        battery_capacity = Integer.parseInt(value.get(0));
        display_inches = Integer.parseInt(value.get(1));
        memory_rom = Integer.parseInt(value.get(2));
        flash_memory_capacity = Integer.parseInt(value.get(3));
        color = value.get(4);
    }

    @Override
    public Product makeSearchByName(String fieldName) {
        if (name.contains(fieldName) || color.contains(fieldName)) {
            return this;
        }
        return null;
    }

    @Override
    public Product makeSearchByValue(double minValue, double maxValue) {
        if ((minValue <= battery_capacity && maxValue >= battery_capacity) ||
                (minValue <= memory_rom && maxValue >= memory_rom) || (minValue <= display_inches && maxValue >= display_inches) ||
                (minValue <= flash_memory_capacity && maxValue >= flash_memory_capacity)) {
            return this;
        }
        return null;
    }

    @Override
    public void printProductInfo() {
        System.out.println(name + ": " +
                "Battery capacity = " + battery_capacity + ", " +
                "Display_Inches = " + display_inches + ", " +
                "Memory ROM= " + memory_rom + ", " +
                "Flash_memory_capacity = " + flash_memory_capacity + ", " +
                "Color = " + color + "."
        );
    }
}
