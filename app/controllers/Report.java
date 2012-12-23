package controllers;

import domain.MostAppearQuestions;
import play.mvc.Controller;
import play.mvc.Result;
import service.ReportService;
import views.html.ip;
import views.html.question;

import java.util.List;

public class Report extends Controller {
    public static Result reportIp() {
        List<String> ips = new ReportService().reportIp();
        return ok(ip.render(ips));
    }

    public static Result reportAppearMost() {
        MostAppearQuestions mostAppearQuestions = new ReportService().reportAppearMost();

        return ok(question.render(mostAppearQuestions));
    }
}
