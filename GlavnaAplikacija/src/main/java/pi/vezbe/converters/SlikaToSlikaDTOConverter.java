package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.SlikaDTO;
import pi.vezbe.model.Slika;

@Component
public class SlikaToSlikaDTOConverter implements Converter<Slika, SlikaDTO>{
	
	@Override
	public SlikaDTO convert(Slika source) {
		if(source == null) {
			return null;
		}
		SlikaDTO ret = new SlikaDTO();
		ret.setId(source.getId());
		ret.setUrl(source.getUrl());
		ret.setIdSmestaj(source.getSmestaj().getId());
		return ret;
	}
	
	public List<SlikaDTO> convert(List<Slika> source) {
		List<SlikaDTO> ret = new ArrayList<SlikaDTO>();
		for(Slika slika : source) {
			ret.add(convert(slika));
		}
		return ret;
	}

}
