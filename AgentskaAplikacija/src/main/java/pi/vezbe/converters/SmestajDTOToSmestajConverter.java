package pi.vezbe.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.model.Smestaj;
import pi.vezbe.service.TipSmestajaService;

@Component
public class SmestajDTOToSmestajConverter implements Converter<SmestajDTO, Smestaj> {

	@Autowired
	private TipSmestajaDTOToTipSmestajaConverter tipDTOToTip;
	
	@Autowired
	private TipSmestajaService tipService;
	
	@Override
	public Smestaj convert(SmestajDTO arg0) {
		// TODO Auto-generated method stub
		Smestaj ret = new Smestaj();
		ret.setId(arg0.getId());
		ret.setLokacija(arg0.getLokacija());
		ret.setNaziv(arg0.getNaziv());
		ret.setOpis(arg0.getOpis());
		ret.setTipSmestaja(tipService.findByNaziv((arg0.getTip())));
		
		return ret;
	}

}
