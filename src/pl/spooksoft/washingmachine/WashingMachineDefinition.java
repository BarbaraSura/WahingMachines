package pl.spooksoft.washingmachine;

import java.util.ArrayList;

public abstract class WashingMachineDefinition {

    private int maxLoad;

    public WashingMachineDefinition(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public abstract ArrayList<WashingProgram> generatePrograms();

    //inicjuje maksymalny ładunek prania
    // generator programów, przechowuje wszystkie parametry pralki
    // nr - nazwa programu, domyślna prędkość wirowania(maksymalna?), temperatura, przybliżony czas trwania
    // index danego programu
}
