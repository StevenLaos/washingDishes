package com.example.service;

import com.example.bean.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 6/15/2017.
 */
public class WorkerService {

    public List<Worker> getAllWorkers() {
        List<Worker> listOfWorkers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM worker")) {
            while (resultSet.next()) {
                Worker worker = new Worker(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("efficiency"),
                        resultSet.getInt("id"));
                listOfWorkers.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnection.closeConnection(connection);
        return listOfWorkers;
    }

    public int findWorkerEfficieny(String firstName, String lastName) {
        int  efficiency = 0;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT efficiency FROM worker WHERE first_name = ? AND last_name = ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                efficiency = resultSet.getInt("efficiency");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnection.closeConnection(connection);
        return efficiency;
    }

    public Worker addNewWorker(Worker worker) {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO worker (first_name, last_name, efficiency) VALUES (?,?,?)");
            preparedStatement.setString(1, worker.getFirstName());
            preparedStatement.setString(2, worker.getLastName());
            preparedStatement.setInt(3, worker.getEfficiency());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worker;
    }

    public void deleteWorker(int id) {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM worker WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Worker editWorker(Worker worker) {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE worker SET first_name = ?, last_name = ?, efficiency = ? WHERE id = ?");
            preparedStatement.setString(1, worker.getFirstName());
            preparedStatement.setString(2, worker.getLastName());
            preparedStatement.setInt(3, worker.getEfficiency());
            preparedStatement.setInt(4, worker.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worker;
    }
}