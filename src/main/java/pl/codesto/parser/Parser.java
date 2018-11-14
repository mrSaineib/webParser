package pl.codesto.parser;

import pl.codesto.parser.cdm.Lunch;
import pl.codesto.provider.PageProvider;

import java.util.List;

public interface Parser {
    List<Lunch> parsePage(PageProvider provider);
}
