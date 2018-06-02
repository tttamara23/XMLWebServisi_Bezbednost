package pi.vezbe.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.RezervacijaDTO;
import pi.vezbe.model.Rezervacija;
import pi.vezbe.service.UserService;

@Component
public class RezervacijaToRezervacijaDTO implements Converter<Rezervacija, RezervacijaDTO>{

	@Autowired
	private PonudaToPonudaDtoConverter ponudaToPonudaDtoConverter;
	

	
	@Override
	public RezervacijaDTO convert(Rezervacija source) {
		if(source == null) {
			return null;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		RezervacijaDTO ret = new RezervacijaDTO();
		ret.setPonudaDTO(ponudaToPonudaDtoConverter.convert(source.getPonuda()));
		ret.setDate(dateFormat.format(source.getDatumRezervacije()));
		ret.setId(source.getId());
		ret.setRealizovano(source.isRealizovano());
		
		return ret;
	}
	
	public List<RezervacijaDTO> convert(List<Rezervacija> source) {
		List<RezervacijaDTO> ret = new ArrayList<RezervacijaDTO>();
		for(Rezervacija rez : source) {
			ret.add(convert(rez));
		}
		return ret;
	}

}
