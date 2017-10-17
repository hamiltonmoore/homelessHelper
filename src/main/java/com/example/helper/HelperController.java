package com.example.helper;

import com.example.helper.helpermodel.Helper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.Double.parseDouble;

@Controller
public class HelperController {
    final static String URL = "https://data.nashville.gov/resource/8zc7-2afq.json";

    // route consumes API above \
    //once received we have a list
    //loop through list
    //for each resource
    //create a new Helper
    //populate each Helper fields with resource fields
    //save Helper to db

    @RequestMapping("/")
    public String dataBase(Model model) {
        List<Helper> results = getHelper(URL);
        model.addAttribute("helper", results);

        for(int i=0; i<results.size(); i++) {
            Helper helper = new Helper;

            helper.setContact("contact");
            helper.setContact_type("contact_type");
            helper.setLongitude(parseDouble("longitude"));
            helper.setLatitude(parseDouble("latitude"));
            helper.setLocation_1_address("location_1_address");
            helper.setLocation_1_city("location_1_city");
            helper.setLocation_1_state("Location_1_state");
            helper.setNotes("notes");
            helper.setPhone_number("phone_number");
        }
        return "allresults";
    }

    public static List<Helper> getHelper(String route) {

        RestTemplate restTemplate = new RestTemplate();
        ResultsPage helperResult = restTemplate.getForObject(route, ResultsPage.class);
        return helperResult.results;


    }
}
