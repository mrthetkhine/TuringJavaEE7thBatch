package com.turing.javaee7.mvc.demo.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee7.mvc.demo.controller.api.common.ApiUtil;
import com.turing.javaee7.mvc.demo.controller.api.dto.ApiResponse;
import com.turing.javaee7.mvc.demo.controller.api.dto.SuccessCode;
import com.turing.javaee7.mvc.demo.controller.api.exception.BeanValidationException;
import com.turing.javaee7.mvc.demo.controller.api.exception.NotFoundException;
import com.turing.javaee7.mvc.demo.dto.BookDto;
import com.turing.javaee7.mvc.demo.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookApiController {

	@Autowired
	BookService bookService;
	
	@Autowired
	ApiUtil apiUtil;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<BookDto>>> getAllBook() {
		log.info("/api/books controller");
		List<BookDto> books = this.bookService.getAllBooks();
		
		return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Book list ok", books);
	}
	
	@GetMapping(value="/{bookId}")
	public ResponseEntity<ApiResponse<BookDto>> getBookById(@PathVariable Long bookId) throws NotFoundException  {
		log.info("Get Book by ID "+bookId);
		BookDto book = this.bookService.getBookById(bookId);
		
		return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Get byID ", book);
	}
	@PostMapping
	public ResponseEntity<ApiResponse<BookDto>> saveBook(@Valid @RequestBody BookDto bookDto, BindingResult result)throws BeanValidationException
	{
		log.info("Save book by Id");
		if(!result.hasErrors())
		{
			
			this.bookService.saveBook(bookDto);
			return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Save book sucess ", bookDto);
		}
		else
		{
			log.info("error in save book");
			throw new BeanValidationException(result.getAllErrors());
		}
		
	}
	@PutMapping(value="/{bookId}")
	public ResponseEntity<ApiResponse<BookDto>> udpateBook(@PathVariable Long bookId,@Valid @RequestBody BookDto bookDto, BindingResult result)
				throws BeanValidationException,NotFoundException
	{
		log.info("Save book by Id");
		if(!result.hasErrors())
		{
			bookDto.setId(bookId);
			this.bookService.updateBook(bookDto);
			return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "Save book sucess ", bookDto);
		}
		else
		{
			log.info("error in save book");
			throw new BeanValidationException(result.getAllErrors());
		}
		
	}
	@DeleteMapping(value="/{bookId}")
	public ResponseEntity<ApiResponse<BookDto>> deleteBookById(@PathVariable Long bookId)throws NotFoundException  {
		log.info("Delete Book by ID "+bookId);
		this.bookService.deleteBookById(bookId);
		
		return apiUtil.buildSucessResponse(HttpStatus.OK, SuccessCode.SUCESS.toString(), "deleteBookById sucess ", null);
	}
}
