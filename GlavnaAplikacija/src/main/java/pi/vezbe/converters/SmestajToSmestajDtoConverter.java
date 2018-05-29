package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.model.Smestaj;

@Component
public class SmestajToSmestajDtoConverter implements Converter<Smestaj, SmestajDTO> {

	@Override
	public SmestajDTO convert(Smestaj source) {
		if(source == null) {
			return null;
		}
		SmestajDTO smestajDTO = new SmestajDTO();
		smestajDTO.setId(source.getId());
		smestajDTO.setNaziv(source.getNaziv());
		smestajDTO.setKategorija(source.getKategorija());
		smestajDTO.setLokacija(source.getLokacija());
		smestajDTO.setOpis(source.getOpis());
		smestajDTO.setTip(source.getTip());
		return smestajDTO;
	}
	
	public List<SmestajDTO> convert(List<Smestaj> source) {
		List<SmestajDTO> ret = new ArrayList<SmestajDTO>();
		for(Smestaj smestaj : source) {
			ret.add(convert(smestaj));
		}
		return ret;
	}

}
