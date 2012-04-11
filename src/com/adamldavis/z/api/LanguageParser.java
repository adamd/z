package com.adamldavis.z.api;

import java.io.File;
import java.util.List;

import com.adamldavis.z.ZNode;

public interface LanguageParser {

	String getImportKeyword();

	String getPackageKeyword();

	List<String> getReservedWords();

	List<String> getValidFileExtensions();

	List<ZNode> getMethods(File file);

	String getNonMethodPart(File file);

	boolean requiresSemicolon();

	boolean usesBraces();

	boolean usesParens();

	/** File used by package for comments (package-info.java in Java). */
	String getPackageFilename();

	boolean isCommentStart(CharSequence code, int i);

	int findCommentEnd(CharSequence code, int i);

}
