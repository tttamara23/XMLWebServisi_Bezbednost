package pi.vezbe.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.PonudaDTO;
import pi.vezbe.model.Ponuda;

@Component
public class PonudaToPonudaDtoConverter implements Converter<Ponuda, PonudaDTO> {

	@Override
	public PonudaDTO convert(Ponuda source) {
		if(source == null) {
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
		PonudaDTO ret = new PonudaDTO();
		ret.setId(source.getId());
		ret.setBrojLezaja(source.getBrojLezaja());
		ret.setBrojSlobodnihPonuda(source.getBrojSlobodnihPonuda());
		ret.setCena(source.getCena().doubleValue());
        ret.setDatumDo(dateFormat.format(source.getDatumDo()));
        ret.setDatumOd(dateFormat.format(source.getDatumOd()));
		ret.setSmestajId(source.getSmestaj().getId());
		ret.setSmestajNaziv(source.getSmestaj().getNaziv());
		
		return ret;
	}
	
	public List<PonudaDTO> convert(List<Ponuda> source) {
		List<PonudaDTO> ret = new ArrayList<PonudaDTO>();
		for(Ponuda ponuda : source) {
			ret.add(convert(ponuda));
		}
		return ret;
	}

}
