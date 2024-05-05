import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class SearchBook {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do livro para a busca: ");
        String search = scanner.nextLine();

        String key = "AIzaSyATcbCqgVTiw_JOZ9IG4z7ZuWGjeWSd118";
        String encodedSearch = URLEncoder.encode(search, "UTF-8");
        String address = "https://www.googleapis.com/books/v1/volumes?q=" + encodedSearch + "&key" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
