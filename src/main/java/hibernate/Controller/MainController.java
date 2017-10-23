package hibernate.Controller;

import hibernate.Services.BookService;
import hibernate.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Maxim on 20.10.2017.
 */
@org.springframework.stereotype.Controller
public class MainController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ModelAndView book(){
        ModelAndView view = new ModelAndView("/book.jsp");
        return view;
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getSaved(Book book){
        Map<String, Object> map = new HashMap();
        List<Book> list = bookService.selectAll();

        if (bookService.saveOrUpdate(book)){
            map.put("status", "200");
            map.put("message", "book was saved successfully!");
            map.put("data", list);
        }
        return map;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> map = new HashMap();
        List<Book> list = bookService.selectAll();
        if (list != null){
            map.put("status", "200");
            map.put("data", list);
        }
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delete(Book book) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bookService.delete(book)) {
            map.put("status", "200");
            map.put("message", "book was deleted successfully!");
        }
        return map;
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> deleteAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Book> list = bookService.selectAll();
        for (Book book: list){
            bookService.delete(book);
        }

        map.put("status", "200");
        map.put("message", "all books were deleted successfully!");

        return map;
    }

    @RequestMapping(value = "/addTestData", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addTestData() {

        bookService.saveOrUpdate(new Book ("title1", "desc1", "author1", "isbn1", 2005, false));

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("status", "200");
        map.put("message", "test books were added successfully!");

        return map;
    }

    @RequestMapping(value = "/findBooks", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> findBooks(String title){
        Map<String, Object> map = new HashMap();
        List<Book> list = bookService.findBooks(title);

        if (list != null){
            map.put("status", "200");
            map.put("data", list);
        }
        return map;
    }
}
