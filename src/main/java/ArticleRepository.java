// ArticleRepository.java
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private List<Article> articles;

    // Constructor
    public ArticleRepository() {
        articles = new ArrayList<>();
    }

    // Method to add an article
    public void addArticle(Article article) {
        articles.add(article);
    }

    // Method to get all articles
    public List<Article> getAllArticles() {
        return articles;
    }
}
