package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.KorisnikDTO;
import pi.vezbe.model.Korisnik;

@Component
public class KorisnikToKorisnikDTOConverter implements Converter<Korisnik, KorisnikDTO> {

	@Override
	public KorisnikDTO convert(Korisnik source) {
		if(source == null) {
			return null;
		}
		KorisnikDTO korisnikDTO = new KorisnikDTO();
		korisnikDTO.setId(source.getId());
		korisnikDTO.setEmail(source.getEmail());
		korisnikDTO.setIme(source.getIme());
		korisnikDTO.setPrezime(source.getPrezime());
		return korisnikDTO;
	}
	
	public List<KorisnikDTO> convert(List<Korisnik> source) {
		List<KorisnikDTO> ret = new ArrayList<KorisnikDTO>();
		for(Korisnik korisnik : source) {
			ret.add(convert(korisnik));
		}
		return ret;
	}

}
