package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.PonudaUslugaDTO;
import pi.vezbe.model.PonudaUsluga;

@Component
public class PonudaUslugaToPonudaUslugaDtoConverter implements Converter<PonudaUsluga, PonudaUslugaDTO> {
	
	@Autowired
	private PonudaToPonudaDtoConverter ponudaToPonudaDtoConverter;
	
	@Autowired
	private UslugaToUslugaDtoConverter uslugaToUslugaDtoConverter;

	@Override
	public PonudaUslugaDTO convert(PonudaUsluga source) {
		if(source == null) {
			return null;
		}
		PonudaUslugaDTO ret = new PonudaUslugaDTO();
		ret.setPonudaDTO(ponudaToPonudaDtoConverter.convert(source.getPonuda()));
		ret.setUslugaDTO(uslugaToUslugaDtoConverter.convert(source.getUsluga()));
		return ret;
	}
	
	public List<PonudaUslugaDTO> convert(List<PonudaUsluga> source) {
		List<PonudaUslugaDTO> ret = new ArrayList<PonudaUslugaDTO>();
		for(PonudaUsluga ponudaUsluga : source) {
			ret.add(convert(ponudaUsluga));
		}
		return ret;
	}

}
