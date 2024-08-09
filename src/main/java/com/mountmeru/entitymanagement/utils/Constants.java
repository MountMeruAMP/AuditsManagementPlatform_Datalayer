package com.mountmeru.entitymanagement.utils;

public class Constants {
	public static final String emailregex = "^(.+)@(.+)$";
	public static final String phoneRegx = "^\\d{10}$";
	public static final String dateFormat_mm_dd_yyyy = "MM/dd/yyyy";
	public static final String timestamp_format = "yyyy.MM.dd.HH.mm.ss";
	public static final String auditType = "AuditType";
	public static final String audit_state_scheduled = "Scheduled";
	public static final String  audit_state_completed = "Completed";
	public static final String  audit_state_inprogress = "In-Progress";
	public static final String  audit_state_inactive = "Inactive";
	public static final String  audit_state_submitted = "Submitted";
	public static final String roleCM = "CM";
	public static final String TOP = "Top";
	public static final String BOTTOM = "Bottom";
	public static final String SMS_BASE_URL = "http://sms.genialconsultancy.com/submitsms.jsp?";

	public static String MESSAGE_TEMPLATE = "Your One Time Password (OTP) to login to the Meru - Audit Management Platform is <USEROTP> . " +
			"This will be valid for the next 180 seconds. - Mount Meru IT Team.";

	public static String EMAIL_SUBJECT = "Testing subject";
	public static String EMAIL_CONTENT = "Testing content";
	public static String TEMP_DIR = "assets/temp/";
}
