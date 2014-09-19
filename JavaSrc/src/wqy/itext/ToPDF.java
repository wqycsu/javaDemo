package wqy.itext;

import java.io.File; 
import java.io.IOException; 
import java.util.ArrayList;  
public class ToPDF 
{ 
	public static void main(String[] args) 
	{ // TODO Auto-generated method stub 
		ArrayList<String> imageUrllist = new ArrayList<String>(); 
		imageUrllist.add("E:\\’’∆¨\\11\\22\\" + "1205041012288000" + ".png");
		String pdfUrl = "E:\\’’∆¨\\11\\22\\vedio.pdf"; 
		File file = PDFManager.Pdf(imageUrllist, pdfUrl); 
		try 
		{ 
			file.createNewFile(); 
		} 
		catch (IOException e) { // TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	} 
}
