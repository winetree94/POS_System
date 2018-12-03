package com.pos.system.util;

import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.dto.Service_File_DTO;
import com.pos.system.service.IService_Board_Service;
import com.pos.system.service.IService_File_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

@Service
public class FileManager {
	
	
	private IService_File_Service service_File;
	private IService_Board_Service service_Board;
	
	@Autowired
	public FileManager(IService_File_Service service_File, IService_Board_Service service_Board) {
		this.service_File = service_File;
		this.service_Board = service_Board;
	}

//    상대경로
	
	/**
	 * <h2>파일 업로드 기능<h2/>
	 *
	 * @param file
	 * @param request
	 * @return int
	 */
	public int upload(MultipartFile file, HttpServletRequest request,int board_seq) {
		
		//    절대경로
//    public int upload(MultipartFile file) {


//경로설정(절대경로)
//        String PATH = "C:\\Users\\jaei\\Documents\\GitHub\\POS_System\\src\\main\\webapp\\WEB-INF\\uploadFiles";


//배포시 상대경로
//        String PATH =
//        ServletContext context = request.getServletContext();
//		String PATH= context.getRealPath("upload");
//		String filepath2 = request.getServletContext() +"/"+"upload";
		String PATH = request.getSession().getServletContext().getRealPath("/") + "upload";
		
		File path = new File(PATH);
		
//폴더위치 없을시 생성
		if (path.exists() == false) {
			path.mkdirs();
		}
		
		
		try {
			
			//uuid 는 파일명의 중복을 피하기 위한 설정
			String uuid;
			uuid = UUID.randomUUID().toString();
			
			//원본파일명
			String origin_fname = file.getOriginalFilename();
			
			System.out.println("origin_fname is : " + origin_fname);
			//저장될 파일명(uuid+원본파일명)
			String stored_fname = uuid + origin_fname.substring(origin_fname.lastIndexOf("."));
			System.out.println("stored_fname is : " + stored_fname);
			
			//파일 사이즈 .getSize()는 Long
			//int로 바꿔줌
			Long fSize = file.getSize();
			int s = (int) (long) fSize;
			
			//file dto 객체 불러오기
			Service_File_DTO fdto = new Service_File_DTO();
			
			//board_seq 가져옴
//			int seq = service_Board.selectRecentBoard();
			int seq = service_Board.selectOneBoard(board_seq).getBoard_seq();

			//값 넣기
			fdto.setBoard_seq(seq);
			fdto.setOrigin_fname(origin_fname);
			fdto.setStored_fname(stored_fname);
			fdto.setFile_size(s);
			
			//File 객체 활용 저장될 파일의 경로와 파일명 지정
			File stored_file = new File(PATH + "/" + stored_fname);
			//fdto 정보 입력
			service_File.uploadFile(fdto);
			
			//받아온 file을 stored_file로 바꿔줌
			file.transferTo(stored_file);
			
			System.out.println(fdto);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
			
		}
		
		return 1;
	}
	
	
	/**
	 * 파일 다운로드 기능
	 *
	 * @param board_seq
	 * @param response
	 * @param request
	 * @return response
	 */
	public HttpServletResponse download(int board_seq, HttpServletResponse response, HttpServletRequest request) {
		
		//수정할 파일 정보 가져오기
		Service_File_DTO fileDto = service_File.selectOneFile(board_seq);
		
		//파일이 있는 실제 폴더경로 (절대경로)
		//String realFolder = "C:\\Users\\jaei\\Documents\\GitHub\\POS_System\\src\\main\\webapp\\WEB-INF\\uploadFiles";
		
		//파일이 있는 실제 폴더 경로(상대경로)
		String realFolder = request.getSession().getServletContext().getRealPath("/") + "upload";
		
		System.out.println(realFolder);
		
		//파일경로
		String filePath = realFolder + "/" + fileDto.getStored_fname();
		
		System.out.println(filePath);
		
		//입력받을 파일 초기화
		//FileInputStream : 출발지점과 도착지점을 연결하는 통로 생성 클래스
		FileInputStream in = null;
		
		//출력할 파일 초기화
		//ServletOutputStream : 파일로 바이트 단위의 출력을 내보내는 클래스
		ServletOutputStream out = null;
		
		try {
			
			//파일경로에서 파일 객체 불러오기
			File file = new File(filePath);
			
			//// 파일의 크기만큼 배열의 길이를 선언
			byte[] b = new byte[(int) file.length()];
			
			//response 초기화
			response.reset();
			
			// 다운로드 파일 형식을 모른다면 octet-stream, 워드 application/msword
			response.setContentType("application/octet-stream");
			
			//한글 인코딩 : 한글파일 이름이 깨지는 것을 방지
			String encoding = new String(fileDto.getOrigin_fname().getBytes("utf-8"), "8859_1");
			
			System.out.println("encoded file name is : " + encoding);
			
			String origin_fname = service_File.selectOneFile(board_seq).getOrigin_fname();
			
			// 파일 버튼을 클릭했을 때 다운로드 저장화면이 출력되게 처리
//        response.setHeader("Content-Disposition", "attachment;  filename=aaa");
			response.setHeader("Content-Disposition", "attachment;  filename=\"" + encoding + "\"");
			
			
			in = new FileInputStream(file);
			out = response.getOutputStream();
			
			int numRead = 0;
			
			while ((numRead = in.read(b, 0, b.length)) != -1) {
				out.write(b, 0, numRead);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		return response;
	}
	
	/**
	 * 파일 삭제 기능
	 *
	 * @param board_seq
	 * @return
	 */
	public int fileDelete(int board_seq) {
		
		try {
			
			System.out.println("파일 삭제기능");
			//파일 삭제
			service_File.deleteFile(board_seq);
			
		} catch (Exception e) {
			System.out.println("파일 삭제실패");
			e.printStackTrace();
			
		}
		
		
		return 1;
	}
	
}


