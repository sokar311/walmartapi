package com.walmart.apiservices;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.walmart.apiservices.model.Product;
import com.walmart.apiservices.services.Services;
import com.walmart.apiservices.utils.Utils;

@SpringBootTest
class ApiservicesApplicationTests {

	@Autowired
	Services services;
	
	Logger logger = LoggerFactory.getLogger(ApiservicesApplicationTests.class);
	
	@Test
	void findAllTest() throws Exception {
		logger.info("findAll test start");
		List<Product> products = services.findAll();
		if (products == null || products.size() == 0) {
			logger.info("findAll failed, no products found.");			
			throw new Exception ("findAll failed, no products found.");			
		} else {
			logger.info("findAll success, found " + products.size() + " products.");			
		}
		logger.info("findAll test end");
	}

	@Test
	void findByIdTest() throws Exception  {
		logger.info("findById test start");
		Product product = services.findById(1);
		if (product == null) {
			logger.info("findById failed, no products found.");			
			throw new Exception ("findById failed, no products found.");			
		} else {
			logger.info("findById success, found 1 product.");			
		}
		logger.info("findById test end");
	}

	@Test
	void checkPalindromeTest() throws Exception {
		logger.info("checkPalindrome test start");
		Boolean result = Utils.checkPalindrome("leoncio nuneZ");
		if (result) {
			logger.error("Expected false result.");
			throw new Exception ("Expected false result.");
		} else {
			logger.info("leoncio nuneZ is palindrome? :" + result +" ok!");
		}
		result = Utils.checkPalindrome("Ali tomo tila");
		if (!result) {
			logger.error("Expected true result.");
			throw new Exception ("Expected true result.");
		} else {
			logger.info("leoncio nuneZ is palindrome? :" + result +" ok!");
		}
		logger.info("checkPalindromeTest end");
	}

	@Test
	void findByPhraseTest() throws Exception  {
		logger.info("findByPhrase test start");
		List<Product> products = services.findByPhrase("ñl");
		if (products == null || products.size() == 0) {
			logger.info("findByPhrase failed, no products found.");			
			throw new Exception ("findByPhrase failed, no products found.");			
		} else {
			logger.info("findByPhrase success, found " + products.size() + " products.");			
		}
		logger.info("findByPhrase test end");
	}

}
