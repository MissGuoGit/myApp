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
@WebServlet("/JavaApi")
public class JavaApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8"); 
			response.setCharacterEncoding("utf-8");
			String rnum=request.getParameter("rnum"); 
			
			response.setContentType("text/json;charset=utf-8");		
			response.setHeader("Access-Control-Allow-Origin","*");//跨域操作
			response.setHeader("Access-Control-Allow-Methods","PUT, GET, POST, DELETE, OPTIONS");
			response.setHeader("Access-Control-Allow-Headers","X-Requested-With");
			response.setHeader("Access-Control-Allow-Headers","Content-Type");
			System.out.print(rnum);
			if(rnum!=null)
			{
				switch(rnum)
				{
					case "1":regUser(request,response);break; 
					case "2":gettasklist(request,response);break;
					case "3":aaaaaaaa(request,response);break;
					case "4":qrrw(request,response);break;
					case "5":faburenwu(request,response);break;
					case "6":mytasklistone(request,response);break;
					case "7":pxb(request,response);break;
					case "8":rwqr(request,response);break;
					case "9":rwwc(request,response);break;
					case "10":pingjia(request,response);break;
					case "11":gerenzhongxin(request,response);break;
				}
			}
			else {
				response.getWriter().write("{\"result\":\"nodata\"}");
			}
		}
		//用户注册
		protected void regUser(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//			String createtime=df.format(new Date());//获取当前系统时间
			
			String username=request.getParameter("username"); 
			String password=request.getParameter("password"); 
			String email=request.getParameter("email"); 
		    String strSql="insert into tbreg (username,password,email) values (?,?,?)";
		    List<Object> params = new ArrayList<Object>();    //构造参数对象
			params.add(username);
			params.add(password);
		    params.add(email);		   
		    DBHelper Dal=new DBHelper();
		    Dal.excuteSql(strSql, params);   //执行sql语句
		    response.getWriter().write("{\"result\":\"ok\"}");
		}
		//领取任务列表
		protected void gettasklist(HttpServletRequest request, HttpServletResponse response) throws IOException
		{					
   		    int currentpage=1;
			int pagesize=10;
			int allpager;
			try
			{
				String p=request.getParameter("p"); 
				currentpage = Integer.valueOf(p);
			}
			catch(Exception e){
				currentpage=1;
			}
			System.out.print(currentpage);
			//查询全部
			String strSql=" select * from tbtask where islq=1 order by shijian desc"; 
			List<Map<String, Object>> listpage1= null;
			try {
				DBHelper Dal=new DBHelper();
				List<Object> params = new ArrayList<Object>();
				listpage1=Dal.executeQuery(strSql, params);	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//分页查询
			int startindex=pagesize*(currentpage-1);//初始
			String strSqlpager=" select * from  tbtask where islq=1 order by shijian desc limit "+startindex+","+pagesize+"";
			strSqlpager=" select * from tbtask where islq=1 order by shijian desc limit "+startindex+","+pagesize+"";
			List<Map<String, Object>> listpage = null;
			try {
				DBHelper Dal=new DBHelper();
				List<Object> params = new ArrayList<Object>();
				listpage=Dal.executeQuery(strSqlpager, params);			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			//就算总页码
			int  allcountpage=listpage1.size();
			if(allcountpage%pagesize==0)
			{
				allpager=(allcountpage/pagesize);
			}
			else{
				allpager=(allcountpage/pagesize)+1;
			}
			
			JsonForPager objList= new JsonForPager();
			objList.datalist=listpage;
			objList.allPage=allpager;
			String jsonstr =JSON.toJSONString(objList); 
			response.getWriter().write(jsonstr);
			
		}
		//领取任务详情列表
		protected void aaaaaaaa(HttpServletRequest request, HttpServletResponse response) 
		{ 
			String id=request.getParameter("tasksid"); 
			DBHelper Dal=new DBHelper();
			String strSql=" select * from tbtask where id=? "; 
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			System.out.print(id);
			Map<String, Object> objbyid = null;
			objbyid=Dal.getSingleObject(strSql, params);
			String jsonstr =JSON.toJSONString(objbyid); 
			try {
				response.getWriter().write(jsonstr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			System.out.print(id);
		}
		//点击确认领取任务   iswc  2代表待确认，3代表已完成，1代表未完成。 islq  0代表领取
		protected void qrrw(HttpServletRequest request, HttpServletResponse response) throws IOException
		{ 		
			String id=request.getParameter("tasksid"); 
			DBHelper Dal=new DBHelper();
			String sql=" update tbtask set islq=0 where id=? "; 
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			Dal.excuteSql(sql, params);
			response.getWriter().write("{\"result\":\"ok\"}");
		}	
		//发布任务
		protected void faburenwu(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String createtime=df.format(new Date());//获取当前系统时间	
			String islq="1";
			String iswc="1";
			String isfabu="1";
			String meberid=request.getParameter("meberid"); 
			String zhuti=request.getParameter("zhuti"); 
			String neirong=request.getParameter("neirong");  
		    String strSql="insert into tbtask (islq,iswc,isfabu,meberid,zhuti,neirong,shijian) values (?,?,?,?,?,?,?)";
		    List<Object> params = new ArrayList<Object>();    //构造参数对象
			params.add(islq);
			params.add(iswc);
		    params.add(isfabu);	
		    params.add(meberid);
		    params.add(zhuti);
			params.add(neirong);
		    params.add(createtime);	
		    DBHelper Dal=new DBHelper();
		    Dal.excuteSql(strSql, params);   //执行sql语句
		    response.getWriter().write("{\"result\":\"ok\"}");
		}
		//我发布领取的任务列表6
		protected void mytasklistone(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			String meberid=request.getParameter("meberid"); 		  
			DBHelper Dal=new DBHelper();   //构造一个DAL对象
			String strSql=" select * from tbtask where isfabu=1 and meberid=?";
			String strSql2=" select * from tbtask where islq=0 and meberid=?";
			String strSql3=" select * from tbtask where meberid=? ";
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
			TaskList objList=new TaskList();
			objList.list1=listpage;
			objList.list2=listpage2;
			objList.list3=listpage3;
			String jsonstr =JSON.toJSONString(objList); 
			response.getWriter().write(jsonstr);
			}	
			
		
		//排行榜
		protected void pxb(HttpServletRequest request, HttpServletResponse response) throws IOException
		{  
			String strSql=" select * from tbtask  order by pxjf  desc"; 
			List<Map<String, Object>> objList= null;
			try {
				DBHelper Dal=new DBHelper();
				List<Object> params = new ArrayList<Object>();
				objList=Dal.executeQuery(strSql, params);	
				String jsonstr =JSON.toJSONString(objList); 
				response.getWriter().write(jsonstr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
		//点击确认领取任务   iswc  2代表待确认，3代表已完成，1代表未完成。 islq  0代表领取   8
		protected void rwqr(HttpServletRequest request, HttpServletResponse response) throws IOException
		{ 		
			String id=request.getParameter("tasksid"); 
			DBHelper Dal=new DBHelper();
			String sql=" update tbtask set iswc=2 where id=? "; 
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			Dal.excuteSql(sql, params);
			response.getWriter().write("{\"result\":\"ok\"}");
		}	
		//点击确认领取任务   iswc  2代表待确认，3代表已完成，1代表未完成。 islq  0代表领取  9
		protected void rwwc(HttpServletRequest request, HttpServletResponse response) throws IOException
		{ 		
			String id=request.getParameter("tasksid"); 
			DBHelper Dal=new DBHelper();
			String sql=" update tbtask set iswc=3 where id=? "; 
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			Dal.excuteSql(sql, params);
			response.getWriter().write("{\"result\":\"ok\"}");
		}	
		//上传评价10//计算 总积分
				protected void pingjia(HttpServletRequest request, HttpServletResponse response) throws IOException
				{ 	
					String meberid=request.getParameter("meberid");
					DBHelper Dal=new DBHelper();
					List<Object> params = new ArrayList<Object>();    //构造参数对象	    	
					String id=request.getParameter("tasksid"); 
					String pingjia=request.getParameter("pingjia"); 
					String jifen=request.getParameter("jifen");  
				    String strSql="update tbtask set pingjia='"+pingjia+"',jifen='"+jifen+"' where id="+id+"";     
				    Dal.excuteSql(strSql, params);   //执行sql语句
				    
				    //计算并更新总积分			
					String strsql1="select jifen from tbtask where meberid=? and islq=0";
					List<Object> params1 = new ArrayList<Object>();
					params1.add(meberid);
					List<Map<String, Object>> listpage = null;
					try {
						listpage=Dal.executeQuery(strsql1, params1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int sumjifen=0;
					for (Map<String, Object> m : listpage)
					{
						sumjifen+=Integer.valueOf(m.get("jifen").toString());
					}
									
					String strsql2="update tbtask set pxjf='"+sumjifen+"' where meberid='"+meberid+"' ";
					Dal.excuteSql(strsql2, params);
					//更新评价积分
				    response.getWriter().write("{\"result\":\"ok\"}");
				}	
			//上传评价11//个人中心
				protected void gerenzhongxin(HttpServletRequest request, HttpServletResponse response) throws IOException
				{ 	
					String meberid=request.getParameter("meberid");
					DBHelper Dal=new DBHelper();
					List<Object> params = new ArrayList<Object>();    //构造参数对象	    	
					String id=request.getParameter("tasksid"); 
					String pingjia=request.getParameter("pingjia"); 
					String jifen=request.getParameter("jifen");  
				    String strSql="update tbtask set pingjia='"+pingjia+"',jifen='"+jifen+"' where id="+id+"";     
				    Dal.excuteSql(strSql, params);   //执行sql语句
				    
				  //计算并更新总积分			
					String strsql1="select sum(jifen) as aa from tbtask where meberid='"+meberid+"' and islq=0";
					Map<String, Object> objbyid = null; 			
					objbyid=Dal.getSingleObject(strsql1, params);			
					String pxjf=objbyid.get("aa").toString();
					String strsql2="update tbtask set pxjf='"+pxjf+"' where meberid='"+meberid+"' ";
					Dal.excuteSql(strsql2, params);
					//更新评价积分
				    response.getWriter().write("{\"result\":\"ok\"}");
				}
	}
  
