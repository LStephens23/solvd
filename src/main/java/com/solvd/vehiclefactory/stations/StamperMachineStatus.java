package main.java.com.solvd.vehiclefactory.stations;

import java.time.LocalDateTime;

public enum StamperMachineStatus {
    OFF("The machine is turned off") {
        @Override
        public boolean isRunning() {
            return false;
        }
    },
    IDLE("The machine is idle") {
        @Override
        public boolean isRunning() {
            return false;
        }
    },
    RUNNING("The machine is running") {
        @Override
        public boolean isRunning() {
            return true;
        }
    },
    MAINTENANCE("The machine is undergoing maintenance") {
        @Override
        public boolean isRunning() {
            return false;
        }
    };

    private String description;
    private LocalDateTime startTime;

    StamperMachineStatus(String description) {
        this.description = description;
        this.startTime = LocalDateTime.now();
    }

    public abstract boolean isRunning();

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}

