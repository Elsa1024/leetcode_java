import java.util.*;
import java.lang.*;
import java.io.IOException;

public class MainClass {
  /**
   * Iterate through each line of input.
   */
  final static String ASSET_TYPE_STOCK = "STOCK";
  final static String ASSET_TYPE_BOND = "BOND";
  final static String TRANSACTION_TYPE_BUY = "BUY";
  final static String TRANSACTION_TYPE_SELL = "SELL";
  public static class Asset {
    String name;
    String assetType;
    Float shares;
    Float price;
    Float accruedInterest;
    Asset(String str) {
      String[] parameter = str.split(",");
      name = parameter[0];
      assetType = parameter[1];
      shares = Float.valueOf(parameter[2]);
      price = Float.valueOf(parameter[3]);
      accruedInterest = Float.valueOf(parameter[4]);
    }
    String trade(Asset that) {
      if (!that.name.equals(this.name))
        return "";
      StringBuilder sb = new StringBuilder();
      Float expectedShares = 0.0F;
      if (this.assetType.equals(ASSET_TYPE_STOCK))
        expectedShares = that.shares * that.price / this.price;
      else if (this.assetType.equals(ASSET_TYPE_BOND))
        expectedShares = that.shares * (that.price + that.accruedInterest) / (this.price + this.accruedInterest);
      sb.append(expectedShares > this.shares ? TRANSACTION_TYPE_BUY : TRANSACTION_TYPE_SELL);
      sb.append("," + this.name + ",");
      sb.append(Math.round(Math.abs(expectedShares-this.shares)));
      return sb.toString();
    }
  }
  public static void main(String[] args) throws IOException {
 /*   InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;*/
    String line = "Google,STOCK,10,50,0|Microsoft,STOCK,15,50,0|IBM,BOND,15,100,0.05:IBM,BOND,20,100,0.05|Google,STOCK,15,50,0|Microsoft,STOCK,10,50,0.05";
    Map<String, Asset> portfolio = new HashMap(), benchmark = new HashMap();
    // while ((line = ) != null) {
        String[] portfolioAndBenchmark = line.split(":");
        System.out.println("portfolioAndBenchmark[0]: " + portfolioAndBenchmark[0]);
        for (String str : portfolioAndBenchmark[0].split("\\|")) {
        System.out.println("str: " + str);
          Asset asset = new Asset(str);
          portfolio.put(asset.name, asset);
        }
        for (String str : portfolioAndBenchmark[1].split("\\|")) {
          Asset asset = new Asset(str);
          benchmark.put(asset.name, asset);
        }
    // }
    for (Map.Entry<String, Asset> me : portfolio.entrySet()) {
      Asset asset = me.getValue();
      System.out.println(asset.trade(benchmark.get(asset.name)));
    }
  }
}