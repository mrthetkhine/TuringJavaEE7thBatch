package com.turing.javaee7.jpa.webclient;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.turing.javaee7.jpa.DelayUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
//https://fakeapi.platzi.com/en/rest/auth-jwt/

@Slf4j
public class WebClientTest {

	WebClient webClient = WebClient.builder()
		      .baseUrl("https://api.escuelajs.co/api/v1")
		      //.defaultCookie("cookie-name", "cookie-value")
		      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		      .build();
	private Mono<AuthResponse> authLogin(AuthUser authUser) 
	{	 
		 return webClient.post()
	      .uri("/auth/login")
	      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	      .body(Mono.just(authUser), AuthUser.class)
	      .retrieve()
	      .bodyToMono(AuthResponse.class)
	      .onErrorResume(ae->Mono.error(new RuntimeException("Auth exception")));
	}
	Mono<UserProfile> getProfile(AuthResponse auth)
	{
		return webClient.get()
			      .uri("/auth/profile")
			      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			      .header(HttpHeaders.AUTHORIZATION, "Bearer "+auth.access_token)
			      .retrieve()
			      .bodyToMono(UserProfile.class)
			      .onErrorResume(ae->Mono.error(new RuntimeException("Cannot fetch user profile exception")));
	}
	
	@Test
	public void testJWtLogin()
	{
		 AuthUser authUser = new AuthUser();
		 authUser.setEmail("john@mail.com");
		 authUser.setPassword("changeme");
		 
		 Mono<UserProfile> authResponse = authLogin(authUser)
				 						 	.flatMap(this::getProfile);
		 
		 authResponse.subscribe(data->{
			 log.info("result "+data);
		 },error->{
			 log.info("Error"+error.getLocalizedMessage());
		 });
		 
		DelayUtil.delay(4000);
	}
	
}
