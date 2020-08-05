package kr.or.ddit.widu.dao.shop;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import kr.or.ddit.widu.vo.shop.Shop_RubbyVO;

public class ShopDao implements IShopDao{

	private SqlMapClient smc;
	private static IShopDao shop;
	
	public static IShopDao getInstance() {
		if(shop == null) {
			shop = new ShopDao();
		}
		
		return shop;
	}
	
	private ShopDao() {
		Reader rd;
		try {
			Charset charset = Charset.forName("UTF-8"); // 설정파일의 인코딩 설정
			
			Resources.setCharset(charset);
			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // Reader객체 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Shop_ItemVO> selectAllItems(Map<String, String> params) {
		List<Shop_ItemVO> list = null;
		
		try {
			list = smc.queryForList("shop.selectAllItems", params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertItem(Shop_ItemVO itemInfo) {
		int chk = 0;
		try {
			Object obj = smc.insert("shop.insertItem", itemInfo);
			if (obj == null) {
				chk = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public int modifyItem(Shop_ItemVO itemInfo) {
		int chk = 0;
		
		try {
			chk = smc.update("shop.modifyItem", itemInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public int deleteItem(Map<String, String> params) {
		int chk = 0;
		
		try {
			chk = smc.delete("shop.deleteItem", params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<Shop_RubbyVO> rubyselectallitems(Map<String, String> params) {
		List<Shop_RubbyVO> list = new ArrayList<Shop_RubbyVO>();
		
		try {
			list = smc.queryForList("shop.rubyselectallitems", params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int rubyinsertItem(Shop_RubbyVO rubyInfo) {
		
		int chk = 0;
		
		Object obj;
		try {
			obj = smc.insert("shop.rubyinsertItem", rubyInfo);
			
			if (obj == null) {
				chk = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public int rubymodifyItem(Shop_RubbyVO rubyInfo) {
		
		int chk = 0;
		
		try {
			chk = smc.update("shop.rubymodifyItem", rubyInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public int rubydeleteItem(Map<String, String> params) {
		int chk = 0;
		
		try {
			chk = smc.delete("shop.rubydeleteItem", params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<Shop_ItemVO> newItemList() {
		List<Shop_ItemVO> list = null;
		
		try {
			list = smc.queryForList("shop.newItemList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Shop_ItemVO> popularItemList() {
		List<Shop_ItemVO> list = null;
		
		try {
			list = smc.queryForList("shop.popularItemList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Shop_ItemVO itemInfo(Map<String, String> params) {
		Shop_ItemVO itemInfo = null;
		
		try {
			itemInfo = (Shop_ItemVO) smc.queryForObject("shop.itemInfo", params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemInfo;
	}
}
