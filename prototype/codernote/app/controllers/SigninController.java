package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.signin;

/**
 * Created by Peng on 3/29/16.
 */
public class SigninController extends Controller {
    public Result signin() {
        return ok(signin.render("sigin"));
    }
}
