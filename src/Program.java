import Exercise.*;

import java.lang.invoke.SwitchPoint;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public enum Type {Balance, Endurance, Flexibility, Strength}
    public List<Exercise> exercises = new ArrayList<Exercise>();
    public Type programType;
    public int duration;
    public int intensityLevel;
    public boolean isBalancedProgram;

    public Program(Type _programType) {
        setProgramType(_programType);
    }

    private void updateProgram(int _exerciseIntensity, int _exerciseDuration) {
        updateMaxIntensityLevel(_exerciseIntensity);
        updateDuration(_exerciseDuration);

        sortExercisesByIntensity();
        updateBalancedProgram();
    }

    public String toString() {
        return String.format("\n=================\n" +
                " Duration: %s \n Intensity: %s \n Balanced: %s \n Program Exercises: %s", getDuration(), getIntensityLevel(), getBalanced(), getExercises());
    }

    //Setter and getter for programType
    public Type getProgramType() {
        return programType;
    }

    public void setProgramType(Type _programType) {
        this.programType = _programType;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    //Method collection to set intensity
    //-----------------------------------------------------------//
    public void setIntensityLevel(int _intensityLevel) {
        this.intensityLevel = _intensityLevel;
    }

    public void updateMaxIntensityLevel(int _intensityLevel) {
        if(_intensityLevel > this.intensityLevel)
            this.setIntensityLevel(_intensityLevel);
    }

    //-----------------------------------------------------------//

    public int getIntensityLevel() {
        return intensityLevel;
    }

    //Method collection to add type of exercises to exercises array
    //-----------------------------------------------------------//
    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
        updateProgram(exercise.intensity, exercise.duration);
    }

    //-----------------------------------------------------------//

    public List<Exercise> getExercises() {
        return exercises;
    }

    //Methods to check if Program is balanced
    //-----------------------------------------------------------//
    public boolean getBalanced(){
        return this.isBalancedProgram;
    }

    public void setBalancedProgram(boolean balanced) {
        isBalancedProgram = balanced;
    }

    public void updateBalancedProgram(){
        boolean hasBalance = false,
                hasEndurance = false,
                hasFlexibility = false,
                hasStrength = false;

        for(Exercise exercise : exercises) {
            String classType = exercise.getClass().getName();

            switch (classType) {
                case "Exercise.Balance":
                    hasBalance = true;
                    break;
                case "Exercise.Endurance":
                    hasEndurance = true;
                    break;
                case "Exercise.Flexibility":
                    hasFlexibility = true;
                    break;
                case "Exercise.Strength":
                    hasStrength = true;
                    break;
            }
        }

        if(hasBalance && hasEndurance && hasFlexibility && hasStrength){
            this.isBalancedProgram = true;
        } else  {
            this.isBalancedProgram = false;
        }
    }
    //-----------------------------------------------------------//


    //Method to sort exercises ArrayList by increasing intensity
    public void sortExercisesByIntensity() {
        Collections.sort(exercises);
    }

    //Method to update Program.duration
    public void updateDuration(int _exerciseDuration) {

        if(_exerciseDuration <= 0) {
            System.out.println("Exercise duration can not be 0 or less.");
            return;
        }
        this.duration += _exerciseDuration * 2;

    }
}
