package com.vieira.cache_server.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/")
public class CacheServerController {


	private RestClient client = RestClient.create();

	@GetMapping
	public String forwardRequest(@RequestBody String body) {
		System.out.println("Forwarding to: " + body + '\n');

		//if (result is cached) {
		//	return cached_result
		//}
		//else {
		//	...forwarding request
		//  cache(result);
		//}

		String result = client.get()
						.uri(body)
						.retrieve()
						.body(String.class);

		return result;
	}
}
