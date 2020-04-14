import Exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public Exercise preferredExercise;
    public String preferredExerciseName = "";
    public int acceptableIntensity;
    Program currentProgram;
    public List<Program> acceptableProgramsList = new ArrayList<Program>();

    @Override
    public String toString() {
        return "Person{" +
                "preferredExercise=" + preferredExercise +
                ", preferredExerciseName='" + preferredExerciseName + '\'' +
                ", acceptableIntensity=" + acceptableIntensity +
                ", currentProgram=" + currentProgram +
                ", acceptableProgramsList=" + acceptableProgramsList +
                '}';
    }

    public void setCurrentProgram(Program newProgram) {
        this.currentProgram = newProgram;
    }

    public Program getCurrentProgram() {
        return currentProgram;
    }

    public void setPreferredExercise(Exercise type) {
        preferredExercise = type;
    }

    public Exercise getPreferredExercise() {
        return preferredExercise;
    }

    public void setAcceptableIntensity(int acceptableIntensity) {
        this.acceptableIntensity = acceptableIntensity;
    }

    public int getAcceptableIntensity() {
        return acceptableIntensity;
    }

    // Checks if program is acceptable according to acceptableIntensity
    public boolean acceptableProgram(Program program){
        // Create variable that stores program intesity
        int pIntensity = program.getIntensityLevel();

        // Checks if program intensity is within acceptable range
        if (pIntensity >= acceptableIntensity * 0.9 && pIntensity <= acceptableIntensity *1.1) {
            // boolean that states if program is already in acceptableProgramsList
            boolean isInList = false;

            // loops through the acceptableProgramsList to check if program is already in list
            for (Program acceptableProgram:acceptableProgramsList){
                // if found program in list
                if (acceptableProgram.equals(program)) {
                    isInList = true;
                    break;
                }
            }

            // if not found in list - add to list
            if (!isInList) {
                acceptableProgramsList.add(program);
            }

            //if program is withing acceptable range - return true
            return true;
        }
        //if program is outside acceptable range - return false
        return false;
    }

    // method to check if persons preferred exercise exists or not, disregarding acceptable intensity level
    public void selectPreferred(Program[] programs){

        // if preferredExerciseName is not set - return (stop method execution)
        if (preferredExerciseName.equals("")) {
            System.out.println("preferredExercise is not set");
            return;
        }
        // boolean determining if preferred exercise exists
        boolean foundPreferredExercise = false;
        // loops through programs
        for (Program program:programs){
            //loops through all exercises within each program
            for (Exercise exercise : program.getExercises()){
                // if persons preferred exercise exists
                if (exercise.name.equals(preferredExerciseName)){
                    // if preferredExercise exists - store exercise
                    preferredExercise = exercise;
                    foundPreferredExercise = true;
                }
            }
        }
        if (foundPreferredExercise){
            System.out.println("Found exercise: " + preferredExercise.name);
        } else {
            System.out.println("Oops. We did not find any exercise with that name!");
        }
    }
}