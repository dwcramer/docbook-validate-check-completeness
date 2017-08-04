package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.oxygenxml.docbookChecker.reporters.ProblemReporterImpl;
import com.oxygenxml.docbookChecker.reporters.StatusReporterImpl;
import com.oxygenxml.docbookChecker.CheckerInteractor;
import com.oxygenxml.docbookChecker.PlainCheckerInterctorImpl;
import com.oxygenxml.ldocbookChecker.parser.Link;
import com.oxygenxml.ldocbookChecker.parser.LinkType;
import com.oxygenxml.ldocbookChecker.parser.LinksChecker;
import com.oxygenxml.ldocbookChecker.parser.LinksCheckerImp;
import com.oxygenxml.ldocbookChecker.parser.PlainParserCreator;

public class ProfileCondistions3Test {

	@Test
	public void test() throws MalformedURLException {
		// Urls for testdb4
		java.net.URL urlDb4 = new File("test-samples/condition-links/testdb4.xml").toURI().toURL();

		LinksChecker linkChecker = new LinksCheckerImp();

		// Problem reporters
		ProblemReporterImpl problemReporterDB4 = new ProblemReporterImpl();

		//profile conditions 
		Map<String, Set<String>> toAdd = new HashMap<String, Set<String>>();
		Set<String> value = new HashSet<String>();
		value.add("windows");
		toAdd.put("os", value);

		value = new HashSet<String>();
		value.add("i386");
		toAdd.put("arch", value);

		// start check
		linkChecker.check(new PlainParserCreator(), urlDb4.toString(), new PlainCheckerInterctorImpl(true, toAdd), problemReporterDB4,
				new StatusReporterImpl());

		// Sets with broken links.
		List<Link> brokenLinkDb4 = problemReporterDB4.getBrokenLinks();

		// Number of broken links.
		assertEquals("Should be one broken links.", 1, brokenLinkDb4.size());

		Iterator<Link> iterDb4 = brokenLinkDb4.iterator();
		Link foundLinkDb4 = iterDb4.next();

		// First broken link founded
		assertEquals("mypara", foundLinkDb4.getRef());

		// Link type
		assertEquals(LinkType.INTERNAL, foundLinkDb4.getType());

		// Position of link
		assertEquals(21, foundLinkDb4.getLine());

	}

}