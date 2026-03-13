
public class BaseDeHechos {

    private Temperatura temperatura;
    private Vibracion   vibracion;
    private Ruido       ruido;

    public BaseDeHechos(Temperatura temperatura, Vibracion vibracion, Ruido ruido) {
        this.temperatura = temperatura;
        this.vibracion   = vibracion;
        this.ruido       = ruido;
    }

    public Temperatura getTemperatura() { return temperatura; }
    public Vibracion   getVibracion()   { return vibracion;   }
    public Ruido       getRuido()       { return ruido;       }

    public void setTemperatura(Temperatura temperatura) { this.temperatura = temperatura; }
    public void setVibracion(Vibracion vibracion)       { this.vibracion   = vibracion;   }
    public void setRuido(Ruido ruido)                   { this.ruido       = ruido;       }

    public void mostrarHechos() {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│        LECTURAS ACTUALES DE SENSORES    │");
        System.out.println("├─────────────────────────────────────────┤");
        System.out.printf( "│  Temperatura : %-26s│%n", temperatura.getDescripcion());
        System.out.printf( "│  Vibración   : %-26s│%n", vibracion.getDescripcion());
        System.out.printf( "│  Ruido       : %-26s│%n", ruido.getDescripcion());
        System.out.println("└─────────────────────────────────────────┘");
    }
}