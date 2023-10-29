package Finalexercise;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class engtomorsTest {
    engtomors engtomors = new engtomors();
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0', '.', ',', '?'};
    String[] code
            = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", ".-.-.-", "--..--", "..--..", "/"};
    @Test
    public void should_return_morseCode_forGiven_inputHasMultipleWords() {
        String ss = engtomors.englishToMorse(code, "test string", alphabet);
        assertEquals(ss,"- . ... - ; ... - .-. .. -. --. ");

    }

    @Test
    public void should_return_morseCode_forGivenWord() {
        String ss = engtomors.englishToMorse(code, "java", alphabet);
        assertEquals(ss,".--- .- ...- .- ");
    }

    @Test
    public void should_return_word_for_GivenMorseCode() {
        String ss = engtomors.morseToEnglish1(code, ".--- .- ...- .- ");
        assertEquals("java",ss);
    }
    @Test
    public void should_return_word_forGivenMorseCode() {
        String ss = engtomors.morseToEnglish1(code, "- . ... - ; ... - .-. .. -. --. ");
        assertEquals("test string",ss);
    }

    @Test
    public void should_throw_exception_when_inputIsNull() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> engtomors.englishToMorse(code, "", alphabet));
        assertEquals(runtimeException.getMessage(),"Invalid input");
    }

}

