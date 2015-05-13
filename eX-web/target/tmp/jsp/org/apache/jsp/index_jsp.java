package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <title>SuperHero Wiki</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("  <link href=\"css/eX.css\" rel=\"stylesheet\"/>\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("  <script src=\"//ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular.js\"></script>\n");
      out.write("  <script src=\"//ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular-route.js\"></script>\n");
      out.write("  <script src=\"//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.0.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- bootstrapping -->\n");
      out.write("  <script src=\"eX/eXApp.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Modules -->\n");
      out.write("  <script src=\"eX/core/service/service.module.js\"></script>\n");
      out.write("  <script src=\"eX/core/routing/route.module.js\"></script>\n");
      out.write("  <script src=\"eX/core/directive/directive.module.js\"></script>\n");
      out.write("  <script src=\"eX/core/core.module.js\"></script>\n");
      out.write("  <script src=\"eX/team/team.module.js\"></script>\n");
      out.write("  <script src=\"eX/heroes/heroes.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!-- Controllers -->\n");
      out.write("  <script src=\"eX/heroes/hero.js\"></script>\n");
      out.write("  <script src=\"eX/team/team.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Services -->\n");
      out.write("  <script src=\"eX/core/service/service.js\"></script>\n");
      out.write("  <script src=\"eX/core/routing/route.js\"></script>\n");
      out.write("  <script src=\"eX/core/directive/directive.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    var contextPath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<div id=\"mainmenu\">\n");
      out.write("    <img id=\"banner\" src=\"images/banner.jpg\" alt=\"Banner Image\"/>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<body ng-app=\"app\" >\n");
      out.write("\n");
      out.write("<div id=\"cointainer\">\n");
      out.write("  <nav class=\"navbar navbar-default\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("      <div class=\"navbar-header\">\n");
      out.write("        <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("          <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("          <span class=\"icon-bar\"></span>\n");
      out.write("          <span class=\"icon-bar\"></span>\n");
      out.write("          <span class=\"icon-bar\"></span>\n");
      out.write("        </button>\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">Home</a>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("        <ul class=\"nav navbar-nav\">\n");
      out.write("          <li class=\"active\"><a href=\"#hero\">Heroes</a></li>\n");
      out.write("          <li><a href=\"#team\">Teams</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <form class=\"navbar-form navbar-left\" role=\"search\">\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\n");
      out.write("          </div>\n");
      out.write("          <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </nav>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("  <div ng-view >\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}