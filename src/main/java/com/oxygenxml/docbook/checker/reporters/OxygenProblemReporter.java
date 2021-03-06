package com.oxygenxml.docbook.checker.reporters;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.oxygenxml.docbook.checker.parser.ConditionDetails;
import com.oxygenxml.docbook.checker.parser.Link;

import ro.sync.document.DocumentPositionedInfo;
import ro.sync.exml.workspace.api.PluginWorkspaceProvider;
import ro.sync.exml.workspace.api.results.ResultsManager;
import ro.sync.exml.workspace.api.results.ResultsManager.ResultType;

/**
 * Report broken link and exception in oxygen using Result Manager
 * 
 * @author intern4
 *
 */
public class OxygenProblemReporter implements ProblemReporter {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger.getLogger(OxygenProblemReporter.class);
	 
	/**
	 * Result manager.
	 */
	private ResultsManager resultManager = PluginWorkspaceProvider.getPluginWorkspace().getResultsManager();

	/**
	 * Report the brokenLink using resultManager.
	 * 
	 */
	@Override
	public void reportBrokenLinks(final Link brokenLink , final Exception ex, final String tabKey) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					// informations that will be added
					DocumentPositionedInfo result = new DocumentPositionedInfo(DocumentPositionedInfo.SEVERITY_WARN,
							ex.getMessage(), brokenLink.getLinkFoundDocumentUrl(), brokenLink.getLine(),
							brokenLink.getColumn());

					// add broken links in given tabKey
					resultManager.addResult(tabKey, result, ResultType.PROBLEM, true, true);

				}
			});
		} catch (InvocationTargetException e) {
			logger.debug(e.getMessage(), e);
		} catch (InterruptedException e) {
			logger.debug(e.getMessage(), e);
		}
	}

	/**
	 * Report the exception using resultManager.
	 */
	@Override
	public void reportException(final Exception ex, final String tabKey, final String document) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					DocumentPositionedInfo result = new DocumentPositionedInfo(DocumentPositionedInfo.SEVERITY_ERROR,
							ex.getMessage(), document);
					resultManager.addResult(tabKey, result, ResultType.PROBLEM, true, true);

				}
			});
		} catch (InvocationTargetException e) {
				logger.debug(e.getMessage(), e);
		} catch (InterruptedException e) {
			logger.debug(e.getMessage(), e);
		}
	}

	/**
	 * Clear the problems reported in given tabKey.
	 * @param tabKey The tabKey.
	 */
	@Override
	public void clearReportedProblems(final String tabKey) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					List<DocumentPositionedInfo> resultsList = resultManager.getAllResults(tabKey);
					int size = resultsList.size();
					for (int i = size - 1; i >= 0; i--) {
						resultManager.removeResult(tabKey, resultsList.get(i));
					}
				}
			});
		} catch (InvocationTargetException e) {
			logger.debug(e.getMessage(), e);
		} catch (InterruptedException e) {
			logger.debug(e.getMessage(), e);
		}
	}

	/**
	 * Report the undefined conditions using resultManager.
	 */
	@Override
	public void reportUndefinedConditions(final ConditionDetails conditionDetails, final String tabKey) {
		final String message = "Profile condition: \"" + conditionDetails.getAttribute() + " : " + conditionDetails.getValue() 
		+ "\" isn't defined in preferences .";
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					DocumentPositionedInfo result = new DocumentPositionedInfo(DocumentPositionedInfo.SEVERITY_WARN, message, 
							conditionDetails.getDocumentUrl(), conditionDetails.getLine(), conditionDetails.getColumn());
					resultManager.addResult(tabKey, result, ResultType.PROBLEM, true, true);
				}
			});
		} catch (InvocationTargetException e) {
				logger.debug(e.getMessage(), e);
		} catch (InterruptedException e) {
				logger.debug(e.getMessage(), e);
		}
	}
}
