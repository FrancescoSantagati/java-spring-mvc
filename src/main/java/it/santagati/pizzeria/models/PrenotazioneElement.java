package it.santagati.pizzeria.models;

/**
 * Created by Francesco on 12/06/2014.
 */
public class PrenotazioneElement {
    private String pizza;
    private int costo;
    private int quantita;

    public PrenotazioneElement(String pizza, int costo, int quantita) {
        this.pizza = pizza;
        this.costo = costo;
        this.quantita = quantita;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
