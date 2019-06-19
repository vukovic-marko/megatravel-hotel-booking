package tim23.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tim23.adminservice.model.Agent;
import tim23.adminservice.model.Authority;
import tim23.adminservice.model.KrajnjiKorisnik;
import tim23.adminservice.model.Uloga;
import tim23.adminservice.repository.AuthorityRepository;
import tim23.adminservice.repository.KrajnjiKorisnikRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class KrajnjiKorisnikService {

    @Autowired
    private KrajnjiKorisnikRepository krajnjiKorisnikRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<KrajnjiKorisnik> getKrajnjiKorisnici() {
        return krajnjiKorisnikRepository.findAll();
    }

    public ResponseEntity<KrajnjiKorisnik> getKrajnjiKorisnik(String username) {
        if (krajnjiKorisnikRepository.existsByUsername(username)) {
            return ResponseEntity.ok(krajnjiKorisnikRepository.findByUsername(username));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<KrajnjiKorisnik> setBlokiran(String username, Boolean blokiran) {
        KrajnjiKorisnik k = krajnjiKorisnikRepository.findByUsername(username);
        if (k != null) {
            k.setBlokiran(blokiran);
            krajnjiKorisnikRepository.save(k);
            return ResponseEntity.ok(k);
        }

        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity setUklonjen(String username, Boolean uklonjen) {
        KrajnjiKorisnik k = krajnjiKorisnikRepository.findByUsername(username);
        if (k != null) {
            k.setUklonjen(uklonjen);
            krajnjiKorisnikRepository.save(k);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }






    public ResponseEntity<KrajnjiKorisnik> registerKrajnjiKorisnik(KrajnjiKorisnik korisnik) {

        if (!krajnjiKorisnikRepository.existsByUsername(korisnik.getUsername())) {

            Authority a = authorityRepository.getByName("KRAJNJI");

            korisnik.setAuthorities(new ArrayList<Authority>() {{add(a);}});
            korisnik.setUloga(Uloga.KLIJENT);
            korisnik.setPassword(encoder.encode(korisnik.getPassword()));
            korisnik.setUklonjen(false);
            korisnik.setBlokiran(false);

            krajnjiKorisnikRepository.save(korisnik);

            return ResponseEntity.ok(krajnjiKorisnikRepository.findByUsername(korisnik.getUsername()));
        }

        return ResponseEntity.badRequest().build();
    }
}
