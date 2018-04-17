package parse_products;

import product.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductParser {
    public List<Product> productsList = new ArrayList<>();

    public void readAllProduct(){

        String[] productArray;
        String currentLine;
        String fileNAme = "products.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNAme));
            while ((currentLine=bufferedReader.readLine())!=null){
                if(!currentLine.equals("")){
                    productArray = currentLine.split("[,:;]");
                    Product product = getTypeOfProduct(productArray);
                    productsList.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Product getTypeOfProduct(String[] productArray) {
        List<String> values = new ArrayList<>();
        for (int i = 1; i < productArray.length;i++){
            String[] productValues;
            productValues = productArray[i].trim().split("=");
            values.add(productValues[1]);
        }
        switch (productArray[0]){
            case "Oven":
                return new Oven(values);
            case "Laptop":
                return new Laptop(values);
            case "Refrigerator":
                return new Refrigerator(values);
            case "Speakers":
                return new Speakers(values);
            case "Newspaper":
                return new Newspaper(values);
            case "TabletPC":
                return new TabletPC(values);
            case "TextBook":
                return new TextBook(values);
            case "VacuumCleaner":
                return new VacuumCleaner(values);
            default:
                throw  new IllegalArgumentException("Invalid product " + productArray[0]);
        }
    }
    public void search(String s){
        List<Product> searchResult = new ArrayList<Product>();
        System.out.println("Search results: ");
        for (Product product:productsList ){
            Product result = product.makeSearchByName(s);
            if(result!=null){
                searchResult.add(result);
            }
        }
        displayInfo(searchResult);
    }

    public void search(double min, double max){
        List<Product> products = new ArrayList<Product>();
        System.out.println("Search results: ");
        for (Product product: productsList){
            Product result = product.makeSearchByValue(min,max);
            if(result!=null){
                products.add(result);
            }
        }
        displayInfo(products);
    }
    public void displayInfo(List<Product> list){
        for (Product product: list){
            product.printProductInfo();
        }
    }




}
