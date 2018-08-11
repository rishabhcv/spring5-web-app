package com.esp.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.esp.spring5webapp.model.Author;
import com.esp.spring5webapp.model.Book;
import com.esp.spring5webapp.model.Publisher;
import com.esp.spring5webapp.repositories.AuthorRepository;
import com.esp.spring5webapp.repositories.BookRepository;
import com.esp.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		initData();
	} 
	
	private void initData() {
		
		Author firstAuth = new Author("Chetan", "Bhagat" );
		Publisher firstPub = new Publisher("Penguin", "Mumbai");
		Book firstBook = new Book ("Revolution 2020", "23412", firstPub);
		firstAuth.getBooks().add(firstBook);
		firstBook.getAuthors().add(firstAuth);
		
		authorRepository.save(firstAuth);
		publisherRepository.save(firstPub);
		bookRepository.save(firstBook);
		
	}

}
