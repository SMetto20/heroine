import static spark.Spark.*;

import java.util.*;

import org.example.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;





public class App {
    static int getHerokuAssignedPort() {

        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static String name;
    public static String power;
    public static String weakness;
    public static String age;
    public static String height;
    public static String squadname;


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
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        get("/", (request, response) -> {

            return new ModelAndView(new HashMap(), "home.hbs");

        }, new HandlebarsTemplateEngine());
        get("/form", (request, response) -> {
//            request.session().attribute("name", name);
//            request.session().attribute("power", power);
//            request.session().attribute("weakness", weakness);
//            request.session().attribute("age", age);
//            request.session().attribute("height", height);
            name = request.queryParams("name");
            power = request.queryParams("power");
            weakness = request.queryParams("weakness");
            age = request.queryParams("age");
            height = request.queryParams("height");
            squadname=request.queryParams("squadname");





            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList mySquadArrayList = Squad.getAll();
            model.put("mySquad", mySquadArrayList);
            model.put("dn",divers.getName());
            model.put("dc",divers.getCause());
            model.put("dg",divers.getGender());
            model.put("ds",divers.getSize());
            model.put("sn",dayLightSavers.getName());
            model.put("sc",dayLightSavers.getCause());
            model.put("sg",dayLightSavers.getGender());
            model.put("ss",dayLightSavers.getSize());
            model.put("fn",femmeous.getName());
            model.put("fc",femmeous.getCause());
            model.put("fg",femmeous.getGender());
            model.put("fs",femmeous.getSize());
            model.put("bn",spinBots.getName());
            model.put("bc",spinBots.getCause());
            model.put("bg",spinBots.getGender());
            model.put("bs",spinBots.getSize());
//            model.put("name", request.session().attribute("name"));
//            model.put("power", request.session().attribute("power"));
//            model.put("weakness", request.session().attribute("weakness"));
//            model.put("age", request.session().attribute("age"));
//            model.put("height", request.session().attribute("height"));
            model.put("name",name);
            model.put("power",power);
            model.put("weakness",weakness);
            model.put("age",age);
            model.put("height",height);
            model.put("squadname", squadname);

            model.put("squadList",squadList);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
