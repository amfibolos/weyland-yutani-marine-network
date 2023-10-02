package wy.mn.ns.marinemanagementservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wy.mn.ns.marinemanagementservice.dto.MarineCreationDTO;
import wy.mn.ns.marinemanagementservice.dto.MarineDTO;
import wy.mn.ns.marinemanagementservice.entity.Marine;
import wy.mn.ns.marinemanagementservice.exception.MarineAlreadyExistsException;
import wy.mn.ns.marinemanagementservice.exception.MarineNotDeleteableException;
import wy.mn.ns.marinemanagementservice.exception.MarineNotFoundException;
import wy.mn.ns.marinemanagementservice.mapper.MarineMapper;
import wy.mn.ns.marinemanagementservice.repository.MarineRepository;
import wy.mn.ns.marinemanagementservice.service.MarineService;

import java.text.MessageFormat;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MarineServiceImpl implements MarineService {

    private final MarineRepository marineRepository;

    @Override
    public MarineDTO createMarine(MarineCreationDTO creationDTO) {
        Optional<Marine> optional = marineRepository.findByEmail(creationDTO.getEmail());
        if (optional.isPresent()) {
            throw new MarineAlreadyExistsException(
                    MessageFormat.format("Marine with email -> {0} already exists", creationDTO.getEmail()));
        }
        Marine marine = MarineMapper.fromCreationDTO(creationDTO);
        Marine savedMarine = marineRepository.save(marine);
        return MarineMapper.toMarineDTO(savedMarine);
    }

    @Override
    public MarineDTO fetchMarine(Long id) {
        Optional<Marine> marine = marineRepository.findById(id);
        if (marine.isPresent()) {
            return MarineMapper.toMarineDTO(marine.get());
        } else {
            throw new MarineNotFoundException(MessageFormat.format("Marine with ID -> {0} not found", id));
        }
    }

    @Override
    public MarineDTO updateMarine(MarineDTO marineDTO) {
        marineRepository.findById(marineDTO.getId()).orElseThrow(() ->
                new MarineNotFoundException(MessageFormat.format("Marine -> {0} not found", marineDTO)));
        Marine saved = marineRepository.save(MarineMapper.fromMarineDTO(marineDTO));
        return MarineMapper.toMarineDTO(saved);
    }

    @Override
    public boolean deleteMarine(Long id) {
        marineRepository.findById(id).orElseThrow(() ->
                new MarineNotFoundException(MessageFormat.format("Marine with ID -> {0} not found", id)));
        try {
            marineRepository.deleteById(id);
        } catch (Exception e) {
            throw new MarineNotDeleteableException(MessageFormat.format("Marine with ID -> {0} cannot be deleted", id), e);
        }
        return true;
    }
}
