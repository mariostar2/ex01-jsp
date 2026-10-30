package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadMulti")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String uploadPath = getServletContext().getRealPath("/uploads");

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			// 파일이 아닌 빈 파트는 건너뛰자.
			if (part.getSize() == 0 || part.getSubmittedFileName() == null) continue;
			String fileName = new File(part.getSubmittedFileName()).getName();
			part.write(uploadPath + File.separator + fileName);
		}
		response.getWriter().println("업로드 완료");
	}

}
