package pl.spooksoft.washingmachine;

public class WashingMachineWithWeightBase extends WashingMachineBase {

    public WashingMachineWithWeightBase(WashingMachineDefinition definition) {
        super(definition);
    }

    @Override
    protected void addHistoryEntry() {
        int loadPercentage = (int) (getLoad() * 100 / maxLoad);
        WashingHistoryEntryWithWeight entry = new WashingHistoryEntryWithWeight(getCurrentProgram(), getTemperature(), getCurrentTempUnit(), getCurrentSpinSpeed(), getLoad(), loadPercentage );
        internalAddHistoryEntry(entry);
    }




}
