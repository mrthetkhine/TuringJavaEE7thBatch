package com.turing.javaee7.mvc.demo.commom;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.turing.javaee7.mvc.demo.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BookValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return BookDto.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		log.info("Book validator validate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.book.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required.book.author");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.book.description");
		BookDto bookDto = (BookDto) obj;
		if(bookDto.getTitle()!= null)
		{
			String title = bookDto.getTitle();
			String upperCase = (title.charAt(0)+"").toUpperCase();
			String startLetter = title.charAt(0)+"";
			log.info("Check uppercase ");
			if(!startLetter.equals(  upperCase))
			{
				errors.rejectValue("title", "uppercase.book.title");
				log.info("Reject ");
			}
		}
		
	
		
	}

}
