package Project;
  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;
/*@Controller*/
public class ProjectController {
/*	@RequestMapping("/Project")*/
	public ModelAndView helloWorld() {
		String msg = "Hello World";
		return new ModelAndView("welcomePage","welcomeMsg",msg);
	}
	
	
}
