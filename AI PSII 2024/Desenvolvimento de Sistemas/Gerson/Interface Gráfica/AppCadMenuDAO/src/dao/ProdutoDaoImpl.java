package dao;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import model.Produto;

public class ProdutoDaoImpl implements ProdutoDao{

    private Connection connection;

    public ProdutoDaoImpl() {
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
    public void addProduto(Produto produto) {
        try {
            String query = "INSERT INTO produto (cod, desc, unidade, qtd, preco) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, produto.getCod());
            statement.setString(2, produto.getDesc());
            statement.setString(3, produto.getUnidade());
            statement.setFloat(4, produto.getQtd());
            statement.setFloat(5, produto.getPreco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto getProduto(int id) {
        Produto produto = null;
        try {
            String query = "SELECT * FROM produto WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                produto = new Produto(
                    resultSet.getInt("cod"),
                    resultSet.getString("desc"),
                    resultSet.getString("unidade"),
                    resultSet.getFloat("qtd"),
                    resultSet.getFloat("preco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    @Override
    public List<Produto> getAllProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            String query = "SELECT * FROM produto";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                produtos.add(new Produto(
                    resultSet.getInt("cod"),
                    resultSet.getString("desc"),
                    resultSet.getString("unidade"),
                    resultSet.getFloat("qtd"),
                    resultSet.getFloat("preco")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public void updateProduto(Produto produto) {
        try {
            String query = "UPDATE produto SET desc = ?, unidade = ?, qtd = ?, preco = ? WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, produto.getDesc());
            statement.setString(2, produto.getUnidade());
            statement.setFloat(3, produto.getQtd());
            statement.setFloat(4, produto.getPreco());
            statement.setInt(5, produto.getCod());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduto(int id) {
        try {
            String query = "DELETE FROM produto WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
