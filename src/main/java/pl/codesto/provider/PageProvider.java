package pl.codesto.provider;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import pl.codesto.target.Endpoint;

import java.io.IOException;

@Data
public class PageProvider {

    private Document document = null;
    private Endpoint endpoint = null;
    private String pageTitle = null;

    public PageProvider(Endpoint endpoint) throws IOException {
        this.endpoint = endpoint;
        this.document = Jsoup.connect(this.endpoint.toString())
                .proxy("empweb1.ey.net", 80)
                .get();
        this.pageTitle = this.document.title();
    }

    public Elements getElements(String cssQuery) {
        return this.document.select(cssQuery);
    }
}

