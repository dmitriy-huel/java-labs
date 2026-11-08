package org.example;

class Train {
    private String destination;
    private int trainNumber;
    private int travelTime;

    public Train(String destination, int trainNumber, int travelTime) {
        setDestination(destination);
        setTrainNumber(trainNumber);
        setTravelTime(travelTime);
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setDestination(String destination) {
        if (destination == null || destination.isEmpty()) {
            System.out.println("пункт назначения не может быть пустым");
            return;
        }
        this.destination = destination;
    }

    public void setTrainNumber(int trainNumber) {
        if (trainNumber <= 0) {
            System.out.println("номер поезда должен быть больше 0");
            return;
        }
        this.trainNumber = trainNumber;
    }

    public void setTravelTime(int travelTime) {
        if (travelTime <= 0) {
            System.out.println("время в пути должно быть больше 0");
            return;
        }
        this.travelTime = travelTime;
    }
}
