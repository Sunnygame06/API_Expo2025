package OrderlyAPI.Expo2025.Services.Mesa;

import OrderlyAPI.Expo2025.Entities.Mesa.MesaEntity;
import OrderlyAPI.Expo2025.Entities.Rol.RolEntity;
import OrderlyAPI.Expo2025.Exceptions.ExceptionDatoNoEncontrado;
import OrderlyAPI.Expo2025.Models.DTO.MesaDTO;
import OrderlyAPI.Expo2025.Models.DTO.RolDTO;
import OrderlyAPI.Expo2025.Repositories.Mesa.MesaRepository;
import OrderlyAPI.Expo2025.Repositories.Rol.RolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MesaService {

    @Autowired
    private MesaRepository repo;


    public List<MesaDTO> getAllMesas(){
        List<MesaEntity> mesas = repo.findAll();
        return mesas.stream()
                .map(this::convertirAMesasDTO)
                .collect(Collectors.toList());
    }

    public MesaDTO createMesa(MesaDTO mesaDTO){
        if (mesaDTO == null || mesaDTO.getNomMesa() == null || mesaDTO.getNomMesa().describeConstable().isEmpty()){
            throw new IllegalArgumentException("La mesa no puede ser nulo");
        }
        try{
            MesaEntity mesaEntity = convertirAMesasEntity(mesaDTO);
            MesaEntity mesaGuardado = repo.save(mesaEntity);
            return convertirAMesasDTO(mesaGuardado);
        }catch (Exception e){
            log.error("Error al registrar mesa: " + e.getMessage());
            throw new ExceptionDatoNoEncontrado("Error al registrar la mesa" + e.getMessage());
        }
    }

    public MesaDTO updateMesa(Long id, MesaDTO mesa){
        MesaEntity mesaExistente = repo.findById(id).orElseThrow(() -> new ExceptionDatoNoEncontrado("Mesa no encontrado"));

        mesaExistente.setNomMesa(mesa.getNomMesa());
        mesaExistente.setIdTipoMesa(mesa.getIdTipoMesa());

        MesaEntity mesaActualizado = repo.save(mesaExistente);
        return convertirAMesasDTO(mesaActualizado);
    }

    public boolean deleteMesa(Long id){
        try{
            MesaEntity objMesa = repo.findById(id).orElse(null);
            if (objMesa != null){
                repo.deleteById(id);
                return true;
            }else{
                System.out.println("Mesa no encontrado");
                return false;
            }
        }catch (EmptyResultDataAccessException e){
            throw new EmptyResultDataAccessException("No se encontro mesa con ID:" + id + " para eliminar.", 1);
        }
    }


    public MesaEntity convertirAMesasEntity(MesaDTO mesa){
        MesaEntity dto = new MesaEntity();
        dto.setId(mesa.getId());
        dto.setNomMesa(mesa.getNomMesa());
        dto.setIdTipoMesa(mesa.getIdTipoMesa());

        return dto;
    }

    public MesaDTO convertirAMesasDTO(MesaEntity mesa){
        MesaDTO dto = new MesaDTO();
        dto.setId(mesa.getId());
        dto.setNomMesa(mesa.getNomMesa());
        dto.setIdTipoMesa(mesa.getIdTipoMesa());
        return dto;
    }
}
