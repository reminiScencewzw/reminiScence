package cn.yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.IMotifDao;
import cn.yunhe.entity.Motif;
import cn.yunhe.utils.DBUtils;

public class MotifImpl implements IMotifDao {

	@Override
	public List<Motif> queryMotifList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Motif> motifList = new ArrayList<Motif>();
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,motif,create_date,state from t_motif";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Motif motif = new Motif();
				motif.setId(rs.getInt(1));
				motif.setMotif(rs.getString(2));
				motif.setCreate_date(rs.getTimestamp(3));
				motif.setState(rs.getString(4));
				motifList.add(motif);
			}
			return motifList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public Motif queryMotifById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,motif,create_date,state from t_motif where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Motif motif = new Motif();
				motif.setId(rs.getInt(1));
				motif.setMotif(rs.getString(2));
				motif.setCreate_date(rs.getTimestamp(3));
				motif.setState(rs.getString(4));
				return motif;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int delMotifById(String state,int id) {
		String sql = "update t_motif set state=? where id=?";
		Object[] objects = {state,id};
		return DBUtils.cudPre(sql, objects);
	}

	@Override
	public int addMotif(Motif motif) {
		String sql = "insert into t_motif(motif) values(?)";
		return DBUtils.cudPre(sql, motif.getMotif());
	}

	@Override
	public int getCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select count(id) from t_motif";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return 0;
	}

	@Override
	public List<Motif> queryMotifList(int pageCount, int pageIndex) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Motif> motifList = new ArrayList<Motif>();
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,motif,create_date,state from t_motif limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageIndex-1)*pageCount);
			ps.setInt(2, pageCount);
			rs = ps.executeQuery();
			while(rs.next()) {
				Motif motif = new Motif();
				motif.setId(rs.getInt(1));
				motif.setMotif(rs.getString(2));
				motif.setCreate_date(rs.getTimestamp(3));
				motif.setState(rs.getString(4));
				motifList.add(motif);
			}
			return motifList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int changeMotifName(int id, String name) {
		String sql = "update t_motif set motif=? where id=?";
		Object[] objects = {name,id};
		return DBUtils.cudPre(sql, objects);
	}

}
