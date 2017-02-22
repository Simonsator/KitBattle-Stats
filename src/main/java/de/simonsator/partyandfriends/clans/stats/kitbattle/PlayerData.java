package de.simonsator.partyandfriends.clans.stats.kitbattle;

/**
 * @author simonbrungs
 * @version 1.0.0 30.11.16
 */
public class PlayerData {
	public final int BOMB_PLANTED;
	public final int COINS;
	public final int DEATHS;
	public final int KILLS;

	public PlayerData(int kills, int deaths, int pCoins, int pExp) {
		KILLS = kills;
		DEATHS = deaths;
		COINS = pCoins;
		BOMB_PLANTED = pExp;
	}
}
