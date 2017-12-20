package com.amazonaws.lambda.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class StreamHandlerTest {

	private static final String SAMPLE_INPUT_STRING = "{\"foo\": \"bar\"}";
	private static final String EXPECTED_OUTPUT_STRING = "{\"FOO\": \"BAR\"}";

	@Test
	public void testStreamHandler() throws IOException {
		LambdaFunctionHandler handler = new LambdaFunctionHandler();

		InputStream input = new ByteArrayInputStream(SAMPLE_INPUT_STRING.getBytes());
		;
		OutputStream output = new ByteArrayOutputStream();
		InputStream stream = TestUtils.class.getResourceAsStream("/StoredValueRequest.json");
		handler.handleRequest(stream, output, null);

		// TODO: validate output here if needed.
		String sampleOutputString = output.toString();
		System.out.println(sampleOutputString);
		Assert.assertEquals(EXPECTED_OUTPUT_STRING, sampleOutputString);
	}
}
