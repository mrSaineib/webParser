package pl.codesto.parser.cdm;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Lunch {
    private BigDecimal price;
    private String soup;
    private String mainCourse;

    public Lunch(BigDecimal price, String soup, String mainCourse) {
        this.price = price;
        this.soup = soup;
        this.mainCourse = mainCourse;
    }

}
