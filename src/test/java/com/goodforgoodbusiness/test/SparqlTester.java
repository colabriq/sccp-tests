package com.goodforgoodbusiness.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;

import com.goodforgoodbusiness.endpoint.route.SparqlRoute;
import com.goodforgoodbusiness.webapp.ContentType;

import spark.Request;
import spark.Response;

public class SparqlTester {
	private static class TestServletOutputStream extends ServletOutputStream {
		private final OutputStream other;

		private TestServletOutputStream(OutputStream other) {
			this.other = other;
		}
		
		@Override
		public boolean isReady() {
			return true;
		}

		@Override
		public void setWriteListener(WriteListener writeListener) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void write(int b) throws IOException {
			other.write(b);
		}
		
	}
	
	private final SparqlRoute route;

	public SparqlTester(SparqlRoute route) {
		this.route = route;
	}

	public void update(String sparqlStmt) throws Exception {
		var req = mock(Request.class);
		
		when(req.contentType()).thenReturn(ContentType.sparql_update.getContentTypeString());
		when(req.body()).thenReturn(sparqlStmt);
		
		var res = mock(Response.class);
		
		route.handle(req, res);
	}

	public void query(String sparqlStmt, String contentType, PrintStream out) throws Exception {
		var req = mock(Request.class);
		
		when(req.contentType()).thenReturn(ContentType.sparql_query.getContentTypeString());
		when(req.body()).thenReturn(sparqlStmt);
		when(req.headers("accept")).thenReturn(contentType);
		
		var res = mock(Response.class);
		var hsr = mock(HttpServletResponse.class);
		
		when(res.raw()).thenReturn(hsr);
		when(hsr.getOutputStream()).thenReturn(new TestServletOutputStream(out));
		
		route.handle(req, res);
	}
}
