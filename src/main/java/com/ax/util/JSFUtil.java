package com.ax.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

		public static void sendMessageSucess(String message) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
			FacesContext context =  FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
		}
		
		public static void sendMessageError(String message) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
			FacesContext context =  FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
		}
}
