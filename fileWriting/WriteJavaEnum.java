//  Jackie Loven, 10 August 2015


package fileWriting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import dataStoring.CodeValuePair;
import dataStoring.EnumSettings;
import spreadsheetParsing.SheetReader;

public class WriteJavaEnum {
	
	private static ArrayList<CodeValuePair> pairList = SheetReader.finalList;

	public static void main(EnumSettings settings) {
		Writer writer = null;
		String fileName = settings.getDestinationFolder().toString()+ "/" + settings.getClassName() + ".java";
		File file = new File(fileName);

		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("package " + settings.getPackageName() + ";");
			writer.write("\n");
			writer.write("\n");
			writer.write("public enum " + settings.getClassName() + " {");
			writer.write("\n");
			writer.write("\n");
			for (CodeValuePair pair : pairList) {
				String enumPairName = pair.getValue().toUpperCase().replaceAll("[^A-Z0-9]+", "_");
				System.out.println(enumPairName + " inside for");
				String enumPairNameNoNumbers = enumPairName.replaceAll("[0-9]+", "");
				System.out.println(enumPairNameNoNumbers + " enumPairNameNoNumbers");
				//  Make sure enumPairName isn't a number:
				if (enumPairNameNoNumbers.trim() == null) {
					System.out.println(enumPairName + " inside if");
					enumPairName = enumPairName + "_";
				}
				writer.write("\t" + enumPairName +"(" + '"' + pair.getCode() + '"' + ", " + '"' + pair.getValue() + '"' + ")" );
				if (pairList.indexOf(pair) != pairList.size() - 1) {
					writer.write(",");
				} else {
					writer.write(";");
				}
				writer.write("\n");
			}
			
			writer.write("\n");
			writer.write("\t" + "private String code;");
			writer.write("\n");
			writer.write("\t" + "private String name;");
			writer.write("\n");
			writer.write("\n");
			
			writer.write("\t" + "private " + settings.getClassName() + "(String code, String name) {");
			writer.write("\n");
			writer.write("\t" + "\t" + "this.code = code;");
			writer.write("\n");
			writer.write("\t" + "\t" + "this.name = name;");
			writer.write("\n");
			writer.write("\t" + "}");
			writer.write("\n");
			writer.write("\n");
			
			writer.write("\t" + "public String getCode() {");
			writer.write("\n");
			writer.write("\t" + "\t" + "return this.code;");
			writer.write("\n");
			writer.write("\t" + "}");
			writer.write("\n");
			writer.write("\n");

			writer.write("\t" + "public String getName() {");
			writer.write("\n");
			writer.write("\t" + "\t" + "return this.name;");
			writer.write("\n");
			writer.write("\t" + "}");
			writer.write("\n");
			writer.write("\n");
			
			writer.write("\t" + "public static " + settings.getClassName() + " getByCode(String code) {");
			writer.write("\n");
			writer.write("\t" + "\t" + "for (" + settings.getClassName() + " value : " + settings.getClassName() + ".values()) {");
			writer.write("\n");
			writer.write("\t" + "\t" + "\t" + "if (code.equals(value.getCode())) {");
			writer.write("\n");
			writer.write("\t" + "\t" + "\t" + "\t" + "return value;");
			writer.write("\n");
			writer.write("\t" + "\t" + "\t" + "}");
			writer.write("\n");
			writer.write("\t" + "\t" + "}");
			writer.write("\n");
			writer.write("\t" + "\t" + "return null;");
			writer.write("\n");
			writer.write("\t" + "}");
			writer.write("\n");
			writer.write("}");
			writer.write("\n");
			writer.write("\n");
			
			writer.close();
		} catch (IOException ex) {
		}
	}
}

