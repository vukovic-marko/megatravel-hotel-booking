package tim23.agent.FromDTO;

import tim23.agent.DTO.SobaDTO;
import tim23.agent.model.Adresa;
import tim23.agent.model.Agent;
import tim23.agent.model.Soba;
import tim23.agent.model.TipSmestaja;

public class FromSobaDTO {
	
	public Soba convert(SobaDTO sobaDTO) {
		Soba soba=new Soba();
		soba.setIdSoba(sobaDTO.getIdSobe());
		soba.setBrojKreveta(sobaDTO.getBroj_kreveta());
		soba.setBrojSobe(sobaDTO.getBroj_sobe());
		soba.setOpisSmestaja(sobaDTO.getOpis());
		soba.setAdresa(sobaDTO.getAdresa());
		soba.setTipSmestaja(sobaDTO.getTipSmestaja());
		soba.setOcena(0d);
		soba.setOdobreno(false);
		return soba;
	}
}
