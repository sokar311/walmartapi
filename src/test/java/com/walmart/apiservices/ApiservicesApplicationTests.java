package com.walmart.apiservices;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.walmart.apiservices.model.Product;
import com.walmart.apiservices.services.Services;
import com.walmart.apiservices.utils.Utils;

@SpringBootTest
class ApiservicesApplicationTests {

	@Autowired
	Services services;

	@Autowired
	MongoTemplate mongoTemplate;

	Logger logger = LoggerFactory.getLogger(ApiservicesApplicationTests.class);
	
//	@Test
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

//	@Test
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

//	@Test
	void checkPalindromeTest() throws Exception {
		System.out.println("checkPalindrome test start");
		Boolean result = Utils.checkPalindrome("leoncio nuneZ");
		if (result) {
			System.out.println("Expected false result.");
			throw new Exception ("Expected false result.");
		} else {
			System.out.println("leoncio nuneZ is palindrome? :" + result +" ok!");
		}
		result = Utils.checkPalindrome("Ali tomo tila");
		if (!result) {
			System.out.println("Expected true result.");
			throw new Exception ("Expected true result.");
		} else {
			System.out.println("leoncio nuneZ is palindrome? :" + result +" ok!");
		}
		System.out.println("checkPalindromeTest end");
	}

	@Test
	void findByPhraseTest() throws Exception  {
		System.out.println("findByPhrase test start");
		List<Product> products = services.findByPhrase("ñl");
		if (products == null || products.size() == 0) {
			System.out.println("findByPhrase failed, no products found.");			
			throw new Exception ("findByPhrase failed, no products found.");			
		} else {
			System.out.println("findByPhrase success, found " + products.size() + " products.");			
		}
		System.out.println("findByPhrase test end");
	}

}
