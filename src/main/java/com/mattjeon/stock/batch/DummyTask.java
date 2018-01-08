package com.mattjeon.stock.batch;


import javax.annotation.Resource;

import org.apache.log4j.Logger;

//import com.mattjeon.stock.service.RssService;

public class DummyTask {
	
	@Resource(name = "rssService")
	//private RssService rssService;
	
	private Logger log = Logger.getLogger(this.getClass());
	
   	public void batchSchedule() throws Exception {

		String resultCode = "";
    	String urlstr = "http://rss.hankyung.com/new/news_stock.xml";
    	//resultCode =  this.rssService.saveRssFeed(urlstr);
    	
    	String urlstr2 = "http://mk.co.kr.feedsportal.com/c/34147/f/618379/index.rss";
    	//resultCode =  this.rssService.saveRssFeed(urlstr2);
    	
    	
    	String urlstr3 = "http://rss.mt.co.kr/mt_news_stock.xml";
    	//resultCode =  this.rssService.saveRssFeed(urlstr3);
    	
	    	
    }
}
