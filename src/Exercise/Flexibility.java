package Exercise;

public class Flexibility extends Exercise {
    public String requirement;

    public Flexibility(String _name, int _intensity, int _duration, int _repetitions, int _sets, String _requirements){
        super(_name, _intensity, _duration, _repetitions, _sets);
        setRequirement(_requirements);
    }

    public void setRequirement(String _requirement) {
        this.requirement = _requirement;
    }

    public String getRequirement(){
        return requirement;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRequirement = " + requirement;
    }
}
