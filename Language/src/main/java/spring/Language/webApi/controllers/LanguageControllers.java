package spring.Language.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.Language.business.abstracts.LanguageService;
import spring.Language.business.requests.DeleteLanguage;
import spring.Language.business.requests.PutLanguage;
import spring.Language.business.responses.GetAllLanguages;

@RestController //annotation
@RequestMapping("/api/language")
public class LanguageControllers {
	LanguageService languageService;

	public LanguageControllers(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("getAllLanguages")
	public List<GetAllLanguages> getAll(){
		return languageService.getAll();
	}
	
	@DeleteMapping("deleteLanguage")
	public void deleteLanguage(String language) {
		languageService.deleteLanguage(new DeleteLanguage(language));
		
	}
	
	@PutMapping("addLanguage")
	public void putLanguage(String language, String technology) {
		languageService.putLanguage(new PutLanguage(language, technology));
	}
	
}
