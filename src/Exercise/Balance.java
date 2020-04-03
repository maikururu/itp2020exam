package Exercise;

public class Balance extends Exercise {
    public String equipment;

    public void balance() {

    }

    public void setEquipment(String _equipment){
        this.equipment = _equipment;
    }

    public String getEquipment(){
        return equipment;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "equipment='" + equipment + '\'' +
                ", intensity=" + intensity +
                ", duration=" + duration +
                ", repetitions=" + repetitions +
                ", sets=" + sets +
                '}';
    }
}