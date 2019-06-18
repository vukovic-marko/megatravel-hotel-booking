package tim23.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tim23.adminservice.model.TipSmestaja;
import tim23.adminservice.repository.TipSmestajaRepository;

import java.util.List;

@Service
public class TipSmestajaService {

    @Autowired
    private TipSmestajaRepository tipSmestajaRepository;

    public ResponseEntity<List<TipSmestaja>> getTipoviSmestaja() {
        return ResponseEntity.ok(tipSmestajaRepository.findAll());
    }

    public ResponseEntity<TipSmestaja> getTipSmestaja(Integer id) {
        return ResponseEntity.ok(tipSmestajaRepository.findByIdTipa(id));
    }

    public ResponseEntity<TipSmestaja> dodajTipSmestaja(TipSmestaja tipSmestaja) {
        return ResponseEntity.ok(tipSmestajaRepository.save(tipSmestaja));
    }

    public ResponseEntity ukloniTipSmestaja(Integer id) {
        TipSmestaja t = tipSmestajaRepository.findByIdTipa(id);
        if (t != null) {
            tipSmestajaRepository.delete(t);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
