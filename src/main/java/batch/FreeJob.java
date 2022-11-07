package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDAO;

public class FreeJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Free top = FreeDAO.getInstance().selectFreeTop();

		File dir = new File("C:\\BoardProject", "top.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		if (dir.exists() == false) {
			try {
				dir.createNewFile();
				fw = new FileWriter(dir);
				bw = new BufferedWriter(fw);
				System.out.println(top.getFreeNo().toString());
				System.out.println(top.getWriter());
				System.out.println(top.getTitle());
				System.out.println(top.getIp());
				System.out.println(top.getHit().toString());
				System.out.println(top.getContent());
				
				
				bw.write(top.getFreeNo().toString());
				bw.write(top.getWriter());
				bw.write(top.getTitle());
				bw.write(top.getIp());
				bw.write(top.getHit().toString());
				bw.write(top.getContent());
				bw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} 

		} else {
			dir.deleteOnExit();
		}
//		try {
//			
//			// 출력 메인 스트림
//			fw = new FileWriter(dir);
//			
//			// 속도 향상을 위한 보조 스트림
//			// 메인 스트림이 없으면 사용 불가
//			bw = new BufferedWriter(fw);
//			
//			bw.write(top.getFreeNo().toString());
//			bw.write(top.getWriter());
//			bw.write(top.getTitle());
//			bw.write(top.getIp());
//			bw.write(top.getHit().toString());
//			bw.write(top.getContent());
//			
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}

//			
//			
//		} else {
//			dir.deleteOnExit();
//		}
//		System.out.println(top);
	}

}
