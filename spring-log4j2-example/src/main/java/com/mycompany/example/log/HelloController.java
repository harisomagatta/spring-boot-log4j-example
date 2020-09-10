/**
 * 
 */
package com.mycompany.example.log;

/**
 * @author Hari Somagatta
 *
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

	private static final Logger logger = LogManager.getLogger(HelloController.class);

	private List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

	@GetMapping("/myMethod")
	public String myMethod(Model model) {

		// pre-java 8
		if (logger.isDebugEnabled()) {
			logger.debug("Hello from Log4j 2 - num : {}", num);
		}

		// java 8 lambda, no need to check log level
		logger.debug("Hello from Log4j 2 - num : {}", () -> num);

		model.addAttribute("tasks", num);
		return "welcome"; // view
	}
	
	@GetMapping("/")
	public String method(Model model) {

				// java 8 lambda, no need to check log level
		logger.debug("Hello from Log4j 2 - num : {}", () -> num);

		model.addAttribute("tasks", num);
		return "welcome2"; // view
	}

	private int getNum() {
		return 100;
	}

}