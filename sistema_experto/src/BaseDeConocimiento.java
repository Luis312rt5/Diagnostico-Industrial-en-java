import java.util.ArrayList;
import java.util.List;

public class BaseDeConocimiento {

    private final List<Regla> reglas = new ArrayList<>();

    public BaseDeConocimiento() {
        cargarReglas();
    }

    private void cargarReglas() {


        reglas.add(new Regla(
            1,
            "Sobrecalentamiento del Motor",
            "SI temperatura = ALTA  Y  vibración = NORMAL",
            hechos -> hechos.getTemperatura() == Temperatura.ALTA
                   && hechos.getVibracion()   == Vibracion.NORMAL,
            "Posible sobrecalentamiento del motor.",
            "Verificar sistema de enfriamiento, limpiar filtros de ventilación y revisar carga de trabajo del motor.",
            Regla.Severidad.ADVERTENCIA
        ));

        reglas.add(new Regla(
            2,
            "Desgaste de Rodamientos",
            "SI vibración = ALTA  Y  ruido = ALTO",
            hechos -> hechos.getVibracion() == Vibracion.ALTA
                   && hechos.getRuido()     == Ruido.ALTO,
            "Posible desgaste de rodamientos.",
            "Programar inspección y lubricación de rodamientos. Considerar reemplazo preventivo.",
            Regla.Severidad.ADVERTENCIA
        ));

        reglas.add(new Regla(
            3,
            "Desalineación del Eje",
            "SI vibración = ALTA  Y  temperatura = MODERADA",
            hechos -> hechos.getVibracion()   == Vibracion.ALTA
                   && hechos.getTemperatura() == Temperatura.MODERADA,
            "Posible desalineación del eje.",
            "Revisar alineación del eje con instrumentos especializados y ajustar acoples.",
            Regla.Severidad.ADVERTENCIA
        ));

        reglas.add(new Regla(
            4,
            "Falta de Lubricación",
            "SI temperatura = ALTA  Y  ruido = ALTO",
            hechos -> hechos.getTemperatura() == Temperatura.ALTA
                   && hechos.getRuido()       == Ruido.ALTO,
            "Posible falta de lubricación.",
            "Aplicar lubricante recomendado por el fabricante y verificar sistema de lubricación automática.",
            Regla.Severidad.ADVERTENCIA
        ));

        reglas.add(new Regla(
            5,
            "Falla Crítica General",
            "SI temperatura = MUY_ALTA  Y  vibración = ALTA  Y  ruido = ALTO",
            hechos -> hechos.getTemperatura() == Temperatura.MUY_ALTA
                   && hechos.getVibracion()   == Vibracion.ALTA
                   && hechos.getRuido()       == Ruido.ALTO,
            "¡FALLA CRÍTICA DETECTADA! Múltiples sistemas comprometidos.",
            "DETENER LA MÁQUINA INMEDIATAMENTE. Llamar al técnico especializado antes de reiniciar.",
            Regla.Severidad.CRITICO
        ));

        reglas.add(new Regla(
            6,
            "Fallo en Sistema de Refrigeración",
            "SI temperatura = MUY_ALTA  Y  vibración = NORMAL  Y  ruido = NORMAL",
            hechos -> hechos.getTemperatura() == Temperatura.MUY_ALTA
                   && hechos.getVibracion()   == Vibracion.NORMAL
                   && hechos.getRuido()       == Ruido.NORMAL,
            "Posible fallo en el sistema de refrigeración o bloqueo de ventilación.",
            "Revisar ventiladores, radiadores y conductos de aire. Limpiar filtros de manera urgente.",
            Regla.Severidad.CRITICO
        ));

        reglas.add(new Regla(
            7,
            "Desequilibrio en Componentes Rotatorios",
            "SI vibración = MODERADA  Y  ruido = ALTO",
            hechos -> hechos.getVibracion() == Vibracion.MODERADA
                   && hechos.getRuido()     == Ruido.ALTO,
            "Posible desequilibrio en componentes rotatorios (poleas, ventiladores, ejes).",
            "Realizar balanceo dinámico de los componentes y verificar tornillos de sujeción.",
            Regla.Severidad.ADVERTENCIA
        ));

        reglas.add(new Regla(
            8,
            "Operación Normal",
            "SI temperatura = NORMAL  Y  vibración = NORMAL  Y  ruido = NORMAL",
            hechos -> hechos.getTemperatura() == Temperatura.NORMAL
                   && hechos.getVibracion()   == Vibracion.NORMAL
                   && hechos.getRuido()       == Ruido.NORMAL,
            "Máquina operando dentro de parámetros normales.",
            "No se requiere acción. Continuar monitoreo rutinario.",
            Regla.Severidad.INFORMATIVO
        ));
    }

    public List<Regla> getReglas() {
        return reglas;
    }
}