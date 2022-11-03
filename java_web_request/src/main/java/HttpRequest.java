import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class HttpRequest {
    public void HttpRequestExample() throws IOException, InterruptedException {
        String cookie = "OptanonConsent=isGpcEnabled=1&datestamp=Mon+Oct+10+2022+02%3A12%3A19+GMT%2B0200+(hora+de+verano+de+Europa+central)&version=6.26.0&isIABGlobal=false&hosts=&consentId=f18fe246-3dbb-48ef-9631-6cec92b048f4&interactionCount=0&landingPath=NotLandingPage&groups=C0001%3A1%2CC0003%3A1%2CC0002%3A1%2CC0004%3A0%2CC0007%3A1&AwaitingReconsent=false; JSESSIONID=0D6FC14DDC79A244D062E1BE1792E026";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36";
//        String bet365URL = "https://www.bet365.com/#/HO/";
        String bet365URL = "http://localhost:8080/api/books_list";
        var client = HttpClient.newHttpClient();
        // create a request

        var request = java.net.http.HttpRequest.newBuilder(URI.create(bet365URL))
                .header("connection", "keep-alive")
                .header("cache-control", "max-age=0")
                .header("upgrade-insecure-requests", "1")
                .header("user-agent", userAgent)
                .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8")
                .header("sec-gpc", "1")
                .header("accept-language", "es-419,es")
                .header("sec-fetch-site", "none")
                .header("sec-fetch-mode", "navigate")
                .header("sec-fetch-user", "?1")
                .header("sec-fetch-dest", "document")
                .header("accept-encoding", "gzip, deflate, br")
                .header("cookie", cookie)
                .build();

        var handler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = client.send(request, handler);

        System.out.println(response);
    }
}
