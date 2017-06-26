package com.example.service;

import com.example.bean.Washer;

import java.sql.*;

/**
 * Created by User on 6/26/2017.
 */
public class WasherService {
    public Washer rdyToWash(Washer washer){
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(""); //vaja täita sisuga, kui seda on üldse vaja
            preparedStatement.setInt(1, 21);//Algselt lihtsalt täidetud, et punast ei näitaks. Vaja täita õige sisuga

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return washer;
    }
}
