package com.dkavraal.countrycode;

import com.dkavraal.countrycode.data.CountryDataContainer;
import com.dkavraal.countrycode.types.Location;

public class CountryCodeMatcher {
	private static PhoneCodeTree _instance = null;
	private static void _instantiate() {
		if (null == _instance) {
			_instance = new PhoneCodeTree();
			CountryDataContainer.fillCountryData(_instance);
		}
	}
	
	public static Location getCountry(String phoneNumber) {
		_instantiate();
		return _instance._getLocation(phoneNumber, _instance);
	}
	
	public static void test() {
		assert(getCountry("12355555").getName() == "US/CA");
	}
	
	public static void main(String[] args) {
		System.out.println(getCountry("12355555").getName());
	}
}
