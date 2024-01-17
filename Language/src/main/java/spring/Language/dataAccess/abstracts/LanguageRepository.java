package spring.Language.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.Language.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	List<Language> findByLanguage(String language);
}
