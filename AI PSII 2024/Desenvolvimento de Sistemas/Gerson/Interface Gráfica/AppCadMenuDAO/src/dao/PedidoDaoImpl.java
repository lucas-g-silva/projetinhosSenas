/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DBManeger.DB_NAME;
import static dao.DBManeger.PASSWORD;
import static dao.DBManeger.URL;
import static dao.DBManeger.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

/**
 *
 * @author lucas-gabreil_silva
 */
public class PedidoDaoImpl implements PedidoDao {

    private Connection connection;

    public PedidoDaoImpl() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPedido(Pedido pedido) {
        try {
            String query = "INSERT INTO pedido (dataEmissao, idCliente) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, pedido.getDataEmissao());
            statement.setInt(2, pedido.getIdCliente());
            statement.executeUpdate();

            query = "INSERT INTO lista_pedidos (codPedido, codProduto) VALUES (?, ?)";
            for (int i = 0; i < pedido.getIdProdutos().size(); i++) {
                PreparedStatement statement1 = connection.prepareStatement(query);
                statement1.setInt(1, pedido.getCod());
                statement1.setInt(2, pedido.getIdProdutos().indexOf(i));
                statement1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido getPedido(int id) {
        Pedido pedido = null;
        List<Integer> idProdutos = new ArrayList<Integer>();
        try {
            String query = "SELECT * FROM pedido WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSetPedido = statement.executeQuery();

            query = "SELECT codProduto FROM lista_pedidos WHERE codPedido = ?";
            PreparedStatement statement1 = connection.prepareStatement(query);
            statement1.setInt(1, id);
            ResultSet resultSetProdutos = statement1.executeQuery();
            while (resultSetProdutos.next()) {
                idProdutos.add(resultSetProdutos.getInt("codProduto"));
            }

            if (resultSetPedido.next()) {
                pedido = new Pedido(
                        resultSetPedido.getInt("cod"),
                        resultSetPedido.getDate("dataEmisssao"),
                        resultSetPedido.getInt("idCliente"),
                        idProdutos
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public List<Pedido> getAllPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String query = "SELECT * FROM pedido";
            Statement statement = connection.createStatement();
            ResultSet resultSetPedido = statement.executeQuery(query);
            
            while (resultSetPedido.next()) {
                List<Integer> idProdutos = new ArrayList<Integer>();
                
                query = "SELECT codProduto FROM lista_pedidos WHERE codPedido = ?";
                PreparedStatement statement1 = connection.prepareStatement(query);
                statement1.setInt(1, resultSetPedido.getInt("cod"));
                ResultSet resultSetProdutos = statement1.executeQuery();
                
                while (resultSetProdutos.next()) {
                    idProdutos.add(resultSetProdutos.getInt("codProduto"));
                }
                pedidos.add( new Pedido(
                        resultSetPedido.getInt("cod"),
                        resultSetPedido.getDate("dataEmisssao"),
                        resultSetPedido.getInt("idCliente"),
                        idProdutos
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public void deletePedido(int id) {
        try {
            String query = "DELETE FROM pedido WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getNextCod() {
        int nextCod = 0;
        try {
            String query = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = '" + DB_NAME + "' AND TABLE_NAME = 'pedido';";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                nextCod = resultSet.getInt("AUTO_INCREMENT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextCod;
    }
}
