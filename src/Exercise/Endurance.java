package Exercise;

public class Endurance extends Exercise {
    public String equipment;

    public Endurance(String _name, int _intensity, int _duration, int _repetitions, int _sets, String _equipment){
        super(_name, _intensity, _duration, _repetitions, _sets);
        setEquipment(_equipment);
    }

    public void setEquipment(String _equipment) {

        equipment = _equipment;
    }

    public String getEquipment(){

        return equipment;
    }
    @Override
    public String toString() {
        return "Endurance: " +
                "\nEquipment = '" + equipment;
    }
}

