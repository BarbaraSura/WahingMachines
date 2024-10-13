package pl.spooksoft.washingmachine.machines;

import pl.spooksoft.washingmachine.WashingMachineBase;

public class WhirpoolWashingMachine extends WashingMachineBase {

    public WhirpoolWashingMachine() {
        super(new WhirpoolWashingMachineDefinition());
    }
}
