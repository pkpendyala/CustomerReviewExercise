package com.randstad.customerreview.dao;

import java.util.Set;

import com.randstad.customerreview.model.CustomerReviewModel;
import com.randstad.customerreview.model.ProductReviewSearchModel;

public interface CustomerReviewDao {
	
	public int getReviewsForProductCount(ProductReviewSearchModel productSearchModel);
	public void addProductReview(CustomerReviewModel productModel);
	public Set<String> fetchCurseWords();

}
