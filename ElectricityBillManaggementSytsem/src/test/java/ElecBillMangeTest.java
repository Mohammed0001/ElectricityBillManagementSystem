import mms.electricitybillmanaggementsytsem.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mabou
 */
public class ElecBillMangeTest {
    //create bill   
    @Test
    public void createBillTest() {
        int MeterReading = 200; // test meter reading
        int customerId = 2; // an already inserted customer
        ElectricityUsage Eusage = new ElectricityUsage(MeterReading);
        boolean actualResult = Eusage.generateUsage(customerId); // to generate the usgae for the customer
        assertTrue(actualResult);
    }
    //payment
    @Test
    public void payBillTest() {
        System.out.println("ElecBillMangeTest.hello()");
        assertTrue(true);
    }
    //
    
    @Test
    public void hello() {
        System.out.println("ElecBillMangeTest.hello()");
        assertTrue(true);
    }
}
