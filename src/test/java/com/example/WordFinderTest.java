package com.example;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Set;

import org.junit.Test;

public class WordFinderTest {

    @Test
    public void testFindEnglishWordsInString() {
        Dictionary mockDictionary = mock(Dictionary.class);
        when(mockDictionary.isEnglishWord("WORK")).thenReturn(true);
        when(mockDictionary.isEnglishWord("KING")).thenReturn(true);
        when(mockDictionary.isEnglishWord("ROW")).thenReturn(true);
        when(mockDictionary.isEnglishWord("KNOW")).thenReturn(true);
        when(mockDictionary.isEnglishWord("GIN")).thenReturn(true);

        WordFinder wordFinder = new WordFinder(mockDictionary);
        String input = "WORKING";

        Set<String> result = wordFinder.findEnglishWordsInString(input);

        assertEquals(5, result.size());
        System.out.println(result);
        assertTrue(result.contains("WORK"));
        assertTrue(result.contains("KING"));
        assertTrue(result.contains("ROW"));
        assertTrue(result.contains("KNOW"));
        assertTrue(result.contains("GIN"));
    }

}
