package com.dkavraal.countrycode;

import java.util.HashMap;
import java.util.Map;

import com.dkavraal.countrycode.types.Country;
import com.dkavraal.countrycode.types.Location;

//@SuppressWarnings("unused")
public class PhoneCodeTree {
	private Country country = null;
	private boolean isPrefix = false;
	private Map<Character, PhoneCodeTree> children = new HashMap<Character, PhoneCodeTree>(5);
	
	private String toString(String prefix) {
		String str = "";
		for (Character C : children.keySet()) {
			PhoneCodeTree child = children.get(C);
			if (child.isPrefix) {
				str += prefix + "  [" + C + "]" + child.country + "\n";
			} else {
				str += prefix + "  [" + C + "]" + "\n";
			}
			str += child.toString(prefix + "  ");
		}
		return str;
	}
	
	public String toString() {
		return toString("");
	}
	
	/*
	private void addChild(Character c, Country country) {
		CountryCodeTree newChild = new CountryCodeTree();
		newChild.country = country;
		newChild.isPrefix = true;
		children.put(c, newChild);
	}*/
	
	public void addChild(String prefix, String countryName) {
		addChild(prefix, new Country(prefix, countryName));
	}
	
	private void addChild(String prefix, Country country) {
		if (prefix.length() == 0) {
			this.country = country;
			isPrefix = true;
			return;
		}
		
		Character c = new Character(prefix.charAt(0));
		PhoneCodeTree leaf = children.get(c);
		if (null != leaf) {
			leaf.addChild(prefix.substring(1), country);
		} else {
			PhoneCodeTree newChild = new PhoneCodeTree();
			children.put(c, newChild);
			newChild.addChild(prefix.substring(1), country);
		}
	}
	
	Location _getLocation(String phoneNumber, PhoneCodeTree _tree) {
//		System.out.print(phoneNumber +  "  > " + _tree.country);
		if (phoneNumber.length() == 0) {
			return _tree.country;
		}
		
//		System.out.print("\t[" + new Character(phoneNumber.charAt(0)) + "]");
		PhoneCodeTree tree = children.get(new Character(phoneNumber.charAt(0)));
		if (tree != null) {
			if (tree.isPrefix) {
//				System.out.println("\t(A)");
				return tree._getLocation(phoneNumber.substring(1), tree);
			} else {
//				System.out.println("\t(B)");
				return tree._getLocation(phoneNumber.substring(1), _tree);
			}
		} else {
//			System.out.println("\t(C)");
			return _tree.country;
		}
	}
	
}
