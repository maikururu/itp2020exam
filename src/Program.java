import Exercise.*;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public List<Exercise> exercises = new ArrayList<Exercise>();
    public int duration;
    public int intensityLevel;
    public boolean isBalanced;

    public Program() {}

    private void updateProgram(int _exerciseIntensity, int _exerciseDuration) {
        setIntensityLevel(_exerciseIntensity);
        updateDuration(_exerciseDuration);

        sortExercisesByIntensity();
        updateBalance();
    }

    public String toString() {
        return String.format("\n=================\n" +
                " Duration: %s \n Intensity: %s \n Balanced: %s \n Program Exercises: %s", getDuration(), getIntensityLevel(), getBalanced(), getExercises());
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
        if(_intensityLevel > this.intensityLevel)
            this.intensityLevel = _intensityLevel;
    }

    //-----------------------------------------------------------//

    public int getIntensityLevel() {
        return intensityLevel;
    }

    //Method collection to add type of exercises to exercises array
    //-----------------------------------------------------------//
    public void addExercise(Balance exercise){
        this.exercises.add(exercise);
        updateProgram(exercise.intensity, exercise.duration);
    }

    public void addExercise(Endurance exercise){
        this.exercises.add(exercise);
        updateProgram(exercise.intensity, exercise.duration);
    }

    public void addExercise(Flexibility exercise){
        this.exercises.add(exercise);
        updateProgram(exercise.intensity, exercise.duration);
    }

    public void addExercise(Strength exercise){
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
        return this.isBalanced;
    }

    public void setBalanced(boolean balanced) {
        isBalanced = balanced;
    }

    public void updateBalance(){
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
            this.isBalanced = true;
        } else  {
            this.isBalanced = false;
        }
    }
    //-----------------------------------------------------------//


    //Method to sort exercises ArrayList by increasing intensity
    public void sortExercisesByIntensity() {
        Collections.sort(exercises);
    }

    //Method to update Program.duration
    private void updateDuration(int _exerciseDuration) {
       this.duration += _exerciseDuration * 2;
    }
}
