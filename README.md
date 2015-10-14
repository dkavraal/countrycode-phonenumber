# countrycode-phonenumber
Extract the country code information from an ordinary phone number

* The length of the phone number isn't important.
* The number doesn't have to obey the belonging country's rules. The country prefix is enough.


## Sample 1 (Country)

(no other initialization or sth needed other than this: )
```java
    System.out.println(CountryCodeMatcher.getCountry("12355555").getName());
```
will print out:

    US/CA

or, this
```java
    System.out.println(CountryCodeMatcher.getCountry("72355555").getName());
```
    KZ/RU

## Sample 2 (Country)

These are ridiculous numbers and their output when tried.
  
    812355555   > JP
    99611111    > KG
    90212545455 > TR
    9761515151  > MN
    44148112131 > GG
    ...
  

## Sample 3 (City)

The project doesn't contain information for cities. But, you can use it if you have the data already.
For instance:
```java
    System.out.println(CityCodeMatcher.getCity("9021233333333333").getName());
    System.out.println(CityCodeMatcher.getCity("9021633333333333").getName());
```
would give

    Istanbul (Europe)
    Istanbul (Asia)
  
If you have prefices for cities or data alike, you can edit [com.dkavraal.countrycode.data.CityDataContainer](https://github.com/dkavraal/countrycode-phonenumber/blob/master/src/com/dkavraal/countrycode/data/CityDataContainer.java) There are already samples in the file.
