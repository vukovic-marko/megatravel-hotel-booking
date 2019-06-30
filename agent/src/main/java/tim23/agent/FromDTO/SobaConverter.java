package tim23.agent.FromDTO;

import tim23.agent.DTO.AdresaDTO;
import tim23.agent.DTO.AgentoveSobeDTO;
import tim23.agent.model.Adresa;
import tim23.agent.model.Soba;

public class SobaConverter {

	public AgentoveSobeDTO convert(Soba soba) {
		AgentoveSobeDTO sobaDTO = new AgentoveSobeDTO();
		AdresaDTO adresaDTO = new AdresaDTO();
		
		Adresa adresa = soba.getAdresa();
		adresaDTO.setDrzava(adresa.getDrzava());
		adresaDTO.setGrad(adresa.getGrad());
		adresaDTO.setUlicaIBroj(adresa.getUlicaIBroj());
		adresaDTO.setIdAdrese(adresa.getId());
		
		sobaDTO.setAdresa(adresaDTO);
		sobaDTO.setBrojKreveta(soba.getBrojKreveta());
		sobaDTO.setBrojSobe(soba.getBrojSobe());
		sobaDTO.setNazivTipaSmestaja(soba.getTipSmestaja().getNaziv());
		sobaDTO.setNazivKategorije(soba.getKategorijaSmestaja().getNaziv());
		sobaDTO.setOpis(soba.getOpisSmestaja());
		sobaDTO.setIdSobe(soba.getIdSoba());
		
		return sobaDTO;
	}
}
