package co.topnews.news_list.models;

public class NewsItem {
    String id;
    String author;
    String title;
    String url;
    String urlToImage;
    String publishedAt;
    String description;


    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getDescription() {
        return description;
    }
}
