import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    private String aNamedMatcherGroup = "(?<a>FIRST_TOKEN)";
    private String aMatcherGroup = "\\\\k<a>";
    private String bNamedMatcherGroup = "(?<b>.+)";
    private String bMatcherGroup = "\\\\k<b>";

    public boolean matches(String pattern, String value) {
        if (pattern.length() == 1) {
            return true;
        }

        String regex = pattern.replaceAll("a", aMatcherGroup).replaceAll("b", bMatcherGroup);
        regex = regex.replaceFirst(aMatcherGroup, aNamedMatcherGroup).replaceFirst(bMatcherGroup, bNamedMatcherGroup);
        System.out.println("Base Regex: " + regex);

        for (int i = 0; i < value.length(); i++) {
            String a = value.substring(0, i + 1);
            String regex2 = regex.replaceAll("FIRST_TOKEN", a);
            Pattern p = Pattern.compile(regex2);
            Matcher m = p.matcher(value);
            boolean checking = m.lookingAt();
            if (checking) {
                System.out.println("Matches! A is " + m.group(1) + " B is " + m.group(2));
                return checking;
            }
        }

        return false;
    }
}