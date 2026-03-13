public enum Temperatura {
    NORMAL("Normal (< 70°C)"),
    MODERADA("Moderada (70°C - 89°C)"),
    ALTA("Alta (90°C - 109°C)"),
    MUY_ALTA("Muy Alta (>= 110°C)");

    private final String descripcion;

    Temperatura(String descripcion) {
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