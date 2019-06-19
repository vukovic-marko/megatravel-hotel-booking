package tim23.searchservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tim23.searchservice.SearchService;
import tim23.searchservice.model.DodatneUsluge;
import tim23.searchservice.model.Soba;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController{
private ArrayList<DodatneUsluge> du = new ArrayList<>();
    @Autowired
    private SearchService searchservice;
   
    @GetMapping("/")
    public String hello() {
    	return "Hello";
    }
 
   @GetMapping("/{brojkreveta},{drzava},{grad},{uib},{dd},{dod}")
    public String search(@PathVariable String brojkreveta,@PathVariable String drzava, @PathVariable String grad,@PathVariable String uib,@PathVariable Date dd,@PathVariable Date dod) {
      List<Soba> s = searchservice.fuzzySearch(brojkreveta,drzava,grad,uib,dd,dod,null,null);
     
     return "Nasao "+s.size();        
    }


}
