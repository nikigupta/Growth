//package com.amazonaws.lambda.demo;
//package com.amazonaws.lambda.demo;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// * handler triggered by AWS API gateway, delegates input request to service
// * class
// *
// */
//public  class LambdaFunctionHandler implements RequestHandler<StoredValueRequest, Void> {
//
//	private static final ObjectMapper mapper = new ObjectMapper();
//
//	/**
//	 * method that AWS lambda invokes and responsible for taking Points object
//	 * model and calls service class to processing and publishing
//	 */
//	@Override
//	public Void handleRequest(StoredValueRequest storedValueRequest, Context context) {
//		context.getLogger().log("Input: " + storedValueRequest);
//
//		try {
//			context.getLogger().log(mapper.writeValueAsString(storedValueRequest));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
