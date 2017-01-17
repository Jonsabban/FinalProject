
import Data.DataAccessObject;
import Logic.Product;
import Logic.ShoppingCart;
import java.util.Collection;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataAccesObjectTest {

    private static DataAccessObject dao;

    public DataAccesObjectTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        dao = new DataAccessObject();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddProduct() {

        ShoppingCart sc = new ShoppingCart();
        sc.addProduct("Apple", 10);
        Collection<Product> allProducts = sc.getAllProducts();
        assertEquals(allProducts.size(), 1);
        for (Product product : allProducts) {
            assertEquals(product.getName(), "Apple");
            assertEquals(product.getPrice(), 10);

        }

    }

    @Test
    public void testAddMoreProducts() {

        ShoppingCart sc = new ShoppingCart();
        sc.addProduct("Apple", 10);
        sc.addProduct("Banana", 20);
        sc.addProduct("Pear", 30);
        Collection<Product> allProducts = sc.getAllProducts();
        Iterator<Product> it = allProducts.iterator();
        assertTrue(it.hasNext());
        Product a = it.next();
        assertTrue(it.hasNext());
        Product b = it.next();
        assertTrue(it.hasNext());
        Product c = it.next();

        assertEquals(a.getName(), "Apple");
        assertEquals(a.getPrice(), 10);
        assertEquals(b.getName(), "Banana");
        assertEquals(b.getPrice(), 20);
        assertEquals(c.getName(), "Pear");
        assertEquals(c.getPrice(), 30);

    }

    @Test
    public void testGetProductDB() {
        Product product = dao.addProduct("Apple Watch");
        assertNotNull(product);
        assertEquals(product.getName(), "Apple Watch");
        assertEquals(product.getPrice(), 2400);
    }

    @Test
    public void tesGetdMoreProductsDB() {

        dao.addProduct("Apple Watch");
        dao.addProduct("iMac");
        dao.addProduct("MacBook Pro");
        Collection<Product> allProducts = dao.getAllProducts();
        Iterator<Product> it = allProducts.iterator();
        assertTrue(it.hasNext());
        Product a = it.next();
        assertTrue(it.hasNext());
        Product b = it.next();
        assertTrue(it.hasNext());
        Product c = it.next();

        assertNotNull(allProducts);
        assertEquals(allProducts.size(), 3);
        assertEquals(a.getName(), "Apple Watch");
        assertEquals(a.getPrice(), 2400);
        assertEquals(b.getName(), "iMac");
        assertEquals(b.getPrice(), 10000);
        assertEquals(c.getName(), "MacBook Pro");
        assertEquals(c.getPrice(), 13000);

    }

    @Test
    public void testRemoveProduct() {
        dao.addProduct("Apple Watch");
        dao.addProduct("iMac");
        dao.addProduct("MacBook Pro");
        Collection<Product> allProducts = dao.getAllProducts();
        assertEquals(allProducts.size(), 3);

        dao.removeProduct("iMac");
        assertEquals(allProducts.size(), 2);

    }

    @Test
    public void testGetTotal() {
        dao.addProduct("Apple Watch");
        dao.addProduct("iMac");
        dao.addProduct("MacBook Pro");
        Collection<Product> allProducts = dao.getAllProducts();
        assertEquals(allProducts.size(), 3);

        int total = dao.getTotal();

        assertEquals(total, 25400);

    }

    @Test
    public void testSortProductsByName() {
        dao.addProduct("iMac");
        dao.addProduct("MacBook Pro");
        dao.addProduct("Apple Watch");
        Collection<Product> allProducts = dao.getAllProducts();
        assertEquals(allProducts.size(), 3);
        
        dao.sortProductsByName();
        
        
        
        Iterator<Product> it = allProducts.iterator();
        assertTrue(it.hasNext());
        Product a = it.next();
        assertTrue(it.hasNext());
        Product b = it.next();
        assertTrue(it.hasNext());
        Product c = it.next();
        
        System.out.println(allProducts);
        System.out.println(a.getName());
        System.out.println(b.getName());
        System.out.println(c.getName());
        
        assertEquals("Apple Watch", a.getName());
        assertEquals("iMac", b.getName());
        assertEquals("MacBook Pro", c.getName());
    }
}
