package com.adamldavis.z.editor;

import javax.swing.JPanel;

import neoe.ne.EditorAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adamldavis.z.ZCodeSaver;
import com.adamldavis.z.ZNode;
import com.adamldavis.z.api.APIFactory;
import com.adamldavis.z.api.ColorMode;

public class ZCodeEditor extends EditorAdapter {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(ZCodeEditor.class);

	final JPanel panel;

	protected ZNode zNode;

	protected final APIFactory apiFactory;

	public ZCodeEditor(ZNode zNode, APIFactory apiFactory) {
		super();
		panel = getEditorPanel();
		applyColorMode(ColorMode.BLACK);
		setText(apiFactory.getCodeFormatter().format(zNode.getCode()));
		this.zNode = zNode;
		this.apiFactory = apiFactory;
		panel.requestFocus();
	}

	public void save() {
		log.info("Saving: {}", zNode);
		zNode.replaceCode(getText());
		new ZCodeSaver(apiFactory).save(zNode);
	}

}
