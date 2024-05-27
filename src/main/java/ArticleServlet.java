// ArticleServlet.java
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articles")
public class ArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArticleRepository articleRepository;

    public void init() throws ServletException {
        articleRepository = new ArticleRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET request to show articles
        request.setAttribute("articles", articleRepository.getAllArticles());
        request.getRequestDispatcher("/articles.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST request to add new article
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String dateString = request.getParameter("publicationDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date publicationDate = null;
        try {
            publicationDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Article newArticle = new Article(title, content, publicationDate);
        articleRepository.addArticle(newArticle);
        response.sendRedirect(request.getContextPath() + "/articles");
    }
}
