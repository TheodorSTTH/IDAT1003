public class App {
    public static void task1() {
        NyString minTekst = new NyString("Heii hva skjeraa?");
        System.out.println(minTekst.skaffForkortetTekst());
        System.out.println(minTekst.fjernTegn('a'));
    }
    public static void task2() {
        final TextAnalasys myTextAnalasys = new TextAnalasys("Hei brur hva skjæra? Åhh. Jeg elsker mat. Gjør du også det med mat?");
        System.out.println("Word count: " + myTextAnalasys.getWordCount());
        System.out.println("Average word length is: " + ((double) Math.round(myTextAnalasys.getAverageWordLength() * 100)) / 100);
        System.out.println("Replace mat with salat: " + myTextAnalasys.replace("mat", "salat"));
        System.out.println("Original Text: " + myTextAnalasys.getOriginalText());
        System.out.println("New text: " + myTextAnalasys.getText());
        System.out.println("New text uppercase: " + myTextAnalasys.getTextUpper());
    }
    public static void main(String[] args) throws Exception {
        task1();
        // task2();
    }
}
