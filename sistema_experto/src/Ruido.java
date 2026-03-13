public enum Ruido {
    NORMAL("Normal (< 70 dB)"),
    MODERADO("Moderado (70 - 84 dB)"),
    ALTO("Alto (>= 85 dB)");

    private final String descripcion;

    Ruido(String descripcion) {
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