import java.util.List;
import java.util.Scanner;

public class App {
    private static final String RESET   = "\u001B[0m";
    private static final String NEGRITA = "\u001B[1m";
    private static final String CYAN    = "\u001B[36m";
    private static final String AMARILLO= "\u001B[33m";
    private static final BaseDeConocimiento base     = new BaseDeConocimiento();
    private static final MotorDeInferencia  motor    = new MotorDeInferencia(base);
    private static final InterfazDiagnostico interfaz = new InterfazDiagnostico();
    private static final Scanner            sc       = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarBienvenida();

        boolean continuar = true;
        while (continuar) {
            Temperatura temp = pedirTemperatura();
            Vibracion   vib  = pedirVibracion();
            Ruido       ruid = pedirRuido();

            BaseDeHechos hechos = new BaseDeHechos(temp, vib, ruid);

            List<Regla> diagnostico = motor.inferir(hechos);

            interfaz.mostrarDiagnostico(diagnostico, hechos);

            continuar = preguntarContinuar();
        }

        System.out.println(CYAN + NEGRITA +
            "\n  Sistema Experto finalizado. ¡Hasta pronto!\n" + RESET);
        sc.close();
    }

    private static Temperatura pedirTemperatura() {
        System.out.println(CYAN + NEGRITA +
            "\n┌─ INGRESE LOS VALORES DEL SENSOR ─────────────────┐" + RESET);
        System.out.println(AMARILLO + "  Temperatura de la máquina:" + RESET);
        Temperatura[] valores = Temperatura.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.printf("    [%d] %s%n", i + 1, valores[i].getDescripcion());
        }
        int op = leerOpcion(1, valores.length);
        return valores[op - 1];
    }

    private static Vibracion pedirVibracion() {
        System.out.println(AMARILLO + "\n  Nivel de vibración:" + RESET);
        Vibracion[] valores = Vibracion.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.printf("    [%d] %s%n", i + 1, valores[i].getDescripcion());
        }
        int op = leerOpcion(1, valores.length);
        return valores[op - 1];
    }

    private static Ruido pedirRuido() {
        System.out.println(AMARILLO + "\n  Nivel de ruido:" + RESET);
        Ruido[] valores = Ruido.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.printf("    [%d] %s%n", i + 1, valores[i].getDescripcion());
        }
        int op = leerOpcion(1, valores.length);
        return valores[op - 1];
    }

    private static boolean preguntarContinuar() {
        System.out.println(CYAN + "  ¿Desea analizar otra máquina? [1] Sí  [2] No" + RESET);
        return leerOpcion(1, 2) == 1;
    }

    private static int leerOpcion(int min, int max) {
        while (true) {
            System.out.printf("  Seleccione una opción (%d-%d): ", min, max);
            try {
                int op = Integer.parseInt(sc.nextLine().trim());
                if (op >= min && op <= max) return op;
                System.out.printf("  ⚠  Ingrese un número entre %d y %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("  ⚠  Entrada inválida. Ingrese un número.");
            }
        }
    }

    private static void mostrarBienvenida() {
        System.out.println();
        System.out.println(CYAN + NEGRITA +
            "╔═══════════════════════════════════════════════════════════════╗");
        System.out.println(
            "║    SISTEMA EXPERTO – DIAGNÓSTICO DE MAQUINARIA INDUSTRIAL    ║");
        System.out.println(
            "╠═══════════════════════════════════════════════════════════════╣");
        System.out.println(
            "║  Analiza temperatura, vibración y ruido para detectar fallas ║");
        System.out.println(
            "║  antes de que se conviertan en averías graves.               ║");
        System.out.println(
            "╚═══════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }
}