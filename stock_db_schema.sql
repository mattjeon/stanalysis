CREATE TABLE stock.company (
  COMPANY_CODE varchar(20) NOT NULL,
  COMPANY_NAME varchar(100) DEFAULT NULL,
  MARKET_KIND varchar(20) DEFAULT NULL COMMENT '0:구분없음, 1:거래소, 2:코스닥, 3:프리보드, 4:KRX',
  INDUSTRY_CODE varchar(20) DEFAULT NULL,
  KOSPI200 varchar(20) DEFAULT NULL,
  SUPERVISION varchar(20) DEFAULT NULL COMMENT '0:일반종목, 1:관리종목',
  CONTROL_KIND varchar(20) DEFAULT NULL COMMENT '0:정상, 1:주의, 2:경고, 3:위험예고, 4:위험',
  STATUS_KIND varchar(20) DEFAULT NULL COMMENT '0:정상, 1:거래정, 2:거래중단',
  LOCK_KIND varchar(20) DEFAULT NULL COMMENT '0:구분없음, 1:권리락, 2:배당락, 3:분배락, 4:권배락, 5:중간배당락, 6:권리중간배당락, 99:기타',
  MARGIN_RATE varchar(20) DEFAULT NULL COMMENT '증거금율',
  MIN_TRADE_UNIT varchar(20) DEFAULT NULL COMMENT '최소매매단위 ',
  CAPITAL varchar(20) DEFAULT NULL COMMENT '0:제외, 1:대, 2:중, 3:소',
  FISCAL_MONTH varchar(20) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (COMPANY_CODE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE stock.company_fundamental (
  COMPANY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  TOTAL_STOCKS int(11) DEFAULT NULL,
  CONTRACT_STRENGTH float DEFAULT NULL,
  PER float DEFAULT NULL,
  EPS float DEFAULT NULL,
  CAPITAL int(11) DEFAULT NULL,
  FACE_VALUE int(11) DEFAULT NULL,
  Y_DEBT_RATIO float DEFAULT NULL,
  Y_RETENTION_RATIO float DEFAULT NULL,
  Y_RETURN_OF_EQUITY float DEFAULT NULL,
  Y_SALES_RISE_RATIO float DEFAULT NULL,
  Y_ORDINARY_PROFIT_RISE_RATIO float DEFAULT NULL,
  Y_NET_PROFIT_RISE_RATIO float DEFAULT NULL,
  INVESTOR_SENTIMENT float DEFAULT NULL,
  VR float DEFAULT NULL,
  FIVE_DAY_TURNOVER float DEFAULT NULL,
  Y_SALES float DEFAULT NULL,
  Y_ORDINARY_PROFIT float DEFAULT NULL,
  Y_TERM_NET_PROFIT float DEFAULT NULL,
  Y_BPS float DEFAULT NULL,
  Y_BUSINESS_PROFIT_RISE_RATIO float DEFAULT NULL,
  Y_BUSINESS_PROFIT float DEFAULT NULL,
  Y_RETURN_ON_NET_SALES float DEFAULT NULL,
  Y_ORDINARY_MARGIN float DEFAULT NULL,
  Y_TIME_INTEREST_EARNED float DEFAULT NULL,
  Y_SETTING_YYYYMM varchar(6) DEFAULT NULL,
  Q_BPS float DEFAULT NULL,
  Q_SALES_RISE_RATIO float DEFAULT NULL,
  Q_BUSINESS_PROFIT_RISE_RATIO float DEFAULT NULL,
  Q_ORDINARY_PROFIT_RISE_RATIO float DEFAULT NULL,
  Q_NET_PROFIT_RISE_RATIO float DEFAULT NULL,
  Q_SALES float DEFAULT NULL,
  Q_BUSINESS_PROFIT float DEFAULT NULL,
  Q_ORDINARY_PROFIT float DEFAULT NULL,
  Q_TERM_NET_PROFIT float DEFAULT NULL,
  Q_RETURN_ON_NET_SALES float DEFAULT NULL,
  Q_ORDINARY_MARGIN float DEFAULT NULL,
  Q_ROE float DEFAULT NULL,
  Q_TIME_INTEREST_EARNED float DEFAULT NULL,
  Q_RETENTION_RATIO float DEFAULT NULL,
  Q_DEBT_RATIO float DEFAULT NULL,
  Q_SETTING_YYYYMM varchar(6) DEFAULT NULL,
  BASIS float DEFAULT NULL,
  CFPS float DEFAULT NULL,
  EBITDA float DEFAULT NULL,
  DEBIT_BALANCE_RATIO float DEFAULT NULL,
  SHORT_STOCK_SELLING_VOL float DEFAULT NULL,
  SHORT_STOCK_SELLING_YM varchar(20) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (COMPANY_CODE,REG_DATE),
  KEY fundamental_idx1 (COMPANY_CODE),
  KEY fundamental_idx2 (REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE stock.company_investors (
  COMPANY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  PERSONAL decimal(20,0) DEFAULT NULL,
  FOREIGNER decimal(20,0) DEFAULT NULL,
  ORG_SUM decimal(20,0) DEFAULT NULL,
  FIN_INVEST decimal(20,0) DEFAULT NULL,
  INSURANCE decimal(20,0) DEFAULT NULL,
  INVEST_TRUST decimal(20,0) DEFAULT NULL,
  BANK decimal(20,0) DEFAULT NULL,
  ETC_FIN decimal(20,0) DEFAULT NULL,
  PENSION decimal(20,0) DEFAULT NULL,
  NATION decimal(20,0) DEFAULT NULL,
  ETC_FOREIGNER decimal(20,0) DEFAULT NULL,
  PRIVATE_FUND decimal(20,0) DEFAULT NULL,
  ETC_CORP decimal(20,0) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (COMPANY_CODE,REG_DATE),
  KEY company_investor_idx1 (COMPANY_CODE),
  KEY company_investor_idx2 (REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE stock.company_price (
  COMPANY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  OPEN_PRICE decimal(10,0) DEFAULT NULL,
  HIGH_PRICE decimal(10,0) DEFAULT NULL,
  LOW_PRICE decimal(10,0) DEFAULT NULL,
  CLOSE_PRICE decimal(10,0) DEFAULT NULL,
  YD_RATIO varchar(20) DEFAULT NULL,
  VOLUME decimal(20,0) DEFAULT NULL,
  UPDOWN_RATIO varchar(20) DEFAULT NULL,
  updown_code varchar(20) DEFAULT NULL,
  FOREIGNER_VOLUME decimal(20,0) DEFAULT NULL,
  FOREIGNER_PORTION varchar(20) DEFAULT NULL,
  ORG_VOLUME decimal(20,0) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (COMPANY_CODE,REG_DATE),
  KEY company_price_idx1 (COMPANY_CODE),
  KEY company_price_idx2 (REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



CREATE TABLE stock.industry (
  INDUSTRY_CODE varchar(20) NOT NULL,
  INDUSTRY_NAME varchar(100) DEFAULT NULL,
  INDUSTRY_KIND varchar(20) DEFAULT NULL COMMENT '0:KOSPI업종, 1:KOSDAQ산업, 2:KOSDAQ지수업종',
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (INDUSTRY_CODE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE stock.industry_investors (
  INDUSTRY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  PERSONAL decimal(20,0) DEFAULT NULL,
  FOREIGNER decimal(20,0) DEFAULT NULL,
  ORG_SUM decimal(20,0) DEFAULT NULL,
  FIN_INVEST decimal(20,0) DEFAULT NULL,
  INSURANCE decimal(20,0) DEFAULT NULL,
  INVEST_TRUST decimal(20,0) DEFAULT NULL,
  BANK decimal(20,0) DEFAULT NULL,
  ETC_FIN decimal(20,0) DEFAULT NULL,
  PENSION decimal(20,0) DEFAULT NULL,
  NATION decimal(20,0) DEFAULT NULL,
  ETC_FOREIGNER decimal(20,0) DEFAULT NULL,
  PRIVATE_FUND decimal(20,0) DEFAULT NULL,
  ETC_CORP decimal(20,0) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (INDUSTRY_CODE,REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE stock.industry_price (
  INDUSTRY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  OPEN_PRICE decimal(10,0) DEFAULT NULL,
  HIGH_PRICE decimal(10,0) DEFAULT NULL,
  LOW_PRICE decimal(10,0) DEFAULT NULL,
  CLOSE_PRICE decimal(10,0) DEFAULT NULL,
  VOLUME decimal(20,0) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (INDUSTRY_CODE,REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE stock.recommend_company (
  COMPANY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  TRADE_SIGNAL int(3) DEFAULT NULL,
  PRICE_TREND int(3) DEFAULT NULL,
  POWER_CHARACTER int(4) DEFAULT NULL,
  WINNER_LIST varchar(2000) DEFAULT NULL,
  POWER_AD_TREND int(3) DEFAULT NULL,
  WINNER_AD_TREND int(3) DEFAULT NULL,
  FOREIGNER_AD_TREND int(3) DEFAULT NULL,
  ORG_SUM_AD_TREND int(3) DEFAULT NULL,
  POWER_CORREL float DEFAULT NULL,
  WINNER_CORREL float DEFAULT NULL,
  POWER_LEADING_RATIO float DEFAULT NULL,
  WINNER_LEADING_RATIO float DEFAULT NULL,
  POWER_ACCR float DEFAULT NULL,
  POWER_LDS5 int(20) DEFAULT NULL,
  POWER_LDS20 int(20) DEFAULT NULL,
  POWER_LDS60 int(20) DEFAULT NULL,
  PRICE_LEVEL float DEFAULT NULL,
  Y_PBR float DEFAULT NULL,
  Y_PER float DEFAULT NULL,
  Y_ROE float DEFAULT NULL,
  Y_NET_PROFIT_RISE_RATIO float DEFAULT NULL,
  Q_PBR float DEFAULT NULL,
  Q_PER float DEFAULT NULL,
  Q_ROE float DEFAULT NULL,
  Q_NET_PROFIT_RISE_RATIO float DEFAULT NULL,
  Q_DEBT_RATIO float DEFAULT NULL,
  Q_RETENTION_RATIO float DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (COMPANY_CODE,REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE stock.recommend_industry (
  INDUSTRY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  PRICE_TREND int(3) DEFAULT NULL,
  POWER_AD_TREND int(3) DEFAULT NULL,
  WINNER_AD_TREND int(3) DEFAULT NULL,
  TRADE_SIGNAL int(3) DEFAULT NULL,
  COWORK_EVAL int(3) DEFAULT NULL,
  POWER_CORREL_EVAL varchar(5) DEFAULT NULL,
  WINNER_CORREL_EVAL varchar(5) DEFAULT NULL,
  POWER_LEADING_RATIO float DEFAULT NULL,
  WINNER_LEADING_RATIO float DEFAULT NULL,
  POWER_ACCR float DEFAULT NULL,
  WINNER_ACCR float DEFAULT NULL,
  DISPARITY_SMA5 float DEFAULT NULL,
  DISPARITY_SMA20 float DEFAULT NULL,
  SHORT_PRICE_LEVEL float DEFAULT NULL,
  MID_PRICE_LEVEL float DEFAULT NULL,
  LONG_PRICE_LEVEL float DEFAULT NULL,
  VOLUME_RATIO float DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (INDUSTRY_CODE,REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE stock.rss_feed (
  ID mediumint(9) NOT NULL AUTO_INCREMENT,
  URI varchar(150) DEFAULT NULL,
  TITLE varchar(500) NOT NULL,
  LINK varchar(500) NOT NULL,
  DESCRIPTION varchar(10000) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY URI_UNIQUE (URI)
) ENGINE=MyISAM AUTO_INCREMENT=13073 DEFAULT CHARSET=utf8;


CREATE TABLE stock.theme (
  THEME_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  THEME_NAME varchar(200) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (THEME_CODE,REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE stock.theme_company (
  THEME_CODE varchar(20) NOT NULL,
  COMPANY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) NOT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (THEME_CODE,COMPANY_CODE,REG_DATE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE stock.trade_diary (
  COMPANY_CODE varchar(20) NOT NULL,
  REG_DATE varchar(8) DEFAULT NULL,
  TRADE_PRICE int(11) DEFAULT NULL,
  TARGET_PRICE int(11) DEFAULT NULL,
  CUT_PRICE int(11) DEFAULT NULL,
  COMMENTS varchar(10000) DEFAULT NULL,
  INSERT_DT datetime DEFAULT NULL,
  INSERT_ID varchar(50) DEFAULT NULL,
  UPDATE_DT datetime DEFAULT NULL,
  UPDATE_ID varchar(50) DEFAULT NULL,
  PRIMARY KEY (COMPANY_CODE)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



