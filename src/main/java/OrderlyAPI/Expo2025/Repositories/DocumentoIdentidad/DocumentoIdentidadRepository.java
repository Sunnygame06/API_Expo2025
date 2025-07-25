package OrderlyAPI.Expo2025.Repositories.DocumentoIdentidad;

import OrderlyAPI.Expo2025.Entities.DocumentoIdentidad.DocumentoIdentidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoIdentidadRepository extends JpaRepository<DocumentoIdentidadEntity, Long> {
}
