import Exercise.*;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name = "Unknown";
    public Program.Type preferredType;
    public Exercise preferredExercise;
    public int preferredIntensity;
    Program currentProgram;

    public Person(String _name, int _preferredIntensity, Program.Type _preferredExerciseType) {
        setName(_name);
        setPreferredExerciseType(_preferredExerciseType);
        setPreferredIntensity(_preferredIntensity);
    }

    @Override
    public String toString() {
        return "Person{" +
                "\n preferredExerciseType: '" + preferredType + '\'' +
                ",\n preferredExercise: " + preferredExercise +
                ",\n preferredIntensity:" + preferredIntensity +
                ",\n currentProgram: " + currentProgram +
                "\n}";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCurrentProgram(Program newProgram) {
        this.currentProgram = newProgram;
    }

    public Program getCurrentProgram() {
        return this.currentProgram;
    }

    public void setPreferredExerciseType(Program.Type _type){
        this.preferredType = _type;
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

    // Method that gets a list of programs, and selects a program that is within the preferred requirements.
    public void selectPreferred(List<Program> _programs) {
        // loops through given programs
        for (Program program : _programs) {
            if(acceptableProgram(program)) {
                // set as current program, if acceptable.
                this.setCurrentProgram(program);
                break;
            }
        }
    }

    // Method that gives back a bool depending on if the program meats the requirements of intensity and type.
    public boolean acceptableProgram(Program _program) {
        if(acceptableIntensity(_program) && isPreferredType(_program)) {
            return true;
        }

        return  false;
    }

    // Returns a bool if program is acceptable according to preferredIntensity
    public boolean acceptableIntensity(Program program){
        // Create variable that stores program intensity
        int pIntensity = program.getIntensityLevel();

        // Checks if program intensity is within acceptable range
        if (pIntensity >= this.preferredIntensity - (10 * 0.1) && pIntensity <= this.preferredIntensity + (10 * 0.1)) {
            //if program is withing acceptable range - return true
            return true;
        }

        //if program is outside acceptable range - return false
        return false;
    }


    // Returns a bool if program type is of preferredProgramType
    public boolean isPreferredType(Program _program){
        if(this.preferredType.equals(_program.programType)){
            return true;
        }

        return false;
    }
}