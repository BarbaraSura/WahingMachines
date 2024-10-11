package pl.spooksoft.washingmachine;

import pl.spooksoft.washingmachine.exceptions.InvalidSpinSpeedException;
import pl.spooksoft.washingmachine.exceptions.TemperatureOutOfRange;
import pl.spooksoft.washingmachine.types.TemperatureUnit;

import java.util.ArrayList;

public abstract class WashingMachineBase {

    public static final int SPIN_SPEED_STEP = 100;
    public static final int MIN_C_TEMP = 30;
    public static final int MAX_C_TEMP = 90;
    public static final int MIN_F_TEMP = 86;
    public static final int MAX_F_TEMP = 194;

    private float maxLoad;

    private int currentSpinSpeed;

    private ArrayList<WashingProgram> programs;
    private int currentProgramIndex;

    private int delayTime;

    private float temperature;
    private float tempCStep;
    private float tempFStep;
    private TemperatureUnit currentTempUnit;

    private void internalSetTemperature(float newTemperature){
        temperature = newTemperature;
        System.out.print("Current temperature is " + temperature );
        if (currentTempUnit == TemperatureUnit.Celsius){
            System.out.println(" °C");
        }
        else if (currentTempUnit == TemperatureUnit.Farenheit){
            System.out.println(" F");
        }
        else
            throw new RuntimeException("Unsupported temperature unit");
    }

    //private Timestamp;
    // dodać metodę showStatus;
    // dodac metodę uruchamiania prania (przed zakończeniem doda pranie do historii)
    // dodac metodę opoźniania prania - przyjmuje przez parametr czas opóźnienia (np. int) i zapisująca w polu
    // po uruchomieniu prania wyświetlamy komunikat "Oczekiwanie ... godzin"

    public WashingMachineBase(WashingMachineDefinition definition){
        this.maxLoad = definition.getMaxLoad();
        this.programs = definition.generatePrograms();
        this.currentProgramIndex = 0;
        this.tempCStep = definition.getTempCStep();
        this.tempFStep = definition.getTempFStep();
        this.currentTempUnit = TemperatureUnit.Celsius;
        this.temperature = 30.0f;

//        if(maxLoad> definition.getMaxLoad()){
//            throw Exeption?
//        }
    }

    public TemperatureUnit getCurrentTempUnit() {
        return currentTempUnit;
    }

    public void setCurrentTempUnit(TemperatureUnit newTempUnit) {

        if(currentTempUnit == newTempUnit) {
            return;
        }

        this.currentTempUnit = newTempUnit;

        if (currentTempUnit == TemperatureUnit.Celsius) {
            float newTemperature = (temperature - 32) * (5.0f/9.0f);
            newTemperature = alignTemperatureToUnit(newTemperature);
            validateTemperature(newTemperature);
            internalSetTemperature(newTemperature);

        } else if (currentTempUnit == TemperatureUnit.Farenheit) {
            float newTemperature = (temperature * 9.0f/5.0f) + 32;
            newTemperature = alignTemperatureToUnit(temperature);
            validateTemperature(newTemperature);
            internalSetTemperature(newTemperature);
        } else
            throw new RuntimeException("Unsupported temperature unit");
    }

    private float alignTemperatureToUnit(float temp) {
        if (currentTempUnit == TemperatureUnit.Celsius) {
            return Math.round(temp/tempCStep) * tempCStep;

        } else if (currentTempUnit == TemperatureUnit.Farenheit) {
            return Math.round(temp/tempFStep) * tempFStep;

        } else
            throw new RuntimeException("Unsupported temperature unit");
    }

    public int getProgram() {
        return currentProgramIndex;
    }

    public void setProgram(int value) {
        if (value<0 || value>= programs.size()){
            throw new IndexOutOfBoundsException();
        }
        this.currentProgramIndex = value;
        updateProgramParameters();
    }

    private void updateProgramParameters() {
        this.currentSpinSpeed = programs.get(currentProgramIndex).getDefaultSpinSpeed();
    }

    public void nextProgram(){
        this.currentProgramIndex = currentProgramIndex + 1;
        if (currentProgramIndex>= programs.size()){
            currentProgramIndex = 0;
        }
        updateProgramParameters();
    }

    public void previousProgram(){
        this.currentProgramIndex = currentProgramIndex - 1;
        if (currentProgramIndex<0){
            currentProgramIndex = programs.size()-1;
        }
        updateProgramParameters();
    }

    public int getCurrentSpinSpeed() {
        return currentSpinSpeed;
    }

    private void validateSpinSpeed(int value) {
        if (value < 0 ||
                value >programs.get(currentProgramIndex).getMaxSpinSpeed() ||
                value % 100 == 0){
            throw new InvalidSpinSpeedException();
        }
    }

    public void setCurrentSpinSpeed(int value) {
        validateSpinSpeed(value);
        this.currentSpinSpeed = value;
    }

    public void currentSpinSpeedDown() {
        setCurrentSpinSpeed(this.currentSpinSpeed - SPIN_SPEED_STEP);
    }

    public void currentSpinSpeedUp(){
        setCurrentSpinSpeed(this.currentSpinSpeed + SPIN_SPEED_STEP);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float newTemperature) {
        newTemperature = alignTemperatureToUnit(newTemperature);

        validateTemperature(newTemperature);
        internalSetTemperature(newTemperature);
    }

    private void validateTemperature(float newTemperature) {
        if (currentTempUnit == TemperatureUnit.Celsius) {
           if(newTemperature < MIN_C_TEMP || newTemperature > MAX_C_TEMP) {
               throw new TemperatureOutOfRange();
           }

        } else if (currentTempUnit == TemperatureUnit.Farenheit) {
            if (newTemperature < MIN_F_TEMP || newTemperature > MAX_F_TEMP){
                throw new TemperatureOutOfRange();
            }

        } else
            throw new RuntimeException("Unsupported temperature unit");
    }

    public void tempUp(){
        if (currentTempUnit == TemperatureUnit.Celsius) {
            validateTemperature(temperature + tempCStep);
            internalSetTemperature( temperature + tempCStep);
        } else if (currentTempUnit == TemperatureUnit.Farenheit) {
            validateTemperature(temperature + tempFStep);
            internalSetTemperature( temperature + tempFStep);
        } else
            throw new RuntimeException("Unsupported temperature unit");
    }

    public void tempDown(){
        if (currentTempUnit == TemperatureUnit.Celsius) {
            validateTemperature(temperature - tempCStep);
            internalSetTemperature(temperature - tempCStep);
        } else if (currentTempUnit == TemperatureUnit.Farenheit) {
            validateTemperature(temperature - tempFStep);
            internalSetTemperature( temperature - tempFStep);
        } else
            throw new RuntimeException("Unsupported temperature unit");
    }

}
