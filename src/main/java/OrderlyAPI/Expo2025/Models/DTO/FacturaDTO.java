package OrderlyAPI.Expo2025.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NotBlank
public class FacturaDTO {
    private Long Id;
    private Long IdPedido;
    private double SubTotal;
    private double Descuento;
    private double Propina;
    private double Total;
    private Long IdEmpleado;
}
