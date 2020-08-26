package br.gov.pe.sefaz.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {


    public void destroy() {}


    @SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();
			
		Map<String, Object> user = (Map<String, Object>) (session.getAttribute("user"));
			
			if (user == null) {
				
				((HttpServletRequest) request).getRequestDispatcher("login").forward(request, response);
				
				return;
			}

	        if(session.getAttribute("user") != null){
	        	
	              chain.doFilter(request, response);
	        }
	        
	        else if(request.getParameter("username") != null && request.getParameter("password") != null 
	            &&  ((HttpServletRequest)request).getRequestURL().toString().equals("/login")){   
	        	
	             chain.doFilter(request, response);
	        }
	        
	        else{
	             ((HttpServletResponse) response).sendRedirect("/login");
	             return;
	         }  
    }


    public void init(FilterConfig fConfig) throws ServletException {}


}


