package Exercise;

public class Flexibility extends Exercise {
    public String requirement;

    public void flexibility(){

    }

    public void setRequirement(String _requirement) {
        this.requirement = _requirement;
    }

    public String getRequirement(){
        return requirement;
    }

    @Override
    public String toString() {
        return "Flexibility: " +
                "\nRequirement = '" + requirement + '\'' +
                "\nIntensity = " + intensity +
                "\nDuration = " + duration +
                "\nRepetitions = " + repetitions +
                "\nSets = " + sets;
    }
}
