import static spark.Spark.*;

import java.util.*;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;





public class App {
    public static void main(String[] args) {
//


        staticFileLocation("/public");
        get("/", (request, response) -> {

            return new ModelAndView(new HashMap(), "home.hbs");

        }, new HandlebarsTemplateEngine());
    }
}
