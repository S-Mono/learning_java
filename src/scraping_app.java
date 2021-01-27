import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

import java.io.IOException;

public class scraping_app {

    public static void main(String[] args) throws IOException {

//        PageConfiguration config = new PageConfiguration();
//        config.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
//        Page page = BrowserFactory.getWebKit().navigate("操作したいサイトのURL", config);
//
//        Document doc = page.getDocument();
//        doc.query("email").setValue("");
//        doc.query();


        //ユーザ名・パスワード
        final String USERNAME = "ユーザ名";
        final String PASSWORD = "パスワード";

        //ログインページのURL
        String LOGIN_URL = "https://www.amazon.co.jp/";
        //ログインした状態でアクセスしたいURL
        String mainURL = "https://www.amazon.co.jp/gp/css/order-history?ref_=nav_orders_first";

        //ユーザーエージェント
        String UA ="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36";

        try{
        //ログインページからのレスポンスを取得
            Connection.Response response = Jsoup.connect(LOGIN_URL)
                    .method(Connection.Method.GET)
                    .execute();
            response = Jsoup.connect(LOGIN_URL)
                    .data("email", USERNAME)
                    .userAgent(UA)
                    .cookies(response.cookies())
                    .method(Connection.Method.POST)
                    .execute();

        //ログインページ空取得したクッキーを使ってアクセス
            org.jsoup.nodes.Document document = Jsoup.connect(mainURL)
                    .userAgent(UA)
                    .cookies(response.cookies())
                    .get();

            Elements thisPage = document.select(".a-box");
            System.out.println("thisPage:::::" + thisPage);

        }catch (IOException e){
            e.printStackTrace();
        }

        Document document = Jsoup.connect(LOGIN_URL).get();
        Elements courses = document.select("#nav-orders");
        //System.out.println("courses:::::" + courses);
        String nextUrl = courses.attr("href");
        //System.out.println("nextUrl:::::::" + nextUrl);
        document = Jsoup.connect("https://www.amazon.co.jp/" + nextUrl).get();
        Elements orderList = document.select(".a-box");
        System.out.println("orderList:::::" + orderList);
        for(Element tittle : orderList){
            System.out.println("tittle::::::" + tittle.text());
        }



    }
}



//    private webView mWebView;
//
//    private void do WebViewPrint(){
//        WebView webView = new WebView(getActivity());
//
//
//
//    }
//
//}
