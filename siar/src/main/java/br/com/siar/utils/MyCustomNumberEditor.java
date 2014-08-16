/**
 * 
 */
package br.com.siar.utils;

import java.text.NumberFormat;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.util.StringUtils;

/**
 * @author Leo
 *
 */
public class MyCustomNumberEditor extends CustomNumberEditor {

	/**
	 * @param numberClass
	 * @param allowEmpty
	 * @throws IllegalArgumentException
	 */
	public MyCustomNumberEditor(Class<? extends Number> numberClass,
			boolean allowEmpty) throws IllegalArgumentException {
		super(numberClass, allowEmpty);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numberClass
	 * @param numberFormat
	 * @param allowEmpty
	 * @throws IllegalArgumentException
	 */
	public MyCustomNumberEditor(Class<? extends Number> numberClass,
			NumberFormat numberFormat, boolean allowEmpty)
			throws IllegalArgumentException {
		super(numberClass, numberFormat, allowEmpty);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getAsText() {
		return super.getAsText();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasText(text))
			super.setAsText(text.trim());
		else
			super.setValue(0);
	}
}
