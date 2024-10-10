package pl.spooksoft.washingmachine;

import pl.spooksoft.washingmachine.exceptions.InvalidSpinSpeedException;

import java.util.ArrayList;

public abstract class WashingMachineBase {

    public static final int SPIN_SPEED_STEP = 100;
    private float maxLoad;
    private int currentSpinSpeed;
    private ArrayList<WashingProgram> programs;
    private int currentProgramIndex;
    private float temperature;
    private int delayTime;
    //private Timestamp;

    // dodać metody: setProgram, getProgram, nextProgram i previousProgram
    // dodać metodę showStatus;
    // dodac metodę uruchamiania prania (przed zakończeniem doda pranie do historii)
    // dodac metodę opoźniania prania - przyjmuje przez parametr czas opóźnienia (np. int) i zapisująca w polu
    // po uruchomieniu prania wyświetlamy komunikat "Oczekiwanie ... godzin"

    public WashingMachineBase(WashingMachineDefinition definition){
        this.maxLoad = definition.getMaxLoad();
        this.programs = definition.generatePrograms();
        this.currentProgramIndex = 0;
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

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }



}
