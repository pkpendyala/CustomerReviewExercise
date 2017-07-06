package com.randstad.customerreview.service;

import com.randstad.customerreview.model.CustomerReviewModel;
import com.randstad.customerreview.model.ProductReviewSearchModel;

public interface SearchCustomerReviewService {
	
	public int getReviewsForProductCount(ProductReviewSearchModel productSearchModel);
	public void addProductReview(CustomerReviewModel productModel);

}
