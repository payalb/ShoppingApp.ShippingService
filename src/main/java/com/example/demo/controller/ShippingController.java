package com.example.demo.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dao.ShippingRepository;
import com.example.demo.dto.Shipping;
import com.example.demo.dto.ShopError;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

	@Autowired ShippingRepository sr;
	
	@PostMapping
	public ResponseEntity addShipping( @RequestBody Shipping ship, BindingResult result, HttpServletRequest request ) {
		if ( ship == null ) {
			return ResponseEntity.badRequest().body(ShopError.builder().message(Arrays.asList("Empty details")).build());
		}else if(result.hasErrors()) {
			return ResponseEntity.badRequest().body(ShopError.builder().message(
					result.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList())));
		} else {
			sr.save(ship);
			URI uri=UriComponentsBuilder.fromUriString(request.getRequestURI().toString()).path(ship.getId().toString()).build().toUri();
			return ResponseEntity.created(uri).build();
		}
	}
}
