package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class MavenTest {
    public static <tring> void main(String[] args) throws IOException {
        tring asciiArt = (tring) FigletFont.convertOneLine("Agnese Antonova");
        System.out.println(asciiArt);

    }
}
