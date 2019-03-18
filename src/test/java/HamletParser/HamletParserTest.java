package HamletParser;

import HamletParser.HamletParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HamletParserTest {
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        String testText = "word <Horatio> word (Hamlet> 3245 word !Horatio0987 word Hamlet!\n" +
                "*&^Horatio^%$&Hamlet*)&%(**&hora084hamlet08974horatio097.";
        this.hamletParser = new HamletParser(testText);
    }

    @Test
    public void testChangeHamletToLeon() {
        // Given
        String expectedHamletData = "word <Horatio> word (Leon> 3245 word !Horatio0987 word Leon!\n" +
                "*&^Horatio^%$&Leon*)&%(**&hora084hamlet08974horatio097.";

        // When
        hamletParser.replaceHamletWithLeon();

        // Then
        String actualHamletData = hamletParser.getHamletData();
        Assert.assertEquals(expectedHamletData, actualHamletData);
    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        String expectedHamletData = "word <Tariq> word (Hamlet> 3245 word !Tariq0987 word Hamlet!\n" +
                "*&^Tariq^%$&Hamlet*)&%(**&hora084hamlet08974horatio097.";

        // When
        hamletParser.replaceHoratioWithTariq();

        // Then
        String actualHamletData = hamletParser.getHamletData();
        Assert.assertEquals(expectedHamletData, actualHamletData);
    }

    @Test
    public void testFindHoratio() {
        // Given
        Integer expectedIndex = 6;

        // When
        Integer actualIndex = hamletParser.findHoratio();

        // Then
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testFindHamlet() {
        // Given
        Integer expectedIndex = 21;

        // When
        Integer actualIndex = hamletParser.findHamlet();

        // Then
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testHamletParser1() {
        // Given
        HamletParser hamletParser = new HamletParser();
        Integer expectedIndex = 15;

        // When
        Integer actualIndex = hamletParser.findHamlet();

        // Then
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testHamletParser2() {
        // Given
        HamletParser hamletParser = new HamletParser();
        Integer expectedIndex = 624;

        // When
        Integer actualIndex = hamletParser.findHoratio();

        // Then
        Assert.assertEquals(expectedIndex, actualIndex);
    }
}