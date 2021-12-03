package hackerrank;

public class DrawingBook {
    public static int pageCount(int numberPages, int pageWanted) {
        int sheets = (int)Math.ceil(((double)numberPages-1)/2)+1;
        int pageInSheet = (pageWanted/2)+1;

        return (sheets-pageInSheet) <= (pageInSheet-1) ? sheets-pageInSheet : pageInSheet-1;
    }
}
