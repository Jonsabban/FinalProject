package Data;


import Logic.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObject {

    private final DBConnector conn;
    ArrayList<Product> products = new ArrayList<Product>();

    public DataAccessObject() throws Exception {
        this.conn = new DBConnector();
    }
    
        public Product addProduct(String productName) {
        
        Product product = null;
        try {
            Statement stmt = conn.getConnection().createStatement();
            String sql = "SELECT * FROM elektronik where Pname = "  + "'" + productName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String name = rs.getString("Pname");
                int price = rs.getInt("Pprice");
                product = new Product(name, price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        products.add(product);

        return product;
    }
         
    
    public ArrayList<Product> getMoreProducts() {

        return products;
    }
    
 public void removeProduct(String productName) {

        for (Product product : products) {
            if (product.getName() != null && product.getName().contains(productName)) {
                products.remove(product);
            }

        }

    }

    
}
