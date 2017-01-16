
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

    public DataAccessObject() throws Exception {
        this.conn = new DBConnector();
    }
    
    public ArrayList<Product> getProducts() {

        Product product = null;
        ArrayList<Product> products = null;
        try {
            
            Statement stmt = conn.getConnection().createStatement();
            String sql = "SELECT * FROM online_shop.elektronik";
            products = new ArrayList<Product>();
            ResultSet rs = stmt.executeQuery(sql);
           
            while (rs.next()) {
                String name = rs.getString("Pname");
                int price = rs.getInt("Pprice");
                product = new Product(name, price);
                products.add(product);

            }
        } catch (Exception ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }
    
    
    
}
