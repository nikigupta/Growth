package com.amazonaws.lambda.demo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionReference implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transactionId;

	@JsonProperty("transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
}
