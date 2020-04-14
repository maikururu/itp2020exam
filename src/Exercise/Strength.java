package Exercise;

public class Strength extends Exercise {
    public int weights;
    public String equipments;

    public void Strength() {

    }

    public void setWeights(int _weights) {
        weights = _weights;
    }

    public void setEquipments(String _equipments) {
        equipments = _equipments;
    }

    public int getWeights() {
        return weights;
    }

    public String getEquipments() {
        return equipments;
    }

    @Override
    public String toString() {
        return "Flexibility: " +
                "\nWeights = " + weights +
                "\nEquipments = '" + equipments;
    }
}
