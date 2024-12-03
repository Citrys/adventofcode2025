package venti.org.day3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdDayTests {
    ThirdDay day3 = new ThirdDay();
    @Test
    public void testSomeData() {
        String text = "!mul(417,528)why();what()?how()from()who()where() ~mul(215,18){} ])/from()*do(),)* ##select()mul(89,59):*select(805,600)*mul(709,138)-!how()$+*why(747,290)>mul(548,826)^@-^%@,@mul(103,952)^why():mul(322,877)select()+who()%?[mul(378,598)<;[&(-*' mul(695,169)??where()mul(12,677){$?:(}*why()mul(911,924) *+/select()*/?,from(952,471)mul(12,238)<why()#<: mul(17,995)+:]mul(619,259)+$,#(mul(477,46)?-why())(?''mul(471,687)why()%why()select()mul(683,261)select()+&how()!mul(59,43);!}from()}^what()<mul(396,135)when()mul(593,130);[/mul(189,802)-where())how()where()%mul(315,986)&$?]::who()+who()mul(408,692)mul(547,681)~}mul(748,448)mul(686,701)#^*:,mul(14,551)who()who(899,635))/!from()mul(405,549)how()";
        int ans = day3.getSumOfNumbersMultiplication(text);
        Assertions.assertEquals(ans, 5353645);
    }

    @Test
    public void testSomeDataFRomFile() {
        int ans = day3.processInputFile("src/main/resources/day3.txt");
        Assertions.assertEquals(ans, 188116424);
    }

    @Test
    public void testSomeDataDoDont() {
        String text = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        long ans = day3.getSumOfNumbersMultiplicationWithDoAndDont(text);
        Assertions.assertEquals(ans, 48);
    }

    @Test
    public void testSomeDataDoDontFile() {
        int ans = day3.processInputFileDoDont("src/main/resources/day3.txt");
        Assertions.assertEquals(ans, 104245808);
    }
}
