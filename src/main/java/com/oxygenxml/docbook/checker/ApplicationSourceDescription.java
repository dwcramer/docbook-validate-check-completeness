package com.oxygenxml.docbook.checker;

import java.util.ArrayList;
import java.util.List;

/**
 * Description of source of action that open the checker dialog.
 * 
 * @author intern4
 *
 */
public class ApplicationSourceDescription {
	
	/**
	 * Type of source.
	 * @author intern4
	 *
	 */
	public enum Source {
		CONTEXTUAL, TOOLBAR, PROJECT_MANAGER
	}
	
	/**
	 * Source of action that start the validation. It can be CONTEXTUAL, TOOLBAR
	 * OR PROJECT_MANAGER
	 */
	private Source source;

	/**
	 * The URL of current file opened in Oxygen
	 */
	private String currentUrl;

	/**
	 * The URLs of selected files in project manager.
	 */
	private List<String> selectedFilesInProject = new ArrayList<String>();

	/**
	 * Getter for source of action that start the validation
	 * @return The source of action
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * Set the source of action.
	 * @param source	The source
	 */
	public void setSource(Source source) {
		this.source = source;
	}

	/**
	 * Get the selected files in project.
	 * @return	List with URLs of file in String format.
	 */
	public List<String> getSelectedFilesInProject() {
		return selectedFilesInProject;
	}

	/**
	 * Set the selected files in project.
	 * @param urls List of URLs in String format to be set. 
	 */
	public void setSelectedFilesInProject(List<String> urls) {
		this.selectedFilesInProject = urls;
	}

	/**
	 * Get the current URL 
	 * @return The current URL in String format.
	 */
	public String getCurrentUrl() {
		return currentUrl;
	}

	/**
	 * Set the current URL
	 * @param currentUrl The current URL in String format .
	 */
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	
}