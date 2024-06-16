package com.oxygenxml.ant.inputhandler;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.input.InputHandler;
import org.apache.tools.ant.input.InputRequest;
import org.apache.tools.ant.input.MultipleChoiceInputRequest;

public class SwingInputHandlerImpl implements InputHandler {

	@Override
	public void handleInput(InputRequest request) throws BuildException {
		if(request instanceof MultipleChoiceInputRequest) {
			MultipleChoiceInputRequest multiReq = (MultipleChoiceInputRequest) request;
			Object result = JOptionPane.showInputDialog(
					null, request.getPrompt(), UIManager.getString("OptionPane.inputDialogTitle"), 
					JOptionPane.QUESTION_MESSAGE, null, multiReq.getChoices().toArray(), 
					multiReq.getDefaultValue());
			if(result != null){
				request.setInput(String.valueOf(result));
			}
		} else {
			String result = JOptionPane.showInputDialog(request.getPrompt(), request.getDefaultValue());
			if(result != null){
				request.setInput(result);
			}
		}
	}

}
