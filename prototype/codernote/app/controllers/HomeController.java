package controllers;

import models.User;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.signup;

import java.util.Map;

import static play.data.Form.form;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result signup() {
        return ok(signup.render("Winter is coming"));
    }

    public Result addUser() {
        DynamicForm requestData = form().bindFromRequest();
        Map<String, String> map = requestData.data();
        User user = new User();
        user.name = map.get("usrName");
        user.password = map.get("usrPasswd");
        user.insert();
        User usr = User.findByName(user.name);
        System.out.println("haha");

        return redirect("/");
    }

}
