package tw.ming.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet21img")
public class servlet21img extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=utf-8");
		response.setContentType("image/jpeg");
		String rate = request.getParameter("rate");
		float floatrate =Float.parseFloat(rate);
		//設定長寬與樣式
		BufferedImage bimg = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		//製作2d圖示
		Graphics2D g2d = bimg.createGraphics();
		//設定顏色
		g2d.setColor(Color.YELLOW);
		//設定顏色充滿區域(座標0,0到400,20)
		g2d.fillRect(0, 0, 400, 20);
		
		//設定顏色(再把紅色疊上去)
		g2d.setColor(Color.red);
		//設定顏色充滿區域(座標0,0到200,20)
		//可利用:servlet/servlet21?rate=23(多少百分比):可畫出占有23%的圖
		g2d.fillRect(0, 0, (int)(400*floatrate/100), 20);
		//得到一個output的方法
		OutputStream out = response.getOutputStream();
		//把圖片以jpeg的格式輸出到servlet上面
		ImageIO.write(bimg, "jpeg", out);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
