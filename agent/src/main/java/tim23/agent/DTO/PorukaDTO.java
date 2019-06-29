package tim23.agent.DTO;

public class PorukaDTO {
	private String username;
	private String sadrzaj;
	
	public PorukaDTO() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public PorukaDTO(String username, String sadrzaj) {
		super();
		this.username = username;
		this.sadrzaj = sadrzaj;
	}
	

}
