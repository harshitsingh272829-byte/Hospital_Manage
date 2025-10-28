package com.hms;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();

        int choice;
        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Add Doctor");
            System.out.println("6. View Doctors");
            System.out.println("7. Update Doctor");
            System.out.println("8. Delete Doctor");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String pname = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Disease: ");
                    String disease = sc.next();
                    patientDAO.addPatient(new Patient(pname, age, disease));
                    break;

                case 2:
                    for (Patient p : patientDAO.getAllPatients()) {
                        System.out.println(p.getId() + " | " + p.getName() + " | " + p.getAge() + " | " + p.getDisease());
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to Update: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    pname = sc.next();
                    System.out.print("Enter New Age: ");
                    age = sc.nextInt();
                    System.out.print("Enter New Disease: ");
                    disease = sc.next();
                    patientDAO.updatePatient(pid, pname, age, disease);
                    break;

                case 4:
                    System.out.print("Enter Patient ID to Delete: ");
                    pid = sc.nextInt();
                    patientDAO.deletePatient(pid);
                    break;

                case 5:
                    System.out.print("Enter Doctor Name: ");
                    String dname = sc.next();
                    System.out.print("Enter Specialization: ");
                    String specialization = sc.next();
                    doctorDAO.addDoctor(new Doctor(dname, specialization));
                    break;

                case 6:
                    for (Doctor d : doctorDAO.getAllDoctors()) {
                        System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialization());
                    }
                    break;

                case 7:
                    System.out.print("Enter Doctor ID to Update: ");
                    int did = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    dname = sc.next();
                    System.out.print("Enter New Specialization: ");
                    specialization = sc.next();
                    doctorDAO.updateDoctor(did, dname, specialization);
                    break;

                case 8:
                    System.out.print("Enter Doctor ID to Delete: ");
                    did = sc.nextInt();
                    doctorDAO.deleteDoctor(did);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 9);

        sc.close();
    }

}
