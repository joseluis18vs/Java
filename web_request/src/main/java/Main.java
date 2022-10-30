public class Main {
    public static void main(String[] args) {

        String response = webClient.get()
                .path(betUrl)
                .request(String.class);

    }

    static final String betUrl = "https://www.bet365.com/#/HO/";
}
