package com.amazonaws.lambda.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
	TransactionReference transactionReference;

	@JsonProperty("transaction_reference")
	public TransactionReference getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(TransactionReference transactionReference) {
		this.transactionReference = transactionReference;
	}
	
}
