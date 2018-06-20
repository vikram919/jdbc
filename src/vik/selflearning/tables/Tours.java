package vik.selflearning.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {
	public static void displayData(ResultSet rs) throws SQLException {
		while(rs.next()) {
			StringBuffer sb = new StringBuffer();
			sb.append("Tour: "+rs.getInt("tourId")+":");
			sb.append(rs.getString("tourName"));
			double price = rs.getDouble("price");
			NumberFormat nf = NumberFormat.getInstance();
			String formattedPrice = nf.format(price);
			sb.append("("+formattedPrice+")");
			System.out.println(sb.toString());
		}
	}
}
