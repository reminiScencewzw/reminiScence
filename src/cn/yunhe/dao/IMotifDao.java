package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Motif;

public interface IMotifDao {

	/**
	 * 	鏌ヨ鎵�鏈夌殑涓婚鍒楄〃
	 * @return
	 */
	List<Motif> queryMotifList();
	
	/**
	 * 	鏍规嵁ID鏌ョ湅涓婚淇℃伅
	 * @param id
	 * @return
	 */
	Motif queryMotifById(int id);
	
	/**
	 * 	鏍规嵁ID鍒犻櫎涓婚
	 * @param id
	 * @return
	 */
	int delMotifById(String state,int id);
	
	/**
	 * 	娣诲姞涓婚
	 * @param motif
	 * @return
	 */
	int addMotif(Motif motif);
	
	/**
	 * 鑾峰彇鎬绘潯鏁�
	 * @return
	 */
	int getCount();
	
	/**
	 * 	鍒嗛〉鏌ヨ
	 * @param pageCount
	 * 		姣忛〉瑕佸睍绀虹殑鏁版嵁鏉℃暟
	 * @param pageIndex
	 * 		椤电爜鏁�
	 * @return
	 */
	List<Motif> queryMotifList(int pageCount,int pageIndex);
	int changeMotifName(int id,String name);
}
