package pi.vezbe.converters;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.PonudaDTO;
import pi.vezbe.model.Ponuda;
import pi.vezbe.service.SmestajService;

@Component
public class PonudaDTOToPonudaConverter implements Converter<PonudaDTO, Ponuda>{
	
	@Autowired
	private SmestajService smestajService;
	
	@Override
	public Ponuda convert(PonudaDTO arg0) {
		// TODO Auto-generated method stub
		Ponuda ret = new Ponuda();
		
		ret.setBrojLezaja(arg0.getBrojLezaja());
		ret.setBrojSlobodnihPonuda(arg0.getBrojSlobodnihPonuda());
		ret.setCena( new BigDecimal(arg0.getCena(), MathContext.DECIMAL64));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datum1;
		String datum11 = arg0.getDatumOd() + " 00:00:00";
		String datum22 = arg0.getDatumDo() + " 00:00:00";
		try {
			datum1 = dateFormat.parse(datum22);
			ret.setDatumDo(datum1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date datum2;
		try {
			datum2 = dateFormat.parse(datum11);
			ret.setDatumOd(datum2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret.setSmestaj(smestajService.findById(arg0.getSmestajId()));
		
		return ret;
	}

}
