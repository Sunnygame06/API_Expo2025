package OrderlyAPI.Expo2025.Repositories.Rol;

import OrderlyAPI.Expo2025.Entities.Rol.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> { }
