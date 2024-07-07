package net.raeen.aetheriusmod.environment;

public class DayNightCycle {
    private String timeOfDay;

    public DayNightCycle() {
        this.timeOfDay = "Day";
    }

    public void changeTimeOfDay(String newTimeOfDay) {
        this.timeOfDay = newTimeOfDay;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }
}
