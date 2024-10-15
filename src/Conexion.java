import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {


    public String consulta (String monedaUno,String monedaDos,double monto){
        try{
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/84c68a0e777a5ad9073d2439/pair/" +
                    monedaUno + "/" + monedaDos + "/" + monto);
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> res = cliente
                    .send(req,HttpResponse.BodyHandlers.ofString());
            var json = res.body();
            return json;
        } catch (NumberFormatException  |IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
