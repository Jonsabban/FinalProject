package Logic;

import Data.DataAccessObject;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Sanox
 */
public class ShoppingCart {

    ArrayList<Product> product = new ArrayList<Product>();

    public ShoppingCart() {
        try {
            DataAccessObject dao = new DataAccessObject();

        } catch (Exception e) {
            System.out.println("dao fail");
        }
    }

    public void addProduct(String name, int price) {

        Product p = new Product(name, price);
        product.add(p);

    }

    public Collection<Product> getAllProducts() {

        return product;

    }

}
