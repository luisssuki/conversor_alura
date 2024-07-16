import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioConversion {

  public TasaCambio obtenerTasa(String divisaBase, String divisaObjetivo) {
    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3bd94cd92e293227a4fae0a0/latest/USD" + divisaBase +
      "/" + divisaObjetivo);

    HttpClient cliente = HttpClient.newHttpClient();
    HttpRequest solicitud = HttpRequest.newBuilder()
      .uri(direccion)
      .build();

    try {
      HttpResponse < String > respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

      if (respuesta.statusCode() == 200) {
        return new Gson().fromJson(respuesta.body(), TasaCambio.class);
      } else {
        System.out.println("La solicitud HTTP no fue exitosa: " + respuesta.statusCode());
        return null;
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null;
    } finally {
      cliente.close();
    }
  }
}
