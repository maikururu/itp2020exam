package Exercise;

public class Endurance extends Exercise {
    public String equipment;

    public void endurance() {

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
                "\nEquipment = '" + equipment + '\'' +
                "\nIntensity = " + intensity +
                "\nDuration = " + duration +
                "\nRepetitions = " + repetitions +
                "\nSets = " + sets;
    }
}

