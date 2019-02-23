package com.filldream.sun.utils;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.filldream.sun.utils.FileIOUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(BarCodeUtil.class);
	
	private static final int WIDTH = 351;
    private static final int CODEHEIGHT = 55;
    private static final int HEIGHT = 78;
    private static final int FONTSIZE = 25;
    
    
    
    /**
     * 生成条形码,带数字
     * @param path            存储地址，覆盖
     * @param content         存储内容
     * @param type            条形码类型，BarcodeFormat
     * @throws Exception
     */
    public static void createCodeHasBottomNum(String path,String content,BarcodeFormat type) {
    	try {
	    	String IMAGETYPE = FileIOUtil.getSuffixByFileName(path);
	        FileOutputStream fos;
	        fos = new FileOutputStream(new File(path));
	        int width = WIDTH;
	        int height = CODEHEIGHT;
	        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
	        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
	        BitMatrix m = new MultiFormatWriter().encode(content,
	        		type, width, height, hints);
	        MatrixToImageWriter.writeToStream(m, IMAGETYPE, fos);
	        fos.flush();
	        fos.close();
	        createFont(path,content);
    	}catch(Exception e) {
    		logger.error("条形码内容不符编码规则或其他原因");
    	}
    }
    
    
    
    
    
    
    /**
	 * 生成条形码到本地  无底部数字
	 * @param barcodeFormat      条码类型
	 * @param contents           条形码内容
	 * @param width              条形码长度
	 * @param height             条形码宽度
	 * @param savePath           存储位置
	 */
	public static void createBarCodeNoBottomNum(BarcodeFormat barcodeFormat,String contents, int width, int height, String savePath) {
		String suffix = FileIOUtil.getSuffixByFileName(savePath);
		int codeWidth = 3 + // start guard
				(7 * 6) + // left bars
				5 + // middle guard
				(7 * 6) + // right bars
				3; // end guard
		codeWidth = Math.max(codeWidth, width);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, barcodeFormat, codeWidth, height,
					null);
			MatrixToImageWriter.writeToFile(bitMatrix, suffix, new File(savePath));
		} catch (Exception e) {
			System.out.println("no number or number error or number uncheck or type is err");
			e.printStackTrace();
		}
	}  
    
    
    /**
     * 读取条形码内容
     * @param imgPath
     * @return
     */
	public static String readBarCode(String imgPath) {     
        BufferedImage image = null;     
        Result result = null;     
        try {     
            image = ImageIO.read(new File(imgPath));     
            if (image == null) {     
                System.out.println("no img or img error");     
            }     
            LuminanceSource source = new BufferedImageLuminanceSource(image);     
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));     
            result = new MultiFormatReader().decode(bitmap, null);     
            return result.getText();     
        } catch (Exception e) {
        	System.out.println("no img or img error or type is err"); 
            e.printStackTrace();     
        }     
        return "";     
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //该方法用来生成二维码字体并且把二维码拼接到字体图片上(createCodeHasBottomNum)
    private static void createFont(String path,String content) throws Exception {
    	String IMAGETYPE = FileIOUtil.getSuffixByFileName(path);
        BufferedImage font = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        BufferedImage code = ImageIO.read(new File(path));
        Graphics2D g = (Graphics2D) font.getGraphics();
        //长宽是总的 字体加二维码的
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //字体渲染
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
                //在图片上把字写好
        for (int i = 0; i < content.length(); i++) {
            g.setColor(Color.black);
            Font font_ = new Font("Consolas", 0, FONTSIZE);
            g.setFont(font_);
            g.drawString(content.charAt(i) + "", (FONTSIZE * 2 + WIDTH - content.length()
                    * FONTSIZE)
                    / 2 + (i - 1) * FONTSIZE, CODEHEIGHT + HEIGHT - CODEHEIGHT);
        }
        //然后把二维码加上去 
        g.drawImage(code, 0, 0, null);
        g.dispose();
        //进行图片处理,防止出现模糊
        int[] rgb = new int[3];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = CODEHEIGHT; j < HEIGHT; j++) {
                int pixel = font.getRGB(i, j);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                if (rgb[0] > 125 || rgb[1] > 125 || rgb[2] > 125) {
                    font.setRGB(i, j, -1);
                }
                if (rgb[0] < 100 || rgb[1] < 100 || rgb[2] < 100) {
                    font.setRGB(i, j, -16777216);
                }
            }
        }

        File outputfile = new File(path);
        ImageIO.write(font, IMAGETYPE, outputfile);
    }
    
}
