import java.util.List;

public class InterfazDiagnostico {

    private static final String RESET   = "\u001B[0m";
    private static final String ROJO    = "\u001B[31m";
    private static final String AMARILLO= "\u001B[33m";
    private static final String VERDE   = "\u001B[32m";
    private static final String CYAN    = "\u001B[36m";
    private static final String NEGRITA = "\u001B[1m";

    public void mostrarDiagnostico(List<Regla> reglasDisparadas, BaseDeHechos hechos) {

        System.out.println();
        System.out.println(CYAN + NEGRITA +
            "╔══════════════════════════════════════════════╗");
        System.out.println(
            "║       DIAGNÓSTICO DEL SISTEMA EXPERTO       ║");
        System.out.println(
            "╚══════════════════════════════════════════════╝" + RESET);
        System.out.println();

        hechos.mostrarHechos();
        System.out.println();

        if (reglasDisparadas.isEmpty()) {
            System.out.println(AMARILLO +
                "  ⚠  No se encontró un diagnóstico exacto para la " +
                "combinación de valores ingresada." + RESET);
            System.out.println("     Revise los parámetros o consulte a un técnico.");
            return;
        }

        System.out.println(NEGRITA + "  Reglas activadas por el Motor de Inferencia:" + RESET);
        System.out.println();

        for (Regla regla : reglasDisparadas) {
            imprimirRegla(regla);
        }

        boolean tieneCritico     = reglasDisparadas.stream()
            .anyMatch(r -> r.getSeveridad() == Regla.Severidad.CRITICO);
        boolean tieneAdvertencia = reglasDisparadas.stream()
            .anyMatch(r -> r.getSeveridad() == Regla.Severidad.ADVERTENCIA);

        System.out.println("─────────────────────────────────────────────────");
        if (tieneCritico) {
            System.out.println(ROJO + NEGRITA +
                "  ⛔  NIVEL DE ALERTA: CRÍTICO – Acción inmediata requerida." + RESET);
        } else if (tieneAdvertencia) {
            System.out.println(AMARILLO + NEGRITA +
                "  ⚠   NIVEL DE ALERTA: ADVERTENCIA – Programar mantenimiento." + RESET);
        } else {
            System.out.println(VERDE + NEGRITA +
                "  ✔   NIVEL DE ALERTA: NORMAL – Sin anomalías detectadas." + RESET);
        }
        System.out.println();
    }

    private void imprimirRegla(Regla regla) {
        String color = colorPorSeveridad(regla.getSeveridad());
        String icono = iconoPorSeveridad(regla.getSeveridad());

        System.out.printf(NEGRITA + "  Regla #%d – %s%n" + RESET,
            regla.getNumero(), regla.getNombre());
        System.out.printf(CYAN + "  Condición activada:%n    %s%n" + RESET,
            regla.getDescripcionCondicion());
        System.out.printf(color + "  %s Diagnóstico:%n    %s%n" + RESET,
            icono, regla.getDiagnostico());
        System.out.printf(VERDE + "  ➤  Recomendación:%n    %s%n" + RESET,
            regla.getRecomendacion());
        System.out.println("  ─────────────────────────────────────────────");
        System.out.println();
    }

    private String colorPorSeveridad(Regla.Severidad severidad) {
        return switch (severidad) {
            case CRITICO     -> ROJO;
            case ADVERTENCIA -> AMARILLO;
            default          -> VERDE;
        };
    }

    private String iconoPorSeveridad(Regla.Severidad severidad) {
        return switch (severidad) {
            case CRITICO     -> "⛔";
            case ADVERTENCIA -> "⚠ ";
            default          -> "✔ ";
        };
    }
}