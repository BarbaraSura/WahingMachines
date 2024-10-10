package pl.spooksoft.washingmachine.machines;

import pl.spooksoft.washingmachine.WashingMachineBase;

public class WhirpoolWashingMachine extends WashingMachineBase {

    WhirpoolWashingMachine() {
        super(new WhirpoolWashingMachineDefinition());
    }
}
