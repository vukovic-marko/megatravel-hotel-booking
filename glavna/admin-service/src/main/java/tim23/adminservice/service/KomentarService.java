package tim23.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tim23.adminservice.model.Komentar;
import tim23.adminservice.repository.KomentarRepository;

import java.util.List;

@Service
public class KomentarService {

    @Autowired
    private KomentarRepository komentarRepository;

    public ResponseEntity<List<Komentar>> getKomentari() {
        return ResponseEntity.ok(komentarRepository.findAll());
    }

    public ResponseEntity<Komentar> getKomentar(Integer id) {
        return ResponseEntity.ok(komentarRepository.findByIdKomentara(id));
    }

    public ResponseEntity<Komentar> objaviKomentar(Integer id) {
        Komentar k = komentarRepository.findByIdKomentara(id);

        if (k != null) {
            k.setOdobreno(true);
            komentarRepository.save(k);
            return ResponseEntity.ok(k);
        }

        return ResponseEntity.badRequest().build();
    }
}
