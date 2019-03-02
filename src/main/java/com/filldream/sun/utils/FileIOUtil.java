package com.filldream.sun.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 文件以及IO工具类
 * @author RickSun
 *
 */
public class FileIOUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FileIOUtil.class);
	
	
	/**
	 * 将文件读取为字符串
	 * @param file
	 * @return
	 */
	public static String FileToString(File file) {
		if(file == null) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	
	/**
	 * 根据文件名称来判断文件的后缀类型
	 * @param fileName 文件名
	 * @return
	 */
	public static String getSuffixByFileName(String fileName) {
		if(SunCommon.isBlank(fileName)) {
			return "";
		}
		int lastIndex = fileName.lastIndexOf(".");
		if(lastIndex == -1) {
			return "";
		}
		String suffix = fileName.substring(lastIndex + 1);
		return suffix;
	}
	
	
	
	//删除文件工具
	
	/**
	 * 删除文件或文件夹
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFiles(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
        	logger.info("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile()) {
                return deleteFile(fileName);
            } else {
                return deleteDirectory(fileName);
            }
        }
    }
	
	/**
	 * 删除单个文件
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
            	logger.info("删除单个文件" + fileName + "成功！");
                return true;
            } else {
            	logger.info("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
        	logger.info("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
	
	/**
	 * 删除目录以及目录下所有文件
	 * @param dir
	 * @return
	 */
	public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            logger.info("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileIOUtil.deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileIOUtil.deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
        	logger.info("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
        	logger.info("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }
	
	
	
	//end  删除文件工具
	
	/**
	 * 添加文件
	 * @param bfile
	 * @param fileURI
	 */
    public static void addFile(byte[] bfile, String fileURI) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        File dir = null;
        try {
            dir = new File(fileURI.substring(0,fileURI.lastIndexOf("/")+1).replace("/", "\\"));
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(fileURI);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
    
    /**
   	 * 获取文件的名字,全名称
   	 * @param fileURI   文件地址
   	 * @return
   	 */
   	public static String getFullName( String fileSource) {
   		File file = new File(fileSource);
   		return file.getName();
   	}
    
    /**
	 * 获取文件的去后缀名字
	 * @param fileURI   文件地址
	 * @return
	 */
	public static String getFileNameNoSuffix( String fileSource) {
		String fullName = getFullName(fileSource);
		return fullName.substring(0, fullName.indexOf("."));
	}
    
	/**
	 * 获取文件大小
	 * @param path
	 * @return  错误返回0
	 */
	public static Object getFileSize(String path, String sizeName) {
		FileChannel fc = null;
		try {
			File f = new File(path);
			if (f.exists() && f.isFile()) {
				FileInputStream fis = new FileInputStream(f);
				fc = fis.getChannel();

				if (sizeName == null) {
					sizeName = "b";
				} else if (sizeName.equals("b")) {
				} else {
					sizeName = sizeName.toUpperCase();
				}

				if (sizeName.equals("G")) {
					return (double) ((fc.size() / 1024 / 1024 / 1024.0));
				} else if (sizeName.equals("M")) {
					return (double) ((fc.size() / 1024 / 1024.0));
				} else if (sizeName.equals("KB")) {
					return (double) ((fc.size() / 1024.0));
				} else if (sizeName.equals("B")) {
					return (double) ((fc.size() / 8.0));
				} else {
					return (double) ((fc.size() / 1.0));
				}

			}else if(f.exists() && f.isDirectory()) {
				logger.error("请正确选择文件");
			}
		} catch (Exception e) {
			logger.error("路径不正确或其他原因");
		} finally {
			if (null != fc) {
				try {
					fc.close();
				} catch (IOException e) {
					logger.error("IO流未正常关闭");
				}
			}
		}
		
		logger.error("路径不正确");
		return 0.0;
	}
	
	
    
    /**
	 * 创建空文件，不是文件夹
	 * @param fileURI     文件路径，待文件名
	 * @param rewrite     是否覆盖原文件，不覆盖则保持原有文件内容
	 * @return
	 */
	public static Boolean createEmptyFile( String fileURI,Boolean rewrite) {
		try {
			File file = new File(fileURI);
			if(!rewrite) { //不覆盖
				return file.createNewFile();
			}else {
				file.delete();
				return file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
    
    
    
    /**
     * 创建多重文件夹
     * @param path
     * @return
     */
    public static Boolean newDirectory (String path) {
    	File file = new File(path);
    	if(!file.exists() && !file.isDirectory()) {
    	    return file.mkdirs();
    	}
    	return true;
    }
    
    
    
    /**
     * 重命名文件、文件夹
     * @param url         文件地址
     * @param new_name    新名称
     * @return
     */
    public static boolean renameFiles(String url, String new_name){
        String old_url = url;
        old_url = old_url.replace("\\", "/");
        File old_file = new File(old_url);
        if (!old_file.exists()) {
        	logger.error("文件重命名失败:"+old_file+" 不存在");
        	return false;
        }
//        System.out.println(old_file.exists());

        // 获得父路径
        String parent = old_file.getParent();
        // 重命名
        String new_url = parent + "/" + new_name;
        File new_file = new File(new_url);
        if (new_file.exists()) {
        	if( new_file.isFile() ) {
        		logger.warn("文件已存在或重复命名，请更换名称");
            	return false;
        	}else {
        		logger.warn("文件夹已存在或重复命名，请更换名称");
            	return false;
        	}
        	
        }
        old_file.renameTo(new_file);

        logger.info("原文件：" + old_file.getName() 
        +" 新文件：" + new_file.getName()
        		);
        
        return true;
    }
    
    
    /**
     * 下载网络资源
     * @param urlStr           网络URL
     * @param fileName         自定义文件名称,全名称
     * @param savePath         存储位置，文件夹
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fullFileName,String savePath) throws IOException{
        URL url = new URL(urlStr);  
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();  
        //获取自己数组
        byte[] getData = readInputStreamToBytes(inputStream);    

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fullFileName);    
        FileOutputStream fos = new FileOutputStream(file);     
        fos.write(getData); 
        if(fos!=null){
            fos.close();  
        }
        if(inputStream!=null){
            inputStream.close();
        }

        logger.info( "FileIOUtil:"+url+" download success" );


    }
    
    /**
     * 获取用户默认系统地址
     * @return
     */
    public static String getUserDirPath() {
    	return System.getProperty("user.dir");
    }
    
    /**
     * 获取用户默认系统文件夹地址
     * @return
     */
    public static File getUserDirFile() {
    	return new File(getUserDirPath());
    }
    
    
    /**
     * 将输入流转换为byte数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStreamToBytes(InputStream inputStream) throws IOException {  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        while((len = inputStream.read(buffer)) != -1) {  
            bos.write(buffer, 0, len);  
        }  
        bos.close();  
        return bos.toByteArray();  
    }
    
    /**
	*  下载网络资源转换成流
	*
	*/
	public void downloadByUrlToIo(HttpServletResponse response,
			HttpServletRequest request, String path){
		try {
			String[] logUrlArray = path.split("/");
			String fileName = logUrlArray[logUrlArray.length - 1];
			URL url = new URL(path);
			URLConnection uc = url.openConnection();
			response.setContentType("application/octet-stream");// 设置文件类型
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "UTF-8"));
			response.setHeader("Content-Length",
					String.valueOf(uc.getContentLength()));
			ServletOutputStream out = response.getOutputStream();
			IOUtils.copy(uc.getInputStream(), out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
}
