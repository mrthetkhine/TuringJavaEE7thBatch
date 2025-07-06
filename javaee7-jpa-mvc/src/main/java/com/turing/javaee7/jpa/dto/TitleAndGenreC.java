package com.turing.javaee7.jpa.dto;

public class TitleAndGenreC {
	String title;
	String genere;
	
	public TitleAndGenreC(String title,String genre)
	{
		System.out.println("Consructor");
		this.title = title;
		this.genere = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
}
