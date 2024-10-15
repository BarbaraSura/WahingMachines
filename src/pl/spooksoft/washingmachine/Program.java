package pl.spooksoft.washingmachine;

import pl.spooksoft.washingmachine.machines.AmicaWashingMachine;
import pl.spooksoft.washingmachine.machines.BekoWashingMachine;
import pl.spooksoft.washingmachine.machines.WhirpoolWashingMachine;
import pl.spooksoft.washingmachine.types.TemperatureUnit;

public class Program {
    public static void main(String[] args) {
        WhirpoolWashingMachine machine = new WhirpoolWashingMachine();
        machine.setProgram(4);
        machine.setLoad(5.0f);
        machine.setCurrentTempUnit(TemperatureUnit.Farenheit);
        machine.setTemperature(90.0f);
        for (int i=0; i<10; i++){
            machine.tempUp();
        }
        machine.tempDown();
        machine.setCurrentSpinSpeed(500);

        machine.showStatus();
        machine.startProgram();

        BekoWashingMachine machine2 = new BekoWashingMachine();
        machine2.setProgram(9);
        machine2.setLoad(6.0f);
        machine2.setTemperature(60.0f);
        machine2.tempUp();
        machine2.tempDown();
        machine2.setCurrentSpinSpeed(600);
        machine2.showStatus();
        machine2.startProgram();

        AmicaWashingMachine machine3 = new AmicaWashingMachine();
        machine3.setProgram(2);
        machine3.setLoad(8.0f);
        machine3.setTemperature(50.0f);
        machine3.tempUp();
        machine3.tempDown();
        machine3.setCurrentSpinSpeed(800);
        machine3.showStatus();
        machine3.startProgram();

        machine3.setProgram(3);
        machine3.setLoad(3);
        machine3.startProgram();
        machine3.displayHistory();

    }
}
