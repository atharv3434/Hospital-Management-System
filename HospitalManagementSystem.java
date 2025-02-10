import java.util.ArrayList;
import java.util.Scanner;

// Patient Class
class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void displayPatient() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

// Doctor Class
class Doctor {
    private int id;
    private String name;
    private String specialty;

    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void displayDoctor() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialty: " + specialty);
    }
}

// Hospital Management System
public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Hospital Management System -----");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Search Patient");
            System.out.println("6. Search Doctor");
            System.out.println("7. Update Patient");
            System.out.println("8. Update Doctor");
            System.out.println("9. Delete Patient");
            System.out.println("10. Delete Doctor");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> displayPatients();
                case 4 -> displayDoctors();
                case 5 -> searchPatient();
                case 6 -> searchDoctor();
                case 7 -> updatePatient();
                case 8 -> updateDoctor();
                case 9 -> deletePatient();
                case 10 -> deleteDoctor();
                case 11 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Add a new patient
    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    // Add a new doctor
    private static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();

        doctors.add(new Doctor(id, name, specialty));
        System.out.println("Doctor added successfully!");
    }

    // Display all patients
    private static void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("\n----- Patient List -----");
        for (Patient p : patients) {
            p.displayPatient();
        }
    }

    // Display all doctors
    private static void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        System.out.println("\n----- Doctor List -----");
        for (Doctor d : doctors) {
            d.displayDoctor();
        }
    }

    // Search for a patient
    private static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();

        for (Patient p : patients) {
            if (p.getId() == id) {
                System.out.println("Patient found:");
                p.displayPatient();
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    // Search for a doctor
    private static void searchDoctor() {
        System.out.print("Enter Doctor ID to search: ");
        int id = scanner.nextInt();

        for (Doctor d : doctors) {
            if (d.getId() == id) {
                System.out.println("Doctor found:");
                d.displayDoctor();
                return;
            }
        }
        System.out.println("Doctor not found!");
    }

    // Update a patient record
    private static void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Patient p : patients) {
            if (p.getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new disease: ");
                String disease = scanner.nextLine();

                p.setName(name);
                p.setAge(age);
                p.setDisease(disease);
                System.out.println("Patient updated successfully!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    // Update a doctor record
    private static void updateDoctor() {
        System.out.print("Enter Doctor ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Doctor d : doctors) {
            if (d.getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new specialty: ");
                String specialty = scanner.nextLine();

                d.setName(name);
                d.setSpecialty(specialty);
                System.out.println("Doctor updated successfully!");
                return;
            }
        }
        System.out.println("Doctor not found!");
    }

    // Delete a patient
    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();

        patients.removeIf(p -> p.getId() == id);
        System.out.println("Patient deleted successfully!");
    }

    // Delete a doctor
    private static void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        int id = scanner.nextInt();

        doctors.removeIf(d -> d.getId() == id);
        System.out.println("Doctor deleted successfully!");
    }
}
