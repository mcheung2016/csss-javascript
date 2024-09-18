package com.healthcaremanagement;

import com.healthcaremanagement.dao.DoctorDAO;
import com.healthcaremanagement.model.Appointment;

import java.sql.SQLException;
import java.util.Scanner;

public class HealthcareRunner {
	public static void main(String[] args) {
		DoctorDAO doctorDAO = new DoctorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Manage Doctors");
		System.out.println("2. Manage Patients");
		System.out.println("3. Manage Appointments");
		int choice = sc.nextInt();
		sc.nextLine();
		try {
			switch (choice) {
				case 1:
					DoctorRunner.docRunner();
					break;
				case 2:
					PatientRunner.patientRunner();
					break;
				case 3:
					AppointmentRunner.apptRunner();
					break;
				default:
					System.out.println("Invalid choice");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			sc.close();
		}
	}
}
