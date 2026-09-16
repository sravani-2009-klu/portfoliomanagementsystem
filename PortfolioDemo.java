package com.portfolioproject.app;


	import java.util.*;

	// ===============================
	// CASE STUDY 2: ABSTRACT ASSET
	// ===============================

	abstract class Asset {
	    private String name;

	    public Asset(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

	    // Abstract method
	    public abstract double calculateCurrentValue();
	}


	// Stock class
	class Stock extends Asset {
	    private int quantity;
	    private double currentPrice;

	    public Stock(String name, int quantity, double currentPrice) {
	        super(name);
	        this.quantity = quantity;
	        this.currentPrice = currentPrice;
	    }

	    @Override
	    public double calculateCurrentValue() {
	        return quantity * currentPrice;
	    }
	}


	// Mutual Fund class
	class MutualFund extends Asset {
	    private double nav;
	    private double units;
	    private double exitLoad;

	    public MutualFund(String name, double nav, double units, double exitLoad) {
	        super(name);
	        this.nav = nav;
	        this.units = units;
	        this.exitLoad = exitLoad;
	    }

	    @Override
	    public double calculateCurrentValue() {
	        return nav * units * (1 - exitLoad);
	    }
	}


	// ===============================
	// HOLDING CLASS
	// ===============================

	class Holding {
	    private String holdingId;
	    private Asset asset;

	    public Holding(String holdingId, Asset asset) {
	        this.holdingId = holdingId;
	        this.asset = asset;
	    }

	    public String getHoldingId() {
	        return holdingId;
	    }

	    public Asset getAsset() {
	        return asset;
	    }

	    public void displayHolding() {
	        System.out.println("Holding ID: " + holdingId);
	        System.out.println("Asset: " + asset.getName());
	        System.out.println("Current Value: ₹" +
	                asset.calculateCurrentValue());
	        System.out.println();
	    }
	}


	// ===============================
	// USER CLASS
	// ===============================

	class User {
	    private String userId;
	    private String name;
	    private String email;

	    // CASE STUDY 1:
	    // Multiple investments belonging to one user
	    private List<Holding> holdings;

	    // CASE STUDY 3:
	    // Fast searching using Holding ID
	    private HashMap<String, Holding> holdingMap;

	    public User(String userId, String name, String email) {
	        this.userId = userId;
	        this.name = name;
	        this.email = email;

	        holdings = new ArrayList<>();
	        holdingMap = new HashMap<>();
	    }

	    // Add investment
	    public void addHolding(Holding holding) {
	        holdings.add(holding);
	        holdingMap.put(holding.getHoldingId(), holding);
	    }

	    // Search using Holding ID
	    public Holding findHolding(String holdingId) {
	        return holdingMap.get(holdingId);
	    }

	    public void displayUser() {
	        System.out.println("User ID: " + userId);
	        System.out.println("Name: " + name);
	        System.out.println("Email: " + email);
	        System.out.println();
	    }

	    // Display all holdings
	    public void displayAllHoldings() {
	        System.out.println("----- All Holdings -----");

	        for (Holding holding : holdings) {
	            holding.displayHolding();
	        }
	    }
	}


	// ===============================
	// MAIN CLASS
	// ===============================

	public class PortfolioDemo {

	    public static void main(String[] args) {

	        // --------------------------------
	        // CASE STUDY 1
	        // --------------------------------

	        User user = new User(
	                "U101",
	                "Ravi",
	                "ravi@gmail.com"
	        );

	        // TCS Stock
	        Stock tcs = new Stock(
	                "TCS",
	                10,
	                3800
	        );

	        Holding h1 = new Holding(
	                "H001",
	                tcs
	        );

	        user.addHolding(h1);


	        // --------------------------------
	        // CASE STUDY 2
	        // --------------------------------

	        // Mutual Fund
	        MutualFund mf = new MutualFund(
	                "ABC Mutual Fund",
	                500,
	                20,
	                0.01
	        );

	        Holding h2 = new Holding(
	                "H002",
	                mf
	        );

	        user.addHolding(h2);


	        // --------------------------------
	        // DISPLAY USER
	        // --------------------------------

	        user.displayUser();


	        // --------------------------------
	        // DISPLAY ALL INVESTMENTS
	        // --------------------------------

	        user.displayAllHoldings();


	        // --------------------------------
	        // CASE STUDY 3
	        // --------------------------------

	        System.out.println("----- Searching Holding -----");

	        Holding result = user.findHolding("H002");

	        if (result != null) {
	            result.displayHolding();
	        } else {
	            System.out.println("Holding not found");
	        }
	    }
	

	}


