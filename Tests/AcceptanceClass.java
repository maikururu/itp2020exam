import Exercise.*;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


public class AcceptanceClass {

    //Persons Test

    Program balanceProgram = new Program(Program.Type.Balance);

    Exercise b  = new Balance("Balance", 2, 10, 10, 3, "Jumprope");
    Exercise e = new Endurance("Endurance", 5, 10, 10, 3, "Running shoes");
    Exercise f = new Flexibility("Flexibility", 3, 10, 10, 3, "Tights");
    Exercise s = new Strength("Strength", 7, 10, 10, 3, 60, "Dumbells");

    Person person1 = new Person("Kari",5, Program.Type.Balance);


    @Test
    public void testPreferredType() {
        boolean isPreferredType = person1.isPreferredType(balanceProgram);

        assertTrue(isPreferredType);
    }

    @Test
    public void testAcceptableIntensity() {
        //Testing intensity around person1's preferred intensity
        for(int intensity = 7; intensity >= 3; intensity--) {
            balanceProgram.setIntensityLevel(intensity);
            boolean isAcceptableIntensity = person1.acceptableIntensity(balanceProgram);

            if(intensity > 6 || intensity < 4) {
                //Test below and above accepted intensity
                assertFalse(isAcceptableIntensity);
                System.out.println("Intensity: "+ intensity + " is out of acceptable range, of person preferred intensity: "+ person1.getPreferredIntensity());
            } else {
                //Test accepted intensity
                assertTrue(isAcceptableIntensity);
                System.out.println("Intensity: "+ intensity + " is withing acceptable range, of person preferred intensity: "+ person1.getPreferredIntensity());
            }
        }
    }

    // Program tests
    @Test
    public void testUpdateMaxIntensityLevel() {
        balanceProgram.setIntensityLevel(5);
        // Test if unable to update intensity level with a lower intensity than set
        balanceProgram.updateMaxIntensityLevel(4);
        assertTrue(balanceProgram.getIntensityLevel() == 5);

        // Test if unable to update intensity level with same intensity set
        balanceProgram.updateMaxIntensityLevel(5);
        assertTrue(balanceProgram.getIntensityLevel() == 5);

        // Test if able to update intensity level when a higher intensity is set
        balanceProgram.updateMaxIntensityLevel(6);
        assertTrue(balanceProgram.getIntensityLevel() > 5);
    }

    @Test
    public void testProgramIsBalanced() {

        balanceProgram.addExercise(b);
        balanceProgram.addExercise(e);

        // Test if program is not balanced
        assertFalse(balanceProgram.getBalanced());

        balanceProgram.addExercise(f);
        balanceProgram.addExercise(s);

        // Test if program is balanced
        assertTrue(balanceProgram.getBalanced());

        // Fresh start
        balanceProgram = new Program(Program.Type.Balance);

        balanceProgram.addExercise(e);
        balanceProgram.addExercise(e);
        balanceProgram.addExercise(e);
        balanceProgram.addExercise(e);

        // Test if repetitive exercise program is not balanced
        assertFalse(balanceProgram.getBalanced());
    }

    @Test
    public void testSortedExercises() {
        balanceProgram = new Program(Program.Type.Balance);

        balanceProgram.addExercise(b);
        balanceProgram.addExercise(e);
        balanceProgram.addExercise(f);
        balanceProgram.addExercise(s);
        List<Exercise> exercises = balanceProgram.exercises;

        boolean isSorted = true;

        for(int i = 0; i < balanceProgram.exercises.size()-1; i++) {
            isSorted = exercises.get(i).intensity < exercises.get(i+1).intensity;
            if(!isSorted) {
                System.out.println("List is not sorted.");
                break;
            }

        }

        assertTrue(isSorted);
        System.out.println("List is sorted.");


    }



    //ExerciseManager Tests
    ExerciseManager manager = new ExerciseManager();



}
