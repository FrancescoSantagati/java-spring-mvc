package it.santagati.pizzeria.models;

/**
 * Created by Francesco on 12/06/2014.
 */
public class Pizza {

    private int id;
    private String nome;
    private String ingredienti;
    private String prezzo;

    public Pizza(String nome, String ingredienti, String prezzo) {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
    }

    public Pizza(String nome, String ingredienti, String prezzo, int id) {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }
}
