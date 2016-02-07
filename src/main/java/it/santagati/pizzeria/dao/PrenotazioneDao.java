package it.santagati.pizzeria.dao;

import it.santagati.pizzeria.models.Prenotazione;

import java.util.ArrayList;

/**
 * Created by Francesco on 12/06/2014.
 */
public interface PrenotazioneDao {

    void insert(Prenotazione prenotazione);
    void confirm(int id);
    void delete(int id);
    ArrayList<Prenotazione> findAllByUsername(String username);
    ArrayList<Prenotazione> getAll();
}
