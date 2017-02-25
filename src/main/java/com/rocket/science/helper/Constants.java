package com.rocket.science.helper;

public class Constants {

    public enum DriverStatus {
        IDLE("IDLE"),
        IN_TRIP("IN_TRIP"),
        LOGGED_OUT("LOGGED_OUT");

        private String driverStatus;

        DriverStatus(String driverStatus){
            this.driverStatus = driverStatus;
        }

        public String getText() {
            return this.driverStatus;
        }

        public String toString(){
            return this.driverStatus.toString();
        }

    }


    public enum BookingStatus {
        BOOKING_REQUEST("BOOKING_REQUEST"),
        REACHED_FOR_PICKUP("REACHED_FOR_PICKUP"),
        WAITING_FOR_CLIENT("WAITING_FOR_CLIENT"),
        TRIP_STARTED("TRIP_STARTED"),
        TRIP_ENDED("TRIP_ENDED"),
        TRIP_CANCELLED("TRIP_CANCELLED"),
        STOCK_OUT("STOCK_OUT");

        private String bookingStatus;

        BookingStatus(String bookingStatus){
            this.bookingStatus = bookingStatus;
        }

        public String getText() {
            return this.bookingStatus;
        }

        public String toString(){
            return this.bookingStatus.toString();
        }

    }



}
