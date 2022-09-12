package com.vc.collections.model;

public class Car {
    private String brand;
    private int number;

    public Car() {
    }

    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (number != car.number) return false;
        return brand != null ? brand.equals(car.brand) : car.brand == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + number;
        return result;
    }

    //    public static final String CAR_NAME;
//
//    static {
//        CAR_NAME = "bmw";
//    }
//
//    public static void makeBrrr() {
//        System.out.println("Brrrrr");
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//    class Bmw {
//
//        public void test() {
//            getNumber();
//        }
//
//    }
//
//    static class Volkswagen {
//
//        public void test() {
//
//        }
//    }
}
