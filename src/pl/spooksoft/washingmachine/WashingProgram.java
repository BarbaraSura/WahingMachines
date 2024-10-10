package pl.spooksoft.washingmachine;

public class WashingProgram {

    private String programName;
    private int defaultSpinSpeed;
    private int maxSpinSpeed;
    private int approximateDuration;


    public WashingProgram(String programName, int maxSpinSpeed, int defaultSpinSpeed, int approximateDuration) {

        this.defaultSpinSpeed = defaultSpinSpeed;
        this.maxSpinSpeed = maxSpinSpeed;
        this.approximateDuration = approximateDuration;
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public int getMaxSpinSpeed() {
        return maxSpinSpeed;
    }

    public int getDefaultSpinSpeed() {
        return defaultSpinSpeed;
    }

    public int getApproximateDuration() {
        return approximateDuration;
    }
}
