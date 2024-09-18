package com.healthcaremanagement;

import com.healthcaremanagement.dao.AppointmentDAO;
import com.healthcaremanagement.dao.DoctorDAO;
import com.healthcaremanagement.model.Appointment;
import com.healthcaremanagement.model.Doctor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppointmentRunner {
    public static void apptRunner() throws SQLException {

			AppointmentDAO appointmentDAO = new AppointmentDAO();
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Create Appointment");
			System.out.println("2. Read Appoinment");
			System.out.println("3. Update Appoinment");
			System.out.println("4. Delete Appoinment");
			int choice = sc.nextInt();
			sc.nextLine();
			try {
				switch (choice) {
					case 1:

//						this.appointmentDate = appointmentDate;
//						this.appointmentId = appointmentId;
//						this.doctorId = doctorId;
//						this.notes = notes;
//						this.patientId = patientId;
						// Create Doctor
						Appointment app1 = new Appointment();
						System.out.print("Enter appointment date: ");
						app1.setAppointmentDate(sc.nextLine());
						System.out.print("Enter doctorId: ");
						app1.setDoctorId(sc.nextInt());
						System.out.print("Enter notes: ");
						app1.setNotes(sc.nextLine());
						System.out.println("Enter Patient ID: ");
						app1.setPatientId(sc.nextInt());
						appointmentDAO.createAppointment(app1);
						System.out.println("Appointment created successfully.");
						break;
					case 2:
						System.out.println("Enter appointment id: ");
						int appId = sc.nextInt();
						Appointment retrievedAppointment = appointmentDAO.getAppointmentById(appId);
						if(retrievedAppointment != null) {
							System.out.println("appointment date: "+ retrievedAppointment.getAppointmentDate());
							System.out.println("doctorId: " + retrievedAppointment.getDoctorId());
							System.out.println("notes: "+ retrievedAppointment.getNotes());
							System.out.println("Patient ID: " + retrievedAppointment.getPatientId());
						} else {
							System.out.println("appointment not found.");
						}
						break;
					case 3:
						System.out.println("Enter appointment id: ");
						appId = sc.nextInt();
						retrievedAppointment = appointmentDAO.getAppointmentById(appId);
						if(retrievedAppointment != null) {
							System.out.print("appointment date: ");
							retrievedAppointment.setAppointmentDate(sc.nextLine());
							System.out.print("doctorId: ");
							retrievedAppointment.setDoctorId(sc.nextInt());
							System.out.print("notes: ");
							retrievedAppointment.setNotes(sc.nextLine());
							System.out.println("Patient ID: ");
							retrievedAppointment.setPatientId(sc.nextInt());
							appointmentDAO.updateAppointment(retrievedAppointment);
						} else {
							System.out.println("appointment not found.");
						}
						break;
					case 4:
						System.out.println("Enter appointment id: ");
						appId = sc.nextInt();
						appointmentDAO.deleteAppointment(appId);
						System.out.println("Appointment deleted successfully.");
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

