package OrderlyAPI.Expo2025.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @NotBlank
public class MetodoPagoDTO {
    private Long Id;
    private String NomMetodo;
    private String Descripcion;
}
