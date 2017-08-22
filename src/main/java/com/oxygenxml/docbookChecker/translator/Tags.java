package com.oxygenxml.docbookChecker.translator;

/**
 * Tags used for persistence and internationalization.
 * @author intern4
 *
 */
public interface Tags {
	/**
	 * Title of checker frame
	 */
	public final String FRAME_TITLE = "Frame_Title";
	
	/**
	 * Label for choose files for check 
	 */
	public final String SELECT_FILES_LABEL_KEY = "Select_Files_Label";
	/**
	 * Radio button for check current file.
	 */
	public final String CHECK_CURRENT_FILE_KEY = "Check_Current_File_Key";
	/**
	 * Radio button for check other files
	 */
	public final String CHECK_OTHER_FILES_KEY = "Check_Other_Files_Key";
	
	/**
	 * CheckBox for use profiling conditions for check;
	 */
	public final String USE_PROFLING_CBOX = "Use_Profiling_Check_Box";
	
	/**
	 * Check button for check external links.
	 */
	public final String CHECK_EXTERNAL_KEY = "Check_External_Key";
	/**
	 * Check button for check images.
	 */
	public final String CHECK_IMAGES_KEY = "Check_Images_Key";
	/**
	 * Check button for check internal links.
	 */
	public final String CHECK_INTERNAL_KEY = "Check_Internal_Key";
	
	
	/**
	 * Head of files table.
	 */
	public final String FILES_TABLE_HEAD = "Files_Tabel_Head";
	/**
	 * Head of conditions table.
	 */
	public final String CONDTIONS_TABLE_HEAD = "Conditions_Tabel_Head";
	/**
	 * Head of Sets table.
	 */
	public final String SETS_TABLE_HEAD = "Sets_Tabel_Head";
	/**
	 * Add button of table.
	 */
	public final String ADD_TABLE = "Add_Table_Button"; 
	
	/**
	 * Edit button of table
	 */
	public final String EDIT_TABLE = "Edit_Table_Button";
	
	/**
	 * Remove button of table
	 */
	public final String REMOVE_TABLE = "Remove_Table_Button";
	/**
	 * Get button for conditions table;
	 */
	public final String GET_TABLE = "Get_Table_Button";
	
	/**
	 * Radio button for configure a conditions set.
	 */
	public final String CONFIG_CONDITIONS_SET = "Configure_Conditions_Set";
	
	/**
	 * Radio button for choose a conditions set.
	 */
	public final String CHOOSE_CONDITIONS_SET = "Choose_Conditions_Set";
	
	/**
	 * Radio button check using all available conditions set.
	 */
	public final String ALL_CONDITIONS_SET = "All_Conditions_Set";
	
	/**
	 * Title of get file conditions dialog;
	 */
	public final String FILE_CONDITIONS_DIALOG_TITLE = "File_Conditions_Dialog_Title";
	
	/**
	 * Check button of checker frame
	 */
	public final String CHECK_BUTTON = "Check_Button";
	/**
	 * Cancel button of checker frame
	 */
	public final String CANCEL_BUTTON = "Cancel_Button";
	
	/**
	 * Message displayed when table is empty and check button is pressed.
	 */
	public final String EMPTY_TABLE = "Empty_Table_Message";
	
	/**
	 * Title for file chooser used to add url in tableFiles
	 */
	public final String FILE_CHOOSER_TITLE = "File_Chooser_Title";
	/**
	 * Action button in file chooser.
	 */
	public final String FILE_CHOOSER_BUTTON = "File_Chooser_Button";
	
	/**
	 * Add button in dialog
	 */
	public final String ADD_BUTTON_IN_DIALOGS = "Add_Button_Dialog";
	
	/**
	 * Tag for file table rows.
	 */
	public final String FILE_TABLE_ROWS = "File_Table_Rows";

	/**
	 * Tag for conditions table rows.
	 */
	public final String CONDITIONS_TABLE_ROWS = "Conditions_Table_Rows";

	/**
	 * Reported progress status. 
	 */
	public final String PROGRESS_STATUS = "Progress_Status"; 
	
	/**
	 * Reported fail status.
	 */
	public final String FAIL_STATUS = "Fail_Status";
	
	/**
	 * Reported success status.
	 */
	public final String SUCCESS_STATUS = "Success_Status";

	/**
	 * Title for configure conditions dialog(Dialog for add/edit conditions in conditions table).
	 */
	public final String CONFIGURE_CONDITIONS_DIALOG_TITLE = "Configure_Conditions_Dialog_Title";
	
	/**
	 * Label for select document type in add conditions dialog.
	 */
	public final String SELECT_DOCUMENT_TYPE = "Select_Document_Type";

	/**
	 * Message in progress monitor. 
	 */
	public final String PROGRESS_MONITOR_MESSAGE = "Progress_Monitor_Message";

	/**
	 * Warning message showed when conditions are undefined.
	 */
	public final String WARNING_MESSAGE_UNDEFINED_CONDITIONS = "Warning_Undefined_Conditions";
	
	/**
	 * Text added in radioButton for select to use all conditions available, when
	 * wasn't found a conditions set.  
	 */
	public final String USPECIFIED_CONDITIONS = "Unspecified_Conditions";
}
