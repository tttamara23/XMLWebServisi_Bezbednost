package pi.vezbe.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Smestaj;
import pi.vezbe.repository.SmestajRepository;

@Service
public class SmestajService {
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	public Smestaj save(Smestaj smestaj) {
		return smestajRepository.save(smestaj);
	}
	
	public List<Smestaj>getAll() {
		return smestajRepository.findAll();
	}
	
	public List<Smestaj>getLocations() {
		return smestajRepository.findLocations();
	}
	
	public List<Smestaj>getByLocation(String lokacija) {
		return smestajRepository.findByLokacija(lokacija);
	}
	
	public Smestaj findById(Long idSmestaja){
		return smestajRepository.findOne(idSmestaja);
	}
	
	@WebMethod()
	  public String sayHello(String name) {
	    return name + ".";
	  }

}
