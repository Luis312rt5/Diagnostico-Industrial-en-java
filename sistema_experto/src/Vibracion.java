public enum Vibracion {
    NORMAL("Normal (< 2.5 mm/s)"),
    MODERADA("Moderada (2.5 - 4.9 mm/s)"),
    ALTA("Alta (>= 5.0 mm/s)");

    private final String descripcion;

    Vibracion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}