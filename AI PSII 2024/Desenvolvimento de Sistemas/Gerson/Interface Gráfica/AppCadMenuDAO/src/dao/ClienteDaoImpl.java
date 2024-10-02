package dao;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import model.Cliente;

public class ClienteDaoImpl implements ClienteDao{

    private Connection connection;

    public ClienteDaoImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_cad_lucas";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCliente(Cliente cliente) {
        try {
            String query = "INSERT INTO cliente (cod, nome, fone, email, endereco) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cliente.getCod());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getFone());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getEndereco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente getCliente(int id) {
        Cliente cliente = null;
        try {
            String query = "SELECT * FROM cliente WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente(
                    resultSet.getInt("cod"),
                    resultSet.getString("nome"),
                    resultSet.getString("fone"),
                    resultSet.getString("email"),
                    resultSet.getString("endereco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = "SELECT * FROM cliente";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                clientes.add(new Cliente(
                    resultSet.getInt("cod"),
                    resultSet.getString("nome"),
                    resultSet.getString("fone"),
                    resultSet.getString("email"),
                    resultSet.getString("endereco")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void updateCliente(Cliente cliente) {
        try {
            String query = "UPDATE cliente SET nome = ?, fone = ?, email = ?, endereco = ? WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getFone());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getEndereco());
            statement.setInt(5, cliente.getCod());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(int id) {
        try {
            String query = "DELETE FROM cliente WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
