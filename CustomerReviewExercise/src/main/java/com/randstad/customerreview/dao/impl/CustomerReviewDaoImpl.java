/**
* The CustomerReviewDaoImpl is the DAO calss 
* to implements an application that interact with Database 
* to fetch the total number of customer reviews for a product and also
* insert a new customer review record to database.
* 
* @author  Prashanth Pendyala
* @version 1.0
* @since   2017-07-05 
*/

package com.randstad.customerreview.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import com.randstad.customerreview.dao.CustomerReviewDao;
import com.randstad.customerreview.model.CustomerReviewModel;
import com.randstad.customerreview.model.ProductReviewSearchModel;

public class CustomerReviewDaoImpl implements CustomerReviewDao{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	   * This method is used to return total number of 
	   * customer reviews with in user provided review range
	   * @param productSearchModel -  This parameter stores user provided 
	   * Product Review Search criteria.
	   * @return int This returns total number of customer product reviews.
	   */
	public int getReviewsForProductCount(ProductReviewSearchModel productSearchModel){
		
		int countReview = 0;
		long productId = 0L;
		double minRange = 0.0;
		double maxRange = 0.0;
		String sql = "SELECT COUNT(ID) FROM CUSTOMERREVIEW WHERE PRODUCT_ID = ? AND (REVIEW_NUM >= ? AND REVIEW_NUM <= ?)";

		Connection conn = null;

		try {
			
			productId = productSearchModel!=null?productSearchModel.getProductId():0L;
			minRange = productSearchModel!=null?productSearchModel.getMinRating():0.0D;
			maxRange = productSearchModel!=null?productSearchModel.getMaxRating():0.5D;
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, productId);
			ps.setDouble(2, minRange);
			ps.setDouble(3, maxRange);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				countReview = rs.getInt("id");
										
			}
			rs.close();
			ps.close();
			return countReview;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
		
	/**
	   * This method is used to add a new customer review record
	   * into DB 
	   * @param customerReviewModel -  This parameter stores user provided 
	   * Product Review data.
	   * @return void.
	   */
		public void addProductReview(CustomerReviewModel customerReviewModel){
			
			String sql = "INSERT INTO CUSTOMERREVIEW " +
					"(CUST_ID, PRODUCT_ID,PRODUCT_NME, REVIEW_NUM) VALUES (?, ?, ?,?)";
			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setLong(1, customerReviewModel.getCustomerId());
				ps.setLong(2, customerReviewModel.getProductId());
				ps.setString(3, customerReviewModel.getProductName());
				ps.setDouble(4, customerReviewModel.getProductReview());
				ps.executeUpdate();
				ps.close();
				
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if (conn != null) {
					try {
					conn.close();
					} catch (SQLException e) {}
				}
			}
			

	}
		/**
		 * 
		 * 
		 */
		public Set<String> fetchCurseWords(){
			
			Set<String> words = new HashSet<String>();
			
			String sql = "SELECT LOOKUP_DESC FROM LOOKUP WHERE SOURCE_NME = ? ";

			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, "CURSEWORDS");
				
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					
					words.add(rs.getString("LOOKUP_DESC"));
											
				}
				rs.close();
				ps.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if (conn != null) {
					try {
					conn.close();
					} catch (SQLException e) {}
				}
			}

			
			return words;
			
		}
	
	
	
	
}
