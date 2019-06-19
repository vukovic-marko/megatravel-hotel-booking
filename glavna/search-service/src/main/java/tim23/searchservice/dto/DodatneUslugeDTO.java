package tim23.searchservice.dto;

public class DodatneUslugeDTO {
	private String naziv;
	private Integer id;
	
	public DodatneUslugeDTO() {
		
	}

	public DodatneUslugeDTO(String naziv, Integer id) {
		super();
		this.naziv = naziv;
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
