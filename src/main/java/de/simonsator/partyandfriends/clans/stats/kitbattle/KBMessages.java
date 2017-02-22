package de.simonsator.partyandfriends.clans.stats.kitbattle;

import de.simonsator.partyandfriends.utilities.Language;
import de.simonsator.partyandfriends.utilities.LanguageConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 30.11.16
 */
public class KBMessages extends LanguageConfiguration {

	public KBMessages(Language pLanguage, File pFile) throws IOException {
		super(pLanguage, pFile);
		readFile();
		loadDefaultValues();
		saveFile();
		process(configuration);
	}

	private void loadDefaultValues() {
		set("ClanStats.Name", "KitBattle");
		set("ClanStats.Exp", "&7The players in the clan gained &a[EXP] &7exp.");
		set("ClanStats.Coins", "&7The players in the clan have &a[COINS] &7in total.");
		set("ClanStats.Kills", "&7The players in the clan killed &a[KILLS]&7 players.");
		set("ClanStats.Deaths", "&7The players in the clan died &c[DEATHS] &7times.");
	}

	public void reloadConfiguration() throws IOException {
		configuration = (new KBMessages(LANGUAGE.OWN, FILE)).getCreatedConfiguration();
	}
}
