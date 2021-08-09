import java.util.*;

public class WordFrequencyGame {

    public static final String BLANK_SPACE = "\\s+";

    public String getResult(String sentence) {
        

        if (sentence.split(BLANK_SPACE).length == 1) {
            return sentence + " 1";
        } else {

            try {

                List<Sentence> wordInfos = getWordInfo(sentence);

                wordInfos.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (Sentence word : wordInfos) {
                    String s = word.getWord() + " " + word.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }

    private List<Sentence> getWordInfo(String sentence) {
        //split the input string with 1 to n pieces of spaces
        String[] words = sentence.split(BLANK_SPACE);

        List<Sentence> sentenceList = new ArrayList<>();
        for (String word : words) {
            Sentence input = new Sentence(word, 1);
            sentenceList.add(input);
        }

        //get the map for the next step of sizing the same word
        Map<String, List<Sentence>> map = getListMap(sentenceList);

        List<Sentence> list = new ArrayList<>();
        for (Map.Entry<String, List<Sentence>> entry : map.entrySet()) {
            Sentence input = new Sentence(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        sentenceList = list;
        return sentenceList;
    }


    private Map<String, List<Sentence>> getListMap(List<Sentence> sentenceList) {
        Map<String, List<Sentence>> map = new HashMap<>();
        for (Sentence sentence : sentenceList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(sentence.getWord())) {
                ArrayList arr = new ArrayList<>();
                arr.add(sentence);
                map.put(sentence.getWord(), arr);
            } else {
                map.get(sentence.getWord()).add(sentence);
            }
        }


        return map;
    }


}
