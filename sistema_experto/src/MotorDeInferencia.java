import java.util.ArrayList;
import java.util.List;

public class MotorDeInferencia {

    private final BaseDeConocimiento baseDeConocimiento;

    public MotorDeInferencia(BaseDeConocimiento baseDeConocimiento) {
        this.baseDeConocimiento = baseDeConocimiento;
    }

    public List<Regla> inferir(BaseDeHechos hechos) {
        List<Regla> reglasDisparadas = new ArrayList<>();

        for (Regla regla : baseDeConocimiento.getReglas()) {
            if (regla.seCumple(hechos)) {
                reglasDisparadas.add(regla);
            }
        }

        return reglasDisparadas;
    }
}