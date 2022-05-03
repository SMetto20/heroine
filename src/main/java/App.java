import static spark.Spark.*;

import java.util.*;

import org.example.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;





public class App {
    public static String name;
    public static String power;
    public static String weakness;
    public static String age;
    public static String height;


    public static Squad divers = new Squad(6,"saving marine life","mixed","divers");
    public static Squad dayLightSavers = new Squad(10,"protecting against darkness","male","daylightsavers");
    public static Squad femmeous = new Squad(10,"protecting women","female","femmeous");
    public static Squad spinBots = new Squad(12,"protects against hackers","mixed","spinbots");

    static Squad[] squadList ={divers,dayLightSavers,femmeous,spinBots};

    //    public List <Squad> squadList =new ArrayList<Squad>();
//    squadList.add("hello")
    static List squad2 = Arrays.asList(squadList);

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
