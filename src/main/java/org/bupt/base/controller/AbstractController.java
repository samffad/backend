package org.bupt.base.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



/*public class AbstractController<T> {
	Logger logger = Logger.getLogger(AbstractController.class);
	public void downloadExcel(HttpServletRequest request,
			HttpServletResponse response, String yearMonth, List<T> lt,
			String templatePath, String fileName, int startNum)
			throws IOException, IllegalArgumentException,
			IllegalAccessException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelExportUtil.createWorkBook(templatePath, lt, startNum)
					.write(os);
		} catch (IOException e) {
			logger.error("文件导出,创建下载文件失败");
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		String fileNames = OfficeUtil.encodeChineseDownloadFileName(request, fileName);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((fileNames + ".xlsx").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[1024 * 1024];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			logger.error("文件导出,文件导出失败");
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}

	}
}*/
