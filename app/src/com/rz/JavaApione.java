package com.rz;
import java.io.IOException;
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

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class JavaApi
 */
@WebServlet("/JavaApione")
public class JavaApione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaApione() {
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
//		String usersid=request.getParameter("usersid"); 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");		
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","PUT, GET, POST, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers","X-Requested-With");
		response.setHeader("Access-Control-Allow-Headers","Content-Type");
		System.out.print(rnum);
//		System.out.print(usersid);
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
				case "9":getxianqqing(request,response);break;
				case "10":chiwhat(request,response);break;
				case "11":tuijianmusic(request,response);break;
				case "12":getNewsxiangqing(request,response);break;
				case "13":getschoolNews(request,response);break;
				case "14":schoolNewsXiangq(request,response);break;
				case "15":useradd(request,response);break; 
				case "16":userlogin(request,response);break;
				case "17":kuaiditijiao(request,response);break;
				case "18":kuaidilist(request,response);break;
				case "19":kuaidixiangqing(request,response);break;
				case "20":lqdingdan(request,response);break;
				case "21":mydingdanlist(request,response);break;
				case "22":dingdanwc(request,response);break;
				case "23":dingdanpj(request,response);break;
			}
		}
		else {
			response.getWriter().write("{\"result\":\"nodata\"}");
		}
		
		
	}
	
	//9分别获取趣闻里面的内容
		protected void getxianqqing(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			String typeid=request.getParameter("typeid");
			DBHelper Dal=new DBHelper();
			String strSql=" select * from hheasy where 	HHtypeid=? order by id desc"; 
			List<Object> params = new ArrayList<Object>();
			List<Map<String, Object>> objbyid = null;
			params.add(typeid);
			
			try {
				objbyid=Dal.executeQuery(strSql, params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String jsonstr =JSON.toJSONString(objbyid); 
			response.getWriter().write(jsonstr);	
		}
	 //10吃什么随机获取图片
		protected void chiwhat(HttpServletRequest request, HttpServletResponse response) throws IOException
		{ 
			DBHelper Dal=new DBHelper();
			String strSql="select  *  from  eatwhat order by rand() limit 6"; 
			List<Object> params = new ArrayList<Object>();
			List<Map<String, Object>> objbyid = null;
			try {
				objbyid=Dal.executeQuery(strSql, params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String jsonstr =JSON.toJSONString(objbyid); 
			response.getWriter().write(jsonstr);	
		}
		//11音乐随机获取
				protected void tuijianmusic(HttpServletRequest request, HttpServletResponse response) throws IOException
				{ 
					DBHelper Dal=new DBHelper();
					String strSql="select  *  from  music order by rand() limit 1"; 
					List<Object> params = new ArrayList<Object>();
					List<Map<String, Object>> objbyid = null;
					try {
						objbyid=Dal.executeQuery(strSql, params);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);	
				}
		//12获取趣闻详情
				protected void getNewsxiangqing(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					String id=request.getParameter("id"); 
					DBHelper Dal=new DBHelper();
					String strSql=" select * from hheasy where id=? "; 
					List<Object> params = new ArrayList<Object>();
					params.add(id);
					Map<String, Object> objbyid = null;
					objbyid=Dal.getSingleObject(strSql, params);
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);	
				}
	   //13获取校园新闻列表
				protected void getschoolNews(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					DBHelper Dal=new DBHelper();
					String strSql=" select * from schoolNews"; 
					List<Object> params = new ArrayList<Object>();
					List<Map<String, Object>> objbyid = null;
					try {
						objbyid=Dal.executeQuery(strSql, params);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);	
				}
		//14获取校园新闻详情
				protected void schoolNewsXiangq(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					String id=request.getParameter("id"); 
					DBHelper Dal=new DBHelper();
					String strSql=" select * from schoolNews where id=? "; 
					List<Object> params = new ArrayList<Object>();
					params.add(id);
					Map<String, Object> objbyid = null;
					objbyid=Dal.getSingleObject(strSql, params);
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);	
				}
		//15新用户注册
				protected void useradd(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
//					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//					String createtime=df.format(new Date());//获取当前系统时间
					DBHelper Dal=new DBHelper();
					String newuser=request.getParameter("newuser"); 
					String usersid=request.getParameter("usersid"); 
					String pwd=request.getParameter("pwd");
					String useremail=request.getParameter("useremail");
					String strSql1="select * from schoolusers where usersid=?";
					List<Object> params2 = new ArrayList<Object>();
					params2.add(usersid);
					List<Map<String, Object>> listall = null;
					try {
						listall=Dal.executeQuery(strSql1, params2);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if(listall.size()>0)
					{
						 response.getWriter().write("{\"result\":\"2\"}");
					}
					else
					{
						  String strSql="insert into schoolusers (newuser,usersid,pwd,useremail) values (?,?,?,?)";
						    List<Object> params = new ArrayList<Object>();
							params.add(newuser);
							params.add(usersid);
							params.add(pwd);
						    params.add(useremail);
						    //params.add(createtime);
						   
						    Dal.excuteSql(strSql, params);
						    response.getWriter().write("{\"result\":\"1\"}");
					}
					
				   
				}
		//16新用户登录
				protected void userlogin(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					String usersid=request.getParameter("usersid"); 
					String pwd=request.getParameter("pwd"); 
					DBHelper Dal=new DBHelper();
					String strSql=" select * from schoolusers where usersid=? AND pwd=?"; //验证用户账号和密码
					List<Object> params = new ArrayList<Object>();
					params.add(usersid);
				    params.add(pwd);
				    Map<String, Object> objbyid = null;
					objbyid=Dal.getSingleObject(strSql, params);
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);
					
				}
				
		//17快递任务提交
				protected void kuaiditijiao(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					SimpleDateFormat tj = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String tjtime=tj.format(new Date());
					String kuaididian=request.getParameter("kuaididian");
					String ldh=request.getParameter("ldh");
					String ceng=request.getParameter("ceng");
					String zhongxing=request.getParameter("zhongxing");
					String daxing=request.getParameter("daxing");
					String jiawei=request.getParameter("jiawei");
					String islq="1";
					String iswc="1";
					String isfabu="1";
				    String steSql="insert into tbkuaidi (kuaididian,ldh,ceng,zhongxing,daxing,jiawei,tjtime,islq,iswc,isfabu) values(?,?,?,?,?,?,?,?,?,?)";
				    List<Object> params =new ArrayList<Object>();
					params.add(kuaididian);
					params.add(ldh);
					params.add(ceng);
					params.add(zhongxing);
					params.add(daxing);
					params.add(jiawei);
					params.add(tjtime);
					params.add(islq);
					params.add(iswc);
					params.add(isfabu);
					DBHelper Dal=new DBHelper();
					Dal.excuteSql(steSql, params);
					response.getWriter().write("{\"result\":\"ok\"}");	
				}
			//18获取快递订单列表
				protected void kuaidilist(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					DBHelper Dal=new DBHelper();
					String strSql=" select * from tbkuaidi where islq=1"; 
					List<Object> params = new ArrayList<Object>();
					List<Map<String, Object>> objbyid = null;
					try {
						objbyid=Dal.executeQuery(strSql, params);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);	
				}
				//19获取快递订单详情
				protected void kuaidixiangqing(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					String id=request.getParameter("id"); 
					DBHelper Dal=new DBHelper();
					String strSql=" select * from tbkuaidi where id=?"; 
					List<Object> params = new ArrayList<Object>();
					params.add(id);
					Map<String, Object> objbyid = null;
					objbyid=Dal.getSingleObject(strSql, params);
					String jsonstr =JSON.toJSONString(objbyid); 
					response.getWriter().write(jsonstr);
				}
//				20领确订单
				protected void lqdingdan(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					String id=request.getParameter("kuaiid"); 
					DBHelper Dal=new DBHelper();
					String sql=" update tbkuaidi set islq=0 where id="+id+""; 
					List<Object> params = new ArrayList<Object>();
					Dal.excuteSql(sql, params);
					response.getWriter().write("{\"result\":\"ok\"}");
				}
//				21我的订单列表
				protected void mydingdanlist(HttpServletRequest request, HttpServletResponse response) throws IOException
				{
					String meberid=request.getParameter("meberid"); 		  
					DBHelper Dal=new DBHelper();   //构造一个DAL对象
					String strSql=" select * from tbkuaidi where isfabu=1 and meberid=?";
					String strSql2=" select * from tbkuaidi where islq=0 and meberid=?";
					String strSql3=" select * from tbkuaidi where meberid=? ";
					List<Object> params = new ArrayList<Object>();
					params.add(meberid);
					System.out.print(meberid);
					List<Map<String, Object>> listpage = null;
					List<Map<String, Object>> listpage2 = null;
					List<Map<String, Object>> listpage3 = null;
					try {
						listpage=Dal.executeQuery(strSql, params);
						listpage2=Dal.executeQuery(strSql2, params);
						listpage3=Dal.executeQuery(strSql3, params);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					Dingdanlist objList=new Dingdanlist();
					objList.list1=listpage;
					objList.list2=listpage2;
					objList.list3=listpage3;
					String jsonstr =JSON.toJSONString(objList); 
					response.getWriter().write(jsonstr);
					}	
//				22确认订单完成
				protected void dingdanwc(HttpServletRequest request, HttpServletResponse response) throws IOException
				{ 		
					String id=request.getParameter("tasksid"); 
					DBHelper Dal=new DBHelper();
					String sql=" update tbkuaidi set iswc=2 where id=? "; 
					List<Object> params = new ArrayList<Object>();
					params.add(id);
					Dal.excuteSql(sql, params);
					response.getWriter().write("{\"result\":\"ok\"}");
				}	
				//23上传评价10//计算 总积分
				protected void dingdanpj(HttpServletRequest request, HttpServletResponse response) throws IOException
				{ 	
					String meberid=request.getParameter("meberid");
					DBHelper Dal=new DBHelper();
					List<Object> params = new ArrayList<Object>();    //构造参数对象	    	
					String id=request.getParameter("tasksid"); 
					String pingjia=request.getParameter("pingjia"); 
					String jifen=request.getParameter("jifen");  
				    String strSql="update tbkuaidi set pingjia='"+pingjia+"',jifen='"+jifen+"' where id="+id+"";     
				    Dal.excuteSql(strSql, params);   //执行sql语句
				    
				  //计算并更新总积分			
					String strsql1="select sum(jifen) as aa from tbkuaidi where meberid="+meberid+" and islq=0";
					Map<String, Object> objbyid = null; 			
					objbyid=Dal.getSingleObject(strsql1, params);			
					String pxjf=objbyid.get("aa").toString();
					String strsql2="update tbkuaidi set pxjf='"+pxjf+"' where meberid="+meberid+" ";
					Dal.excuteSql(strsql2, params);
					//更新评价积分
				    response.getWriter().write("{\"result\":\"ok\"}");
				}	
		
	
	//上传图片
	protected void imgsadd(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createtime=df.format(new Date());//获取当前系统时间		
		String title=request.getParameter("title"); 
		String imgtxt=request.getParameter("imgtxt"); //存取图片base64位编码字符串
		String details=request.getParameter("details"); 
		
	    String strSql="insert into tbimgs (title,ctime,imgtxt,details) values (?,?,?,?)";
	    List<Object> params = new ArrayList<Object>();
		params.add(title);
		params.add(createtime);
		params.add(imgtxt);
	    params.add(details);	    
	    DBHelper Dal=new DBHelper();
	    Dal.excuteSql(strSql, params);
	    response.getWriter().write("{\"result\":\"ok\"}");
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
		
		