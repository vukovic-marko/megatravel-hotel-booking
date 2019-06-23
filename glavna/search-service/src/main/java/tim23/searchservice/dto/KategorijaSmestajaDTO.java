package tim23.searchservice.dto;

public class KategorijaSmestajaDTO {

	private Integer id;
	private String naziv;
	
	public KategorijaSmestajaDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public KategorijaSmestajaDTO(Integer id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	
	
}
