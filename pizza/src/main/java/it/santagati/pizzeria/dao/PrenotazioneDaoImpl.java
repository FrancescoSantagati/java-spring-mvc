package it.santagati.pizzeria.dao;

import it.santagati.pizzeria.Common;
import it.santagati.pizzeria.models.Prenotazione;
import org.json.JSONArray;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Francesco on 12/06/2014.
 */
public class PrenotazioneDaoImpl implements PrenotazioneDao {

    private DataSource dataSource;
    private String tableName = "ium_prenotazioni";

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Prenotazione prenotazione)  {
        String sql = "INSERT INTO " + tableName +
                "(json_pizze, data_consegna, username) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, new JSONArray(prenotazione.getPizzeList()).toString());
            ps.setString(2, prenotazione.getData_consegna());
            ps.setString(3, prenotazione.getUsername());
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
    public void confirm(int id) {
        String sql = "UPDATE " + tableName + " SET flag_confirm = 1 WHERE id = ?";
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
    public void delete(int id) {
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
    public ArrayList<Prenotazione> findAllByUsername(String username) {
        String sql = "SELECT * FROM " + tableName + " WHERE username = ? ORDER BY data_consegna DESC";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                prenotazioni.add(new Prenotazione(
                        Common.getPizzeListByJsonString(rs.getString("json_pizze")),
                        rs.getString("data_consegna"),
                        rs.getString("username"),
                        rs.getInt("flag_confirm"),
                        rs.getInt("id")
                ));
            }
            rs.close();
            ps.close();
            return prenotazioni;
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
    public ArrayList<Prenotazione> getAll() {
        String sql = "SELECT * FROM " + tableName + " ORDER BY data_consegna DESC";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                prenotazioni.add(new Prenotazione(
                        Common.getPizzeListByJsonString(rs.getString("json_pizze")),
                        rs.getString("data_consegna"),
                        rs.getString("username"),
                        rs.getInt("flag_confirm"),
                        rs.getInt("id")
                ));
            }
            rs.close();
            ps.close();
            return prenotazioni;
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
