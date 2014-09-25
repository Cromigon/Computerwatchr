package nu.fulkod.computer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class computerServlet
 */
public class computerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6910606787380248954L;

	public computerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerwatchr", "$USERNAME", "$PASSWORD");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM computers");
			// Send a message and dump all the data
			out.print("Quick data dump\n");
			out.print("Id\t\tName\t\tServices\t\tIp Address\t\tOperatingSystem\n");
			while (resultSet.next()) {
				// Id
				out.print(resultSet.getObject(1).toString());
				out.print("\t\t");
				// Name
				out.print(resultSet.getObject(2).toString());
				out.print("\t\t");
				// Services
				out.print(resultSet.getObject(3).toString());
				out.print("\t\t");
				// Ip Address
				out.print(resultSet.getObject(4).toString());
				out.print("\t\t");
				// Operating System
				out.print(resultSet.getObject(5).toString());
				out.print("\n");
			}
		} catch (SQLException e) {
			throw new ServletException("Servlet Could not display records.", e);
		} catch (ClassNotFoundException e) {
			throw new ServletException("JDBC Driver not found.", e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
					resultSet = null;
				}
				if (statement != null) {
					statement.close();
					statement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				out.print(e.getMessage());
			}
		}
		out.close();
	}
}
