package com.tayadetech.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tayadetech.model.CatalogItem;
import com.tayadetech.model.UserRating;
import com.tayadetech.service.MovieInfoService;
import com.tayadetech.service.UserRatingInfoService;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResource {
	
	@Autowired
	MovieInfoService movieInfoService;
	
	@Autowired
	UserRatingInfoService userRatingInfoService;
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
		
		UserRating ratings = userRatingInfoService.getUserRating(userId);

		return ratings.getUserRating().stream().map(rating -> movieInfoService.getCatalogItem(rating)).collect(Collectors.toList());
		
		//	return Collections.singletonList(new CatalogItem("Transformer", "Test", 1));
		/*
		 * Movie movie = webClientBuilder.build() .get()
		 * .uri("http://localhost:8082/movie/"+rating.getMoviesId()) .retrieve()
		 * .bodyToMono(Movie.class) .block();
		 */
	}
	
	
	
}
