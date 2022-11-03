import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("jdk.httpclient.allowRestrictedHeaders", "Connection");
        chromeSimulation();

    }

    public static void chromeSimulation() throws IOException {
        URL url = new URL("https://www.bet365.com/#/HO/");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Connection", "keep-alive");
        http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        http.setRequestProperty("Upgrade-Insecure-Requests", "1");
        http.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        http.setRequestProperty("Accept-Language", "en-US,en;q=0.9");
        http.setRequestProperty("Accept-Encoding", "gzip, deflate");

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();
    }

}
