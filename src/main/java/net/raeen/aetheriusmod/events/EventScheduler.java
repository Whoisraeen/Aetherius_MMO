package net.raeen.aetheriusmod.events;

import java.util.Timer;
import java.util.TimerTask;

public class EventScheduler {
    private final EventManager eventManager;
    private final Timer timer;

    public EventScheduler(EventManager eventManager) {
        this.eventManager = eventManager;
        this.timer = new Timer();
    }

    public void schedulePeriodicEvents() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();
                eventManager.getActiveEvents(currentTime).forEach(event -> {
                    // Logic for ongoing event activities
                });
                eventManager.checkAndEndEvents(currentTime);
            }
        }, 0, 60000); // Check every minute
    }
}
