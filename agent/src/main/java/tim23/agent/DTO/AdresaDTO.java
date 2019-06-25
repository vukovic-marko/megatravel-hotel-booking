package tim23.agent.DTO;

public class AdresaDTO {

	private Integer idAdrese;
	private String grad;
	private String drzava;
	private String ulicaIBroj;
	
	public AdresaDTO() {
		
	}

	public AdresaDTO(Integer idAdrese, String grad, String drzava, String ulicaIBroj) {
		super();
		this.idAdrese = idAdrese;
		this.grad = grad;
		this.drzava = drzava;
		this.ulicaIBroj = ulicaIBroj;
	}

	public Integer getIdAdrese() {
		return idAdrese;
	}

	public void setIdAdrese(Integer idAdrese) {
		this.idAdrese = idAdrese;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getUlicaIBroj() {
		return ulicaIBroj;
	}

	public void setUlicaIBroj(String ulicaIBroj) {
		this.ulicaIBroj = ulicaIBroj;
	}
	
	
}
