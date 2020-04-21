import org.junit.Test;
import static org.junit.Assert.*;

public class AcceptanceClass {

    //Persons Test

    Program balanceProgram = new Program(Program.Type.Balance);

    Person person1 = new Person("Kari",5, Program.Type.Balance);


    @Test
    public void testPreferredType() {
        boolean isPreferredType = person1.isPreferredType(balanceProgram);

        assertTrue(isPreferredType);
    }

    @Test
    public void testAcceptanceIntensity() {
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

    //ExerciseManager Tests
    ExerciseManager manager = new ExerciseManager();


}
