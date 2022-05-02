package colamonico.spingboot.calculator;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}


	@RestController
	public class Calcolatrice {
		
		@GetMapping("/") //this mapping redirect all '/' request to '/add'
		public void redirect(HttpServletResponse response) throws IOException {
			response.sendRedirect("/add");
		}
		

		@GetMapping("/add")
		@ResponseBody
		public String addizione(@RequestParam(value ="n1", defaultValue="0") double n1, @RequestParam(value="n2",defaultValue="0")double n2 ){
			double risultato = n1+n2;
			String response = "Il risultato dell'addizione è pari a " + risultato;
			return response;
		}
		
		
		@GetMapping("/sub")
		@ResponseBody
		public String sottrazione(@RequestParam(value ="n1", defaultValue="0") double n1, @RequestParam(value="n2",defaultValue="0")double n2 ){
			double risultato = n1-n2;
			String response = "Il risultato della sottrazione è pari a " + risultato;
			return response;
		}
		
		@GetMapping("/mol")
		@ResponseBody
		public String moltiplicazione(@RequestParam(value ="n1", defaultValue="0") double n1, @RequestParam(value="n2",defaultValue="0")double n2 ){
			double risultato = n1*n2;
			String response = "Il risultato della moltiplicazione è pari a " + risultato;
			return response;
		}
		
		@GetMapping("/div")
		@ResponseBody
		public String divisione(@RequestParam(value ="n1", defaultValue="1") double n1, @RequestParam(value="n2",defaultValue="1")double n2 ){
			double risultato = n1/n2;
			String response = "Il risultato della divisione è pari a " + risultato;
			return response;
		}
		

	}
}