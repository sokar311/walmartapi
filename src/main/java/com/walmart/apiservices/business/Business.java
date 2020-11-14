package com.walmart.apiservices.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.apiservices.dto.ProductDTO;
import com.walmart.apiservices.model.Product;
import com.walmart.apiservices.services.Services;
import com.walmart.apiservices.utils.Utils;

@Service
public class Business {

	@Autowired
	Services services;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @param phrase
	 * @return list of products that match phrase in it id, brand or description
	 */
	public List<ProductDTO> findProducts(String phrase) {
		List<Product> products = new ArrayList<>();
		
		Boolean isNumeric = true;
		Integer productId = null;
		
		// Check is the phrase is a number
		try {
			productId = Integer.parseInt(phrase);
		} catch (NumberFormatException e) {
			isNumeric = false;
		}
		
		// Check if the phrase is a palindrome
		Boolean isPalindrome = Utils.checkPalindrome(phrase);
		
		if (phrase.length()<3 && !isNumeric) {
			// The phrase is shorter than 3 charactes and is not a number
			// No results returned
			
			// The result is processed with Utils.applyDiscount
			return Utils.applyDiscount(products, isPalindrome);
		}
		
		// If the phrase is a number, we have to search the product by id (only one product)
		if (isNumeric) {
			Product product = this.services.findById(productId);
			products.add(product);
		} else if (phrase.length()>3) {
			// If the phrase is not a number only search if it's longer than 3 characters
			// The result is processed with Utils.applyDiscount
			products = this.services.findByPhrase(phrase);
		}
		
		// The result is processed with Utils.applyDiscount
		return Utils.applyDiscount(products, isPalindrome);
    }

}
