package cn.fosu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.fosu.dao.SP_infoDao;
import cn.fosu.javabean.SP_info;
import cn.fosu.util.FosuJDBCUtil;

public class SP_infoDaoImpl implements SP_infoDao {

	public List<SP_info> getSP_infoList(String type, String sous_info, String id) {//定义一个方法得List<SP_info>对象
		// TODO Auto-generated method stub
		ResultSet rs = null;
		List<SP_info> sp_info_list = new ArrayList<SP_info>();//声明初始化一个List<SP_info>变量sp_info_list
		
		if (id != null) {											//判断输入有无ID即点击图片，有则通id查库放rs
			String sql = "select * from sp_info where id=?";
			String info[] = { id };
			rs = FosuJDBCUtil.executeQuery(sql, info);

			try {
				forInfo(rs, sp_info_list);				//将rs中的数据遍历到sp_info_list中
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
					FosuJDBCUtil.close(FosuJDBCUtil.getCt(), FosuJDBCUtil.getPs(), rs);
					}
		}
 
		else {

			if (sous_info == null) {
				String sql = "select * from sp_info;";
				rs = FosuJDBCUtil.executeQuery(sql, null);

			} else {
				String sql2 = "select * from sp_info where sp_info like '%"
						+ sous_info + "%'" + " and sp_type='" + type + "'";
				// System.out.println(sql);
				rs = FosuJDBCUtil.executeQuery(sql2, null);
			}

			try {
				forInfo(rs, sp_info_list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// List<SP_info> sp_info_list = new ArrayList<SP_info>();

			for (SP_info sp_info : sp_info_list) {
				System.out.println(sp_info);
			}
			// return sp_info_list;

		 
		}
		return sp_info_list;
	}

	// 封装一个遍历数据
	public void forInfo(ResultSet rs, List<SP_info> sp_info_list)
			throws SQLException {

		while (rs.next()) {//有下一个就是真
			SP_info sp_info = new SP_info();
			sp_info.setId(rs.getInt("id"));
			sp_info.setSp_type(rs.getInt("sp_type"));
			sp_info.setSp_name(rs.getString("sp_name"));
			sp_info.setOld_price(rs.getString("old_price"));
			sp_info.setNew_price(rs.getString("new_price"));
			sp_info.setSp_info(rs.getString("sp_info"));
			sp_info.setSp_img(rs.getString("sp_img"));
			sp_info_list.add(sp_info);
		}
	}

	@Override
	public List<SP_info> deletcSP_infoList(String type, String sous_info,
			String id) {
		// TODO Auto-generated method stub
		return null;
	}
}