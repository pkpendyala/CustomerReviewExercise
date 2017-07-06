package com.randstad.customerreview.model;

public class ProductReviewSearchModel {
	
	private long productId;
	private long customerId;
	private String productName;
	private double minRating = 0.0D;
	private double maxRating = 5.0D;
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
	 * @return the minRating
	 */
	public double getMinRating() {
		return minRating;
	}
	/**
	 * @param minRating the minRating to set
	 */
	public void setMinRating(double minRating) {
		this.minRating = minRating;
	}
	/**
	 * @return the maxRating
	 */
	public double getMaxRating() {
		return maxRating;
	}
	/**
	 * @param maxRating the maxRating to set
	 */
	public void setMaxRating(double maxRating) {
		this.maxRating = maxRating;
	}
	

}
