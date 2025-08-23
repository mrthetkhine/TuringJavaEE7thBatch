package com.turing.javaee7.jpa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import com.turing.javaee7.jpa.model.Movie;

import reactor.core.publisher.Flux;

public interface MovieRepository  extends ReactiveMongoRepository<Movie,String>{
	Flux<Movie> findByName(String name);
	
	@Query("{ 'director' : ?0 }")
	Flux<Movie> searchByDirector(String directorName);
	
	@Query("{ 'genres' : ?0 }")
	Flux<Movie> searchByGenre(String genre);
	
	@Query("{ 'details.details' : /?0/ }")
	Flux<Movie> searchByDetails(String details);
	
	@Aggregation(pipeline={"{\n"
	 		+ "        $addFields: {\n"
	 		+ "            \"movie_actors\": {\n"
	 		+ "                $map:{\n"
	 		+ "                    input: \"$actors\",\n"
	 		+ "                    as: \"actor\",\n"
	 		+ "                    in: '$$actor.$id'\n"
	 		+ "                }\n"
	 		+ "                \n"
	 		+ "            }\n"
	 		+ "        }\n"
	 		+ "    },\n"
	 		,
	 		 "    {\n"
	 		+ "        $unwind : \"$movie_actors\" \n"
	 		+ "    },\n"
	 		,
	 		 "    { \n"
	 		+ "        \"$lookup\": {\n"
	 		+ "            \"from\": \"actors\",\n"
	 		+ "            \"localField\": \"movie_actors\",\n"
	 		+ "            \"foreignField\": \"_id\",\n"
	 		+ "            \"as\": \"joined_actors\"\n"
	 		+ "        } \n"
	 		+ "    }"
	 		,
	 		 "    { \n"
	 		+ "        \"$group\": {\n"
	 		+ "            \"_id\": \"$_id\",\n"
	 		+ "            \"joined_actors\":{ \n"
	 		+ "                                \"$push\":{ $arrayElemAt: [ \"$joined_actors\",0] }\n"
	 		+ "                            },\n"
	 		+ "            \"doc\":{\"$first\":\"$$ROOT\"}\n"
	 		+ "        }\n"
	 		+ "    }"
	 		,
	 		 "    {   \"$replaceRoot\":{\n"
	 		+ "            \"newRoot\":{ $mergeObjects: [ '$doc',{ actors: '$joined_actors' }] },\n"
	 		+ "        }\n"
	 		+ "    }"
	 		,
	 		" { $unset: \"joined_actors\" }"
	 		,
	 		 "     { \n"
	 		+ "        \"$match\": {\n"
	 		+ "            \"actors\": {\n"
	 		+ "                $elemMatch:{\n"
	 		+ "                    \"firstName\":?0"
	 		+ "                }\n"
	 		+ "            }\n"
	 		+ "        } \n"
	 		+ "    }"})
	 Flux<Movie> getAllMovieWithLookup(String actorName);
	
	@Aggregation("{ '$project': { '_id' : '$name' } }")
	Flux<String> getAllMovieName();  
}	
