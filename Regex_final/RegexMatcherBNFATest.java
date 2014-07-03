import static org.junit.Assert.*;

import org.junit.Test;

public class RegexMatcherBNFATest {

	private void check(String regex, String text, int correctStartingPosition, String correctMatchedString){
		MatchingResult calculatedResult = RegexMatcherBNFA.match(regex, text);
		boolean c1 = (calculatedResult.getStartingPosition() == correctStartingPosition);
		boolean c2 = calculatedResult.getMatchedString().equals(correctMatchedString);
		assertTrue(c1 && c2);
	}
	
	@Test public void noMatch() {check("a", "b", -1, "");} // This means that your program should return a MatchingResultForBNFAEngine with startingPosition -1, if there is no match. 

	@Test public void t01() {check("a", "a", 0, "a");}
	@Test public void t02() {check("1", "1", 0, "1");}
	@Test public void t03() {check("b", "baa", 0, "b");}
	@Test public void t04() {check("b", "aba", 1, "b");}
	@Test public void t05() {check("b", "aab", 2, "b");}
	@Test public void t06() {check("ab", "baba", 1, "ab");}
	@Test public void t07() {check("(ab)a", "baba", 1, "aba");}
	@Test public void t08() {check("aba", "babab", 1, "aba");}
	@Test public void t09() {check("c", "a", -1, "");}
	
	@Test public void t10() {check("(ab)*", "cababc", 1, "abab");}
	@Test public void t11() {check("(ab)*", "cabababc", 1, "ababab");}
	@Test public void t12() {check("(ab)*", "cabababc", 1, "ababab");}
	@Test public void t13() {check("(ab)*c", "cabc", 0, "c");}
	@Test public void t14() {check("(ab)*c", "ababc", 0, "ababc");}
	
	@Test public void t15() {check("a|b", "a", 0, "a");}
	@Test public void t16() {check("a|b", "b", 0, "b");}
	@Test public void t17() {check("a|b|c", "c", 0, "c");}
	@Test public void t18() {check("(a|b)|c", "c", 0, "c");}
	@Test public void t19() {check("(ab|cd)", "kab", 1, "ab");}
	@Test public void t20() {check("(ab|cd)", "kcd", 1, "cd");}
	@Test public void t21() {check("(ab|cd)", "a", -1, "");}

	@Test public void t22() {check("(ab|cd)*", "zzababcdcdzz", 2, "ababcdcd");}
	@Test public void t23() {check("(ab|cd)*", "zzabcdabcdzz", 2, "abcdabcd");}
	@Test public void t24() {check("k(ab|cd)*", "zkabcdabcdmz", 1, "kabcdabcd");}
	@Test public void t25() {check("k(ab|cd)*m", "zkabcdabcdmz", 1, "kabcdabcdm");}
	
	@Test public void t26() {check("(ab|c*d)*", "zzzababcdccdabccccd", 3, "ababcdccdabccccd");}

	//New Tests (extended Syntax) DFA & BNFA

	@Test public void s01() {check("ab?c", "aabc", 1, "abc");}
	@Test public void s02() {check("ab?c", "aac", 1, "ac");}
	@Test public void s03() {check("a.c", "a1c", 0, "a1c");}
	@Test public void s04() {check("a.+a", "abracadabra", 0, "abracadabra");}
	@Test public void s05() {check("a.?a", "abracadabra", 3, "aca");}
	@Test public void s06() {check("a.?.?......a", "abracadabra", 0, "abracada");}
	@Test public void s07() {check("[HRTW]+", "RWTH", 0, "RWTH");}
	@Test public void s08() {check("(0|[123456789][0123456789]*)", "dieZahl1209finden", 7, "1209");}
	@Test public void s09() {check("(0|[123456789][0123456789]*)", "dieZahl04306finden", 7, "0");}
	@Test public void s10() {check("(ab?)+", "abaababbaabab", 0, "abaabab");}
	
	//New Tests (capturing groups) only BNFA

	@Test public void c01() {check("(a[br]+a).*\\{1}", "abracadabra", 0, "abracadabra");}
	@Test public void c02() {check("(.*)\\{1}+", "12121212123", 0, "12121212");}
	@Test public void c03() {check("(.+)(.+)\\{2}\\{1}", "abc123abcabc123123", 3, "123abcabc123");}
	@Test public void c04() {check("(.)(.)((.).?\\{4})?\\{2}\\{1}", "einrentneristeinpalindrom", 3, "rentner");}
	@Test public void c05() {check("(.)(.)((.).?\\{4})?\\{2}\\{1}", "auchannaisteinpalindrom", 4, "anna");}
	@Test public void c06() {check("(.+)(.+)(.+)(.+)\\{2}", "123452", 0, "123452");}
	@Test public void c07() {check("(.+)(.+)(.+)(.+)\\{2}", "123453", 0, "123453");}
	@Test public void c08() {check("(.+)(.+)(.+)(.+)\\{2}", "123454", -1, "");}
	
	//Capturing the last group
	@Test public void c09() {check("(..)+(\\{1})", "abcdefefgh", 0, "abcdefef");}
	@Test public void c10() {check("(.)*(\\{1})", "12331", 0, "1233");}
	@Test public void c11() {check("(.)(.)*(\\{2})(\\{1})", "123412234", 2, "341223");}


	//nested parentheses
	@Test public void c12() {check("(((1)2)3((4)(5)6)7)group.*\\{1}", "1234567group1234567", 0, "1234567group1234567");}
	@Test public void c13() {check("(((1)2)3((4)(5)6)7)group.*\\{2}", "1234567group1234567", 0, "1234567group12");}
	@Test public void c14() {check("(((1)2)3((4)(5)6)7)group.*\\{3}", "1234567group1234567", 0, "1234567group1");}
	@Test public void c15() {check("(((1)2)3((4)(5)6)7)group.*\\{4}", "1234567group1234567", 0, "1234567group123456");}
	@Test public void c16() {check("(((1)2)3((4)(5)6)7)group.*\\{5}", "1234567group1234567", 0, "1234567group1234");}
	@Test public void c17() {check("(((1)2)3((4)(5)6)7)group.*\\{6}", "1234567group1234567", 0, "1234567group12345");}
		
}











