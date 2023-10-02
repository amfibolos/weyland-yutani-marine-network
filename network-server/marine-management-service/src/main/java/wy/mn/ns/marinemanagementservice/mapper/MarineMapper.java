package wy.mn.ns.marinemanagementservice.mapper;

import wy.mn.ns.marinemanagementservice.dto.MarineCreationDTO;
import wy.mn.ns.marinemanagementservice.dto.MarineDTO;
import wy.mn.ns.marinemanagementservice.entity.Marine;

public class MarineMapper {

    public static MarineDTO toMarineDTO(Marine marine) {
        return MarineDTO.builder()
                .id(marine.getId())
                .firstName(marine.getFirstName())
                .lastName(marine.getLastName())
                .militaryRank(marine.getMilitaryRank())
                .spaceForce(marine.getSpaceForce())
                .division(marine.getDivision())
                .base(marine.getBase())
                .idsn(marine.getIdsn())
                .email(marine.getEmail())
                .createdAt(marine.getCreatedAt())
                .createdBy(marine.getCreatedBy())
                .updatedAt(marine.getUpdatedAt())
                .updatedBy(marine.getUpdatedBy())
                .build();
    }

    public static Marine fromMarineDTO(MarineDTO marineDTO) {
        return Marine.builder()
                .id(marineDTO.getId())
                .firstName(marineDTO.getFirstName())
                .lastName(marineDTO.getLastName())
                .militaryRank(marineDTO.getMilitaryRank())
                .spaceForce(marineDTO.getSpaceForce())
                .division(marineDTO.getDivision())
                .base(marineDTO.getBase())
                .email(marineDTO.getEmail())
                .idsn(marineDTO.getIdsn())
                .createdAt(marineDTO.getCreatedAt())
                .createdBy(marineDTO.getCreatedBy())
                .updatedAt(marineDTO.getUpdatedAt())
                .updatedBy(marineDTO.getUpdatedBy())
                .build();
    }

    public static Marine fromCreationDTO(MarineCreationDTO creationDTO){
        return Marine.builder()
                .firstName(creationDTO.getFirstName())
                .lastName(creationDTO.getLastName())
                .email(creationDTO.getEmail())
                .build();
    }
}
