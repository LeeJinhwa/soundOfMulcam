package servlet;
 
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.Part;


import dao.FileDao;
import vo.FileVO;
 
@WebServlet("/file.do")
public class FileController extends HttpServlet{
    private FileDao dao = FileDao.getInstance();
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String viewPath = "";
         
        if(action==null || action.equals("fileList")){
            // ���� ������ ���ε�� ���� ��� �����ֱ�
            List<FileVO> fileList = dao.selectFileList();
            req.setAttribute("fileList", fileList);
            viewPath = "file_list.jsp";
        } else if(action.equals("uploadForm")){
            viewPath = "upload_form.jsp";
        }
         
        RequestDispatcher dispatcher = 
            req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    // ���� ���ε� �ɶ����� post ����̹Ƿ� doPost�� �����.
        request.setCharacterEncoding("EUC-KR");
        
//        String contentType1 = request.getContentType();
//        
//        System.out.println("�̰���´� "+ contentType1.toLowerCase());
        
         
        
        
        String uploadFolder = getServletContext().getRealPath("/")+"/files/";
        MultipartRequest mRequest = new MultipartRequest
                (request, uploadFolder, 10240 * 10240 * 5, 
                "EUC-KR", new DefaultFileRenamePolicy());
        
//        Collection<Part> parts = request.getParts();
//        
//        for(Part part : parts){
//        	
//        	String contentType = part.getContentType();
//        	
//        	System.out.println("������ Ÿ�� �˾Ƴ���"+contentType);
//        }
        
        String title = mRequest.getParameter("title");
    	String album =mRequest.getParameter("album");
    	String singer = mRequest.getParameter("singer");
        
        System.out.println(title);
        System.out.println(album);
        System.out.println(singer);
        
 
        // ���������� ����Ǵ� ����
        File file = mRequest.getFile("uploadFile"); 
        File img =mRequest.getFile("uploadImg");
 
//         ������ ����� ���� ������ DB�� insert ��Ű��
        
        
        FileVO fileVO = new FileVO();
        fileVO.setMp3Name(mRequest.
                getOriginalFileName("uploadFile"));//���� �����̸�
        fileVO.setFileName(mRequest.getOriginalFileName("uploadImg")); //�̹��� �����̸�
        fileVO.setSavedPath(file.getAbsolutePath());//������
        fileVO.setSavedImgPath(img.getAbsolutePath());
        fileVO.setTitle(title);
        fileVO.setAlbum(album);
        fileVO.setSinger(singer);
         
        int result = dao.insert(fileVO);
        
        System.out.println("�־ȿ���?"+result);
         
        // DB �۾� ����� request�� ����ؼ� forward
        request.setAttribute("uploadResult", result);
         
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("upload_result.jsp");
            dispatcher.forward(request, resp);
    }
}

