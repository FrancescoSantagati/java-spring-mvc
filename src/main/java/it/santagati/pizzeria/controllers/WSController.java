package it.santagati.pizzeria.controllers;

import it.santagati.pizzeria.Common;
import it.santagati.pizzeria.dao.PizzaDao;
import it.santagati.pizzeria.models.Pizza;
import it.santagati.pizzeria.models.Prenotazione;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(Common.applicationBasePath)

public class WSController {

    @RequestMapping(value = "/user/inviaPrenotazione", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> inviaPrenotazione(@RequestBody String body) {

        JSONObject jsonResponse = new JSONObject();
        try {
            JSONObject jsonPrenotazione = new JSONObject(body);
            String data = jsonPrenotazione.getString("data");
            JSONArray prenotazione = jsonPrenotazione.getJSONArray("prenotazione");
            Common.getPrenotazioneDao().insert(new Prenotazione(
                    Common.getPizzeListByJsonString(prenotazione.toString()),
                    data,
                    Common.getCurrentUsername()
            ));

            jsonResponse.put("code", 200);
            jsonResponse.put("status", "success");
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
            jsonResponse.put("code", 400);
            jsonResponse.put("status", e.getMessage());
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/confermaPrenotazione", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> confermaPrenotazione(@RequestParam(value = "id", required = true) int id) {

        JSONObject jsonResponse = new JSONObject();
        try {
            Common.getPrenotazioneDao().confirm(id);
            jsonResponse.put("code", 200);
            jsonResponse.put("status", "success");
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
            jsonResponse.put("code", 400);
            jsonResponse.put("status", e.getMessage());
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/cancellaPrenotazione", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> cancellaPrenotazione(@RequestParam(value = "id", required = true) int id) {

        JSONObject jsonResponse = new JSONObject();
        try {
            Common.getPrenotazioneDao().delete(id);
            jsonResponse.put("code", 200);
            jsonResponse.put("status", "success");
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
            jsonResponse.put("code", 400);
            jsonResponse.put("status", e.getLocalizedMessage());
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/admin/inserisciPizza", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> inserisciPizza(@RequestBody String body) {

        JSONObject jsonResponse = new JSONObject();
        try {
            JSONObject jsonPrenotazione = new JSONObject(body);
            int id = jsonPrenotazione.getInt("id");
            String nome = jsonPrenotazione.getString("nome");
            String ingredienti = jsonPrenotazione.getString("ingredienti");
            String prezzo = jsonPrenotazione.getString("prezzo");

//            CREATE
            if(id == 0) {
                Common.getPizzaDao().insert(new Pizza(nome, ingredienti, prezzo));
            }
//            UPDATE
            else {
                Common.getPizzaDao().update(new Pizza(nome, ingredienti, prezzo, id));
            }

            jsonResponse.put("code", 200);
            jsonResponse.put("status", "success");
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
            jsonResponse.put("code", 400);
            jsonResponse.put("status", e.getMessage());
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/admin/cancellaPizza", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> cancellaPizza(
            @RequestParam(value = "id", required = true) int id) {

        JSONObject jsonResponse = new JSONObject();
        try {
            Common.getPizzaDao().delete(id);

            jsonResponse.put("code", 200);
            jsonResponse.put("status", "success");
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
            jsonResponse.put("code", 400);
            jsonResponse.put("status", e.getMessage());
            return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}