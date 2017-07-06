package com.randstad.customerreview.model;

public class CustomerReviewModel {
	
	private long customerId;
	private long productId;
	private String productName;
	private String customerComment;
	private double productReview;
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the customerComment
	 */
	public String getCustomerComment() {
		return customerComment;
	}
	/**
	 * @param customerComment the customerComment to set
	 */
	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}
	/**
	 * @return the productReview
	 */
	public double getProductReview() {
		return productReview;
	}
	/**
	 * @param productReview the productReview to set
	 */
	public void setProductReview(double productReview) {
		this.productReview = productReview;
	}
		

}
