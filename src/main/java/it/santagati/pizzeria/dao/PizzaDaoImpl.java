package it.santagati.pizzeria.dao;

import it.santagati.pizzeria.dao.PizzaDao;
import it.santagati.pizzeria.models.Pizza;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Francesco on 12/06/2014.
 */
public class PizzaDaoImpl implements PizzaDao {

    private DataSource dataSource;
    private String tableName = "ium_pizze";

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Pizza pizza) throws SQLException {
        String sql = "INSERT INTO " + tableName +
                "(nome, ingredienti, prezzo) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pizza.getNome());
            ps.setString(2, pizza.getIngredienti());
            ps.setString(3, pizza.getPrezzo());
            ps.executeUpdate();
            ps.close();

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public void update(Pizza pizza) throws SQLException {
        String sql = "UPDATE " + tableName +
                " SET nome = ?, ingredienti = ?, prezzo = ? WHERE id = ?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pizza.getNome());
            ps.setString(2, pizza.getIngredienti());
            ps.setString(3, pizza.getPrezzo());
            ps.setInt(4, pizza.getId());
            ps.executeUpdate();
            ps.close();

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM " + tableName +" WHERE id = ?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public Pizza findById(int id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Pizza pizza = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pizza = new Pizza(
                        rs.getString("nome"),
                        rs.getString("ingredienti"),
                        rs.getString("prezzo")
                );
            }
            rs.close();
            ps.close();
            return pizza;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public ArrayList<Pizza> getAll() {
        String sql = "SELECT * FROM " + tableName;
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ArrayList<Pizza> pizze = new ArrayList<Pizza>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pizze.add(new Pizza(
                        rs.getString("nome"),
                        rs.getString("ingredienti"),
                        rs.getString("prezzo"),
                        rs.getInt("id")
                ));
            }
            rs.close();
            ps.close();
            return pizze;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
