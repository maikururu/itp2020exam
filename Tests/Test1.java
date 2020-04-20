import org.junit.Test;
import Exercise.*;

import static org.junit.Assert.assertTrue;

public class Test1 {
    @Test
    public void testGetEquipment() {
        Balance b1 = new Balance("Balanse", 10, 9, 8, 7, "Legs");

        assertTrue(b1.getEquipment() == "Legs");

    }
}
