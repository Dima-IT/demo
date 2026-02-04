package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetDAO {

    // ================================
    // CREATE
    // ================================

    public boolean insertPet(String name, int age, String type) {

        String sql = "INSERT INTO pet (name, age, type) VALUES (?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, type);

            int rowsInserted = statement.executeUpdate();
            statement.close();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    // ================================
    // READ
    // ================================

    public void getAllPets() {

        String sql = "SELECT * FROM pet ORDER BY pet_id";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("type")
                );
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getPetById(int petId) {

        String sql = "SELECT * FROM pet WHERE pet_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, petId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("type")
                );
            } else {
                System.out.println("No pet found with ID: " + petId);
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    // ================================
    // UPDATE
    // ================================

    public boolean updatePet(int id, String name, int age, String type) {

        String sql = "UPDATE pet SET name = ?, age = ?, type = ? WHERE pet_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, type);
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    // ================================
    // DELETE
    // ================================

    public boolean deletePet(int petId) {

        String sql = "DELETE FROM pet WHERE pet_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, petId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    // ================================
    // SEARCH
    // ================================

    public void searchByName(String name) {

        String sql = "SELECT * FROM pet WHERE name ILIKE ? ORDER BY name";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("type")
                );
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByAgeRange(int minAge, int maxAge) {

        String sql = "SELECT * FROM pet WHERE age BETWEEN ? AND ? ORDER BY age";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            statement.setInt(2, maxAge);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("type")
                );
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByMinAge(int minAge) {

        String sql = "SELECT * FROM pet WHERE age >= ? ORDER BY age";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("type")
                );
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
