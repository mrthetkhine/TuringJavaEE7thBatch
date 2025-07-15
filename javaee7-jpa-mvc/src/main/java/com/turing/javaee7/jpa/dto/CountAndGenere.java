package com.turing.javaee7.jpa.dto;

public class CountAndGenere {
	Long count;
	String genre;
	public CountAndGenere(Long count,String genre)
	{
		this.count = count;
		this.genre = genre;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "CountAndGenere [count=" + count + ", genre=" + genre + "]";
	}
	
}
