package com.calculatrice.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculatrice")
public class Calculatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calculatrice() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nb1 = 0;
		int nb2 = 0;
		try {
			nb1 = Integer.parseInt(request.getParameter("nb1"));
		} catch (NumberFormatException e) {
			nb1 = 0;
		}
		try {
			nb2 = Integer.parseInt(request.getParameter("nb2"));
		} catch (NumberFormatException e) {
			nb2 = 0;
		}
		String operation = request.getParameter("operation");
		double result = 0;
		String message = "";
		switch (operation) {
		case "+":
			result = (double) nb1 + nb2;
			break;
		case "*":
			result = (double) nb1 * nb2;
			break;
		case "-":
			result = (double) nb1 - nb2;
			break;
		case "/":
			if (nb2 == 0) {
				message = "vous ne pouvez pas diviser par 0";
			} else {
				result = (double) nb1 / nb2;
			}
			break;
		default:
			break;
		}
		if (message.isEmpty()) {
			message = "Résultat de l'opération : " + nb1 + operation + nb2 + "=" + result;
		}
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

}
