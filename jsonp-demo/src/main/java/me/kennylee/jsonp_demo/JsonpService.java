package me.kennylee.jsonp_demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

/**
 * Servlet implementation class JsonpService
 */
@WebServlet("/JsonpService")
public class JsonpService extends HttpServlet {

	private static final long serialVersionUID = -5721212006954168102L;

	/**
	 * Default constructor.
	 */
	public JsonpService() {
		// do nothing
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String callBack = request.getParameter("callBack");
		Gson gson = new Gson();
		String name = request.getParameter("name");
		String msg = null;
		boolean isCross = false;
		if (StringUtils.isNotBlank(callBack) || StringUtils.isNoneBlank(name)) {
			msg = "Hello " + name + " !";
			isCross = true;
		} else {
			msg = "bad parameter!";
		}
		JsonData jsonData = new JsonData(msg);

		PrintWriter out = response.getWriter();
		String s = null;
		if (isCross) {
			// response.setContentType("application/json");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			s = callBack + "(" + gson.toJson(jsonData) + ")";
		} else {
			s = gson.toJson(jsonData);
		}
		out.print(s);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 
	 * Json Data Bean
	 * 
	 * @author kennylee
	 * 
	 */
	public static class JsonData {
		private String msg;

		public JsonData(String msg) {
			super();
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}

}
