package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CRUD implements InterCRUD {
    public void Create(Connection connection, Client client) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients (ID,LastName, FirstName, TypeDoc) VALUES(?,?,?,?)");
            preparedStatement(client, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void preparedStatement(Client client, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, client.getID());
        preparedStatement.setString(2, client.getLastName());
        preparedStatement.setString(3, client.getFirstName());
        preparedStatement.setString(4, client.getTypeDoc());
    }

    public List<Client> Read(Connection connection) {
        List<Client> clientList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM clients";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Client client = new Client();
                client.setID(resultSet.getInt("ID"));
                client.setLastName(resultSet.getString("LastName"));
                client.setFirstName(resultSet.getString("FirstName"));
                client.setTypeDoc(resultSet.getString("TypeDoc"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientList;
    }

    public void Update(Connection connection, Client client, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE clients SET LastName=?, FirstName=?, TypeDoc=? WHERE ID=?");
            preparedStatement.setString(1, client.getLastName());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getTypeDoc());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Delete(Connection connection, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE ID=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
