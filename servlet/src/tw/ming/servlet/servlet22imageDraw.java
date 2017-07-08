package tw.ming.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/servlet22")
public class servlet22imageDraw extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		String imgpath = getServletContext().getInitParameter("upload-path");
		
		File image = new File(imgpath,"111.jpg");
		//if(image.exists())
		BufferedImage bimg = ImageIO.read(image);
		Graphics g2d = bimg.getGraphics();
		
		//作畫(樣式,粗細)
		Font font = new Font(null,Font.BOLD+Font.ITALIC,48);
		//變形
		AffineTransform tran = new AffineTransform();
		//Math.toRadians():徑度,45:字尾(圓心)向上轉45度,-30:字尾向下轉30度
		tran.rotate(Math.toRadians(45),100,0);		
		Font newfont = font.deriveFont(tran);
		
		g2d.setFont(newfont);
		g2d.setColor(Color.blue);
		//從字的下面向上輸出
		g2d.drawString("資策會", 100, 200);

		File outfile = new File(imgpath,"ming.png");
		//得到一個output的方法
		OutputStream out = response.getOutputStream();
		//把圖片以jpeg的格式輸出到servlet上面
		ImageIO.write(bimg, "png", out);
		//將圖片順便傳到資料夾裡
		ImageIO.write(bimg, "png", outfile);
		out.flush();
		out.close();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
