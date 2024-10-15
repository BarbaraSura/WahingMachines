package pl.spooksoft.washingmachine;

import pl.spooksoft.washingmachine.types.TemperatureUnit;

public class WashingHistoryEntryWithWeight extends WashingHistoryEntry {
    private final float load;
    private final int loadPercentage;

    public WashingHistoryEntryWithWeight(WashingProgram washingProgram, float temperature, TemperatureUnit tempUnit, int spinSpeed, float load, int loadPercentage) {
        super(washingProgram, temperature, tempUnit, spinSpeed);
        this.load = load;
        this.loadPercentage = loadPercentage;
    }

    public int getLoadPercentage() {
        return loadPercentage;
    }

    public float getLoad() {
        return load;
    }
    @Override
    public void display() {
        System.out.println("Wpis historyczny: " + washingProgram.getProgramName() + ", " + temperature + ", " + tempUnit + ", " + spinSpeed + ", " + load + ", " + loadPercentage + " %");
    }

}
