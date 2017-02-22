package de.simonsator.partyandfriends.clans.stats.kitbattle;

import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0.0 30.11.16
 */
public class KBConfig extends ConfigurationCreator {
	protected KBConfig(File file) throws IOException {
		super(file);
		readFile();
		loadDefaultValues();
		saveFile();
	}

	private void loadDefaultValues() {
		set("database.host", "localhost");
		set("database.port", 3306);
		set("database.db", "minecraft");
		set("database.UseSSL", false);
		set("database.user", "root");
		set("database.password", "password");
	}

	public void reloadConfiguration() throws IOException {
		configuration = (new KBConfig(FILE)).getCreatedConfiguration();
	}
}
