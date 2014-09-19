package wqy.itext; 
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.lowagie.text.Annotation;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;


public class PDFManager 
{ 
	public static final String RESOURCE
    = "E:\\照片\\11\\22\\loa.jpg";
	public static File Pdf(ArrayList<String> imageUrllist,String mOutputPdfFileName)
	{ 
		String TAG = "PdfManager"; 
		Document doc = new Document(new Rectangle(0,0,800,1101), 0, 0, 0, 0); 
		try { 
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(mOutputPdfFileName)); 
			doc.open(); 
//			for (int i = 0; i < imageUrllist.size(); i++) 
//			{ 
//				doc.newPage();
//				Image png1 = Image.getInstance(imageUrllist.get(i)); 
//				float heigth = png1.getHeight(); 
//				float width = png1.getWidth(); 
//				System.out.println("heigth = "+heigth+", width = "+width);
//				int percent = getPercent2(heigth, width);
//				png1.setAlignment(Image.MIDDLE); 
//				png1.scalePercent(percent+3);// 表示是原来图像的比例; 
//				heigth = png1.getHeight()*percent; 
//				width = png1.getWidth()*percent; 
//				System.out.println("heigth = "+heigth+", width = "+width);
//				doc.add(png1); 
//			} 
			
//			 Image image = Image.getInstance(RESOURCE);
//			 img.setRotation(270);
//		        writer.getDirectContent().addImage(img, true);
//		        img.setReference("https://www.dropbox.com/s/u1th7wnzkh59cxt/1307261751051016.mp4");
//		        doc.add(img);
//		        doc.add(Chunk.NEWLINE);	        
		        
//		        doc.add(imdb);
//		        doc.add(Chunk.NEWLINE);
//		        SubClassofAnchor imdb1 = new SubClassofAnchor("click me");
//		        imdb1.setReference("http://www.baidu.com");
//		        doc.add(imdb1);
//		        doc.newPage();
//		        Anchor imgAnchor = new Anchor(img,doc,"http://www.baidu.com");
//		        Rectangl rec = new Rectangl(100,400,200,500);
//		        rec.setBackgroundColor(BaseColor.BLUE);
//		        rec.setReference("http://www.baidu.com");
//		        doc.add(rec);
		        float scale = (float)1101/1328;
		        Annotation annot = new Annotation(200, 517, 712, 901, new URL("https://www.dropbox.com/s/u1th7wnzkh59cxt/1307261751051016.mp4"));
//		        Rectangle rect = new Rectangle(0, 0, 800,1101);
//		        rect.setBackgroundColor(BaseColor.BLUE);
//		        doc.add(rect);
//		        Image img = Image.getInstance(RESOURCE);
//		        img.setRotation((float)Math.PI/6);
//		        img.setAbsolutePosition(100f, 700f);
//		        img.scaleAbsolute(100,100);
//		        doc.add(img);
//		        doc.add(annot);
//		        doc.newPage();
//		        PdfContentByte over = writer.getDirectContent();
//		        over.saveState();
		        float sinus = (float)Math.sin(0);
		        float cosinus = (float)Math.cos(0);
		        BaseFont bf = BaseFont.createFont(BaseFont.TIMES_BOLDITALIC, BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
		        BaseFont  bfChinese = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
		        Font fontChinese = new Font(bfChinese,15,Font.NORMAL);
//		        fontChinese.setStyle(Font.UNDERLINE);
//		        over.beginText();
//		        over.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
//		        over.setLineWidth(1f);
//		        over.setRGBColorFill(0x00, 0x00, 0x00);
//		        over.setFontAndSize(bfChinese, 18);
//		        over.setTextMatrix(cosinus, sinus, -sinus, cosinus, 100, 724);
//		        over.showText("SOLD 玩");
//		        over.setTextMatrix(0, 0);
//		        over.endText();
//		        over.restoreState();
//		        Chunk chunk = new Chunk("123456789 987654321 123456789");
//		        chunk.setFont(fontChinese);
//		        Paragraph p = new Paragraph(chunk);
		        PdfContentByte canvas = writer.getDirectContent();
//		        PdfTemplate template = canvas.createTemplate(60, 100);
//	            ColumnText ct1 = new ColumnText(template);
//		        ct1.addText(chunk);
//		        ct1.setSimpleColumn(0,0,60,100);
//		        ct1.addText(p);
//	            ct1.go();
//	            Image textImg = Image.getInstance(template);
//	            textImg.setInterpolation(true);
//	            textImg.setAbsolutePosition(200, 200);
//	            textImg.setRotationDegrees(-30);
////	            ct1.go();
//	            doc.add(textImg);
//	            doc.newPage();
		        canvas.saveState();
		        PdfTemplate template1 = canvas.createTemplate(237, 71);
	            Chunk chunk1 = new Chunk("又失落了 est omnis divisa in partes tres");
	            PdfGState gState = new PdfGState();
	            gState.setFillOpacity(0.5f);
	            float gap = (doc.getPageSize().getWidth() - 400) / 3;
	            canvas.setGState(gState);
	            chunk1.setUnderline(1, -1);
	            chunk1.setFont(fontChinese);
	            ColumnText ct = new ColumnText(template1);
		        ct.setSimpleColumn(0,0,237,71);
		        Paragraph p1 = new Paragraph(chunk1);
		        ct.addText(p1);
		        ct.go();
		        Image textImg1 = Image.getInstance(template1);
		        Image img = Image.getInstance(RESOURCE);
		        img.setTransparency(new int[]{ 0x00, 0x00 });
		        img.setAbsolutePosition(222, 514);
	            textImg1.setInterpolation(true);
	            textImg1.setAbsolutePosition(222, 514);
	            textImg1.setRotationDegrees(30);
	            textImg1.setTransparency(new int[]{ 0xFF, 0xFF });
//	            ct.go();
	            canvas.restoreState();
	            doc.add(img);
	            doc.add(textImg1);
	            // rotated text at an absolute position
		     doc.close();
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
		}
		catch (DocumentException e) 
		{ 
			e.printStackTrace(); 
		} catch (IOException e) 
		{ 
			e.printStackTrace(); } 
		File mOutputPdfFile = new File(mOutputPdfFileName); 
		if (!mOutputPdfFile.exists())
		{ 
			mOutputPdfFile.deleteOnExit();
			return null; 
		} 
		return mOutputPdfFile; 
	}  
	/** * 第一种解决方案 在不改变图片形状的同时，判断，如果h>w，则按h压缩，否则在w>h或w=h的情况下，按宽度压缩 
	 * * * @param h 
	 * * @param w 
	 * * @return */  
	public static int getPercent(float h, float w) { 
		int p = 0; 
		float p2 = 0.0f; 
		if (h > w) { 
			p2 = 297 / h * 100; 
		} 
		else { 
			p2 = 210 / w * 100; 
		} 
		p = Math.round(p2); 
		return p; 
	}  
	/** * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的  
	 * * @param args */ 
	public static int getPercent2(float h, float w) 
	{ 
		int p = 0; 
		float p2 = 0.0f; 
		p2 = 800 / w * 100; 
		p = Math.round(p2); 
		return p; 
	} 
	
	public static void pictureBackdrop(float x, float y, PdfContentByte cb) {
        cb.setColorStroke(GrayColor.GRAYBLACK);
        cb.setColorFill(new GrayColor(0.8f));
        cb.rectangle(x, y, 100, 200);
        cb.fill();
        cb.setLineWidth(2);
        cb.rectangle(x, y, 200, 200);
        cb.stroke();
    }
}
