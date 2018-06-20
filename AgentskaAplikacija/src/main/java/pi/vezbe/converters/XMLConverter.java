package pi.vezbe.converters;

import pi.vezbe.model.TipSmestaja;
import glavna.wsdl.TipSmestajaXML;

public class XMLConverter {

	public XMLConverter(){
		
	}
	
	public TipSmestajaXML convertTipSmestajaToTipSmestajaXML(TipSmestaja tip){
		TipSmestajaXML retVal = new TipSmestajaXML();
		retVal.setId(tip.getId());
		retVal.setNaziv(tip.getNaziv());
		
		return retVal;
	}
	public TipSmestaja convertTipSmestajaXMLToTipSmestaja(TipSmestajaXML tipXML){
		TipSmestaja retVal = new TipSmestaja();
		retVal.setId(tipXML.getId());
		retVal.setNaziv(tipXML.getNaziv());
		
		return retVal;
	}
	
}
