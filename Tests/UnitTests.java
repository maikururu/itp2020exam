import org.junit.Test;
import Exercise.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTests {

    // Balance class
    @Test
    public void testBalanceClass() {
        Balance b = new Balance("Atomic Situps", 3, 20, 30, 5, "None");
        // Testing getEquipment()
        assertEquals(b.getEquipment(),"None");

    }

    @Test
    public void testBalanceToString() {
        Balance b = new Balance("Atomic Situps", 3, 20, 30, 5, "None");
        String expected =
                "\n=============================\nExercise: \nName = Atomic Situps\nIntensity = '3'\nDuration = 20\nRepetitions = 30\nSets = 5\nEquipment = None";

        assertEquals(expected, b.toString());
    }

    // Endurance class
    @Test
    public void testEnduranceClass() {
        Endurance e = new Endurance("Body weight squats", 3, 5, 30, 3, "None");
        // Testing getEquipment()
        assertEquals(e.getEquipment(),"None");

    }

    @Test
    public void testEnduranceToString() {
        Endurance e = new Endurance("Body weight squats", 3, 5, 30, 3, "None");
        String expected =
                "\n=============================\nExercise: \nName = Body weight squats\nIntensity = '3'\nDuration = 5\nRepetitions = 30\nSets = 3\nEquipment = None";

        assertEquals(expected, e.toString());
    }

    // Flexibility class
    @Test
    public void testFlexibilityClass() {
        Flexibility f = new Flexibility("Standing hamstring stretch", 3, 4, 2, 1, "Warm muscles");
        // Testing getRequirement()
        assertEquals(f.getRequirement(),"Warm muscles");

    }

    @Test
    public void testFlexibilityToString() {
        Flexibility f = new Flexibility("Standing hamstring stretch", 3, 4, 2, 1, "Warm muscles");
        String expected =
                "\n=============================\nExercise: \nName = Standing hamstring stretch\nIntensity = '3'\nDuration = 4\nRepetitions = 2\nSets = 1\nRequirement = Warm muscles";

        assertEquals(expected, f.toString());
    }

    // Strength class
    @Test
    public void testStrengthClass() {
        Strength s = new Strength("Bench press", 5, 3, 10, 3, 30, "Weight bench");
        // Testing getWeights()
        assertEquals(s.getWeights(),30);

        // Testing getEquipment
        assertEquals(s.getEquipment(), "Weight bench");

    }

    @Test
    public void testStrengthToString() {
        Strength s = new Strength("Bench press", 5, 3, 10, 3, 30, "Weight bench");
        String expected =
                "\n=============================\nExercise: \nName = Bench press\nIntensity = '5'\nDuration = 3\nRepetitions = 10\nSets = 3\nWeights = 30\nEquipment = Weight bench";

        assertEquals(expected, s.toString());
    }





}
