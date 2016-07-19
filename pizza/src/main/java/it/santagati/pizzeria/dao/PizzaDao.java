package it.santagati.pizzeria.dao;

import it.santagati.pizzeria.models.Pizza;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Francesco on 12/06/2014.
 */
public interface PizzaDao {

    public void insert(Pizza pizza) throws SQLException;

    void update(Pizza pizza) throws SQLException;

    void delete(int id) throws SQLException;

    public Pizza findById(int id);

    ArrayList<Pizza> getAll();
}
