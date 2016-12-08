package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import beans.AppHelper;
import beans.Colours;
import beans.Result;

//Kontroler - obsluga formularzy
@Controller
public class StylesController {

    @GetMapping("styles")
    public String getMapping(Model model) {
        model.addAttribute("getColours", new Colours());
        return "styles";
    }

   
    @RequestMapping(value = "/getColours", method = RequestMethod.POST)
    @ResponseBody
    public String getColours(@ModelAttribute("getColours") Colours colours, HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setHeader("Content-Disposition", "attachment; filename=styl.css");  
    	return ResultPrinter.makeCSS(colours);
    }
    
    @RequestMapping(value = "/templateOne", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String templateOne(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	response.setHeader("Content-Disposition", "attachment; filename=styl.css");  
    	Colours colours = AppHelper.createTemplate1();
    	return ResultPrinter.makeCSS(colours);
    	
    }
    
    @RequestMapping(value = "/templateTwo", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String templateTwo(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	response.setHeader("Content-Disposition", "attachment; filename=styl.css");  
    	Colours colours = AppHelper.createTemplate2();
    	return ResultPrinter.makeCSS(colours);
    	
    }
    
    @RequestMapping(value = "/templateThree", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String templateThree(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	response.setHeader("Content-Disposition", "attachment; filename=styl.css");  
    	Colours colours = AppHelper.createTemplate3();
    	return ResultPrinter.makeCSS(colours);
    	
    }

    

}