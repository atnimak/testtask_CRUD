package hibernate.DAO;

import hibernate.Model.Book;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Maxim on 20.10.2017.
 */
@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    @Autowired
    SessionFactory session;

    public List<Book> selectAll() {
        List list = session.getCurrentSession().createSQLQuery("SHOW TABLES LIKE 'book'").list();
        if (list.size() == 0) {
            session.getCurrentSession().createSQLQuery("CREATE TABLE `test`.`book` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` VARCHAR(100) NOT NULL,\n" +
                    "  `description` VARCHAR(255) NOT NULL,\n" +
                    "  `author` VARCHAR(100) NOT NULL,\n" +
                    "  `isbn` VARCHAR(20) NOT NULL,\n" +
                    "  `printYear` INT NOT NULL,\n" +
                    "  `readAlready` BIT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "    ENGINE = InnoDB \n" +
                    "    DEFAULT CHARACTER SET = utf8; ").executeUpdate();
        }
        return session.getCurrentSession().createQuery("from hibernate.Model.Book").list();
    }

    public boolean saveOrUpdate(Book book) {
        session.getCurrentSession().saveOrUpdate(book);
        return true;
    }

    public boolean delete(Book book) {
        try {
            session.getCurrentSession().delete(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Book> findBooks(String title){
        Query query = session.getCurrentSession().createQuery("from hibernate.Model.Book u where u.title like :title");
        query.setParameter("title", "%" + title + "%");
        List<Book> list = query.list();

        return list;
    }

}
