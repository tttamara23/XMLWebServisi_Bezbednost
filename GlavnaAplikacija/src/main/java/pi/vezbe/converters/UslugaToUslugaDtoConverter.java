package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.UslugaDTO;
import pi.vezbe.model.Usluga;

@Component
public class UslugaToUslugaDtoConverter implements Converter<Usluga, UslugaDTO> {

	@Override
	public UslugaDTO convert(Usluga source) {
		if(source == null) {
			return null;
		}
		UslugaDTO uslugaDTO = new UslugaDTO();
		uslugaDTO.setId(source.getId());
		uslugaDTO.setNaziv(source.getNaziv());
		return uslugaDTO;
	}
	
	public List<UslugaDTO> convert(List<Usluga> source) {
		List<UslugaDTO> ret = new ArrayList<UslugaDTO>();
		for(Usluga usluga : source) {
			ret.add(convert(usluga));
		}
		return ret;
	}

}
