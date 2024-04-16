package tn.esprit.pi2024.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BadWordDetectorService {

    private static final List<String> BAD_WORDS = Arrays.asList("test1", "test2", "test3", "test4", "test5", "test6");

    public String filterBadWords(String text) {
        for (String badWord : BAD_WORDS) {
            if (text.contains(badWord)) {

                text = text.replaceAll(badWord, "*".repeat(badWord.length()));
            }
        }
        return text;
    }
}
