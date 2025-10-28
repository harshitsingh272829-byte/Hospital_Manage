package com.hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
	
	public void addPatient(Patient p) {
        String query = "INSERT INTO patients(name, age, disease) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDisease());
            ps.executeUpdate();
            System.out.println("✅ Patient Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Patient(rs.getInt("id"),
                                     rs.getString("name"),
                                     rs.getInt("age"),
                                     rs.getString("disease")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updatePatient(int id, String name, int age, String disease) {
        String query = "UPDATE patients SET name=?, age=?, disease=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("✅ Patient Updated Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePatient(int id) {
        String query = "DELETE FROM patients WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Patient Deleted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
