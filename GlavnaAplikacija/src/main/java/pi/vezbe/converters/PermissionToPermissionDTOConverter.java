package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.PermissionDTO;
import pi.vezbe.model.Permission;

@Component
public class PermissionToPermissionDTOConverter implements Converter<Permission, PermissionDTO>{

	@Override
	public PermissionDTO convert(Permission source) {
		if(source == null) {
			return null;
		}
		PermissionDTO permissionDTO = new PermissionDTO();
		permissionDTO.setId(source.getId());
		permissionDTO.setName(source.getName());
		return permissionDTO;
	}
	
	public List<PermissionDTO> convert(List<Permission> source) {
		List<PermissionDTO> ret = new ArrayList<PermissionDTO>();
		for(Permission permission : source) {
			ret.add(convert(permission));
		}
		return ret;
	}

}
