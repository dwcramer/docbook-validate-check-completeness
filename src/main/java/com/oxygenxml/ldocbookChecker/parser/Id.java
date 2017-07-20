package com.oxygenxml.ldocbookChecker.parser;

import java.net.MalformedURLException;
import java.net.URL;

public class Id {
	

	/**
	 * The id founded.
	 */
	private String id;

	/**
	 * The URL of the parsed document.
	 */
	private URL documentUrl;

	/**
	 * Location(line) of the id.
	 */
	private int line;

	/**
	 * Location(column) of the id.
	 */
	private int column;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param documentUrl
	 * @param line
	 * @param column
	 */
	public Id(String id, URL documentUrl, int line, int column) {
		this.id = id;
		this.documentUrl = documentUrl;
		this.line = line;
		this.column = column;
	}

	// Getters
	public String getId() {
		return id;
	}

	public URL getDocumentURL() {
		return documentUrl;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	
	/**
	 * Get absolute location
	 * @return the url
	 */
	public URL getAbsoluteLocation() {
		URL toReturn = null;
		
		try {
			toReturn = new URL(id);
		} catch (MalformedURLException e) {
			
			try {
					toReturn = new URL(documentUrl, id);
			} catch (MalformedURLException e2) {
				//return null
			}
		}
		return toReturn;
	}
	
	
	@Override
	public String toString() {
		return "Id [id=" + id + ", documentUrl=" + documentUrl + ", line=" + line + ", column=" + column + "]";
	}


}
