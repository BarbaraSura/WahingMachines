package pl.spooksoft.washingmachine.machines;

import pl.spooksoft.washingmachine.WashingMachineWithWeightBase;

public class BekoWashingMachine extends WashingMachineWithWeightBase {

    public BekoWashingMachine() {
        super(new BekoWashingMachineDefinition());
    }
}
