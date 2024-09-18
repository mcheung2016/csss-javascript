package com.healthcaremanagement;

import com.healthcaremanagement.dao.DoctorDAO;
import com.healthcaremanagement.model.Doctor;

import java.sql.SQLException;
import java.util.Scanner;

public class DoctorRunner {

    public static void docRunner() throws SQLException {
        DoctorDAO doctorDAO = new DoctorDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Create Doctor");
        System.out.println("2. Read Doctor");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");
        int choice = sc.nextInt();
        sc.nextLine();
        try {
            switch (choice) {
                case 1:
                // Create Doctor
                Doctor doctor1 = new Doctor();
                    System.out.print("Enter first name: ");
                    doctor1.setFirstName(sc.nextLine());
                    System.out.print("Enter last name: ");
                    doctor1.setLastName(sc.nextLine());
                    System.out.print("Enter specialty: ");
                    doctor1.setSpecialty(sc.nextLine());
                    System.out.print("Enter : Email");
                    doctor1.setEmail(sc.nextLine());
                    doctorDAO.createDoctor(doctor1);
                    System.out.println("Doctor created successfully.");
                    break;
				case 2:
					System.out.println("Enter doctor id: ");
					int docId = sc.nextInt();
					Doctor retrievedDoctor = doctorDAO.getDoctorById(docId);
					if(retrievedDoctor != null) {
						System.out.print("Doctor id = "+ retrievedDoctor.getDoctorId());
						System.out.print("First name = " + retrievedDoctor.getFirstName());
						System.out.print("Last name = " + retrievedDoctor.getLastName());
						System.out.print("Specialty = " + retrievedDoctor.getSpecialty());
						System.out.print("Email = " + retrievedDoctor.getEmail());
					} else {
						System.out.println("Doctor retrieved: " + retrievedDoctor);
					}
					break;
				case 3:
					System.out.println("Enter doctor id: ");
					docId = sc.nextInt();
					retrievedDoctor = doctorDAO.getDoctorById(docId);
					if(retrievedDoctor != null) {
						System.out.print("First name = ");
						retrievedDoctor.setFirstName(sc.nextLine());
						System.out.print("Last name = ");
						retrievedDoctor.setLastName(sc.nextLine());
						System.out.print("Specialty = ");
						retrievedDoctor.setSpecialty(sc.nextLine());
						System.out.print("Email = ");
						retrievedDoctor.setEmail(sc.nextLine());
					} else {
						System.out.println("Doctor retrieved: " + retrievedDoctor);
					}
					break;
				case 4:
					System.out.println("Enter doctor id: ");
					docId = sc.nextInt();
					doctorDAO.deleteDoctor(docId);
					System.out.println("Doctor deleted successfully.");
					break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
            }
        }



