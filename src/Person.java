import Exercise.*;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String preferredExerciseType = "";
    public Exercise preferredExercise;
    public int preferredIntensity;
    Program currentProgram;
    public List<Program> acceptableProgramsList = new ArrayList<Program>();

    public Person(int _preferredIntensity, String _preferredExerciseType) {
        setPreferredExerciseType(_preferredExerciseType);
        setPreferredIntensity(_preferredIntensity);
    }

    @Override
    public String toString() {
        return "Person{" +
                "\n preferredExerciseType: '" + preferredExerciseType + '\'' +
                ",\n preferredExercise: " + preferredExercise +
                ",\n preferredIntensity:" + preferredIntensity +
                ",\n currentProgram: " + currentProgram +
                ",\n acceptableProgramsList: " + acceptableProgramsList +
                "\n}";
    }

    public void setCurrentProgram(Program newProgram) {
        this.currentProgram = newProgram;
    }

    public Program getCurrentProgram() {
        return this.currentProgram;
    }

    public void setPreferredExerciseType(String _type){
        this.preferredExerciseType = _type;
    }

    public void setPreferredExercise(Exercise _exercise) {
        this.preferredExercise = _exercise;
    }

    public Exercise getPreferredExercise() {
        return this.preferredExercise;
    }

    public void setPreferredIntensity(int preferredIntensity) {
        this.preferredIntensity = preferredIntensity;
    }

    public int getPreferredIntensity() {
        return this.preferredIntensity;
    }

    //Method to add new program, if it is acceptable, set it as the current program.
    public void addNewProgram(Program _program){
        boolean acceptableIntensity = acceptableProgramIntensity(_program);
        boolean preferredType = isPreferredType(_program);

        System.out.println("ACCEPTABLE INTENSITY:::" + acceptableIntensity);
        System.out.println("PREFERRED TYPE:::"+preferredType);

        if(acceptableIntensity && preferredType) {
            setCurrentProgram(_program);
        }
    }

    //TODO
    // Rip out adding the program to the acceptableProgramList
    // And make that it's own method.

    // Checks if program is acceptable according to preferredIntensity
    public boolean acceptableProgramIntensity(Program program){
        // Create variable that stores program intensity
        int pIntensity = program.getIntensityLevel();

        // Checks if program intensity is within acceptable range
        if (pIntensity >= this.preferredIntensity - (10 * 0.1) && pIntensity <= this.preferredIntensity + (10 * 0.1)) {
            // boolean that states if program is already in acceptableProgramsList
            boolean isInList = false;

            // loops through the acceptableProgramsList to check if program is already in list
            for (Program acceptableProgram : acceptableProgramsList){
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

    //Method to check if program type is of preferredProgramType
    public boolean isPreferredType(Program _program){
        if(this.preferredExerciseType.equals(_program.programType)){
            return true;
        }

        return false;
    }


    //TODO
    // Move selectPreferred method over to main (ExerciseManager) and refactor

    // method to check if persons preferred exercise exists or not, disregarding acceptable intensity level
    public void selectPreferred(Program[] programs){

        // if preferredExerciseName is not set - return (stop method execution)
        if (this.preferredExerciseType.equals("")) {
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
                if (exercise.name.equals(this.preferredExerciseType)){
                    // if preferredExercise exists - store exercise
                    this.preferredExercise = exercise;
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