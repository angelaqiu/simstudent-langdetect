package langtestv5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.optimaize.langdetect.DetectedLanguage;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;

public class Test {
	public static void main (String [] args) throws IOException
	{
		//load all languages:
//		List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
		List<LdLocale> languages;
		List<LdLocale> names = new ArrayList<>();
		names.add(LdLocale.fromString("en"));
		names.add(LdLocale.fromString("tl"));
		languages = ImmutableList.copyOf(names);
		List<LanguageProfile> languageProfiles = new LanguageProfileReader().readBuiltIn(languages);

		//build language detector:
		LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
		        .withProfiles(languageProfiles)
		        .build();

		//create a text object factory
		TextObjectFactory textObjectFactory = CommonTextObjectFactories.forDetectingShortCleanText();

		//query:
		TextObject textObject = textObjectFactory.forText("basta");
//		Optional<LdLocale> lang = languageDetector.detect(textObject);
		List<DetectedLanguage> lang = languageDetector.getProbabilities(textObject);
		System.out.println(lang.toString());
	}

}
