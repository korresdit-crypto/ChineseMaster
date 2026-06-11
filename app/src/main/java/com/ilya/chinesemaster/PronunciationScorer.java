package com.ilya.chinesemaster;

import java.text.Normalizer;
import java.util.Locale;

public class PronunciationScorer {
    public static int scoreRadical(int radicalNumber, String recognizedText) {
        if (!RadicalPronunciationBank.isRadicalNumber(radicalNumber)) return 0;
        if (recognizedText == null) return 0;
        String expectedSymbol = RadicalPronunciationBank.symbol(radicalNumber);
        String expectedPinyin = RadicalPronunciationBank.pinyin(radicalNumber);
        return score(expectedSymbol, expectedPinyin, recognizedText);
    }

    public static int score(String expectedSymbol, String expectedPinyin, String recognizedText) {
        String heard = recognizedText == null ? "" : recognizedText.trim();
        if (heard.length() == 0) return 0;
        if (expectedSymbol != null && expectedSymbol.length() > 0 && heard.contains(expectedSymbol)) return 100;
        String hp = normalizePinyin(heard);
        String ep = normalizePinyin(expectedPinyin);
        if (hp.equals(ep)) return 95;
        if (hp.contains(ep) || ep.contains(hp)) return 75;
        return 35;
    }

    public static String normalizePinyin(String s) {
        if (s == null) return "";
        String x = s.toLowerCase(Locale.ROOT).trim();
        x = Normalizer.normalize(x, Normalizer.Form.NFD);
        x = x.replaceAll("\\p{M}", "");
        x = x.replace("ü", "v");
        x = x.replace("u:", "v");
        x = x.replaceAll("[^a-z0-9]", "");
        return x;
    }
}
