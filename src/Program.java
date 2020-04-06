import Exercise.Exercise;

import java.util.List;

public class Program {
    public List<Exercise> exercises;
    public int duration;
    public int intensityLevel;

    public void program(int _duration, int _intensity) {
        setDuration(_duration);
        setIntensityLevel(_intensity);
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

    public int getIntensityLevel() {
        return intensityLevel;
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}
