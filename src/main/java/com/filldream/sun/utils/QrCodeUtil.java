package com.filldream.sun.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.filldream.sun.sunEntity.QrParam;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码工具类
 * @author RickSun
 *
 */
public class QrCodeUtil {

	private final static Logger logger = LoggerFactory.getLogger(QrCodeUtil.class);
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	// 创建普通的二维码
	public static void normalToFile(BitMatrix matrix, File file) throws IOException {
		String imgType = FileIOUtil.getSuffixByFileName(file.getName());
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, imgType, file)) {
			throw new IOException("Could not write an image of format " + imgType + " to " + file);
		}
	}
	
	// 创建彩色二维码
	public static void colorToFile(BitMatrix matrix, File file) throws IOException {
		String imgType = FileIOUtil.getSuffixByFileName(file.getName());
		BufferedImage image = toBufferedImageColor(matrix);
		if (!ImageIO.write(image, imgType, file)) {
			throw new IOException("Could not write an image of format " + imgType + " to " + file);
		}
	}
	
	// 创建彩色带图片的二维码
	public static void colorAndImgToFile(BitMatrix matrix, String saveSource,String imgSource) throws Exception {
		String imgType =FileIOUtil.getSuffixByFileName(saveSource);
		BufferedImage image = toBufferedImageColorAndImg(matrix,imgSource);
		if (!ImageIO.write(image, imgType, new File(saveSource))) {
			throw new IOException("Could not write an image of format " + imgType + " to " + saveSource);
		}
	}

	
	public static void normalToStream(BitMatrix matrix, String imgType, OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, imgType, stream)) {
			throw new IOException("Could not write an image of format " + imgType);
		}
	}
	
	public static void colorToStream(BitMatrix matrix, String imgType, OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImageColor(matrix);
		if (!ImageIO.write(image, imgType, stream)) {
			throw new IOException("Could not write an image of format " + imgType);
		}
	}
	
	public static void colorAndImgToStream(BitMatrix matrix, String imgType,String imgSource, OutputStream stream) throws Exception {
		BufferedImage image = toBufferedImageColorAndImg(matrix,imgSource);
		if (!ImageIO.write(image, imgType, stream)) {
			throw new IOException("Could not write an image of format " + imgType);
		}
	}

//	public static void main(String[] args) {
//		try {
//			String content = "SunJar";
//			String path = "D:\\msg";
//
//			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//			Map hints = new HashMap();
//			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//			hints.put(EncodeHintType.MARGIN, 1);
//			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
//
////			File file1 = new File(path, "color.jpg");
//			String s1 = "D:\\\\msg\\ci.jpg";
//			String s2 = "D:\\\\msg\\二维码.jpg";
//			QrCodeUtil.colorAndImgToFile(bitMatrix, s1,s2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// ---------辅助方法-------------

	//生成普通二维码bufferedImage
	private static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	//生成彩色二维码bufferedImage
	private static BufferedImage toBufferedImageColor(BitMatrix matrix) {
		// int halfW = matrix.getWidth() / 2;
		// int halfH = matrix.getHeight() / 2;
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		int[] pixels = new int[width * height];

		for (int y = 0; y < matrix.getHeight(); y++) {
			for (int x = 0; x < matrix.getWidth(); x++) {
				// System.out.println("x="+x+" y="+y);
				// 二维码颜色（RGB）
				int num1 = (int) (50 - (50.0 - 13.0) / matrix.getHeight() * (y + 1));
				int num2 = (int) (165 - (165.0 - 72.0) / matrix.getHeight() * (y + 1));
				int num3 = (int) (162 - (162.0 - 107.0) / matrix.getHeight() * (y + 1));
				Color color = new Color(num1, num2, num3);
				int colorInt = color.getRGB();
				// 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
				pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;// 0x000000:0xffffff
			}
		}
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.getRaster().setDataElements(0, 0, width, height, pixels);
		return image;
	}

	
	
	
	
	
	
	
	/**
     * 得到BufferedImage
     *
     * @param content 二维码显示的文本
     * @param width   二维码的宽度
     * @param height  二维码的高度
     * @return
     * @throws WriterException
     * @throws IOException
     */
    private static BufferedImage toBufferedImageColorAndImg(BitMatrix matrix, String srcImagePath) throws WriterException,
            IOException {
    	// 图片宽度的一半
    	int IMAGE_WIDTH = 100;
	    int IMAGE_HEIGHT = 100;
	    int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;
	    int FRAME_WIDTH = 2;
    	
        // 读取源图像
        BufferedImage scaleImage = scale(srcImagePath, IMAGE_WIDTH,
                IMAGE_HEIGHT, true);
        int[][] srcPixels = new int[IMAGE_WIDTH][IMAGE_HEIGHT];
        for (int i = 0; i < scaleImage.getWidth(); i++) {
            for (int j = 0; j < scaleImage.getHeight(); j++) {
                srcPixels[i][j] = scaleImage.getRGB(i, j);//图片的像素点
            }
        }
        
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        
        // 二维矩阵转为一维像素数组
        int halfW = matrix.getWidth() / 2;
        int halfH = matrix.getHeight() / 2;
        int[] pixels = new int[width * height];
 
        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                // 左上角颜色,根据自己需要调整颜色范围和颜色
                /*if (x > 0 && x < 170 && y > 0 && y < 170) {
                    Color color = new Color(231, 144, 56);
                    int colorInt = color.getRGB();
                    pixels[y * width + x] = matrix.get(x, y) ? colorInt
                            : 16777215;
                } else*/
                // 读取图片
                if (x > halfW - IMAGE_HALF_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH
                        && y < halfH + IMAGE_HALF_WIDTH) {
                    pixels[y * width + x] = srcPixels[x - halfW
                            + IMAGE_HALF_WIDTH][y - halfH + IMAGE_HALF_WIDTH];
                }
                // 在图片四周形成边框
                else if ((x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW - IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        + IMAGE_HALF_WIDTH + FRAME_WIDTH)
                        || (x > halfW + IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        + IMAGE_HALF_WIDTH + FRAME_WIDTH)
                        || (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        - IMAGE_HALF_WIDTH + FRAME_WIDTH)
                        || (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
                        && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
                        && y > halfH + IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
                        + IMAGE_HALF_WIDTH + FRAME_WIDTH)) {
                    pixels[y * width + x] = 0xfffffff;
                } else {
                    // 二维码颜色（RGB）
                    int num1 = (int) (50 - (50.0 - 13.0) / matrix.getHeight()
                            * (y + 1));
                    int num2 = (int) (165 - (165.0 - 72.0) / matrix.getHeight()
                            * (y + 1));
                    int num3 = (int) (162 - (162.0 - 107.0)
                            / matrix.getHeight() * (y + 1));
                    Color color = new Color(num1, num2, num3);
                    int colorInt = color.getRGB();
                    // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
                    pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;// 0x000000:0xffffff
                }
            }
        }
 
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        image.getRaster().setDataElements(0, 0, width, height, pixels);
 
        return image;
    }
	
	
	/**
     * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标
     *
     * @param srcImageFile 源文件地址
     * @param height       目标高度
     * @param width        目标宽度
     * @param hasFiller    比例不对时是否需要补白：true为补白; false为不补白;
     * @throws IOException
     */
	private static BufferedImage scale(String srcImageFile, int height, int width, boolean hasFiller) throws IOException {
        double ratio = 0.0; // 缩放比例
        File file = new File(srcImageFile);
        BufferedImage srcImage = ImageIO.read(file);
        Image destImage = srcImage.getScaledInstance(width, height,
                BufferedImage.SCALE_SMOOTH);
        // 计算比例
        if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
            if (srcImage.getHeight() > srcImage.getWidth()) {
                ratio = (new Integer(height)).doubleValue()
                        / srcImage.getHeight();
            } else {
                ratio = (new Integer(width)).doubleValue()
                        / srcImage.getWidth();
            }
            AffineTransformOp op = new AffineTransformOp(
                    AffineTransform.getScaleInstance(ratio, ratio), null);
            destImage = op.filter(srcImage, null);
        }
        if (hasFiller) {// 补白
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D graphic = image.createGraphics();
            graphic.setColor(Color.white);
            graphic.fillRect(0, 0, width, height);
            if (width == destImage.getWidth(null))
                graphic.drawImage(destImage, 0,
                        (height - destImage.getHeight(null)) / 2,
                        destImage.getWidth(null), destImage.getHeight(null),
                        Color.white, null);//画图片
            else
                graphic.drawImage(destImage,
                        (width - destImage.getWidth(null)) / 2, 0,
                        destImage.getWidth(null), destImage.getHeight(null),
                        Color.white, null);
            graphic.dispose();
            destImage = image;
        }
        return (BufferedImage) destImage;
    }
	
	
	
	
	
	
	// ---------END 辅助方法-------------

	public static String IoHelp() {
		return "/**\r\n" + 
				"	 * 创建二维码\r\n" + 
				"	 * @param response\r\n" + 
				"	 */\r\n" + 
				"	@RequestMapping(\"/qrCode/showQrCode\")\r\n" + 
				"	@ResponseBody\r\n" + 
				"	public void showQrCode( HttpSession session, HttpServletResponse response,String qrContent ){\r\n" + 
				"		response.setContentType(\"image/jpeg\");//设置相应类型,告诉浏览器输出的内容为图片\r\n" + 
				"		response.setHeader(\"Pragma\", \"No-cache\");//设置响应头信息，告诉浏览器不要缓存此内容\r\n" + 
				"		response.setHeader(\"Cache-Control\", \"no-cache\");\r\n" + 
				"		response.setDateHeader(\"Expire\", 0);\r\n" + 
				"		try {\r\n" + 
				"			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();\r\n" + 
				"			Map hints = new HashMap();\r\n" + 
				"			hints.put(EncodeHintType.CHARACTER_SET, \"UTF-8\");\r\n" + 
				"			BitMatrix bitMatrix = multiFormatWriter.encode(qrContent, BarcodeFormat.QR_CODE, 200, 200,hints);\r\n" + 
				"			QrCodeUtil.writeToStream(bitMatrix, \"JPEG\", response.getOutputStream());\r\n" + 
				"		} catch (Exception e) {\r\n" + 
				"			e.printStackTrace();\r\n" + 
				"		}";
	}

	/**
	 * 读取二维码图片
	 * 
	 * @param file
	 *            文件路径
	 * @return 返回一个二维码的信息list list.size = 3 list has Qrcode test list has Timestamp
	 *         list has BarcodeFormat
	 */
	public static List<Object> readQrCode(File file) {
		try {
			List<Object> list = new ArrayList<Object>();
			MultiFormatReader formatReader = new MultiFormatReader();
			BufferedImage image = ImageIO.read(file);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			// 定义二维码的参数
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			Result result = formatReader.decode(binaryBitmap, hints);
			list.add(result.getText());
			list.add(result.getTimestamp());
			list.add(result.getBarcodeFormat().toString());
			return list;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	/**
	 * 设置二维码内容
	 * @param linkUrl    二维码跳转参数
	 * @param paramMap   地址其他参数
	 * @param qrParam    二维码属性
	 * @return
	 */
	public static String setQrContent(String linkUrl, Map<String, Object> paramMap,QrParam qrParam) {
		if(qrParam != null) {
			String qrCodeParam = qrParam.getUrlParamName();//二维码自身的参数
			paramMap.put(qrCodeParam, qrParam.toString());
		}
		String url = UrlUtil.splicingParam(linkUrl,paramMap);
		return url;
	}
	
	public static QrParam getQrContent(String linkUrl) {
		try {
			Integer jsonStartLocal = linkUrl.indexOf("{\"urlParamName\"");
			String jsonStart = linkUrl.substring(jsonStartLocal, linkUrl.length());
			Integer jsonEndLocal = jsonStart.indexOf("}");
			String jsonend = linkUrl.substring(jsonStartLocal, jsonEndLocal+jsonStartLocal+1);
			QrParam qrParam = QrParam.jsonToEean(jsonend);
			return qrParam;
		}catch (Exception e) {
			return new QrParam(null, "二维码属性错误", new Date().getTime(), new Date().getTime(), null, null);
		}
		
	}
	
	/**
	 * 设置二维码内容
	 * @param linkUrl     url/接口
	 * @param qrParam     二维码属性
	 * @return
	 */
	public static String setQrContent(String linkUrl, QrParam qrParam) {
		String qrCodeParam = "qrContent";
		if(qrParam != null) {
			 qrCodeParam = qrParam.getUrlParamName();//二维码自身的参数
		}
		String url = linkUrl+"?"+qrCodeParam + "=" + qrParam.toString();
		return url;
	}
	
	/**
	 * 设置二维码
	 * @param linkUrl         url/接口
	 * @param qrContent       二维码属性
	 * @return
	 */
	public static String setQrContent(String linkUrl, String qrContent) {
		String url = linkUrl+"?"+ qrContent;
		return url;
	}
}
