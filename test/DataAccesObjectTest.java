
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

    
}
