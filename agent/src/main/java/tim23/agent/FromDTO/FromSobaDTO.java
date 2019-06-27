package tim23.agent.FromDTO;

import org.springframework.beans.factory.annotation.Autowired;

import tim23.agent.DTO.SobaDTO;
import tim23.agent.model.Soba;
import tim23.agent.repository.AdresaRepository;
import tim23.agent.repository.TipSmestajaRepository;

public class FromSobaDTO {
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	@Autowired
	private TipSmestajaRepository tipSmestajaRepository;
	
	
	public Soba convert(SobaDTO sobaDTO) {
		Soba soba=new Soba();
		soba.setIdSoba(sobaDTO.getIdSobe());
		soba.setBrojKreveta(sobaDTO.getBroj_kreveta());
		soba.setBrojSobe(sobaDTO.getBroj_sobe());
		soba.setOpisSmestaja(sobaDTO.getOpis());
		soba.setAdresa(adresaRepository.findById(sobaDTO.getAdresa()).get());
		soba.setTipSmestaja(tipSmestajaRepository.findById(sobaDTO.getTipSmestaja()).get());
		soba.setOcena(0d);
		soba.setOdobreno(false);
		return soba;
	}
}
