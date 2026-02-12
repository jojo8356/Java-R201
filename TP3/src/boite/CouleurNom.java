package boite;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CouleurNom {

    private static final HttpClient client = HttpClient.newHttpClient();

    /**
     * Retourne le nom de la couleur via l'API thecolorapi.com
     */
    public static String depuisRGB(int r, int g, int b) throws Exception {
        String url = "https://www.thecolorapi.com/id?rgb=rgb(" + r + "," + g + "," + b + ")";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // Extraction du champ "name" -> "value" depuis le JSON
        String marqueur = "\"name\":{\"value\":\"";
        int debut = json.indexOf(marqueur) + marqueur.length();
        int fin = json.indexOf("\"", debut);
        return json.substring(debut, fin);
    }

    /**
     * Retourne le nom de la couleur depuis un code hexadecimal (#RRGGBB)
     */
    public static String depuisHex(String hex) throws Exception {
        hex = hex.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);
        return depuisRGB(r, g, b);
    }

    // --- Test ---
    public static void main(String[] args) throws Exception {
        System.out.println("(255, 0, 0)     -> " + depuisRGB(255, 0, 0));
        System.out.println("(0, 200, 0)     -> " + depuisRGB(0, 200, 0));
        System.out.println("(50, 50, 200)   -> " + depuisRGB(50, 50, 200));
        System.out.println("(255, 165, 0)   -> " + depuisRGB(255, 165, 0));
        System.out.println("(100, 50, 20)   -> " + depuisRGB(100, 50, 20));
        System.out.println("#FF1493         -> " + depuisHex("#FF1493"));
        System.out.println("#000080         -> " + depuisHex("#000080"));
    }
}
