import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exercise.*;


public class UnitTests {

    ExerciseManager manager = new ExerciseManager();
    Person person = new Person("Kari", 4, Program.Type.Strength);

    Program program = new Program(Program.Type.Strength);

    Exercise e = new Exercise("Exercise", 5, 10, 30, 5);
    Exercise e2 = new Exercise("Exercise 2", 1, 10, 30, 5);

    Endurance endurance = new Endurance("Body weight squats", 3, 5, 30, 3, "None");
    Balance b = new Balance("Atomic Situps", 3, 20, 30, 5, "None");
    Flexibility f = new Flexibility("Standing hamstring stretch", 2, 4, 2, 1, "Warm muscles");
    Strength s = new Strength("Bench press", 5, 3, 10, 3, 30, "Weight bench");

    public UnitTests() {
        program.addExercise(s);
    }

    // Exercise Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void testExerciseClass() {
        Exercise e = new Exercise("Exercise", 5, 10, 30, 5);
        // Testing getName()
        assertEquals(e.getName(), "Exercise");
        // Testing getIntensity()
        assertEquals(e.getIntensity(), 5);
        // Testing getDuration()
        assertEquals(e.getDuration(), 10);
        // Testing getRepetitions
        assertEquals(e.getRepetitions(), 30);
        // Testing getSets()
        assertEquals(e.getSets(), 5);
    }

    @Test
    public void testExerciseToString() {
        String expected =
                "\n=============================\nExercise: \nName = Exercise\nIntensity = '5'\nDuration = 10\nRepetitions = 30\nSets = 5";
        assertEquals(expected, e.toString());
    }

    @Test
    public void testExerciseCompareTo() {
        assertEquals(e.compareTo(e2), 4);

    }

    // Balance Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void testBalanceClass() {
        // Testing getEquipment()
        assertEquals(b.getEquipment(), "None");
    }

    @Test
    public void testBalanceToString() {
        String expected =
                "\n=============================\nExercise: \nName = Atomic Situps\nIntensity = '3'\nDuration = 20\nRepetitions = 30\nSets = 5\nEquipment = None";

        assertEquals(expected, b.toString());
    }

    // Endurance Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void testEnduranceClass() {
        // Testing getEquipment()
        assertEquals(endurance.getEquipment(), "None");

    }

    @Test
    public void testEnduranceToString() {
        String expected =
                "\n=============================\nExercise: \nName = Body weight squats\nIntensity = '3'\nDuration = 5\nRepetitions = 30\nSets = 3\nEquipment = None";

        assertEquals(expected, endurance.toString());
    }


    // Flexibility Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void testFlexibilityClass() {
        // Testing getRequirement()
        assertEquals(f.getRequirement(), "Warm muscles");

    }

    @Test
    public void testFlexibilityToString() {
        String expected =
                "\n=============================\nExercise: \nName = Standing hamstring stretch\nIntensity = '2'\nDuration = 4\nRepetitions = 2\nSets = 1\nRequirement = Warm muscles";

        assertEquals(expected, f.toString());
    }

    // Strength Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void testStrengthClass() {
        // Testing getWeights()
        assertEquals(s.getWeights(), 30);

        // Testing getEquipment
        assertEquals(s.getEquipment(), "Weight bench");

    }

    @Test
    public void testStrengthToString() {
        String expected =
                "\n=============================\nExercise: \nName = Bench press\nIntensity = '5'\nDuration = 3\nRepetitions = 10\nSets = 3\nWeights = 30\nEquipment = Weight bench";

        assertEquals(expected, s.toString());
    }


    //Person Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void testGetName() {
        assertEquals(person.getName(), "Kari");
    }

    @Test
    public void testGetCurrentProgram() {
        person.setCurrentProgram(program);

        assertEquals(person.getCurrentProgram(), program);
    }

    @Test
    public void testGetPreferredExerciseType() {
        assertEquals(person.getPreferredExerciseType(), Program.Type.Strength);
    }

    @Test
    public void testGetPreferredIntensity() {
        assertEquals(person.getPreferredIntensity(), 4);
    }

    @Test
    public void testAcceptableProgram() {
        assertTrue(person.acceptableProgram(program));
    }

    @Test
    public void testAcceptableIntensity() {
        assertTrue(person.acceptableProgram(program));
    }

    @Test
    public void testIsPreferredType() {
        assertTrue(person.isPreferredType(program));
    }

    //Program Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void getProgramType() {
        assertEquals(program.getProgramType(), Program.Type.Strength);
    }

    @Test
    public void testGetDuration() {
        assertEquals(program.getDuration(), 6);
    }

    @Test
    public void testGetIntensityLevel() {
        assertEquals(program.getIntensityLevel(), 5);
    }

    @Test
    public void testGetExercises() {
        List<Exercise> programExercises = program.getExercises();
        assertEquals(programExercises.size(), 1);
    }

    @Test
    public void testGetBalanced() {
        assertFalse(program.getBalanced());
    }

    @Test
    public void testUpdateMaxIntensityLevel() {
        program.setIntensityLevel(5);

        // Test if unable to update intensity level with a lower intensity than set
        program.updateMaxIntensityLevel(4);
        assertEquals(program.getIntensityLevel(), 5);

        // Test if unable to update intensity level with same intensity set
        program.updateMaxIntensityLevel(5);
        assertEquals(program.getIntensityLevel(), 5);

        // Test if able to update intensity level when a higher intensity is set
        program.updateMaxIntensityLevel(6);
        assertTrue(program.getIntensityLevel() > 5);
    }

    @Test
    public void testUpdateProgram() {
        program = new Program(Program.Type.Strength);

        assertEquals(program.getIntensityLevel(), 0);
        assertEquals(program.getDuration(), 0);
        assertFalse(program.getBalanced());

        program.addExercise(s);
        program.addExercise(b);

        assertEquals(program.getIntensityLevel(), 5);
        assertEquals(program.getDuration(), 46);

        assertEquals(program.getExercises().get(0), b);
        assertEquals(program.getExercises().get(1), s);

        program.addExercise(endurance);
        program.addExercise(f);

        assertTrue(program.getBalanced());
    }

    // ExerciseManager Tests
    /*------------------------------------------------------------------------------------------------------------------*/
    @Test
    public void testIsAppropriate() {
        program = new Program(Program.Type.Strength);


        // Test if program does not meet requirements of persons preferred exercise type and intensity
        program.addExercise(f);
        assertFalse(manager.isAppropriate(program, person));

        // Test if program meets requirements of persons preferred exercise type and intensity
        program.addExercise(e);
        assertTrue(manager.isAppropriate(program, person));
    }

    @Test
    public void testRecommendProgram() {
        List<Program> programList = new ArrayList<>();

        program = new Program(Program.Type.Strength);
        Program enduranceProgram = new Program(Program.Type.Endurance);
        Program flexibilityProgram = new Program(Program.Type.Flexibility);

        // Add exercises we know will meet the preferred requirements
        program.addExercise(b);
        program.addExercise(e);

        programList.add(program);
        programList.add(enduranceProgram);
        programList.add(flexibilityProgram);

        List<Program> recommendedList = manager.recommendPrograms(programList, person);

        for(Program program : recommendedList) {
            System.out.println("Program "+ program.getProgramType() +" met the preferred person requirements of "+ person.getName());

            assertTrue(person.acceptableProgram(program));
        }
    }

    @Test
    public void testBuildProgramBalance() {
        manager = new ExerciseManager();

        String testInput = "1";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        manager.buildProgram(scanner);

        System.setIn(stdin);

        assertEquals(manager.programs.size(), 1);
        assertEquals(manager.programs.get(0).getProgramType(), Program.Type.Balance);
    }

    @Test
    public void testBuildProgramEndurance() {
        manager = new ExerciseManager();

        String testInput = "2";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        manager.buildProgram(scanner);

        System.setIn(stdin);

        assertEquals(manager.programs.size(), 1);
        assertEquals(manager.programs.get(0).getProgramType(), Program.Type.Endurance);
    }

    @Test
    public void testBuildProgramFlexibility() {
        manager = new ExerciseManager();

        String testInput = "3";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        manager.buildProgram(scanner);

        System.setIn(stdin);

        assertEquals(manager.programs.size(), 1);
        assertEquals(manager.programs.get(0).getProgramType(), Program.Type.Flexibility);
    }

    @Test
    public void testBuildProgramStrength() {
        manager = new ExerciseManager();

        String testInput = "4";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        manager.buildProgram(scanner);

        System.setIn(stdin);

        assertEquals(manager.programs.size(), 1);
        assertEquals(manager.programs.get(0).getProgramType(), Program.Type.Strength);
    }

    @Test
    public void testBuildProgramQ() {
        manager = new ExerciseManager();

        String testInput = "q";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        manager.buildProgram(scanner);

        System.setIn(stdin);

        assertEquals(manager.programs.size(), 0);
    }

    @Test
    public void testBuildProgramExit() {
        manager = new ExerciseManager();

        String testInput = "exit";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        manager.buildProgram(scanner);

        System.setIn(stdin);

        assertEquals(manager.programs.size(), 0);
    }

    @Test
    public void testBuildProgramNothing() {
        manager = new ExerciseManager();

        String testInput = "\n";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        manager.buildProgram(scanner);

        System.setIn(stdin);

        assertEquals(manager.programs.size(), 0);
    }
}
