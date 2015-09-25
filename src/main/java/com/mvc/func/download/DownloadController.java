package com.mvc.func.download;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/download")
public class DownloadController {
	/**
     * Handle request to download a excel document
     */
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel(Model model) {
		// create some sample data
        List<Book> listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Effective Java", "Joshua Bloch", "0321356683",
                "May 28, 2008", 38.11F));
        listBooks.add(new Book("Head First Java", "Kathy Sierra & Bert Bates",
                "0596009208", "February 9, 2005", 30.80F));
        listBooks.add(new Book("Java Generics and Collections",
                "Philip Wadler", "0596527756", "Oct 24, 2006", 29.52F));
        listBooks.add(new Book("Thinking in Java", "Bruce Eckel", "0596527756",
                "February 20, 2006", 43.97F));
        listBooks.add(new Book("Spring in Action", "Craig Walls", "1935182358",
                "June 29, 2011", 31.98F));
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("excelView", "listBooks", listBooks);
	}
	
	/**
     * Handle request to download a PDF document
     */
    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadPdf() {
        // create some sample data
        List<Book> listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Spring in Action", "Craig Walls", "1935182358",
                "June 29th 2011", 31.98F));
        listBooks.add(new Book("Spring in Practice", "Willie Wheeler, Joshua White",
                "1935182056", "May 16th 2013", 31.95F));
        listBooks.add(new Book("Pro Spring 3",
                "Clarence Ho, Rob Harrop", "1430241071", "April 18th 2012", 31.85F));
        listBooks.add(new Book("Spring Integration in Action", "Mark Fisher", "1935182439",
                "September 26th 2012", 28.73F));
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("pdfView", "listBooks", listBooks);
    }
}
