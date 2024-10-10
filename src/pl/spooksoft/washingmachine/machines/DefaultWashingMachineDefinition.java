package pl.spooksoft.washingmachine.machines;

import pl.spooksoft.washingmachine.WashingMachineDefinition;
import pl.spooksoft.washingmachine.WashingProgram;

import java.util.ArrayList;

public class DefaultWashingMachineDefinition extends WashingMachineDefinition {

    public DefaultWashingMachineDefinition(int maxLoad) {
        super(maxLoad);
    }

    @Override
    public ArrayList<WashingProgram> generatePrograms() {

        ArrayList<WashingProgram> result = new ArrayList<>();
        result.add(new WashingProgram("Bawełna", 1000, 1000, 120));
        result.add(new WashingProgram("Bawełna +", 1000, 900, 90));
        result.add(new WashingProgram("Mieszane", 800, 800, 80));
        result.add(new WashingProgram("Tw. sztuczne", 900, 800, 60));
        result.add(new WashingProgram("Delikatne", 500, 400, 45));
        result.add(new WashingProgram("Sportowe", 700, 700, 60));
        result.add(new WashingProgram("Szybkie", 800, 700, 30));
        result.add(new WashingProgram("Eco", 800, 800, 120));
        result.add(new WashingProgram("Ciche", 600, 400, 60));
        result.add(new WashingProgram("Dziecięce", 1000, 900, 180));

        return result;
    }
}
