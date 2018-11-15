package pl.codesto.parser;

import pl.codesto.parser.cdm.Restaurant;
import pl.codesto.provider.PageProvider;

public interface Parser {
    Restaurant parsePage(PageProvider provider);
}
