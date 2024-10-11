public class NyString {
    private String tekst;
    public NyString(String tekst) {
        this.tekst = tekst;
    }
    public String skaffForkortetTekst() {
        String[] splittetTekst = tekst.split(" ");
        String forkortetTekst = "";
        for (String subTekst : splittetTekst) {
            forkortetTekst += subTekst.charAt(0);
        }
        return forkortetTekst;
    }
    public String fjernTegn(char tegn) {
        char[] splittetTekst = tekst.toCharArray(); 
        String utTekstMedFjerning = "";
        for (char nåværendeBokstav : splittetTekst) {
            if (tegn != nåværendeBokstav) utTekstMedFjerning += nåværendeBokstav;
        }
        return utTekstMedFjerning;
    }
}
