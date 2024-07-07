package net.raeen.aetheriusmod.environment;

public class WeatherSystem {
    private String currentWeather;

    public WeatherSystem() {
        this.currentWeather = "Clear";
    }

    public void changeWeather(String newWeather) {
        this.currentWeather = newWeather;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }
}
