package pl.spooksoft.washingmachine;

public class WashingMachineWithWeightBase extends WashingMachineBase {

    public WashingMachineWithWeightBase(WashingMachineDefinition definition) {
        super(definition);
    }
    private float currentLoadWeight;

    public void setCurrentLoadWeight(float currentLoadWeight) {
        this.currentLoadWeight = currentLoadWeight;
    }

    // if currentLoadWeigth> maxLoad -> exeption "Ładunek jest za duży"


}
