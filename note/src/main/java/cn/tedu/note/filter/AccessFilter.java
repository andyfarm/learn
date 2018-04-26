package cn.tedu.note.filter;

import cn.tedu.note.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {
	@Override
	public void destroy() {
	}

	private String login = "/log_in.html";
	private String alert = "alert_error.html";
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String path = request.getRequestURI();
		if (path.endsWith(login)) {
			chain.doFilter(req, resp);
			return;
		}

		if (path.endsWith(alert)){
			chain.doFilter(req, resp);
			return;
		}

		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath()+login);
			return;
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
