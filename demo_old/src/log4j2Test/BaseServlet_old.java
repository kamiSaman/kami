//package log4j2Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.StringReader;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.xml.XMLConstants;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.stream.StreamSource;
//import javax.xml.validation.Schema;
//import javax.xml.validation.SchemaFactory;
//import javax.xml.validation.Validator;
//
//import org.apache.commons.codec.binary.Base64;
//import org.apache.log4j.Logger;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.xml.sax.InputSource;
//
//
//
///**
// * 基底サーブレット
// */
//public class BaseServlet_old extends HttpServlet {
//
//    String defaultContentType = "text/html";
//    private Logger logger = Logger.getLogger(BaseServlet_old.class);
//    private String propLog4j = null;
//    private String propFile = null;
//    private Properties props = new Properties();
//
//
//    public static void main(String[] args) {
////    	logger.debug("start (class=" + getClass().toString() + ")");
////        super.init(config);
////        ServletContext context = getServletContext();
////        this.propLog4j = context.getRealPath("/")
////                + "WEB-INF/conf/ngn-web.log4j.properties";
////        this.propFile = context.getRealPath("/WEB-INF/conf/ngn-web.properties");
////
////        if ((new java.io.File(this.propLog4j)).exists() == false) {
////            this.logger.warn("log4j properties file not found (file="
////                    + this.propLog4j + ") ... skip");
////        } else {
////            org.apache.log4j.PropertyConfigurator.configure(this.propLog4j);
////        }
////        if ((new java.io.File(this.propFile)).exists() == false) {
////            this.logger.warn("system properties file not found (file="
////                    + this.propFile + ") ... skip");
////        } else {
////            this.reloadProperties(this.propFile);
////        }
////        logger.debug("done");
//	}
//    
//    
//    
//    
// }
