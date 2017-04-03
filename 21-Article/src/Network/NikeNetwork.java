package Network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.swing.SwingWorker;

import Network.NikeNetwork.NetworkRequest;
import data.Article;
import manager.DataManager;
import parser.Parser;

public class NikeNetwork {

	public void startRequest(List<Article> a_list, int l_id) {
		RequestTimer m = new RequestTimer(a_list, l_id);
		m.start();
	}

	public static class NetworkRequest extends SwingWorker<Void, String> {

		private String targetURL;
		HttpURLConnection connection = null;
		Article a;
		int l_id;

		public NetworkRequest(String targetURL, Article a, int l_id) {
			super();
			this.targetURL = targetURL;
			this.l_id = l_id;
			this.a = a;
		}

		@Override
		protected Void doInBackground() throws Exception {
			// TODO Auto-generated method stub
			try {

				URL url = new URL(targetURL);
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

				connection.setRequestProperty("Content-Language", "en-US");

				connection.setUseCaches(false);
				connection.setDoOutput(true);

				// Send request
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.close();

				// Get Response
				// InputStream is = connection.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				StringBuilder response = new StringBuilder();

				String line;
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();

				Parser.parseString_NikeCheck(response.toString(), a, l_id);

			} catch (FileNotFoundException e) {
				DataManager.updateTableContent(a, false);
			} finally {
				if (connection != null) {
					connection.disconnect();
				}
			}
			return null;
		}
	}
}

class RequestTimer extends Thread {

	private List<Article> a_list;
	private int l_id;

	public RequestTimer(List<Article> a_list, int l_id) {
		this.a_list = a_list;
		this.l_id = l_id;
	}

	public void run() {

		for (Article a : a_list) {
			try {
				Thread.sleep(1300);
				NetworkRequest nr;
				switch (l_id) {
				case 0:
					nr = new NetworkRequest(a.getArt_webLink_de(), a, l_id);
					nr.execute();
					break;
				case 1:
					nr = new NetworkRequest(a.getArt_webLink_uk(), a, l_id);
					nr.execute();
					break;
				case 2:
					nr = new NetworkRequest(a.getArt_webLink_es(), a, l_id);
					nr.execute();
					break;
				case 3:
					nr = new NetworkRequest(a.getArt_webLink_fr(), a, l_id);
					nr.execute();
					break;
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
