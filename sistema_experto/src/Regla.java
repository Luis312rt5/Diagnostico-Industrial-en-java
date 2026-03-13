public class Regla {

    public enum Severidad {
        INFORMATIVO, ADVERTENCIA, CRITICO
    }

    private final int        numero;
    private final String     nombre;
    private final String     descripcionCondicion;
    private final Condicion  condicion;
    private final String     diagnostico;
    private final String     recomendacion;
    private final Severidad  severidad;

    @FunctionalInterface
    public interface Condicion {
        boolean evaluar(BaseDeHechos hechos);
    }

    public Regla(int numero,
                 String nombre,
                 String descripcionCondicion,
                 Condicion condicion,
                 String diagnostico,
                 String recomendacion,
                 Severidad severidad) {
        this.numero               = numero;
        this.nombre               = nombre;
        this.descripcionCondicion = descripcionCondicion;
        this.condicion            = condicion;
        this.diagnostico          = diagnostico;
        this.recomendacion        = recomendacion;
        this.severidad            = severidad;
    }

    public boolean seCumple(BaseDeHechos hechos) {
        return condicion.evaluar(hechos);
    }

    public int       getNumero()               { return numero;               }
    public String    getNombre()               { return nombre;               }
    public String    getDescripcionCondicion() { return descripcionCondicion; }
    public String    getDiagnostico()          { return diagnostico;          }
    public String    getRecomendacion()        { return recomendacion;        }
    public Severidad getSeveridad()            { return severidad;            }
}