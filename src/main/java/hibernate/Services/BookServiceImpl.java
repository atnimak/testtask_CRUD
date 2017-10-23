package hibernate.Services;
import hibernate.DAO.BookDao;
import hibernate.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Maxim on 20.10.2017.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    public boolean saveOrUpdate(Book book) {
        return bookDao.saveOrUpdate(book);
    }

    public boolean delete(Book book) {
        return bookDao.delete(book);
    }

    public List<Book> findBooks(String namePar) {
        return bookDao.findBooks(namePar);
    }

}
