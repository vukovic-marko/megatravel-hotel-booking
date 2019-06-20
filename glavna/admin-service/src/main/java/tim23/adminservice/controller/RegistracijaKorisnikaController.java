package tim23.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim23.adminservice.model.KrajnjiKorisnik;
import tim23.adminservice.service.KrajnjiKorisnikService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/korisnik")
public class RegistracijaKorisnikaController {

    @Autowired
    private KrajnjiKorisnikService krajnjiKorisnikService;

    @PostMapping("/register")
    public ResponseEntity<KrajnjiKorisnik> registerAgent(@RequestBody KrajnjiKorisnik korisnik, HttpServletRequest request) {
        return krajnjiKorisnikService.registerKrajnjiKorisnik(korisnik);
    }
}
