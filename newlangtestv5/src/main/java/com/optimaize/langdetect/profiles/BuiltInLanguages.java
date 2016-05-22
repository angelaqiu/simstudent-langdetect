package com.optimaize.langdetect.profiles;

import com.google.common.collect.ImmutableList;
import com.optimaize.langdetect.i18n.LdLocale;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicole Torres
 */
public class BuiltInLanguages {

    private static final List<LdLocale> languages;
    private static final List<String> shortTextLanguages;

    static {
        List<LdLocale> names = new ArrayList<>();

        //sorted alphabetically
        
        names.add(LdLocale.fromString("en"));
        names.add(LdLocale.fromString("tl"));

        languages = ImmutableList.copyOf(names);
    }

    static {
        List<String> texts = new ArrayList<>();
        texts.add("en");
        shortTextLanguages = ImmutableList.copyOf(texts);
    }

    /**
     * @return immutable
     */
    public static List<LdLocale> getLanguages() {
        return languages;
    }
    /**
     * @return immutable
     */
    public static List<String> getShortTextLanguages() {
        return shortTextLanguages;
    }
}