package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1MB - 이 크기를 초과하면 메모리가 아닌 디스크에 임시 저장
		maxFileSize = 1024 * 1024 * 10, // 10MB - 단일 파일 크기
		maxRequestSize = 1024 * 1024 * 50 // 50MB - 전체 요청 크기

)

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset= utf-8");
		// 업로드된 파일을 저장하는 폴더 지정
		String uploadPath = getServletContext().getRealPath("/uploads");
		System.out.println("uploadPath:" + uploadPath);

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();

		String author = request.getParameter("author");
		// 파라미터 이름이 'file'인 Part
		Part filePart = request.getPart("file");

		// 파일이름 얻어내기
		if (filePart != null && filePart.getSize() > 0) {
			String fileName = filePart.getSubmittedFileName();
			System.out.println("fileName" + fileName);

			// 저장할 폴더 경로와 파일 이름을 합쳐서 파일합치기
			String fullPath = uploadPath + File.separator + fileName;
			filePart.write(fullPath);	
			
			response.getWriter().println("업로드 성공" + fileName + "<br>");
			response.getWriter().println("업로드한 사람:" + author + "<br>");
			
		}

	}

}
