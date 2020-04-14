package Exercise;

public class Exercise {
    public String name;
    public int intensity;
    public int duration;
    public int repetitions;
    public int sets;


    public Exercise(String _name, int _intensity, int _duration, int _repetitions, int _sets){
        setName(_name);
        setIntensity(_intensity);
        setDuration(_duration);
        setRepetitions(_repetitions);
        setSets(_sets);
    }

    // setters
    public void setName(String _name) {
        this.name = _name;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getIntensity() {
        return intensity;
    }

    public int getDuration() {
        return duration;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getSets() {
        return sets;
    }

    @Override
    public String toString() {
        return "Exercise: " +
                "\nName = " + name +
                "\nIntensity = '" + intensity + '\'' +
                "\nDuration = " + duration +
                "\nRepetitions = " + repetitions +
                "\nSets = " + sets;
    }
}
