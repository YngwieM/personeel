package be.vdab.personeel.forms;

import java.math.BigDecimal;

public class OpslagForm {
    private final BigDecimal nieuwSalaris;

    public OpslagForm(BigDecimal nieuwSalaris) {
        this.nieuwSalaris = nieuwSalaris;
    }

    public BigDecimal getNieuwSalaris() {
        return nieuwSalaris;
    }
}
