public class TextAnalasys {
    private String originalText;
    private String text;
    public TextAnalasys(String text) {
        this.text = text;
        this.originalText = text;
    }
    private boolean isLetter(char inputCharacter) {
        final char brukbartTegn = Character.toLowerCase(inputCharacter);
        final int asciiValue = (int) brukbartTegn - 97;
        if (asciiValue >= 0 && asciiValue <= 26) return true;
        return (asciiValue == 132 || asciiValue == 133 || asciiValue == 151);
    }
    private int getWordLength(String word) {
        char[] splitWord = word.toCharArray(); 
        String wordWithOnlyLetters = "";
        for (char currentCharacter : splitWord) {
            if (isLetter(currentCharacter)) wordWithOnlyLetters += currentCharacter;
        }
        return wordWithOnlyLetters.length();
    }
    private int getTotalLengthOfAllWords() {
        String[] wordsArray = this.text.split("\\s+");
        int lengthOfAllWords = 0;
        for (String word : wordsArray) {
            lengthOfAllWords += getWordLength(word);
        }
        return lengthOfAllWords;
    }
    public int getWordCount() {
        String[] wordsArray = text.split("\\s+");
        return wordsArray.length;
    }
    public double getAverageWordLength() {
        int wordCount = getWordCount();
        int totalLengthOfAllWords = getTotalLengthOfAllWords();
        return (double) totalLengthOfAllWords / (double) wordCount;
    }
    public String replace(String targetWord, String replacementWord) {
        this.text = this.text.replaceAll(targetWord, replacementWord);
        return this.text;
    }
    public String getOriginalText() {
        return this.originalText;
    }
    public String getText() {
        return this.text;
    }
    public String getTextUpper() {
        return this.text.toUpperCase();
    }
}
