public class TasaCambio {
  private String base_code;
  private String target_code;
  private double conversion_rate;

  public String obtenerCodigoBase() {
    return base_code;
  }

  public void establecerCodigoBase(String base_code) {
    this.base_code = base_code;
  }

  public String obtenerCodigoObjetivo() {
    return target_code;
  }

  public void establecerCodigoObjetivo(String target_code) {
    this.target_code = target_code;
  }

  public double obtenerTasaConversion() {
    return conversion_rate;
  }

  public void establecerTasaConversion(double conversion_rate) {
    this.conversion_rate = conversion_rate;
  }
}
