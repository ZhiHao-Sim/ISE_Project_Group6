public class SeasonConverter {

    public static String HemisphereMatching(String inCountry) {
        
        inCountry = inCountry.trim().toLowerCase();
        if (inCountry.equals("usa") || inCountry.equals("canada") || inCountry.equals("china") || inCountry.equals("india") || inCountry.equals("germany")) {
            return "Northern Hemisphere";
        } else if (inCountry.equals("australia") || inCountry.equals("brazil") || inCountry.equals("indonesia") || inCountry.equals("south africa") || inCountry.equals("argentina")) {
            return "Southern Hemisphere";
        } else {
            return "Unknown Hemisphere";
        }
    }
}
