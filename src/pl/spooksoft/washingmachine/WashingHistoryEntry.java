package pl.spooksoft.washingmachine;

import pl.spooksoft.washingmachine.types.TemperatureUnit;

public class WashingHistoryEntry {
    protected final WashingProgram washingProgram;
    protected final float temperature;
    protected final TemperatureUnit tempUnit;
    protected final int spinSpeed;

    public WashingHistoryEntry(WashingProgram washingProgram, float temperature, TemperatureUnit tempUnit , int spinSpeed) {

        this.washingProgram = washingProgram;
        this.temperature = temperature;
        this.tempUnit = tempUnit;
        this.spinSpeed = spinSpeed;
    }

    public WashingProgram getWashingProgram() {
        return washingProgram;
    }

    public float getTemperature() {
        return temperature;
    }

    public TemperatureUnit getTempUnit() {
        return tempUnit;
    }

    public int getSpinSpeed() {
        return spinSpeed;
    }

    public void display() {
        System.out.println("Wpis historyczny: " + washingProgram.getProgramName() + ", " + temperature + ", " + tempUnit + ", " + spinSpeed);
    }
    //przechowuje program (referencję?),temp, predkość wirowania
    // Beko i Amica - waga prania i % załadowania
    // linked list

}
