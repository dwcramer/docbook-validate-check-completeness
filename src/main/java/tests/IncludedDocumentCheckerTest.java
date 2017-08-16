package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.oxygenxml.ldocbookChecker.parser.Link;
import com.oxygenxml.ldocbookChecker.parser.LinkType;
import com.oxygenxml.ldocbookChecker.parser.LinksChecker;
import com.oxygenxml.ldocbookChecker.parser.LinksCheckerImp;
import com.oxygenxml.ldocbookChecker.parser.PlainParserCreator;

public class IncludedDocumentCheckerTest {
	@Test
	public void test() throws MalformedURLException {
		// Urls for testdb4 and test db5
		java.net.URL urlDb5 = new File("test-samples/xi-include/db5/sampleXInclude.xml").toURI().toURL();

		LinksChecker linkChecker = new LinksCheckerImp();

		// Problem reporters
		ProblemReporterImpl problemReporterDB5 = new ProblemReporterImpl();

		List<String> urls = new ArrayList<String>();
		urls.add(urlDb5.toString());
	  
		//start check
		linkChecker.check(new PlainParserCreator(), urls,  new PlainCheckerInteractorImpl(false, null), problemReporterDB5, new StatusReporterImpl(), new PlainWorkerReporter(),  new TranslatorImpl());

		// Sets with broken links.
		List<Link> brokenLinkDb5 = problemReporterDB5.getBrokenLinks();

		// Number of broken links
		assertEquals("Should be 4 broken links.", 4, brokenLinkDb5.size());

		Iterator<Link> iterDb5 = brokenLinkDb5.iterator();

		Link foundLinkDb5 = iterDb5.next();
		// first broken link
		assertEquals("http://www.xmdsadsal2.com/", foundLinkDb5.getRef());
		// link type
		assertEquals(LinkType.EXTERNAL, foundLinkDb5.getType());
		// Position of link
		assertEquals(9, foundLinkDb5.getLine());

		foundLinkDb5 = iterDb5.next();
		// second broken link
		assertEquals("1.png", foundLinkDb5.getRef());
		// link type
		assertEquals(LinkType.IMAGE, foundLinkDb5.getType());
		// Position of link
		assertEquals(5, foundLinkDb5.getLine());

	}
}
