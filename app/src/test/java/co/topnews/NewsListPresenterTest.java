package co.topnews;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import co.topnews.news_list.NewsListView;
import co.topnews.news_list.data.NewsRepository;
import co.topnews.news_list.models.NewsItem;
import co.topnews.news_list.presenter.NewsListPresenter;
import co.topnews.news_list.presenter.NewsListPresenterImpl;
import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class NewsListPresenterTest {

    @Mock
    public NewsRepository repository;
    @Mock
    public NewsListView newsListView;

    private NewsListPresenter listPresenter;
    private TestScheduler testScheduler;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        testScheduler = new TestScheduler();
        listPresenter = new NewsListPresenterImpl(repository, testScheduler, testScheduler);
        listPresenter.attachView(newsListView);

    }


    @Test
    public void loadTopHeadlines_WhenDataIsAvailable_UpdateViews() {
        List<NewsItem> items = new ArrayList<>();
        items.add(new NewsItem());
        items.add(new NewsItem());
        doReturn(Observable.just(items)).when(repository).getTopHeadlines(null);
        listPresenter.getTopHeadlines(null);
        testScheduler.triggerActions();
        verify(newsListView).setData(items);
    }


}
