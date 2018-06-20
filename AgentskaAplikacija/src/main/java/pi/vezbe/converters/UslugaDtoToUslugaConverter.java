package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.UslugaDTO;
import pi.vezbe.model.Usluga;

@Component
public class UslugaDtoToUslugaConverter implements Converter<UslugaDTO, Usluga>{

	@Override
	public Usluga convert(UslugaDTO source) {
		// TODO Auto-generated method stub
		if(source == null) {
			return null;
		}
		Usluga ret = new Usluga();
		ret.setId(source.getId());
		ret.setNaziv(source.getNaziv());
		return ret;
	}
	
	public ArrayList<Usluga> convert(ArrayList<UslugaDTO> source) {
		ArrayList<Usluga> ret = new ArrayList<Usluga>();
		for(UslugaDTO usluga : source) {
			ret.add(convert(usluga));
		}
		return ret;
	}

}
