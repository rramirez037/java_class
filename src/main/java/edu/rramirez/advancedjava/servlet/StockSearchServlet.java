package edu.rramirez.advancedjava.servlet;

import edu.rramirez.advancedjava.model.StockQuery;
import edu.rramirez.advancedjava.model.StockQuote;
import edu.rramirez.advancedjava.services.ServiceFactory;
import edu.rramirez.advancedjava.services.StockService;
import edu.rramirez.advancedjava.services.StockServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * StockSearchServlet - retrieve data from the stockquote.jsp. It process the data to
 *                      get quotes for the Yahoo Finance API and forward the data to the
 *                      stockquoteResult.jsp
 * 
 * @author Ramon Ramirez
 *
 */
public class StockSearchServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String symbol = request.getParameter("symbol");
		String from = request.getParameter("from");
		String until = request.getParameter("until");
		String interval = request.getParameter("Intervals");

		StockService Service = ServiceFactory.getStockServiceInstance();
		List<StockQuote> stockQuote = null;

		try {

			StockQuery stockQuery = new StockQuery(symbol, from, until);

			stockQuote = Service.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), 
					stockQuery.getUntil(), interval);

		} catch (ParseException | StockServiceException e) {

			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		/*
		 * Storage the data in the session map
		 */
		session.setAttribute("result", stockQuote);
		session.setAttribute("symbol", symbol);
		session.setAttribute("from", from);
		session.setAttribute("to", until);
		session.setAttribute("interval", interval);

		/*
		 * forward the data to the stockquoteResult JSP page
		 *
		 */
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/stockquoteResult.jsp");
		dispatcher.forward(request, response);

	}
}
