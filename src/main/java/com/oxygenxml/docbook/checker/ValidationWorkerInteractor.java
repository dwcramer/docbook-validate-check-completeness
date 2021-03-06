package com.oxygenxml.docbook.checker;

/**
 * Interactor for validations worker.
 * @author intern4
 *
 */
public interface ValidationWorkerInteractor {
	/**
	 * Report progress of process.
	 * @param progressCounter The current progress counter.
	 * @param isFinalCycle <code>true</code> if is the final cycle of progress bar
	 */
	public void reportProgress(int progressCounter, boolean isFinalCycle);

	/**
	 * Report note at progress monitor.
	 * @param note The note in String format.
	 */
	public void reportNote(String element);

	/**
	 * Get the state of isCancelled flag(flag set true if this task was cancelled before it completed normally).
	 */
	public boolean isCancelled();
}
