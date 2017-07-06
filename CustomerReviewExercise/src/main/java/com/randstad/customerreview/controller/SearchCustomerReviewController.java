/**
* The SearchCustomerReviewController is the Rest Controller 
* to implements an application that show the Total Number of Customer
* Reviews whose ratings are within a given range (inclusive).
* And also add a new customer review based on conditions
*
* @author  Prashanth Pendyala
* @version 1.0
* @since   2017-07-05 
*/
package com.randstad.customerreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.randstad.customerreview.model.CustomerReviewModel;
import com.randstad.customerreview.model.ProductReviewSearchModel;
import com.randstad.customerreview.service.SearchCustomerReviewService;

@Controller
@RequestMapping("/product")
public class SearchCustomerReviewController {
	
	SearchCustomerReviewService searchCustomerReviewService;

	/**
	 * @return the searchCustomerReviewService
	 */
	public SearchCustomerReviewService getSearchCustomerReviewService() {
		return searchCustomerReviewService;
	}

	/**
	 * @param searchCustomerReviewService the searchCustomerReviewService to set
	 */
	public void setSearchCustomerReviewService(SearchCustomerReviewService searchCustomerReviewService) {
		this.searchCustomerReviewService = searchCustomerReviewService;
	}
	
	/**
	   * This method is used to call a service method to return total number of 
	   * customer reviews with in user provided review range
	   * @param productSearchModel -  This parameter stores user provided 
	   * Product Review Search criteria.
	   * @return int This returns total number of customer product reviews.
	   */
	@RequestMapping(value="/{productid}",method=RequestMethod.GET,headers="Accept=application/json",produces={"application/json"})
	@ResponseBody
	public int getReviewsForProductCount(@PathVariable ProductReviewSearchModel productSearchModel){
		int reviewCount;
		reviewCount = searchCustomerReviewService.getReviewsForProductCount(productSearchModel);
		return reviewCount;
		
	}
	
	/**
	   * This method is used to call a service method to add a new customer review
	   * for a product based on following conditions.
	   * 1. There should not any curse words exist in the customer comments
	   * 2. The Rating should not be less than or equal to zero
	   * @param productSearchModel -  This parameter stores user provided 
	   * Product Review Data.
	   * @return void
	   */
	@RequestMapping(value="/{productid}",method=RequestMethod.POST,headers="Accept=application/json",produces={"application/json"})
	@ResponseBody
	public void addProductReview(@RequestBody CustomerReviewModel productModel){
		searchCustomerReviewService.addProductReview(productModel);
	}

}
