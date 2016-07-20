package it.santagati.pizzeria.models;

import java.util.ArrayList;

/**
 * Created by Francesco on 12/06/2014.
 */
public class Prenotazione {

    private ArrayList<PrenotazioneElement> pizzeList;
    private String data_consegna;
    private String username;
    private int flag_confirm;
    private int id;

    public Prenotazione(ArrayList<PrenotazioneElement> pizzeList, String data_consegna, String username) {
        this.pizzeList = pizzeList;
        this.data_consegna = data_consegna;
        this.username = username;
    }

    public Prenotazione(ArrayList<PrenotazioneElement> pizzeList, String data_consegna, String username, int flag_confirm, int id) {
        this.pizzeList = pizzeList;
        this.data_consegna = data_consegna;
        this.username = username;
        this.flag_confirm = flag_confirm;
        this.id = id;
    }

    public ArrayList<PrenotazioneElement> getPizzeList() {
        return pizzeList;
    }

    public int getId() {
        return id;
    }

    public void setPizzeList(ArrayList<PrenotazioneElement> pizzeList) {
        this.pizzeList = pizzeList;
    }

    public String getData_consegna() {
        return data_consegna;
    }

    public void setData_consegna(String data_consegna) {
        this.data_consegna = data_consegna;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFlag_confirm() {
        return flag_confirm;
    }

    public void setFlag_confirm(int flag_confirm) {
        this.flag_confirm = flag_confirm;
    }
}
