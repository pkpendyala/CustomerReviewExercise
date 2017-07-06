/**
* The SearchCustomerReviewServiceImpl is Service calss 
* to implements an application to  show the Total Number of Customer
* Reviews whose ratings are within a given range (inclusive).
* And also add a new customer review based on conditions
*
* @author  Prashanth Pendyala
* @version 1.0
* @since   2017-07-05 
*/

package com.randstad.customerreview.service.impl;

import java.util.Set;

import com.randstad.customerreview.dao.CustomerReviewDao;
import com.randstad.customerreview.exception.CurseWordException;
import com.randstad.customerreview.exception.ZeroRatingReviewException;
import com.randstad.customerreview.model.CustomerReviewModel;
import com.randstad.customerreview.model.ProductReviewSearchModel;
import com.randstad.customerreview.service.SearchCustomerReviewService;

public class SearchCustomerReviewServiceImpl implements SearchCustomerReviewService{
	
	CustomerReviewDao customerReviewDao;

	/**
	 * @param customerReviewDao the customerReviewDao to set
	 */
	public void setCustomerReviewDao(CustomerReviewDao customerReviewDao) {
		this.customerReviewDao = customerReviewDao;
	}
	
	/**
   * This method is used to return total number of 
   * customer reviews with in user provided review range
   * @param productSearchModel -  This parameter stores user provided 
   * Product Review Search criteria.
   * @return int This returns total number of customer product reviews.
	   */
	public int getReviewsForProductCount(ProductReviewSearchModel productSearchModel){
		
		int count = 0;
		try{
			
			count = customerReviewDao.getReviewsForProductCount(productSearchModel);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return count;
	}
	
	/**
	   * This method is used to add a new customer review
	   * for a product based on following conditions.
	   * 1. There should not any curse words exist in the customer comments
	   * 2. The Rating should not less than zero
	   * @param productSearchModel -  This parameter stores user provided 
	   * Product Review Data.
	   * @return void
	   */
	public void addProductReview(CustomerReviewModel productModel){
			
		try{
				if(validateCustComments(productModel)){
					customerReviewDao.addProductReview(productModel);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
	}
	
	/**
	   * This method is used to validate Customer provided review details
	   * Customer data will be added based following conditions.
	   * 1. There should not any curse words exist in the customer comments
	   * 2. The Rating should not be less than or equal to zero
	   * @param productSearchModel -  This parameter stores user provided 
	   * Product Review Data.
	   * @return boolean
	   */

	public boolean validateCustComments(CustomerReviewModel productModel){
		
		Set<String> curseWords = null;
		String custComments = productModel.getCustomerComment();
		
		try{
			curseWords = customerReviewDao.fetchCurseWords();
			//Check whether any curse word is exist in the customer's comment
			
			if(isCurseWordExist(curseWords,custComments) ){
				throw new CurseWordException("Customer Comments contain few curse words !!"); 
				
			}else if(!validRating(productModel.getProductReview())){
				throw new ZeroRatingReviewException("Customer Rating is Zero for the product : "+productModel.getProductName());
				
			}
		
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		return true;
		
	}
	
	/**
	   * This method is used to checck any predefined curse word has
	   * exist in the ustomer provided comments
	   * @param Set<String> -  This parameter stores all curse words defined in system 
	   * @param comments - Customr provided comments
	   * @return boolean
	   */
	public boolean isCurseWordExist(Set<String> words,String comments) {
	     for (String word : words) {
	       if (comments.contains(word)) {
	         return true;
	       }
	     }

	     return false;
	   }
	
	/**
	   * This method is used to validate Review Rating based on customers provided data
	   * 1. The Rating should not be less than or equal to zero
	   * @param double -  review rating number 
	   * @return boolean
	   */

	
	public boolean validRating(double reviewRating) {
	     
		if(reviewRating <0 )
			return false;
		
	     return true;
	   }

}
