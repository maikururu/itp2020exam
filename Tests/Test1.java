import org.junit.Test;
import Exercise.*;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertTrue;

public class Test1 {
    // Unit test?
    @Test
    public void testGetEquipment() {
        Balance b1 = new Balance("Atomic Situps", 3, 20, 30, 5, "Floor");

        assertTrue(b1.getEquipment() == "Floor");

    }

    @Test
    public void testToString() {

    }
}
