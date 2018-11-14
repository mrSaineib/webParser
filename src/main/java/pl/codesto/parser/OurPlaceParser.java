package pl.codesto.parser;

import org.jsoup.select.Elements;
import pl.codesto.parser.cdm.Lunch;
import pl.codesto.provider.PageProvider;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OurPlaceParser implements Parser {

    public List<Lunch> parsePage(PageProvider provider) {
        Elements priceElements = provider.getElements(".entry p strong:contains(zł)");
        Elements soupElements = provider.getElements(".entry p em");
        Elements mainCourseElements = provider.getElements(".entry p:containsOwn(,)");

        List<Lunch> result = new ArrayList<Lunch>();
        for (int i = 0; i < priceElements.size(); i++) {
            String soupStr = soupElements.get(i).html();
            String mainCourseStr = mainCourseElements.get(i).html();
            BigDecimal price = BigDecimal.valueOf(extractNumFormString(priceElements.get(i).html()));
            result.add(new Lunch(price, soupStr, mainCourseStr));
        }

        return result;
    }

    private int extractNumFormString(String str) {
        return Integer.valueOf(str.replaceAll("[^0-9?!\\.]",""));
    }
}
