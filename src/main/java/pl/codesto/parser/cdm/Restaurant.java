package pl.codesto.parser.cdm;

import lombok.Data;

import java.util.List;

@Data
public class Restaurant {
    private String name;
    private List<Lunch> lunchList;

    public Restaurant() {
    }

    public Restaurant(String name, List<Lunch> lunchList) {
        this.name = name;
        this.lunchList = lunchList;
    }
}
