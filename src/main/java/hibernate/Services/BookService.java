package hibernate.Services;
import hibernate.Model.Book;

import java.util.List;

/**
 * Created by Maxim on 20.10.2017.
 */
public interface BookService {
    List<Book> selectAll();
    boolean saveOrUpdate(Book book);
    boolean delete(Book book);
    List<Book> findBooks(String book);
}
