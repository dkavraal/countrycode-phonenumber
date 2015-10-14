package com.dkavraal.countrycode;

import com.dkavraal.countrycode.data.CityDataContainer;
import com.dkavraal.countrycode.types.Location;

public class CityCodeMatcher {
	private static PhoneCodeTree _instance = null;
	private static void _instantiate() {
		if (null == _instance) {
			_instance = new PhoneCodeTree();
			CityDataContainer.fillCountryData(_instance);
		}
	}
	
	public static Location getCity(String phoneNumber) {
		_instantiate();
		return _instance._getLocation(phoneNumber, _instance);
	}
	
	public static void test() {
		assert(getCity("902125554433").getName() == "Istanbul (Europe)");
	}
	
}
