package it.santagati.pizzeria;

import it.santagati.pizzeria.dao.PizzaDao;
import it.santagati.pizzeria.dao.PrenotazioneDao;
import it.santagati.pizzeria.models.PrenotazioneElement;
import org.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;

/**
 * Created by Francesco on 16/06/2014.
 */
public class Common {

    public static final String applicationBasePath = "/pizzeria";

    private static ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("spring-module.xml");
    }

    private static Authentication getSecurityContext() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getCurrentUsername() {
        return getSecurityContext().getName();
    }

    public static PizzaDao getPizzaDao() {
        return (PizzaDao) getContext().getBean("pizzaDAO");
    }

    public static PrenotazioneDao getPrenotazioneDao() {
        return (PrenotazioneDao) getContext().getBean("prenotazioneDAO");
    }

    public static ArrayList<PrenotazioneElement> getPizzeListByJsonString(String jsonPizze) {
        ArrayList<PrenotazioneElement> pizzaList = new ArrayList<PrenotazioneElement>();
        JSONArray pizzaArray = new JSONArray(jsonPizze);
        for (int i=0; i < pizzaArray.length(); i++){
            pizzaList.add(new PrenotazioneElement(
                    pizzaArray.getJSONObject(i).getString("pizza"),
                    pizzaArray.getJSONObject(i).getInt("costo"),
                    pizzaArray.getJSONObject(i).getInt("quantita")
            ));
        }
        return pizzaList;
    }
}
