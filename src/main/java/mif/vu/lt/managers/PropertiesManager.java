package mif.vu.lt.managers;
import lombok.Getter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

@Getter
public class PropertiesManager {
	// url props
	public static final String DOMAIN = "www.autoplius.lt/skelbimai/naudoti-automobiliai";
	public static final String MAKE = "make_id";
	public static final String MODEL = "model_id";
	public static final String PRICE_FROM = "sell_price_from";
	public static final String PRICE_TO = "sell_price_to";
	public static final String FUEL = "fuel_id";
	public static final String COUNTRY = "fk_place_countries_id";
	public static final String CITY = "fk_place_cities_id";
	
	private enum UserOpt {
		MAKE("mk", true, "make name"),
		MODEL("mdl", true, "model name"),
		PRICE_FROM("pf", false, "car price from"),
		PRICE_TO("pt", false, "car price to"),
		FUEL("f", false, "fuel type"),
		COUNTRY("c", false, "country"),
		CITY("t", false, "town");
		
		private final String option;
		private final Boolean hasArg;
		private final String description;
		
		UserOpt(String opt, boolean hasArg, String description) { 
			this.option = opt;
			this.hasArg = hasArg;
			this.description = description;
		}
	}
	// command line options
	private CommandLine cmd;
	
	public PropertiesManager(String[] args) {
    	Options options = new Options();
    	CommandLineParser parser = new DefaultParser();
    	for (UserOpt opt : UserOpt.values()) {
    		options.addOption(opt.option, opt.hasArg, opt.description);
    	}
    	try {
    		cmd = parser.parse(options, args);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasMake() {
		String opt = UserOpt.MAKE.option;
		return cmd.hasOption(opt);
	}
	
	public boolean hasModel() {
		String opt = UserOpt.MODEL.option;
		return cmd.hasOption(opt);
	}
	
	public boolean hasPriceFrom() {
		String opt = UserOpt.PRICE_FROM.option;
		return cmd.hasOption(opt);
	}
	
	public boolean hasPriceTo() {
		String opt = UserOpt.PRICE_TO.option;
		return cmd.hasOption(opt);
	}
	
	public boolean hasFuel() {
		String opt = UserOpt.FUEL.option;
		return cmd.hasOption(opt);
	}
	
	public boolean hasCountry() {
		String opt = UserOpt.COUNTRY.option;
		return cmd.hasOption(opt);
	}
	
	public boolean hasCity() {
		String opt = UserOpt.CITY.option;
		return cmd.hasOption(opt);
	}
	
	public String getMake() {
		if (hasMake()) return UserOpt.MAKE.option;
		return null;
	}
	
	public String getModel() {
		if (hasModel()) return UserOpt.MODEL.option;
		return null;
	}
	
	public String getPriceFrom() {
		if (hasPriceFrom()) return UserOpt.PRICE_FROM.option;
		return null;
	}
	
	public String getPriceTo() {
		if (hasPriceTo()) return UserOpt.PRICE_TO.option;
		return null;
	}
	
	public String getFuel() {
		if (hasFuel()) return UserOpt.FUEL.option;
		return null;
	}
	
	public String getCountry() {
		if (hasCountry()) return UserOpt.COUNTRY.option;
		return null;
	}
	
	public String getCity() {
		if (hasCity()) return UserOpt.CITY.option;
		return null;
	}
}
