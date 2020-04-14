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

    public Program(int _duration) {
        setDuration(_duration);
        //setIntensityLevel(_intensity);

        //addExercise(exercises);
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
    public void setIntensityLevel(int intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    public void setIntensityLevel(Balance exercise){
        if(exercise.intensity > this.intensityLevel)
            this.setIntensityLevel(exercise.intensity);
    }

    public void setIntensityLevel(Endurance exercise){
        if(exercise.intensity > this.intensityLevel)
            this.setIntensityLevel(exercise.intensity);
    }

    public void setIntensityLevel(Strength exercise){
        if(exercise.intensity > this.intensityLevel)
            this.setIntensityLevel(exercise.intensity);
    }

    public void setIntensityLevel(Flexibility exercise){
        if(exercise.intensity > this.intensityLevel)
            this.setIntensityLevel(exercise.intensity);
    }
    //-----------------------------------------------------------//

    public int getIntensityLevel() {
        return intensityLevel;
    }

    //Method collection to add type of exercises to exercises array
    //-----------------------------------------------------------//
    public void addExercise(Balance exercise){
        this.exercises.add(exercise);
        setIntensityLevel(exercise);
        sortExercisesByIntensity();
        updateBalance();
    }

    public void addExercise(Endurance exercise){
        this.exercises.add(exercise);
        setIntensityLevel(exercise);
        sortExercisesByIntensity();
        updateBalance();
    }

    public void addExercise(Flexibility exercise){
        this.exercises.add(exercise);
        setIntensityLevel(exercise);
        sortExercisesByIntensity();
        updateBalance();
    }

    public void addExercise(Strength exercise){
        this.exercises.add(exercise);
        setIntensityLevel(exercise);
        sortExercisesByIntensity();
        updateBalance();
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
}
