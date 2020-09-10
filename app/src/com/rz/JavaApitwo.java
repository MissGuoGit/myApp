package com.rz;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class JavaApi
 */
@WebServlet("/JavaApitwo")
public class JavaApitwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaApitwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8");
		String rnum=request.getParameter("rnum"); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");		
		response.setHeader("Access-Control-Allow-Origin","*");//跨域请求
		response.setHeader("Access-Control-Allow-Methods","PUT, GET, POST, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers","X-Requested-With");
		response.setHeader("Access-Control-Allow-Headers","Content-Type");
		System.out.print(rnum);
		if(rnum!=null)
		{
			switch(rnum)
			{
				case "1":regUser(request,response);break; 
				case "2":getNewsList(request,response);break;
				case "3":getNewsById(request,response);break;
				case "4":getProductList(request,response);break;
				case "5":getProductById(request,response);break;
				case "6":testCaiYun(request,response);break;
				case "7":imgsadd(request,response);break;
				case "8":getimgs(request,response);break;
				case "9":getimgById(request,response);break;
				case "10":pllimgsadd(request,response);break;
				case "11":addcomment(request,response);break;
				case "12":displaycomment(request,response);break;
				case "13":displaydymaic(request, response);break;
				case "14":cxwimgsadd(request, response);break;
				case "15":displaysw(request, response);break;
				case "16":cxwimgsadd2(request, response);break;
				case "17":displaysz(request, response);break;
				case "18":displayxq(request, response);break;
				case "19":displayxq2(request, response);break;
			}
		}
		else {
			response.getWriter().write("{\"result\":\"nodata\"}");
		}
		
		
	}
	
	/**
	 * base64字符串转换成图片
	 * @param imgStr		base64字符串
	 * @param imgFilePath	图片存放路径
	 * @return
	 *
	 * @author ZHANGJL
	 * @dateTime 2018-02-23 14:42:17
	 */
	public static boolean Base64ToImage(String imgStr,String imgFilePath) 
	{ // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr.equals("")) // 图像数据为空
		{
			return false;
		}
		imgStr=imgStr.replaceAll("data:image/png;base64,", "");
		imgStr=imgStr.replaceAll("data:image/jpg;base64,", "");
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//上传图片
	protected void imgsadd(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createtime=df.format(new Date());//获取当前系统时间	
		String title=request.getParameter("title"); 
		String imgtxt=request.getParameter("imgtxt"); 
		String details=request.getParameter("details"); 		
		
		SimpleDateFormat dfforfilename = new SimpleDateFormat("yyyyMMddHHmmsssss");//设置日期格式
		String filename=dfforfilename.format(new Date())+".png";
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		String filepath=realPath+"upload/"+filename;
		Base64ToImage(imgtxt,filepath);
		
	    String strSql="insert into tbimgs (title,ctime,imgtxt,details) values (?,?,?,?)";
	    List<Object> params = new ArrayList<Object>();
		params.add(title);
		params.add(createtime);
		params.add(filename);
	    params.add(details);	    
	    DBHelper Dal=new DBHelper();
	    Dal.excuteSql(strSql, params);
	    response.getWriter().write("{\"result\":\"ok\"}");
	}
	
	//pll上传评论rnum=11
	protected void addcomment(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createtime=df.format(new Date());//获取当前系统时间	
		
		//从前端获取一系列数据
		String cmttid=request.getParameter("cmttid"); 
		String cmdetail=request.getParameter("details"); 
		String cmmemberid=request.getParameter("cmmemberid"); 
		String cmlikecount=request.getParameter("cmlikecount");
		String cmname=request.getParameter("cmname"); 
		String cmheadpicture=request.getParameter("cmheadpicture");
		
		//定义一个查询字符串strsql
	    String strSql="insert into comment (cmttid,cmmemberid,cmtime,cmdetail,cmlikecount,cmname,cmheadpicture) values (?,?,?,?,?,?,?)";
	    //	new一个list 对象
	    List<Object> params = new ArrayList<Object>();
	    params.add(cmttid);
		params.add(cmmemberid);
		params.add(createtime);
		params.add(cmdetail);
	    params.add(cmlikecount);
	    params.add(cmname);
	    params.add(cmheadpicture);
	   
	    DBHelper Dal=new DBHelper();
	    Dal.excuteSql(strSql, params);
	    response.getWriter().write("{\"result\":\"ok\"}");
	}
	

	//pll上传动态rnum=10
	protected void pllimgsadd(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createtime=df.format(new Date());//获取当前系统时间	
		//从前端获取一系列数据
		String ttdymaicpicture=request.getParameter("ttdymaicpicture"); 
		String ttname=request.getParameter("ttname"); 
		
		String ttcontent=request.getParameter("ttcontent"); 
		String ttheadpicture=request.getParameter("ttheadpicture"); 
		String ttmemberid=request.getParameter("ttmemberid"); 
		
		SimpleDateFormat dfforfilename = new SimpleDateFormat("yyyyMMddHHmmsssss");//设置日期格式
		String filename=dfforfilename.format(new Date())+".png";
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		String filepath=realPath+"upload/"+filename;
		Base64ToImage(ttdymaicpicture,filepath);
		
	    String strSql="insert into tt (ttmemberid,ttname,ttheadpicture,tttime,ttcontent,ttdymaicpicture) values (?,?,?,?,?,?)";
	    List<Object> params = new ArrayList<Object>();
	    params.add(ttmemberid);
		params.add(ttname);
		params.add(ttheadpicture);
		params.add(createtime);
	    params.add(ttcontent);	
	    params.add(filename);
	
	    DBHelper Dal=new DBHelper();
	    Dal.excuteSql(strSql, params);
	    response.getWriter().write("{\"result\":\"ok\"}");
	}
	
	//PLL获取动态13
		protected void displaydymaic(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			int currentpage=1;
			int pagesize=10;
			try
			{
				String p=request.getParameter("p"); 
				currentpage = Integer.valueOf(p);
			}
			catch(Exception e){
				currentpage=1;
			}
			DBHelper Dal=new DBHelper();
			//查询全部
			String strSql=" select id from tt order by id desc "; 
			List<Map<String, Object>> listall = null;
			List<Object> params = new ArrayList<Object>();
			try {
				listall=Dal.executeQuery(strSql, params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//分页查询
			int startindex=pagesize*(currentpage-1);
			String strSqlpager=" select * from tt order by id desc limit "+startindex+","+pagesize+""; 
			List<Map<String, Object>> listpage = null;
			try {
				listpage=Dal.executeQuery(strSqlpager, params);	
				PagerJsonForApp p=new PagerJsonForApp();
				p.itemlist=listpage;
				p.RecordCount=listall.size();
				p.PageCount=((listall.size()%pagesize==0)?(listall.size()/pagesize):(listall.size()/pagesize+1));
				p.CurrentPage=currentpage;
				String jsonstr =JSON.toJSONString(p); 
				response.getWriter().write(jsonstr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	//PLL获取评论12
	protected void displaycomment(HttpServletRequest request, HttpServletResponse response) throws IOException
	{


		
		
		String cmttid=request.getParameter("cmttid");
		int currentpage=1;
		int pagesize=10;
		try
		{
			String p=request.getParameter("p"); 
			currentpage = Integer.valueOf(p);
			
		}
		catch(Exception e){
			currentpage=1;
		}
		DBHelper Dal=new DBHelper();
		//查询全部
		String strSql=" select * from comment where cmttid='"+cmttid+"'"; 
		List<Map<String, Object>> listall = null;
		List<Object> params = new ArrayList<Object>();
		try {
			listall=Dal.executeQuery(strSql, params);
			String jsonstr =JSON.toJSONString(listall); 
			response.getWriter().write(jsonstr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//cxw上传失物招领14
	protected void cxwimgsadd(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		//从前端获取一系列数据
		String swname=request.getParameter("swname"); 
		String swdescribe=request.getParameter("swdescribe"); 
		String imgtxt=request.getParameter("imgtxt"); 
		String swplace=request.getParameter("swplace"); 
		String swtel=request.getParameter("swtel"); 
		String swqq=request.getParameter("swqq"); 
		
		SimpleDateFormat dfforfilename = new SimpleDateFormat("yyyyMMddHHmmsssss");//设置日期格式
		String filename=dfforfilename.format(new Date())+".png";
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		String filepath=realPath+"upload/"+filename;
		Base64ToImage(imgtxt,filepath);
		
	    String strSql="insert into sw (swname,swdescribe,swplace,swtel,swqq,swpicture) values (?,?,?,?,?,?)";
	    List<Object> params = new ArrayList<Object>();
	    params.add(swname);
		params.add(swdescribe);
		params.add(swplace);
		params.add(swtel);
	    params.add(swqq);	
	    params.add(filename);
	
	    DBHelper Dal=new DBHelper();
	    Dal.excuteSql(strSql, params);
	    response.getWriter().write("{\"result\":\"ok\"}");
	}
	
	
	//cxw显示失物招领
	protected void displaysw(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		int currentpage=1;
		int pagesize=10;
		try
		{
			String p=request.getParameter("p"); 
			currentpage = Integer.valueOf(p);
		}
		catch(Exception e){
			currentpage=1;
		}
		DBHelper Dal=new DBHelper();
		//查询全部
		String strSql=" select id from sw order by id desc "; 
		List<Map<String, Object>> listall = null;
		List<Object> params = new ArrayList<Object>();
		try {
			listall=Dal.executeQuery(strSql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//分页查询
		int startindex=pagesize*(currentpage-1);
		String strSqlpager=" select * from sw order by id desc limit "+startindex+","+pagesize+""; 
		List<Map<String, Object>> listpage = null;
		try {
			listpage=Dal.executeQuery(strSqlpager, params);	
			PagerJsonForApp p=new PagerJsonForApp();
			p.itemlist=listpage;
			p.RecordCount=listall.size();
			p.PageCount=((listall.size()%pagesize==0)?(listall.size()/pagesize):(listall.size()/pagesize+1));
			p.CurrentPage=currentpage;
			String jsonstr =JSON.toJSONString(p); 
			response.getWriter().write(jsonstr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//cxw上传找失主
		protected void cxwimgsadd2(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String createtime=df.format(new Date());//获取当前系统时间	
			//从前端获取一系列数据
			String swname=request.getParameter("szname"); 
			String swdescribe=request.getParameter("szdescribe"); 
			String imgtxt=request.getParameter("imgtxt"); 
			String swplace=request.getParameter("szplace"); 
			String swtel=request.getParameter("sztel"); 
			String swqq=request.getParameter("szqq"); 
			
			SimpleDateFormat dfforfilename = new SimpleDateFormat("yyyyMMddHHmmsssss");//设置日期格式
			String filename=dfforfilename.format(new Date())+".png";
			String realPath = request.getSession().getServletContext().getRealPath("/");  
			String filepath=realPath+"upload/"+filename;
			Base64ToImage(imgtxt,filepath);
			
		    String strSql="insert into sz (szname,szdescribe,szplace,sztel,szqq,szpicture) values (?,?,?,?,?,?)";
		    List<Object> params = new ArrayList<Object>();
		    params.add(swname);
			params.add(swdescribe);
			params.add(swplace);
			params.add(swtel);
		    params.add(swqq);	
		    params.add(filename);
		
		    DBHelper Dal=new DBHelper();
		    Dal.excuteSql(strSql, params);
		    response.getWriter().write("{\"result\":\"ok\"}");
		}
	//cxw显示寻找失主
		protected void displaysz(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			int currentpage=1;
			int pagesize=10;
			try
			{
				String p=request.getParameter("p"); 
				currentpage = Integer.valueOf(p);
			}
			catch(Exception e){
				currentpage=1;
			}
			DBHelper Dal=new DBHelper();
			//查询全部
			String strSql=" select id from sw order by id desc "; 
			List<Map<String, Object>> listall = null;
			List<Object> params = new ArrayList<Object>();
			try {
				listall=Dal.executeQuery(strSql, params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//分页查询
			int startindex=pagesize*(currentpage-1);
			String strSqlpager=" select * from sz order by id desc limit "+startindex+","+pagesize+""; 
			List<Map<String, Object>> listpage = null;
			try {
				listpage=Dal.executeQuery(strSqlpager, params);	
				PagerJsonForApp p=new PagerJsonForApp();
				p.itemlist=listpage;
				p.RecordCount=listall.size();
				p.PageCount=((listall.size()%pagesize==0)?(listall.size()/pagesize):(listall.size()/pagesize+1));
				p.CurrentPage=currentpage;
				String jsonstr =JSON.toJSONString(p); 
				response.getWriter().write(jsonstr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	//cxw失物详情
		protected void displayxq(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			String id=request.getParameter("id"); 
			DBHelper Dal=new DBHelper();
			String strSql=" select * from sw where id=? "; 
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			Map<String, Object> objbyid = null;
			objbyid=Dal.getSingleObject(strSql, params);
			String jsonstr =JSON.toJSONString(objbyid); 
			response.getWriter().write(jsonstr);	
		}
		//cxw失主详情19
				protected void displayxq2(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					String id=request.getParameter("id"); 
					DBHelper Dal=new DBHelper();
					String strSql=" select * from sz where id=? "; 
					List<Object> params = new ArrayList<Object>();
					params.add(id);
					Map<String, Object> objbyid = null;
					objbyid=Dal.getSingleObject(strSql, params);
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);	
				}
		
			
	//获取图片列表
	protected void getimgs(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		int currentpage=1;
		int pagesize=10;
		try
		{
			String p=request.getParameter("p"); 
			currentpage = Integer.valueOf(p);
		}
		catch(Exception e){
			currentpage=1;
		}
		DBHelper Dal=new DBHelper();
		//查询全部
		String strSql=" select id from tbimgs order by id desc "; 
		List<Map<String, Object>> listall = null;
		List<Object> params = new ArrayList<Object>();
		try {
			listall=Dal.executeQuery(strSql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//分页查询
		int startindex=pagesize*(currentpage-1);
		String strSqlpager=" select * from tbimgs order by id desc limit "+startindex+","+pagesize+""; 
		List<Map<String, Object>> listpage = null;
		try {
			listpage=Dal.executeQuery(strSqlpager, params);	
			PagerJsonForApp p=new PagerJsonForApp();
			p.itemlist=listpage;
			p.RecordCount=listall.size();
			p.PageCount=((listall.size()%pagesize==0)?(listall.size()/pagesize):(listall.size()/pagesize+1));
			p.CurrentPage=currentpage;
			String jsonstr =JSON.toJSONString(p); 
			response.getWriter().write(jsonstr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//根据id获取图片
	protected void getimgById(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String id=request.getParameter("id"); 
		DBHelper Dal=new DBHelper();
		String strSql=" select * from tbimgs where id=? "; 
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		Map<String, Object> objbyid = null;
		objbyid=Dal.getSingleObject(strSql, params);
		String jsonstr =JSON.toJSONString(objbyid); 
		response.getWriter().write(jsonstr);	
	}
		
	
	//财运测试
	protected void testCaiYun(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String jsonstr="{\"a1\": \"您今年运气很好，如果利用课外时间学点程序，说不定有意外的收获，推荐你学习：javascript git vue 微信小程序 nodejs开发。\",	\"a2\": \"您运气还行，但是要克服一些学习上的小毛病，比如你爱睡懒觉的习惯就应该改一改，学习上要多实践，技术学好了，财运自然就来了。\",	\"a3\": \"您上半年运气不是特别好，您的运气来自对象，对你喜欢的人好点，运气自然好转，不要跟喜欢的人吵架，多去看几场电影，元旦和国庆等长假要特别注意交通安全，不开赌气车。\",	\"a4\": \"你幼年孤独，青年勤奋，中年富裕，老年安康，有钱的时候要切记不要浪费，年终红包可以收获很大，一定要把握好机会。\",	\"a5\": \"你的财运方向在西北方向的一座大城市，给你介绍一个人，你可以去寻找他，他会带你飞。\",\"a6\": \"你今年运气666，谁也挡不住您啦，你已经超越神了，实际上你可以考虑去买几注福利彩票。\",	\"a0\": \"这几天你最好小心点。\"}";
		response.getWriter().write(jsonstr);
	}
	
	//用户报名
	protected void regUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createtime=df.format(new Date());//获取当前系统时间
		
		String username=request.getParameter("username"); 
		String tel=request.getParameter("tel"); 
		String contents=request.getParameter("contents"); 
	    String strSql="insert into tbguestbook (username,tel,contents,createtime) values (?,?,?,?)";
	    List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(tel);
	    params.add(contents);
	    params.add(createtime);
	    DBHelper Dal=new DBHelper();
	    Dal.excuteSql(strSql, params);
	    response.getWriter().write("{\"result\":\"ok\"}");
	}
	//获取新闻列表
	protected void getNewsList(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String typeid=request.getParameter("typeid");
		int currentpage=1;
		int pagesize=10;
		try
		{
			String p=request.getParameter("p"); 
			currentpage = Integer.valueOf(p);
		}
		catch(Exception e){
			currentpage=1;
		}
		
		DBHelper Dal=new DBHelper();
		
		//查询全部
		String strSql=" select id from tbnews order by id desc "; 
		if(!(typeid==null||typeid==""))
		{
			strSql=" select id from tbnews where typeid='"+typeid+"' order by id desc "; 
		}
		List<Map<String, Object>> listall = null;
		List<Object> params = new ArrayList<Object>();
		try {
			listall=Dal.executeQuery(strSql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//分页查询
		int startindex=pagesize*(currentpage-1);
		String strSqlpager=" select * from tbnews order by id desc limit "+startindex+","+pagesize+""; 
		if(!(typeid==null||typeid==""))
		{
			strSqlpager=" select * from tbnews where typeid='"+typeid+"' order by id desc limit "+startindex+","+pagesize+""; 
		}
		
		List<Map<String, Object>> listpage = null;
		try {
			listpage=Dal.executeQuery(strSqlpager, params);			
			String jsonstr =JSON.toJSONString(listpage); 
			response.getWriter().write(jsonstr);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//获取新闻详细数据
		protected void getNewsById(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			String id=request.getParameter("id"); 
			DBHelper Dal=new DBHelper();
			String strSql=" select * from tbnews where id=? "; 
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			Map<String, Object> objbyid = null;
			objbyid=Dal.getSingleObject(strSql, params);
			String jsonstr =JSON.toJSONString(objbyid); 
			response.getWriter().write(jsonstr);	
		}
		
		
		//获取产品列表
		protected void getProductList(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			String typeid=request.getParameter("typeid");
			int currentpage=1;
			int pagesize=10;
			try
			{
				String p=request.getParameter("p"); 
				currentpage = Integer.valueOf(p);
			}
			catch(Exception e){
				currentpage=1;
			}
			
			DBHelper Dal=new DBHelper();
			
			//查询全部
			String strSql=" select id from tbproduct order by id desc "; 
			if(!(typeid==null||typeid==""))
			{
				strSql=" select id from tbproduct where typeid='"+typeid+"' order by id desc "; 
			}
			List<Map<String, Object>> listall = null;
			List<Object> params = new ArrayList<Object>();
			try {
				listall=Dal.executeQuery(strSql, params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//分页查询
			int startindex=pagesize*(currentpage-1);
			String strSqlpager=" select * from tbproduct order by id desc limit "+startindex+","+pagesize+""; 
			if(!(typeid==null||typeid==""))
			{
				strSqlpager=" select * from tbproduct where typeid='"+typeid+"' order by id desc limit "+startindex+","+pagesize+""; 
			}
			
			List<Map<String, Object>> listpage = null;
			try {
				listpage=Dal.executeQuery(strSqlpager, params);			
				String jsonstr =JSON.toJSONString(listpage); 
				response.getWriter().write(jsonstr);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		//获取产品详细数据
		protected void getProductById(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			String id=request.getParameter("id"); 
			DBHelper Dal=new DBHelper();
			String strSql=" select * from tbproduct where id=? "; 
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			Map<String, Object> objbyid = null;
			objbyid=Dal.getSingleObject(strSql, params);
			String jsonstr =JSON.toJSONString(objbyid); 
			response.getWriter().write(jsonstr);	
		}

}
