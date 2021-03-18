package com.booth.fileutils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * <p>
 * 导出下载
 * </p>
 */
public class ExcelDownloadUtil {
  private static String MOZILLA = "Mozilla";
  private static String MSIE = "MSIE";

  /**
   * excel 文件导出
   *
   * @param wb       excel文件
   * @param fileName 文件名称
   * @param response
   * @param request
   * @throws IOException
   */
  public static void workBook2down(Workbook wb, String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {

    if (fileName == null || "".equals(fileName)) {
      fileName = "文件下载.xls";
    } else {
      fileName = fileName + ".xls";
    }

    String ug = request.getHeader("User-Agent");

    String finalFileName = null;

    if (StringUtils.contains(ug, MSIE)) {
      //IE浏览器
      finalFileName = URLEncoder.encode(fileName, "UTF8");
    } else {

      if (StringUtils.contains(ug, MOZILLA)) {
        //google,火狐浏览器
        finalFileName = new String(fileName.getBytes(), "ISO8859-1");
      } else {
        //其他浏览器
        finalFileName = URLEncoder.encode(fileName, "UTF8");
      }
    }
    response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");
    response.setContentType("application/vnd.ms-excel");

    //得到响应的流
    ServletOutputStream outputStream = response.getOutputStream();
    wb.write(outputStream);
    if (outputStream != null) {
      outputStream.close();
    }
  }

  private static OutputStream initHeader(HttpServletResponse res, String fileName) throws IOException {
    res.setContentType("text/html; charset=UTF-8");
    res.setContentType("application/octet-stream");
    res.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "ISO-8859-1"));
    return res.getOutputStream();
  }

  /**
   * 下载下文件
   *
   * @param res
   * @param filePath
   * @return
   * @throws IOException
   */
  public static String download(HttpServletResponse res, String fileName, String filePath) throws IOException {
    OutputStream out = initHeader(res, fileName);
    InputStream is = new FileInputStream(filePath);
    byte[] buffer = new byte[2048];
    int size = 0;
    while ((size = is.read(buffer)) != -1) {
      out.write(buffer, 0, size);
    }
    is.close();
    return null;
  }

  /**
   * 压缩文件
   *
   * @param filePaths 需要压缩的文件路径集合
   * @throws IOException
   */
  private static String zipFile(Map<String, String> filePaths, ZipOutputStream zos) throws IOException {
    //循环读取文件路径集合
    for (Map.Entry<String, String> entry : filePaths.entrySet()) {
      String fileName = entry.getKey();
      String filePath = entry.getValue();
      File inputFile = new File(filePath);
      //判断文件是否存在
      if (inputFile.exists()) {
        //判断是否属于文件，还是文件夹
        if (inputFile.isFile()) {
          //创建输入流读取文件
          BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));

          //将文件写入zip内，即将文件进行打包
          zos.putNextEntry(new ZipEntry(fileName + filePath.substring(filePath.lastIndexOf("."))));

          //写入文件的方法，同上
          int size = 0;
          //设置读取数据缓存大小
          byte[] buffer = new byte[1024];
          while ((size = bis.read(buffer)) > 0) {
            zos.write(buffer, 0, size);
          }
          zos.closeEntry();
          bis.close();

        }
      }
    }
    return null;
  }

  /**
   * 打包多个excel文件
   *
   * @param
   * @throws IOException
   */
  private static String wbPackage(Map<String, Workbook> filePaths, ZipOutputStream zos) throws IOException {
    //循环读取文件路径集合
    for (Map.Entry<String, Workbook> entry : filePaths.entrySet()) {
      String fileName = entry.getKey();
      Workbook wb = entry.getValue();
      zos.putNextEntry(new ZipEntry(fileName));
      wb.write(zos);
      zos.closeEntry();
    }
    return null;
  }

  private static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};

  private static boolean isMSBrowser(HttpServletRequest request) {
    String userAgent = request.getHeader("User-Agent");
    for (String signal : IEBrowserSignals) {
      if (userAgent.contains(signal)) {
        return true;
      }
    }
    return false;
  }

}
