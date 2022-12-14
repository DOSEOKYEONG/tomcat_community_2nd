package com.ll.exam;

import com.ll.exam.article.ArticleController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq = new Rq(req, resp);

        ArticleController articleController = new ArticleController();

        switch (rq.getMethod()){
            case "GET":
                switch (rq.getActionPath()) {
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/write":
                        articleController.showWrite(rq);
                        break;
                    case "/usr/article/detail":
                        articleController.showDetail(rq);
                        break;
                    case "/usr/article/delete":
                        articleController.doDelete(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.showModify(rq);
                        break;
                    case "/usr/article/getArticles":
                        articleController.getArticles(rq);
                        break;
                    case "/usr/article/bigger":
                        articleController.bigger(rq);
                        break;
                }
                break;

            case "POST":
                switch (rq.getActionPath()) {
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                        break;
//                    case "/usr/article/write":
//                        articleController.doWrite_(rq);
//                        break;
                    case "/usr/article/modify":
                        articleController.doModify(rq);
                        break;
                }
            break;
        }
    }
}
