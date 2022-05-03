import static spark.Spark.*;

import java.util.*;

import org.example.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;





public class App {
    public static void main(String[] args) {
//


        staticFileLocation("/public");
        get("/", (request, response) -> {

            return new ModelAndView(new HashMap(), "home.hbs");

        }, new HandlebarsTemplateEngine());
        get("/form", (request, response) -> {
            name = request.queryParams("name");
            power = request.queryParams("power");
            weakness = request.queryParams("weakness");
            age = request.queryParams("age");
            height = request.queryParams("height");



            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList mySquadArrayList = Squad.getAll();
            model.put("mySquad", mySquadArrayList);
            model.put("name",name);
            model.put("power",power);
            model.put("weakness",weakness);
            model.put("age",age);
            model.put("height",height);
            model.put("squadList",squadList);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
