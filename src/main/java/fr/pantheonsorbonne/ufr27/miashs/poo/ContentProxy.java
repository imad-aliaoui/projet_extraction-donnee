package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.stream.Collectors;

public final class ContentProxy {
  public static final String CACHED_FILE_PATH = "src/main/resources/scrapped0.txt";

  public static final String REMOTE_URL = "https://projet-l2.nextnet.top/url/aHR0cHM6Ly9mYnJlZi5jb20vZnIvY29tcHMvQmlnNS9zdGF0cy9qb3VldXJzL1N0YXRpc3RpcXVlcy1MZXMtNS1ncmFuZHMtY2hhbXBpb25uYXRzLWV1cm9wZWVucw==";

  public static String getCached() throws IOException {
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(CACHED_FILE_PATH),"UTF-8"))) {
      return reader.lines().collect(Collectors.joining("\n"));
    } catch(IOException ie) {
      throw new RuntimeException(ie);
    }
  }

  public static String getFresh() throws IOException {
    return WebPageFetcher.fetchResource(REMOTE_URL);
  }
}
