import parse_products.ProductParser;
import product.Product;



public class ProductRunner {
    public static void main(String [] args){

        ProductParser productParser = new ProductParser();
        productParser.readAllProduct();
        productParser.search("TextBook");
        productParser.search(32,33);
    }
}
