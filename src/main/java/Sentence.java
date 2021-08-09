public class Sentence {
    private final String word;
    private final int wordCount;

    public Sentence(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }


    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.wordCount;
    }


}
