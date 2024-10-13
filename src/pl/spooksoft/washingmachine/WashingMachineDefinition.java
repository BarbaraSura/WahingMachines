package pl.spooksoft.washingmachine;

import java.util.ArrayList;

public abstract class WashingMachineDefinition {

    private int maxLoad;
    private float tempCStep;
    private float tempFStep;


    public WashingMachineDefinition(int maxLoad, float tempCStep, float tempFStep) {
        this.maxLoad = maxLoad;
        this.tempCStep = tempCStep;
        this.tempFStep = tempFStep;
    }

    public float getTempCStep() {
        return tempCStep;
    }

    public float getTempFStep() {
        return tempFStep;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public abstract ArrayList<WashingProgram> generatePrograms();

}
