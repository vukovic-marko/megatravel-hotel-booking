package tim23.agent.FromDTO;

import org.springframework.beans.factory.annotation.Autowired;

import tim23.agent.DTO.TerminskiPlanCenaDTO;
import tim23.agent.model.Cena;
import tim23.agent.repository.SobaRepository;

public class TerminskiPlanCenaConverter {
	
	@Autowired
	private SobaRepository sobaRepository;

	public Cena convert(TerminskiPlanCenaDTO cenaDTO) {
		Cena c = new Cena();
		c.setVrednost(cenaDTO.getCena());
		c.setPocetakVazenja(cenaDTO.getPocetakVazenja());
		c.setKrajVazenja(cenaDTO.getKrajVazenja());
		c.setSoba(sobaRepository.findById(cenaDTO.getIdSobe()).get());
		return c;
	}
}
