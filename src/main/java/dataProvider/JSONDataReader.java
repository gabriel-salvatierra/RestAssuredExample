package dataProvider;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONDataReader {
    private final String bookFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "/Books.json";
    private List<Book> booksList;

    public JSONDataReader() {
        booksList = getBookData();
    }

    private List<Book> getBookData() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(bookFilePath));
            Book[] books = gson.fromJson(bufferedReader, Book[].class);
            return Arrays.asList(books);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + bookFilePath);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ignore) {
            }
        }
    }

    public final Book getBookByName(final String bookName) {
        for (Book book : booksList) {
            if (book.name.equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }
}
