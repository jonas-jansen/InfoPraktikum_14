import static org.junit.Assert.*;

import org.junit.Test;

public class RegexMatcherDFATest {

	private void check(String regex, String text, int correctStartingPosition, String correctMatchedString){
		MatchingResult calculatedResult = RegexMatcherDFA.match(regex, text);
		boolean c1 = (calculatedResult.getStartingPosition() == correctStartingPosition);
		boolean c2 = calculatedResult.getMatchedString().equals(correctMatchedString);
		assertTrue(c1 && c2);
	}
	
	@Test public void noMatch() {check("a", "b", -1, "");} // This means that your program should return a MatchingResultForDFAEngine with startingPosition -1, if there is no match. 

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
	
	@Test public void t27() {check("a.d", "zzbaddbczz", 3, "add");}
	@Test public void t28() {check("Wh.*y", "Why are you so greedy?", 0, "Why are you so greedy");}
	@Test public void t29() {check(".", "[#a-z]", 0, "[");}
	
	@Test public void t30() {check("(ab)+c", "cabc", 1, "abc");}
	@Test public void t31() {check("(ab)+c", "cacbac", -1, "");}
	@Test public void t32() {check("(ab)+", "cababc", 1, "abab");}
	@Test public void t33() {check("(ab)+", "cacabababa", 3, "ababab");}
	@Test public void t34() {check("c(ab+)+", "zabbcabbbbabaa", 4, "cabbbbab");}
	
	@Test public void t35() {check("a?", "ba", 1, "a");}
	@Test public void t36() {check("a?b", "bab", 0, "b");}
	@Test public void t37() {check("a?b", "caab", 2, "ab");}
	@Test public void t38() {check("(ab)?c", "cabc", 0, "c");}
	@Test public void t39() {check("(ab)?c", "dabc", 1, "abc");}
	
	@Test public void t40() {check("[ab]", "a", 0, "a");}
	@Test public void t41() {check("[ab]", "b", 0, "b");}
	@Test public void t42() {check("[xyz]", "ayxa", 1, "y");}
	@Test public void t43() {check("([ab]|c)", "c", 0, "c");}
	
	@Test public void t44() {check("([ab]?|c)+d", "daacbabcd", 0, "d");}
	@Test public void t45() {check("([ab]?|c)+d", "zzaacbabcd", 2, "aacbabcd");}
	@Test public void t46() {check("(ab?|ac)+ac", "ddacaacacf", 2, "acaacac");}
	@Test public void t47() {check("(a|abb)+b", "zzaaaabbaaabbbzz", 2, "aaaabbaaabbb");}
	@Test public void t48() {check("d((a.?d|c)*[gh])", "zzdacddadacdcchzz", 6, "dadacdcch");}
	@Test public void t49() {check("(((a|b)+)[ghA]...?c)", "zzabaabaAxyccz", 2, "abaabaAxycc");}
	@Test public void t50() {check("(ab?|c.d*)+", "zaabcxddacydddabz", 1, "aabcxddacydddab");}
	
	//	Write also your own unit tests here
	
}
