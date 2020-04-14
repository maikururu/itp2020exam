package Exercise;

public class Strength extends Exercise {
    public int weights;
    public String equipment;


    public Strength(String _name, int _intensity, int _duration, int _repetitions, int _sets, int _weights, String _equipment){
        super(_name, _intensity, _duration, _repetitions, _sets);
        setWeights(_weights);
        setEquipment(_equipment);
    }

    public void setWeights(int _weights) {
        weights = _weights;
    }

    public void setEquipment(String _equipments) {
        equipment = _equipments;
    }

    public int getWeights() {
        return weights;
    }

    public String getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWeights = " + weights +
                "\nEquipments = '" + equipment;
    }
}
