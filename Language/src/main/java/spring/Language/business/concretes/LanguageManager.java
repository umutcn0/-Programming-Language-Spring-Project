package spring.Language.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.Language.business.abstracts.LanguageService;
import spring.Language.business.requests.DeleteLanguage;
import spring.Language.business.requests.PutLanguage;
import spring.Language.business.responses.GetAllLanguages;
import spring.Language.dataAccess.abstracts.LanguageRepository;
import spring.Language.entities.Language;

@Service
public class LanguageManager implements LanguageService {
	LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguages> getAll() {
		
		List<Language> languages = this.languageRepository.findAll();
		List<GetAllLanguages> get_languages = new ArrayList<GetAllLanguages>();
		
		for (Language language : languages) {
			GetAllLanguages entity = new GetAllLanguages();
			entity.setLanguage(language.getLanguage());
			entity.setTechology(language.getTechology());
			get_languages.add(entity);
		}
		
		return get_languages;
	}

	@Override
	public void deleteLanguage(DeleteLanguage deleteLanguage) {
		
		List<Language> languages = this.languageRepository.findByLanguage(deleteLanguage.getLanguage());
		for (Language language : languages) {
			languageRepository.delete(language);
		}
	}

	@Override
	public void putLanguage(PutLanguage putLanguage) {
		Language language = new Language();
		language.setLanguage(putLanguage.getLanguage());
		language.setTechology(putLanguage.getTechology());
		languageRepository.save(language);
		
	}


}
