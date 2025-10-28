package com.hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
	 public void addDoctor(Doctor d) {
	        String query = "INSERT INTO doctors(name, specialization) VALUES(?,?)";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, d.getName());
	            ps.setString(2, d.getSpecialization());
	            ps.executeUpdate();
	            System.out.println("✅ Doctor Added Successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Doctor> getAllDoctors() {
	        List<Doctor> list = new ArrayList<>();
	        String query = "SELECT * FROM doctors";
	        try (Connection con = DBConnection.getConnection();
	             Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery(query)) {
	            while (rs.next()) {
	                list.add(new Doctor(rs.getInt("id"),
	                                    rs.getString("name"),
	                                    rs.getString("specialization")));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    public void updateDoctor(int id, String name, String specialization) {
	        String query = "UPDATE doctors SET name=?, specialization=? WHERE id=?";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, name);
	            ps.setString(2, specialization);
	            ps.setInt(3, id);
	            ps.executeUpdate();
	            System.out.println("✅ Doctor Updated Successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteDoctor(int id) {
	        String query = "DELETE FROM doctors WHERE id=?";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            System.out.println("✅ Doctor Deleted Successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
