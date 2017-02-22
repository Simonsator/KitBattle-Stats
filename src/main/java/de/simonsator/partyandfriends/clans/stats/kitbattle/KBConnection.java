package de.simonsator.partyandfriends.clans.stats.kitbattle;

import de.simonsator.partyandfriends.communication.sql.SQLCommunication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author Simonsator
 * @version 1.0.0 30.11.16
 */
public class KBConnection extends SQLCommunication {
	protected KBConnection(String pDatabase, String pURL, String pUserName, String pPassword, boolean pUseSSL) {
		super(pDatabase, pURL, pUserName, pPassword, pUseSSL);
	}

	public PlayerData getPlayerData(UUID pUUID) {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement prepStmt = null;
		try {
			prepStmt = con.prepareStatement(
					"SELECT Coins, Kills, Deaths, Exp FROM `" + DATABASE + "`.`kitbattle_` WHERE player_uuid=? LIMIT 1");
			prepStmt.setString(1, pUUID.toString());
			rs = prepStmt.executeQuery();
			if (rs.next())
				return new PlayerData(rs.getInt("Kills"), rs.getInt("Deaths"), rs.getInt("Coins"),
						rs.getInt("Exp"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, prepStmt);
		}
		return null;
	}
}
