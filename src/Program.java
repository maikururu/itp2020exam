import Exercise.*;
import java.util.List;

public class Program<E> {
    public List<? super Exercise> exercises;
    public int duration;
    public int intensityLevel;

    public Program(int _duration, int _intensity) {
        setDuration(_duration);
        setIntensityLevel(_intensity);

        //addExercise(exercises);
    }

    public String toString() {
        return String.format("Duration: %s \n Intensity: %s \n Exercises: %s", getDuration(), getIntensityLevel(), getExercises());
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setIntensityLevel(int intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

//    public <T super Exercise> void setIntensityLevel(T exercise){
//
//    }

    public int getIntensityLevel() {
        return intensityLevel;
    }

    //Method collection to add type of exercises to exercises array
    //-----------------------------------------------------------//
    public void addExercise(Balance exercise){
        this.exercises.add(exercise);

        if(exercise.intensity > this.intensityLevel)
            this.setIntensityLevel(exercise.intensity);
    }

    public void addExercise(Endurance exercise){
        this.exercises.add(exercise);
    }

    public void addExercise(Flexibility exercise){
        this.exercises.add(exercise);
    }

    public void addExercise(Strength exercise){
        this.exercises.add(exercise);
    }
    //-----------------------------------------------------------//

    public List<? super Exercise> getExercises() {
        return exercises;
    }
}
