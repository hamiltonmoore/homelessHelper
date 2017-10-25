package com.example.helper;

import com.example.helper.helpermodel.ApiResult;
import com.example.helper.helpermodel.Helper;
import com.example.helper.helpermodel.Location;
import com.example.helper.helperservice.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.annotation.PostConstruct;
import java.util.*;

@CrossOrigin
@RestController
public class HelperController {
    final static String URL = "https://data.nashville.gov/resource/8zc7-2afq.json";

    @Autowired
    HelperService helperService;

    @PostConstruct
    private void createTables(){
        helperService.createTable();
    }

    // route consumes API above \
    //once received we have a list
    //loop through list
    //for each resource
    //create a new Helper
    //populate each Helper fields with resource fields
    //save Helper to db

    @RequestMapping(path = "/api/admin/loaddata", method = RequestMethod.GET)   // TODO: /{api-key}
    public String loadData() {
        ApiResult[] results = getApiResult(URL);

        System.out.println("BEFORE: # of rows deleted = " + helperService.deleteAll());

        Arrays.asList(results).stream()
                .filter( result ->
                    result.getContact_type().equals("Clothing") ||
                            result.getContact_type().equals("Food Assistance") ||
                            result.getContact_type().equals("Housing") ||
                            result.getContact_type().equals("Transportation") )
                .forEach( helper -> helperService.add(apiMapper(helper)) );
        return String.valueOf(helperService.count()) + " Records added!";
    }

    private Helper apiMapper(ApiResult result) {
        Helper helper = new Helper();
        helper.setContact(result.getContact());
        helper.setContact_type(result.getContact_type());

        Location location = result.getLocation_1();

        if (location != null) {
            helper.setLongitude(location.getCoordinates().get(0));
            helper.setLatitude(location.getCoordinates().get(1));
        }

        helper.setLocation_1_address(result.getLocation_1_address());
        helper.setLocation_1_city(result.getLocation_1_city());
        helper.setLocation_1_state(result.getLocation_1_state());
        helper.setNotes(result.getNotes());
        helper.setPhone_number(result.getphone_number());
        return helper;
    }

    public static ApiResult[] getApiResult(String route) {

        RestTemplate restTemplate = new RestTemplate();
        ApiResult[] apiResult = restTemplate.getForObject(route, ApiResult[].class);
        return apiResult;
    }

    @RequestMapping("/api/resources/{variable}")
    public List<Helper> resources(@PathVariable String variable) {
        List<Helper> results = helperService.getByContact_type(variable);
        return results;
    }

    @RequestMapping(path = "/add_resource", method = RequestMethod.POST)
    public String createResoure(@RequestParam(value = "Contact") String Contact,
                                @RequestParam(value = "Contact_type") String Contact_type,
                                @RequestParam(value = "longitude") Double longitude,
                                @RequestParam(value = "latitude") Double latitude,
                                @RequestParam(value = "location_1_address") String location_1_address,
                                @RequestParam(value = "location_1_city") String location_1_city,
                                @RequestParam(value = "location_1_state") String location_1_state,
                                @RequestParam(value = "notes") String notes,
                                @RequestParam(value = "phone_number") String phone_number, Model model) {
        Helper helper = new Helper();

        helper.setContact(Contact);
        helper.setContact_type(Contact_type);
        helper.setLongitude(longitude);
        helper.setLatitude(latitude);
        helper.setLocation_1_address(location_1_address);
        helper.setLocation_1_city(location_1_city);
        helper.setLocation_1_state(location_1_state);
        helper.setNotes(notes);
        helper.setPhone_number(phone_number);

        helperService.add(helper);

        return "redirect:/helpers.html";
    }

    @RequestMapping("allResources")
    public List<Helper> allResources() {
        List<Helper> allResources = helperService.get();
        return allResources;
    }


    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        helperService.delete(id);
        return "redirect:/helpers.html";
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, Helper helper) {
        helperService.update(helper, id);
        return "redirect:/customers.html";
    }
}
