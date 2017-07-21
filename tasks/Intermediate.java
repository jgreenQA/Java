package com.qac.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Intermediate {
    public static void main(String[] args) throws Exception {
        System.out.println(blackJack(18, 21));
        System.out.println(uniqSum(1, 2, 3));
        System.out.println(tooHot(70, true));

        ArrayList<Person> people = new ArrayList<>(3);
        people.add(new Person("John", 21, "Consultant"));
        people.add(new Person("Mark", 22, "Mechanic"));
        people.add(new Person("Fred", 23, "Engineer"));

        for (Person p : people) {
            System.out.println("Name: " + p.getName());
            System.out.println("Age: " + p.getAge());
            System.out.println("Job Title: " + p.getJobTitle());
        }

        Garage g = new Garage();
        g.addVehicle(new Car("Lamborghini", 4, false, 10));
        g.addVehicle(new Motorbike("Ducati", 2, "500cc", 6));

        System.out.println(g.getPrices());
        g.removeVehicleByID(0);
        g.empty();

        System.out.println(paintWiz(10));

        people.clear();
        people.add(new Person("John", 21, "Consultant"));
        people.add(new Person("Mark", 22, "Mechanic"));
        people.add(new Person("Fred", 23, "Engineer"));
        people.add(new Person("Greg", 24, "Doctor"));
        people.add(new Person("Alex", 25, "Cashier"));

        FileWriter out = new FileWriter("output.txt");
        for (Person p : people) {
            out.write(p.getName() + ":" + p.getAge() + ":" + p.getJobTitle() + "\n");
        }
        out.flush();

        people.clear();
        BufferedReader in = new BufferedReader(new FileReader("output.txt"));
        String s;
        String[] vals;
        while ((s = in.readLine()) != null) {
            vals = s.split(":");
            people.add(new Person(vals[0], Integer.parseInt(vals[1]), vals[2]));
        }
    }

    private static double paintWiz(int roomSize) {
        double totalPrice_CM = Paint.CHEAPOMAX.getTotalPrice() * (Paint.CHEAPOMAX.getCoverage() / roomSize);
        double totalPrice_AJ = Paint.AVERAGEJOES.getTotalPrice() * (Paint.AVERAGEJOES.getCoverage() / roomSize);
        double totalPrice_DP = Paint.DULUXOUROUSPAINTS.getTotalPrice() * (Paint.DULUXOUROUSPAINTS.getCoverage() / roomSize);

        return Math.min(totalPrice_CM, Math.min(totalPrice_AJ, totalPrice_DP));
    }

    private static int blackJack(int x, int y) {
        if (x > 21 && y > 21) {
            return 0;
        }

        if (x > 21) {
            return y;
        } else if (y > 21) {
            return x;
        }

        if (x > y) {
            return x;
        }
        return y;
    }

    private static int uniqSum(int x, int y, int z) {
        int[] arrInit = new int[3];
        arrInit[0] = x;
        arrInit[1] = y;
        arrInit[2] = z;

        ArrayList<Integer> arr = new ArrayList<>(3);
        for (int val : arrInit) {
            if (!arr.contains(val)) {
                arr.add(val);
            }
        }

        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    private static boolean tooHot(int temp, boolean summer) {
        return summer ? (temp >= 60 && temp <= 100) : (temp >= 60 && temp <= 90);
}
}

class Person {
    private String name;
    private int age;
    private String jobTitle;

    public Person(String name, int age, String jobTitle) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}

class Vehicle {
    private String model;
    private int wheelAmount;
    private int priceClass;

    public Vehicle(String model, int wheelAmount, int priceClass) {
        this.model = model;
        this.wheelAmount = wheelAmount;
        this.priceClass = priceClass;
    }

    public String getModel() {
        return model;
    }

    public int getWheelAmount() {
        return wheelAmount;
    }

    public int getPriceClass() {
        return priceClass;
    }
}

class Garage {
    ArrayList<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }

    public void empty() {
        vehicles.clear();
    }

    public void removeVehicleByID(int id) {
        vehicles.remove(id);
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public double getPrices() {
        double priceTotal = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                priceTotal += v.getPriceClass() * 3000;
            } else if (v instanceof Motorbike) {
                priceTotal += v.getPriceClass() * 2000;
            } else {
                priceTotal += v.getPriceClass() * 1000;
            }
        }
        return priceTotal;
    }
}

class Car extends Vehicle {
    private boolean automatic;

    public Car(String model, int wheelAmount, boolean automatic, int priceClass) {
        super(model, wheelAmount, priceClass);
        this.automatic = automatic;
    }

    public boolean isAutomatic() {
        return automatic;
    }
}

class Motorbike extends Vehicle {
    private String engineSize;

    public Motorbike(String model, int wheelAmount, String engineSize, int priceClass) {
        super(model, wheelAmount, priceClass);
        this.engineSize = engineSize;
    }

    public String getEngineSize() {
        return engineSize;
    }
}