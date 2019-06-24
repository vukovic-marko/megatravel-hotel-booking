package tim23.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tim23.adminservice.model.KategorijaSmestaja;
import tim23.adminservice.repository.KategorijaSmestajaRepository;

import java.util.List;

@Service
public class KategorijaSmestajaService {

    @Autowired
    private KategorijaSmestajaRepository kategorijaSmestajaRepository;
    
    public Boolean exists(String naziv) {
    return kategorijaSmestajaRepository.existsByNaziv(naziv);
    
    }

    public ResponseEntity<List<KategorijaSmestaja>> getKategotijeSmestaja() {
        return ResponseEntity.ok(kategorijaSmestajaRepository.findAll());
    }

    public ResponseEntity<KategorijaSmestaja> dodajKategorijuSmestaja(KategorijaSmestaja kategorijaSmestaja) {
        return ResponseEntity.ok(kategorijaSmestajaRepository.save(kategorijaSmestaja));
    }

    public ResponseEntity ukloniKategorijuSmestaja(Integer id) {
        KategorijaSmestaja k = kategorijaSmestajaRepository.findById(id).get();
        if (k != null) {
            kategorijaSmestajaRepository.delete(k);
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.badRequest().build();
    }
}
