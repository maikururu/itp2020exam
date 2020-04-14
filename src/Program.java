import Exercise.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public List<Exercise> exercises = new ArrayList<Exercise>();
    public int duration;
    public int intensityLevel;

    public Program(int _duration) {
        setDuration(_duration);
        //setIntensityLevel(_intensity);

        //addExercise(exercises);
    }

    public String toString() {
        return String.format("\n=================\n" +
                " Duration: %s \n Intensity: %s \n Program Exercises: %s", getDuration(), getIntensityLevel(), getExercises());
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
    }

    public void addExercise(Endurance exercise){
        this.exercises.add(exercise);
        setIntensityLevel(exercise);
    }

    public void addExercise(Flexibility exercise){
        this.exercises.add(exercise);
        setIntensityLevel(exercise);
    }

    public void addExercise(Strength exercise){
        this.exercises.add(exercise);
        setIntensityLevel(exercise);
    }
    //-----------------------------------------------------------//

    public List<Exercise> getExercises() {
        return exercises;
    }
}
