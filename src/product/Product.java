package product;

public interface Product {
    Product makeSearchByName(String fieldName);
    Product makeSearchByValue(double minValue, double maxValue);
    void printProductInfo();
}
