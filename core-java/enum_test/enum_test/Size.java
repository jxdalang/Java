package enum_test;

public enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbr;

    private Size(String abbr) {
        this.abbr = abbr;
    }

    // get abbreviation
    public String getAbbr() {
        return abbr;
    }

}
