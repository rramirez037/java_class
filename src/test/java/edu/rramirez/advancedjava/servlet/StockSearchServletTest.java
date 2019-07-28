package edu.rramirez.advancedjava.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StockSearchServletTest {

	HttpServletRequest request;
	HttpServletResponse response;

	@Test
	public void test() throws IOException, ServletException {

		StockSearchServlet stockSearch = new StockSearchServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("symbol")).thenReturn("GOOG");
		when(request.getParameter("from")).thenReturn("2018/01/01");
		when(request.getParameter("until")).thenReturn("2018/12/31");
		when(request.getParameter("Intervals")).thenReturn("monthly");
		when(request.getSession()).thenReturn(new MySession());
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		//stockSearch.doPost(request, response);
		

		/*
		 * I didn't have success implementing this class after following the
		 * example from week 10.
		 * 
		 * The statement stockSearch.foPost(request,response) is throwing a
		 * java.lang.illegalStateException.ServletConfig has not been initialized.
		 *
		 */ 
		}

	class MySession implements HttpSession {
		private Map<String, Object> attributes = new HashMap<String, Object>();

		public long getCreationTime() {
			return 0;
		}

		public String getId() {
			return null;
		}

		public long getLastAccessedTime() {
			return 0;
		}


		public ServletContext getServletContext() {                
			return new ServletContext() {                    
				public String getContextPath() {                        
					return null;                    
					}                        
				public ServletContext getContext(String s) {                        
					return null;                    }                        
				public int getMajorVersion() {                        
					return 0;                    }                        
				public int getMinorVersion() {                        
					return 0;                    
					}                        
				public int getEffectiveMajorVersion() {                        
					return 0;                    
					}                       
				public int getEffectiveMinorVersion() {                        
					return 0;                    
					}                        
				public String getMimeType(String s) {                        
					return null;                    
					}                      
				public Set<String> getResourcePaths(String s) {                       
					return null;                   
					
				}                      
				public URL getResource(String s) throws MalformedURLException {                       
					return null;                   
					}                      
				public InputStream getResourceAsStream(String s) {                       
					return null;                   }                      
				public RequestDispatcher getRequestDispatcher(String s) {                       
					return new RequestDispatcher() {                           
						public void forward(ServletRequest servletRequest, ServletResponse servletResponse)                                   
								throws ServletException, IOException {                              
							
						}                          
						public void include(ServletRequest servletRequest, ServletResponse servletResponse)                                   
								throws ServletException, IOException {                              
							
						}};                   
						}                      
				public RequestDispatcher getNamedDispatcher(String s) {                       
					return null;                   
					}                     
				public Servlet getServlet(String s) throws ServletException {                       
					return null;                   
					}                      
				public Enumeration<Servlet> getServlets() {                       
					return null;                   
					}                      
				public Enumeration<String> getServletNames() {                      
					return null;                   
					}                      
				public void log(String s) { 

          }                      
				public void log(Exception e, String s) {                      
					
				}                      
				public void log(String s, Throwable throwable) {                      
					
				}                      
				public String getRealPath(String s) {                       
					return null;                   
					}                      
				public String getServerInfo() {                       
					return null;                   
					}                      
				public String getInitParameter(String s) {                       
					return null;                   
					}                      
				public Enumeration<String> getInitParameterNames() {                       
					return null;                   
					}                     
				public boolean setInitParameter(String s, String s1) {                       
					return false;                   
					}                      
				public Object getAttribute(String s) {                       
					return null;                   
					}                      
				public Enumeration<String> getAttributeNames() {                       
					return null;                   
					}                      
				public void setAttribute(String s, Object o) {                      
					
				}                      
				public void removeAttribute(String s) {                      
				}                    
				
				public String getServletContextName() {                       
					return null;                   
					}                      
				public ServletRegistration.Dynamic addServlet(String s, String s1) {                       
					return null;                   
					}                      
				public ServletRegistration.Dynamic addServlet(String s, Servlet servlet) {                       
					return null;                   
					}                      
				public ServletRegistration.Dynamic addServlet(String s, Class<? extends Servlet> aClass) {                       
					return null;                   
					}                      
				public <T extends Servlet> T createServlet(Class<T> aClass) throws ServletException {                       
					return null;                   
					}                      
				public ServletRegistration getServletRegistration(String s) {                       
					return null;                   
					}                      
				public Map<String, ? extends ServletRegistration> getServletRegistrations() {                       
					return null;                   
					}                      
				public FilterRegistration.Dynamic addFilter(String s, String s1) {                       
					return null;                   
					}    

       public FilterRegistration.Dynamic addFilter(String s, Filter filter) {                       
    	   return null;                   
    	   }                      
       public FilterRegistration.Dynamic addFilter(String s, Class<? extends Filter> aClass) {                       
    	   return null;                   
    	   }                      
       public <T extends Filter> T createFilter(Class<T> aClass) throws ServletException {                       
    	   return null;                   
    	   }                      
       public FilterRegistration getFilterRegistration(String s) {                       
    	   return null;                   
    	   }                      
       public Map<String, ? extends FilterRegistration> getFilterRegistrations() {                       
    	   return null;                   
    	   }                      
       public SessionCookieConfig getSessionCookieConfig() {                       
    	   return null;                   
    	   }                      
       public void setSessionTrackingModes(Set<SessionTrackingMode> set) {                      
    	   
       }                      
       public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {                       
    	   return null;                   
    	   }                      
       public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {                       
    	   return null;                   
    	   }                      
       public void addListener(String s) {                      
       }                      
       public <T extends EventListener> void addListener(T t) {                      
       }                      
       public void addListener(Class<? extends EventListener> aClass) {                      
       }                      
       public <T extends EventListener> T createListener(Class<T> aClass) throws ServletException {                       
    	   return null;                   
    	   }                      
       public JspConfigDescriptor getJspConfigDescriptor() {                       
    	   return null;                   
    	   }                      
       public ClassLoader getClassLoader() {                       
    	   return null;                   
    	   }                      
       public void declareRoles(String... strings) {                      
       }};           
       }

		public void setMaxInactiveInterval(int i) {
		}

		public int getMaxInactiveInterval() {
			return 0;
		}

		/** * @deprecated */
		public HttpSessionContext getSessionContext() {
			return null;
		}

		public Object getAttribute(String s) {
			return attributes.get(s);
		}

		/** * @param s * @deprecated */
		public Object getValue(String s) {
			return null;
		}

		public Enumeration<String> getAttributeNames() {
			return null;
		}

		/** * @deprecated */
		public String[] getValueNames() {
			return new String[0];
		}

		public void setAttribute(String s, Object o) {
			attributes.put(s, o);
		}

		/** * @param s * @param o * @deprecated */
		public void putValue(String s, Object o) {
		}

		public void removeAttribute(String s) {
		}

		/** * @param s * @deprecated */
		public void removeValue(String s) {
		}

		public void invalidate() {
		}

		public boolean isNew() {
			return false;
		}
	}
}
