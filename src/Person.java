import Exercise.Endurance;
import Exercise.Flexibility;
import Exercise.Strength;

public class Person {
    public enum preferredExercise {
        Balance,
        Endurance,
        Flexibility,
        Strength
    }

    public int acceptableIntensity;
    public Program currentProgram;

    public void setAcceptableIntensity(int acceptableIntensity) {
        this.acceptableIntensity = acceptableIntensity;
    }
}
