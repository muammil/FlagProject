package com.quiz.flag;

import java.util.ArrayList;
import java.util.List;

/**
*
* Enum for Countries.
* @author Muammil
*/
public enum Countries {
  ANDORRA("Andorra", R.drawable.andorra),
  ARGENTINA("Argentina", R.drawable.argentina),
  ARMENIA("Armenia", R.drawable.armenia),
  AZEBAIJAN("Azebaijan", R.drawable.azebaijan),
  BANGLADESH("Bangladesh", R.drawable.bangladesh),
  BOLIVIA("Bolivia", R.drawable.bolivia),
  BRAZIL("Brazil", R.drawable.brazil),
  BRITAIN("Britain", R.drawable.britain),
  CAMERON("Cameron", R.drawable.cameron),
  CANADA("Canada", R.drawable.canada),
  CHILE("Chile", R.drawable.chile),
  COLOMBIA("Colombia", R.drawable.colombia),
  CZECH("Czech Republic", R.drawable.czech_republic),
  DENMARK("Denmark", R.drawable.denmark),
  ESTONIA("Estonia", R.drawable.estonia),
  FRANCE("France", R.drawable.france),
  GERMANY("Germany", R.drawable.germany),
  GREECE("Greece", R.drawable.greece),
  GUINEA("Guinea", R.drawable.guinea),
  HAITI("Haiti", R.drawable.haiti),
  HUNGARY("Hungary", R.drawable.hungary),
  ICELAND("Iceland", R.drawable.iceland),
  INDIA("India", R.drawable.india),
  INDONESIA("Indonesia", R.drawable.indonesia),
  IRELAND("Ireland", R.drawable.ireland),
  ITALY("Italy", R.drawable.italy),
  JAMAICA("Jamaica", R.drawable.jamaica),
  JAPAN("Japan", R.drawable.japan),
  KUWAIT("Kuwait", R.drawable.kuwait),
  LATVIA("Latvia", R.drawable.latvia),
  LITHUANIA("Lithuania", R.drawable.lithuania),
  LUXEMBOURG("Luxembourg", R.drawable.luxembourg),
  MACEDONIA("Macedonia", R.drawable.macedonia),
  MALAYSIA("Malaysia", R.drawable.malaysia),
  MALI("Mali", R.drawable.mali),
  NETHERLANDS("Netherlands", R.drawable.netherlands),
  PAKISTAN("Pakistan", R.drawable.pakistan),
  PANAMA("Panama", R.drawable.panama),
  PHILIPPINES("Philippines", R.drawable.philippines),
  POLAND("Poland", R.drawable.poland),
  PORTUGAL("Portugal", R.drawable.portugal),
  ROMANIA("Romania", R.drawable.romania),
  SANMARINO("San Marino", R.drawable.san_marino),
  SENEGAL("Senegal", R.drawable.senegal),
  SERBIA("Serbia", R.drawable.serbia_and_montegro),
  SLOVAKIA("Slovakia", R.drawable.slovakia),
  SLOVENIA("Slovenia", R.drawable.slovenia),
  SOUTHAFRICA("South Africa", R.drawable.south_africa),
  SOUTHKOREA("South Korea", R.drawable.south_korea),
  SPAIN("Spain", R.drawable.spain),
  SRILANKA("Sri Lanka", R.drawable.sri_lanka),
  SUDAN("Sudan", R.drawable.sudan),
  SWEDEN("Sweden", R.drawable.sweden),
  TANZANIA("Tanzania", R.drawable.tanzania),
  TOGO("Togo", R.drawable.togo),
  TRINIDAD("Trinidad and Tobago", R.drawable.trinidad_and_tobago),
  TUNISIA("Tunisia", R.drawable.tunisia),
  TURKEY("Turkey", R.drawable.turkey),
  UGANDA("Uganda", R.drawable.uganda),
  UKRAIN("Ukrain", R.drawable.ukrain),
  USA("United States", R.drawable.united_states),
  URUGUAY("Uruguay", R.drawable.uruguay),
  VENEZUELA("Venezuela", R.drawable.venezuela),
  WALES("Wales", R.drawable.wales),
  YEMEN("Yemen", R.drawable.yemen),
  ZIMBABWE("Zimbabwe", R.drawable.zimbabwe);

  private final String name;
  private final int drawableId;

  private Countries(String name, int drawableId) {
    this.name = name;
    this.drawableId = drawableId;
  }

  public String getName() {
    return name;
  }

  public int getDrawableId() {
    return drawableId;
  }

  public static List<Countries> getAllCountries() {
    List<Countries>  countries = new ArrayList<Countries>();
    for (Countries country : values()) {
      countries.add(country);
    }
    return countries;
  }
}
