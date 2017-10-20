import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.Thread;
import java.net.*;
import java.io.*;


public class Solution {
    /**
     * @param url a url of root page
     * @return all urls
     */

	public List<String> crawler(String url) {
		int thread_num = 3;
		CrawlerThread.setFirstUrl(url, thread_num);

		CrawlerThread[] thread_pools = new CrawlerThread[thread_num];
		for (int i=0; i < thread_num; i++) {
			thread_pools[i] = new CrawlerThread();
			thread_pools[i].start();
		}

		while (CrawlerThread.getCounter() > 0);

		for (int i = 0; i < thread_num; i++) {
			thread_pools[i].stop();
		}

		List<String> results = CrawlerThread.getResults();

		return results;
	}
}

class CrawlerThread extends Thread {
	private static AtomicLong counter;
	private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	private static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();

	private static List<String> results = new ArrayList<String>();

	public static void setFirstUrl(String url, int thread_num) {
		counter = new AtomicLong(thread_num);

		try {
			queue.put(url);
		} catch (InterruptedException e) {
		}
	}

	public static Long getCounter() {
		return counter.get();
	}

	public static List<String> getResults() {
		return results;
	}

	@Override
	public void run() {
		while (true) {
			String url = "";
			try {
				counter.decrementAndGet();
				url = queue.take();
				counter.incrementAndGet();
			} catch (Exception e) {
				break;
			}

			String domain = "";

			try {
				URL netUrl = new URL(url);
				domain = netUrl.getHost();
			} catch (MalformedURLException e) {
			}

			if (!mp.containsKey(url) && domain.endsWith("wikipedia.org")) {
				mp.put(url, true);
				results.add(url);
				List<String> urls = HtmlHelper.parseUrls(url);

				for (String u: urls) {
					try {
						queue.put(u);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
	
