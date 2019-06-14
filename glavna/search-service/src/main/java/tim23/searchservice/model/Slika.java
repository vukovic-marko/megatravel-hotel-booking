package tim23.searchservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Slika {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSlike;
	
	@Column
	private String urlSlike;
	
	@ManyToOne
	@JoinColumn(name="id_sobe")
	private Soba idSobe;
	
	public Slika() {
		
	}

	public Slika(Integer idSlike, String urlSlike, Soba idSobe) {
		super();
		this.idSlike = idSlike;
		this.urlSlike = urlSlike;
		this.idSobe = idSobe;
	}

	public Integer getIdSlike() {
		return idSlike;
	}

	public void setIdSlike(Integer idSlike) {
		this.idSlike = idSlike;
	}

	public String getUrlSlike() {
		return urlSlike;
	}

	public void setUrlSlike(String urlSlike) {
		this.urlSlike = urlSlike;
	}

	public Soba getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Soba idSobe) {
		this.idSobe = idSobe;
	}
	
	
}
