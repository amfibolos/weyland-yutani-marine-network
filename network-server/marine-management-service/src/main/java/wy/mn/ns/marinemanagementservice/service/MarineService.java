package wy.mn.ns.marinemanagementservice.service;

import wy.mn.ns.marinemanagementservice.dto.MarineCreationDTO;
import wy.mn.ns.marinemanagementservice.dto.MarineDTO;

public interface MarineService {

    MarineDTO createMarine(MarineCreationDTO marineDTO);

    MarineDTO fetchMarine(Long id);

    MarineDTO updateMarine(MarineDTO marineDTO);

    boolean deleteMarine(Long id);

}
