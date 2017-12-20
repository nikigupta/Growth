package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.expedia.globalpayments.ir.model.StoredValueRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LambdaFunctionHandler implements RequestStreamHandler {
	private static final ObjectMapper mapper = new ObjectMapper();


    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
    	StoredValueRequest storedValueRequest = mapper.readValue(input, StoredValueRequest.class);
    	try {
    		System.out.println(mapper.writeValueAsString(storedValueRequest));
    		 TransactionReference transactionReference = new TransactionReference();
    		 transactionReference.setTransactionId("Hello");
    		 output.write( mapper.writeValueAsBytes(transactionReference));	
    		 } catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
