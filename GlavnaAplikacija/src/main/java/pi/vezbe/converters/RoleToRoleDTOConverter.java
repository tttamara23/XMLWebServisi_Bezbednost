package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.RoleDTO;
import pi.vezbe.model.Role;

@Component
public class RoleToRoleDTOConverter implements Converter<Role, RoleDTO>{

	@Override
	public RoleDTO convert(Role source) {
		if(source == null) {
			return null;
		}
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(source.getId());
		roleDTO.setName(source.getName());
		return roleDTO;
	}
	
	public List<RoleDTO> convert(List<Role> source) {
		List<RoleDTO> ret = new ArrayList<RoleDTO>();
		for(Role role : source) {
			ret.add(convert(role));
		}
		return ret;
	}

}
