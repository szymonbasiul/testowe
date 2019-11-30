package sklep.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Smartfon {
    private String marka;
    private String model;
    private int cena;
    private String modelProcesora;
    private int pamiecRam;
    private int pamiecRom;
}
