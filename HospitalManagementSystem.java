package com.HMS;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

class Patient extends Person {
    String patientId;

    public Patient(String name, int age, String gender, String patientId) {
        super(name, age, gender);
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Patient ID: " + patientId;
    }
}

class Doctor extends Person {
    String specialization;
    String doctorId;

    public Doctor(String name, int age, String gender, String specialization, String doctorId) {
        super(name, age, gender);
        this.specialization = specialization;
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialization: " + specialization + ", Doctor ID: " + doctorId;
    }
}

class Appointment {
    String appointmentId;
    String patientId;
    String doctorId;
    String date;

    public Appointment(String appointmentId, String patientId, String doctorId, String date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId +
                ", Doctor ID: " + doctorId + ", Date: " + date;
    }
}

public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> scheduleAppointment();
                case 4 -> viewPatients();
                case 5 -> viewDoctors();
                case 6 -> viewAppointments();
                case 7 -> {
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        patients.add(new Patient(name, age, gender, patientId));
        System.out.println("Patient added successfully.");
    }

    static void addDoctor() {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        doctors.add(new Doctor(name, age, gender, specialization, doctorId));
        System.out.println("Doctor added successfully.");
    }

    static void scheduleAppointment() {
        System.out.print("Enter Appointment ID: ");
        String appointmentId = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        appointments.add(new Appointment(appointmentId, patientId, doctorId, date));
        System.out.println("Appointment scheduled successfully.");
    }

    static void viewPatients() {
        System.out.println("\n=== Patients List ===");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    static void viewDoctors() {
        System.out.println("\n=== Doctors List ===");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    static void viewAppointments() {
        System.out.println("\n=== Appointments List ===");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}
