package pi.vezbe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_smestaj", "id_agent"})
})
public class SmestajVlasnik {
	 	@Id
	    protected Long id;
	 
	
	 	@ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_smestaj", nullable = false)
		private Smestaj smestaj;
		
		@ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_agent", nullable = false)
		private KrajnjiKorisnik agent;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		

		
		public SmestajVlasnik(Long id, Smestaj smestaj, KrajnjiKorisnik agent) {
			super();
			this.id = id;
			this.smestaj = smestaj;
			this.agent = agent;
		}

		public Smestaj getSmestaj() {
			return smestaj;
		}

		public void setSmestaj(Smestaj smestaj) {
			this.smestaj = smestaj;
		}

		public KrajnjiKorisnik getAgent() {
			return agent;
		}

		public void setAgent(KrajnjiKorisnik agent) {
			this.agent = agent;
		}

		public SmestajVlasnik() {
			super();
		}

		

}


