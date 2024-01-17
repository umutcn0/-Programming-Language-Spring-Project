package spring.Language.business.abstracts;

import java.util.List;

import spring.Language.business.requests.DeleteLanguage;
import spring.Language.business.requests.PutLanguage;
import spring.Language.business.responses.GetAllLanguages;

public interface LanguageService {
	List<GetAllLanguages> getAll();
	void deleteLanguage(DeleteLanguage deleteLanguage);
	void putLanguage(PutLanguage putLanguage);

}
