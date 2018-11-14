package pl.codesto;

import pl.codesto.parser.OurPlaceParser;
import pl.codesto.parser.Parser;
import pl.codesto.parser.cdm.Lunch;
import pl.codesto.provider.PageProvider;
import pl.codesto.target.Endpoint;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PageProvider pp = null;
        try {
            pp = new PageProvider(Endpoint.NASZE_MIEJSCE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parser parser = new OurPlaceParser();
        List<Lunch> lunches = parser.parsePage(pp);

        for (int i=0; i<lunches.size(); i++) {
            Lunch lunch = lunches.get(i);
            System.out.println("Propozycja " + (i + 1) + ".");
            System.out.println("\tZupa: " + lunch.getSoup());
            System.out.println("\tDrugi danie: " + lunch.getMainCourse());
            System.out.println("\tCena: " + lunch.getPrice().setScale(2) + " PLN");
        }


    }

}
